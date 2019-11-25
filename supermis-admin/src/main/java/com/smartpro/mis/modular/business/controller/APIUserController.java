package com.smartpro.mis.modular.business.controller;

import com.alibaba.fastjson.JSONObject;
import com.smartpro.mis.config.properties.SupermisProperties;
import com.smartpro.mis.core.base.controller.BaseController;
import com.smartpro.mis.core.base.tips.Tip;
import com.smartpro.mis.core.common.annotion.BussinessLog;
import com.smartpro.mis.core.common.constant.Const;
import com.smartpro.mis.core.common.constant.dictmap.UserDict;
import com.smartpro.mis.core.common.constant.state.ManagerStatus;
import com.smartpro.mis.core.common.exception.BizExceptionEnum;
import com.smartpro.mis.core.datascope.DataScope;
import com.smartpro.mis.core.exception.SupermisException;
import com.smartpro.mis.core.log.LogManager;
import com.smartpro.mis.core.log.factory.LogTaskFactory;
import com.smartpro.mis.core.shiro.ShiroKit;
import com.smartpro.mis.core.shiro.ShiroUser;
import com.smartpro.mis.core.support.HttpKit;
import com.smartpro.mis.core.util.SelfDefineException;
import com.smartpro.mis.core.util.ToolUtil;
import com.smartpro.mis.modular.business.service.IDprelationService;
import com.smartpro.mis.modular.system.factory.UserFactory;
import com.smartpro.mis.modular.system.model.Doctoruser;
import com.smartpro.mis.modular.system.model.Patientuser;
import com.smartpro.mis.modular.system.model.User;
import com.smartpro.mis.modular.system.service.IDoctoruserService;
import com.smartpro.mis.modular.system.service.IPatientuserService;
import com.smartpro.mis.modular.system.service.IUserService;
import com.smartpro.mis.modular.system.transfer.RegisterUseInfo;
import com.smartpro.mis.modular.system.transfer.UserDto;
import com.smartpro.mis.modular.system.warpper.UserWarpper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.smartpro.mis.core.shiro.ShiroKit.md5;

/**
 * 系统管理员控制器
 *
 * @author mengiy
 * @Date 2017年1月11日 下午1:08:17
 */
@RestController
@RequestMapping("/api/service/")
public class APIUserController extends BaseController {

    @Autowired
    private SupermisProperties supermisProperties;

    @Autowired
    private IUserService userService;
    @Autowired
    private IPatientuserService puserService;

    @Autowired
    private IDoctoruserService doctoruserService;

    @Autowired
    private IDprelationService dprelationService;


    /**
     * 修改当前用户的密码
     */
    @ApiOperation(value = "修改密码",notes = "修改用户的密码")
    @ApiImplicitParam(name = "totalUserInfo", value = "JSON数据格式：{'oldPwd'：'','newPwd':'','rePwd':''}", required = true, dataType = "JSONObject")
    @RequestMapping(value = "/user/changePwd",method = RequestMethod.POST)
    public Object changePwd(@RequestBody JSONObject object) {
        String oldPwd = object.getString("oldPwd");
         String newPwd = object.getString("newPwd");
         String rePwd = object.getString("rePwd");
        if (!newPwd.equals(rePwd)) {
            throw new SupermisException(BizExceptionEnum.TWO_PWD_NOT_MATCH);
        }
        Integer userId = ShiroKit.getUser().getId();
        User user = userService.selectById(userId);
        String oldMd5 = md5(oldPwd, user.getSalt());
        if (user.getPassword().equals(oldMd5)) {
            String newMd5 = md5(newPwd, user.getSalt());
            user.setPassword(newMd5);
            user.updateById();
            return SUCCESS_TIP;
        } else {
            throw new SupermisException(BizExceptionEnum.OLD_PWD_NOT_RIGHT);
        }
    }


    /**
     * 找回用户密码
     */
    @ApiOperation(value = "找回密码",notes = "找回用户的密码")
    @ApiImplicitParam(name = "totalUserInfo", value = "JSON数据格式：{'name':'','cardNo':'','phone':'','roleid':'','newPwd':'','rePwd':''}", required = true, dataType = "JSONObject")
    @RequestMapping(value = "/user/findPwd",method = RequestMethod.POST)
    @ResponseBody
    public Object findPwd(@RequestBody JSONObject object) {
        String name = object.getString("name");
        String cardNo = object.getString("cardNo");
        String phone = object.getString("phone");
        String roleid = object.getString("roleid");
        String newPwd = object.getString("newPwd");
        String rePwd = object.getString("rePwd");
        if (!newPwd.equals(rePwd)) {
            throw new SupermisException(BizExceptionEnum.TWO_PWD_NOT_MATCH);
        }
        Map<String,Object> condition = new HashedMap();
        condition.put("name",name);
//        condition.put("cardNo",cardNo);
        condition.put("phone",phone);
        condition.put("roleid",roleid);
        List<User> userlist = this.userService.selectByMaps(condition);
        if(userlist.size()==0){
            throw new SupermisException(BizExceptionEnum.NO_THIS_USER);
        }
        User user = userlist.get(0);
        String newMd5 = ShiroKit.md5(newPwd, user.getSalt());
        user.setPassword(newMd5);
        user.updateById();
        return SUCCESS_TIP;

    }

    /**
     * 查询用户列表
     */
    @RequestMapping("/user/list")
    public Object list(@RequestParam(required = false) String name, @RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime, @RequestParam(required = false) Integer deptid, @RequestParam(required = false) Integer roleid) {
        if (ShiroKit.isAdmin()) {
            List<Map<String, Object>> users = userService.selectUsersByRoles(null, name, beginTime, endTime, roleid);
            return new UserWarpper(users).warp();
        } else {
            DataScope dataScope = new DataScope(ShiroKit.getDeptDataScope());
            List<Map<String, Object>> users = userService.selectUsers(dataScope, name, beginTime, endTime, deptid);
            return new UserWarpper(users).warp();
        }
    }

    /**
     * 条件查询用户列表
     */
    @ApiOperation(value = "条件查询用户列表",notes = "条件查询用户列表")
    @ApiImplicitParam(name = "condition", value = "条件数据格式：{'name':'','cardNo':'','phone':'','roleid':'',...}", required = true, dataType = "Map")
    @RequestMapping(value = "/user/getlist",method = RequestMethod.POST)
    @ResponseBody
    public Object getlist(@RequestBody Map<String,Object> condition) {
           condition.put("roleid","7");
            List<User> users = userService.selectByMap(condition);
            return users;
    }

    /**
     * 医生全库查询未绑定的病人列表
     */
    @ApiOperation(value = "条件查询用户列表",notes = "条件查询用户列表,userId是必备字段，表示是谁在查询")
    @ApiImplicitParam(name = "condition", value = "条件数据格式：{'userId':65,'name':'','phone':'','roleid':'',...}", required = true, dataType = "Map")
    @RequestMapping(value = "/user/getPatList",method = RequestMethod.POST)
    @ResponseBody
    public Object getPatList(@RequestBody Map<String,Object> condition) {
        if(null==condition.get("userId")||condition.get("userId")==""){
            throw new SupermisException(BizExceptionEnum.REQUEST_INVALIDATE);
        }
        condition.put("roleid","7");
        int userId = Integer.parseInt((String)condition.get("userId"));
        condition.remove("userId");
        List<User> users = userService.selectByMap(condition);
        //去重，去掉已经绑定的病人用户
        for(User u : users){
            //默认没有跟该医生建立绑定关系的病人设置状态为-1
            u.setVersion(-1);
//            List<Map<String, Object>> docList =  this.dprelationService.selectDocsByKey(u.getId());
            //查询该病人的医生列表，status为-1表示查询绑定、已发送请求的医生信息
            List<Map<String, Object>> docList =  this.dprelationService.selectDocs(u.getId(),-1);
            for(Map<String,Object> doc :docList){
                if(null != doc.get("id") && ((Integer)doc.get("id") == userId)){
                    u.setVersion((Integer)doc.get("status"));
//                    users.remove(u);
                    continue;
                }
            }
        }
        return users;
    }


    /**
     * 注册用户
     */
    @ApiOperation(value ="注册用户",notes = "区分不同角色")
    @ApiImplicitParam(name = "totalUserInfo", value = "用户注册信息", required = true, dataType = "RegisterUseInfo")
    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
    @BussinessLog(value = "API用户注册", key = "account", dict = UserDict.class)
//    @Permission(Const.ADMIN_NAME)
    public Object register(@RequestBody RegisterUseInfo totalUserInfo) {
//        System.out.println("#######registerUser#################"+ JSON.toJSONString(totalUserInfo));
//        if (result.hasErrors()) {
//            throw new SupermisException(BizExceptionEnum.REQUEST_NULL);
//        }
        User registerUser = totalUserInfo.getUser();
        String userRole = registerUser.getRoleid();
        if(null == userRole ||(!userRole.equals("7")&&(!userRole.equals("8")))){
//            throw new SupermisException(BizExceptionEnum.ROLE_NOT_SUPPORTED);
            return new SelfDefineException(BizExceptionEnum.ROLE_NOT_SUPPORTED);
        }
        Doctoruser doctoruser = totalUserInfo.getDoctoruser();
        Patientuser patientuser = totalUserInfo.getPatientuser();
        if(null!=patientuser){
            patientuser.setAge(IdNOToAge(patientuser.getCardNo()));
        }
        UserDto user  = new UserDto();
        // 判断账号是否重复
        user.setAccount(registerUser.getAccount());
        user.setAvatar(registerUser.getAvatar());
        user.setBirthday(registerUser.getBirthday());
        user.setCreatetime(registerUser.getCreatetime());
        user.setDeptid(registerUser.getDeptid());
        user.setEmail(registerUser.getEmail());
        user.setId(registerUser.getId());
        user.setName(registerUser.getName());
        user.setPassword(registerUser.getPassword());
        user.setPhone(registerUser.getPhone());
        user.setRoleid(registerUser.getRoleid());
        user.setSex(registerUser.getSex());
        user.setStatus(registerUser.getStatus());
        user.setVersion(registerUser.getVersion());

        User theUser = userService.getByAccount(user.getAccount());
        Patientuser puser = puserService.getByMobile(registerUser.getPhone());
        Doctoruser duser = doctoruserService.getByMobile(registerUser.getPhone());
        //允许同一手机账号不同角色注册
        if(userRole.equals("7")&&(null != theUser && null != puser)){

//            throw new SupermisException(BizExceptionEnum.USER_ALREADY_REG);
            return new SelfDefineException(BizExceptionEnum.USER_ALREADY_REG);
        }
        if(userRole.equals("8")&&(null != theUser && null != duser)){
//            throw new SupermisException(BizExceptionEnum.USER_ALREADY_REG);
            return new SelfDefineException(BizExceptionEnum.USER_ALREADY_REG);
        }
        // 完善账号信息
        user.setSalt(ShiroKit.getRandomSalt(5));
        user.setPassword(ShiroKit.md5(registerUser.getPassword(), user.getSalt()));
        user.setStatus(ManagerStatus.OK.getCode());
        user.setCreatetime(new Date());
        user.setDeptid(26);

        if(null!= userRole && userRole.equals( "7")){                     //插入普通用户信息
            this.puserService.insert(patientuser);
//           int userid  = this.puserService.insertObject(patientuser);

        }else if(null!=userRole && userRole.equals("8")){               //插入医生用户信息
            this.doctoruserService.insert(doctoruser);
        }else {
//            throw new SupermisException(BizExceptionEnum.ROLE_NOT_SUPPORTED);
            return new SelfDefineException(BizExceptionEnum.ROLE_NOT_SUPPORTED);
        }
        this.userService.insert(UserFactory.createUser(user));    //插入用户公共信息
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",SUCCESS_TIP);
        jsonObject.put("user",user);
        jsonObject.put("patientuser",patientuser);
        jsonObject.put("doctoruser",doctoruser);
        return jsonObject;
    }


    /**
     * 用户登录接口
     */
    @ApiOperation(value ="用户登录",notes = "区分不同角色")
    @ApiImplicitParam(name = "login", value = "需要用户账号、密码、角色", required = true,dataType = "JSONObject")
    @RequestMapping(value = "/user/signin", method = RequestMethod.POST)
    @BussinessLog(value = "API用户登录", key = "account", dict = UserDict.class)
    public Object login(@RequestBody JSONObject login) {
        String account =  login.getString("account").trim();
        String password = login.getString("password").trim();
        String roleid = login.getString("roleid").trim();
        if(null==account||null==password||null == roleid){
//            throw new SupermisException(BizExceptionEnum.ERROR_WRAPPER_FIELD);
            return new SelfDefineException(BizExceptionEnum.ERROR_WRAPPER_FIELD);
        }
        //验证验证码是否正确
//        if (KaptchaUtil.getKaptchaOnOff()) {
//            String kaptcha = super.getPara("kaptcha").trim();
//            String code = (String) super.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
//            if (ToolUtil.isEmpty(kaptcha) || !kaptcha.equalsIgnoreCase(code)) {
//                throw new InvalidKaptchaException();
//            }
//        }

//        Subject currentUser = ShiroKit.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());
//        currentUser.login(token);
//        ShiroUser shiroUser = ShiroKit.getUser();
//        User user = this.userService.getByAccount(shiroUser.getAccount());
        Map<String,Object> condition = new HashedMap();
        condition.put("account",account);
//        condition.put("cardNo",cardNo);
//        condition.put("password",password);
        condition.put("roleid",roleid);
//        System.out.println("####################account:  "+account +"  "+password+"  "+roleid);
        List<User> userlist = this.userService.selectByMaps(condition);
//        System.out.println("############user list#############"+ JSON.toJSONString(userlist));
        if(userlist.size()<1){
//            throw new SupermisException(BizExceptionEnum.USER_NOT_EXISTED);
            return new SelfDefineException(BizExceptionEnum.USER_NOT_EXISTED);
        }
        User user = userlist.get(0);
        String dbPassword = ShiroKit.md5(password,user.getSalt());
        if(!dbPassword .equals(user.getPassword())){
//            throw new SupermisException(BizExceptionEnum.USER_PWD_ERROR);
            return new SelfDefineException(BizExceptionEnum.USER_PWD_ERROR);
        }
        RegisterUseInfo useInfo = new RegisterUseInfo();
        useInfo.setUser(user);
        Patientuser puser;
        Doctoruser duser;
        if(roleid.equals("7")){
            puser = this.puserService.getByMobile(user.getPhone());
          useInfo.setPatientuser(puser);
        }else if(roleid.equals("8")){
            duser = this.doctoruserService.getByMobile(user.getPhone());
            useInfo.setDoctoruser(duser);
        }else{
//            throw new SupermisException(BizExceptionEnum.ROLE_NOT_SUPPORTED);
            return new SelfDefineException(BizExceptionEnum.ROLE_NOT_SUPPORTED);
        }
        /**
         * 登录成功之后让Shiro同步登录
         */
        try {
            Subject currentUser = ShiroKit.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(account, password.toCharArray());
            currentUser.login(token);
            ShiroUser shiroUser = ShiroKit.getUser();
            super.getSession().setAttribute("shiroUser", shiroUser);
            super.getSession().setAttribute("username", shiroUser.getAccount());
            LogManager.me().executeLog(LogTaskFactory.loginLog(shiroUser.getId(), HttpKit.getIp()));
            ShiroKit.getSession().setAttribute("sessionFlag", true);
        }catch (Exception e){
            System.out.println("Shiro 同步登录失败!#######"+ account);
        }
       return useInfo;
    }

    /**
     * 退出登录
     */
    @ApiOperation(value ="退出登录",notes = "同步退出")
    @RequestMapping(value = "/user/logout", method = RequestMethod.GET)
    @BussinessLog(value = "API退出登录", key = "account", dict = UserDict.class)
    @ResponseBody
    public Object logOut() {
        LogManager.me().executeLog(LogTaskFactory.exitLog(ShiroKit.getUser().getId(), HttpKit.getIp()));
        ShiroKit.getSubject().logout();
        return SUCCESS_TIP;
    }

    /**
     * 修改用户信息
     *
     */
    @ApiOperation(value ="修改用户信息",notes = "同步修改")
    @ApiImplicitParam(name = "registerUserInfo", value = "需要用户ID、账号、角色、手机号码字段", required = true, dataType = "RegisterUseInfo")
    @RequestMapping(value = "/user/edit",method = RequestMethod.POST)
    @BussinessLog(value = "修改用户信息", key = "account", dict = UserDict.class)
    @ResponseBody
    public Tip useEdit(@RequestBody RegisterUseInfo registerUserInfo){
        User user = registerUserInfo.getUser();
        String roleid = user.getRoleid();
        if(null == user.getRoleid()||null==user.getAccount()){
            throw new SupermisException(BizExceptionEnum.USER_PARAMS_ERROR);
        }
        /**
         * 考虑到用户有可能更改手机号码，此处使用数据库已有的手机号码进行关联查询对应的doctor和patient 信息
         */
        Map<String,Object> conditions = new HashedMap();
        conditions.put("account",user.getAccount());
        conditions.put("roleid",roleid);
        User dbUser;
        try {
            dbUser = this.userService.selectByMaps(conditions).get(0);
            if(null == dbUser)
                throw new SupermisException(BizExceptionEnum.USER_NOT_EXISTED);
        }catch (Exception e){
            throw new SupermisException(BizExceptionEnum.USER_NOT_EXISTED);
        }
        //判断用户是否更改了手机号码，若此手机号码在其他账号已经注册，则不允许更改，提示此“手机号码已经注册过，不允许重复使用！”错误信息
        if(null!=user.getPhone()) {
            //默认用户手机号码为用户的账号account
            User theUser = userService.getByAccount(user.getPhone());
            Patientuser puser = puserService.getByMobile(user.getPhone());
            Doctoruser duser = doctoruserService.getByMobile(user.getPhone());
            //允许同一手机账号不同角色注册
            if (roleid.equals("7") && (null != theUser || null != puser)) {
                throw new SupermisException(BizExceptionEnum.PHONE_ALREADY_REG);
            }
            if (roleid.equals("8") && (null != theUser || null != duser)) {
                throw new SupermisException(BizExceptionEnum.PHONE_ALREADY_REG);
            }
        }
        if(null != roleid && roleid.equals("7") ){
            Patientuser puser = this.puserService.getByMobile(dbUser.getPhone());
            Patientuser patientuser = registerUserInfo.getPatientuser();
            if(null!=user.getPhone()) {
                patientuser.setMobile(user.getPhone());
            }
            if(null != puser && null != puser.getId()) {
                patientuser.setId(puser.getId());
            }else{
                throw new SupermisException(BizExceptionEnum.NO_THIS_USER);
            }
            this.puserService.updateById(patientuser);
        }else if(null != roleid && roleid.equals("8") ){
            Doctoruser duser = this.doctoruserService.getByMobile(dbUser.getPhone());
            Doctoruser doctoruser = registerUserInfo.getDoctoruser();
            if(null!=user.getPhone()) {
                doctoruser.setMobile(user.getPhone());
            }
            if(null != duser && null != duser.getId()) {
                doctoruser.setId(duser.getId());
            }else{
                throw new SupermisException(BizExceptionEnum.NO_THIS_USER);
            }
            this.doctoruserService.updateById(doctoruser);
        }
        this.userService.updateById(user);
        return SUCCESS_TIP;
    }

    /**
     * 删除用户（物理删除）
     */
    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "删除用户")
    @BussinessLog(value = "删除用戶", key = "account", dict = UserDict.class)
    @ResponseBody
    public Tip delete(@PathVariable Integer id) {
        if (ToolUtil.isEmpty(id)) {
            throw new SupermisException(BizExceptionEnum.REQUEST_NULL);
        }
//        assertAuth(id);
        User user = this.userService.selectById(id);
         String roleid = user.getRoleid();
        String phone = user.getPhone();
        if(!ToolUtil.isEmpty(roleid)&&!ToolUtil.isEmpty(phone)){
            if(roleid.equals("7")){
                this.puserService.deleteByMobile(phone);
            }else if(roleid.equals("8")){
                this.doctoruserService.deleteByMobile(phone);
            }else {
                new SupermisException(BizExceptionEnum.ROLE_NOT_SUPPORTED);
            }
            this.userService.deleteById(id);
        }else {
            throw  new SupermisException(BizExceptionEnum.ERROR_WRAPPER_FIELD);
        }

        return SUCCESS_TIP;
    }

    /**
     * 查看用戶详情
     */
    @ApiOperation(value = "查看用户详情",notes = "用户详细信息展示")
    @RequestMapping(value = "/user/view/{id}",method = RequestMethod.GET)
    @BussinessLog(value = "查询用戶信息", key = "account", dict = UserDict.class)
    @ResponseBody
    public RegisterUseInfo view(@PathVariable Integer id) {
        if (ToolUtil.isEmpty(id)) {
            throw new SupermisException(BizExceptionEnum.REQUEST_NULL);
        }
//        assertAuth(id);
        User user = this.userService.selectById(id);
        String roleid = user.getRoleid();
        RegisterUseInfo resultObj = new RegisterUseInfo();
        resultObj.setUser(user);
        Patientuser puser = null;
        Doctoruser duser = null;
        if(roleid.equals("7")||roleid.contains(",7")||roleid.contains("7,")){
            puser = this.puserService.getByMobile(user.getPhone());
            resultObj.setPatientuser(puser);
        }else if(roleid.equals("8")||roleid.contains(",8")||roleid.contains("8,")){
            duser = this.doctoruserService.getByMobile(user.getPhone());
            resultObj.setDoctoruser(duser);
        }else{
            throw new SupermisException(BizExceptionEnum.ROLE_NOT_SUPPORTED);
//            return new SelfDefineException(BizExceptionEnum.ROLE_NOT_SUPPORTED);
        }
        return resultObj;
    }

    /**
     * 重置用户的密码
     */
    @RequestMapping(value = "/user/reset",method = RequestMethod.GET)
    @BussinessLog(value = "重置用户密码", key = "account", dict = UserDict.class)
    @ResponseBody
    public Tip reset(@RequestBody Integer id) {
        if (ToolUtil.isEmpty(id)) {
            throw new SupermisException(BizExceptionEnum.REQUEST_NULL);
        }
        User user = this.userService.selectById(id);
        user.setSalt(ShiroKit.getRandomSalt(5));
        user.setPassword(md5(Const.DEFAULT_PWD, user.getSalt()));
        this.userService.updateById(user);
        return SUCCESS_TIP;
    }


    /**
     * 上传图片(上传到项目的webapp/static/img)
     */
    @ApiOperation(value ="上传图片",notes = "上传用户头像")
    @ApiImplicitParam(name = "picture", value = "需要图片", required = true, dataType = "MultipartFile")
    @RequestMapping(method = RequestMethod.POST, path = "/user/upload")
    @ResponseBody
    public JSONObject upload(@RequestParam("file") MultipartFile picture, HttpServletRequest request) {
        JSONObject result = new JSONObject();
        String pictureName = UUID.randomUUID().toString() + ".jpg";
        try {
            String fileSavePath = supermisProperties.getFileUploadPath();

            picture.transferTo(new File(fileSavePath + pictureName));
            try{
                String os = System.getProperty("os.name");
                if(!os.toLowerCase().startsWith("win")){
                    String cmdStrs[] = new String[]{"chmod","-R","775",fileSavePath + pictureName};
                    Process child = Runtime.getRuntime().exec(cmdStrs);
                }

            }catch(Exception e){
                System.out.println("########################chmod error!!!!");
//                e.printStackTrace();
            }
//            System.out.println("文件上传路径##########################"+fileSavePath + pictureName);
            result.put("code",200);
            result.put("pictureName",pictureName);
            String url =  request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
            result.put("pictureUrl",url+"kaptcha/"+ pictureName);
            result.put("saveUrl",fileSavePath + pictureName);
//            result.put("pictureUrl",url+ fileSavePath + pictureName);

        } catch (Exception e) {
            throw new SupermisException(BizExceptionEnum.UPLOAD_ERROR);
        }

        return result;
    }

    /**
     * 判断当前登录的用户是否有操作这个用户的权限
     */
    private void assertAuth(Integer userId) {
        if (ShiroKit.isAdmin()) {
            return;
        }
        List<Integer> deptDataScope = ShiroKit.getDeptDataScope();
        User user = this.userService.selectById(userId);
        Integer deptid = user.getDeptid();
        if (deptDataScope.contains(deptid)) {
            return;
        } else {
            throw new SupermisException(BizExceptionEnum.NO_PERMITION);
        }

    }




    //根据身份证号输出年龄
    public static int IdNOToAge(String IdNO){
        int leh = IdNO.length();
        try {
            String dates="";
            if (leh == 18) {
                int se = Integer.valueOf(IdNO.substring(leh - 1)) % 2;
                dates = IdNO.substring(6, 10);
                SimpleDateFormat df = new SimpleDateFormat("yyyy");
                String year=df.format(new Date());
                int u=Integer.parseInt(year)-Integer.parseInt(dates);
                return u;
            }else if(leh == 15){
                dates = IdNO.substring(6, 8);
                return Integer.parseInt(dates);
            }else {
                return 0;
            }
        } catch (Exception e) {
            return -1;
        }

    }

    public static void main(String[] args) {
        System.out.println(IdNOToAge("320623199305150021")); //320621198804303
    }
}
