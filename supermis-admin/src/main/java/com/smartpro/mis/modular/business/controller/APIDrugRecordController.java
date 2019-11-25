package com.smartpro.mis.modular.business.controller;

import com.smartpro.mis.core.base.controller.BaseController;
import com.smartpro.mis.core.common.annotion.BussinessLog;
import com.smartpro.mis.core.common.constant.dictmap.UserDict;
import com.smartpro.mis.modular.business.service.IUserdrugrecordService;
import com.smartpro.mis.modular.system.model.Userdrugrecord;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户药物记录控制器
 *
 * @author mengiy
 * @Date 2018-03-22 15:27:19
 */
@RestController
@RequestMapping("/api/service")
public class APIDrugRecordController extends BaseController {


    @Autowired
    private IUserdrugrecordService userdrugrecordService;

    /**
     * 获取用户药物库列表
     */
    @ApiOperation(value = "查询用户药物列表",notes="获取全部药物列表" )
    @BussinessLog(value = "API查询用户药物列表", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/uDrugRec/listAll",method = RequestMethod.GET)
    public Object listAll() {
        return userdrugrecordService.selectList(null);
    }



    /**
     * 获取用户药物记录列表
     */
    @ApiOperation(value ="获取用户药物列表",notes = "需要用户的唯一标识")
    @BussinessLog(value = "API获取用户药物列表", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/uDrugRec/list/{uid}",method = RequestMethod.GET)
    public Object list(@PathVariable Integer uid) {
        return userdrugrecordService.selectListByUid(uid,null);
    }

    /**
     * 查询用户药物记录列表
     */
    @ApiOperation(value ="查询用户药物",notes = "需要用户的唯一标识和药物名称")
    @BussinessLog(value = "API查询用户药物", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/uDrugRec/queryDrug/{uid}/{drug}",method = RequestMethod.GET)
    public Object queryDrug(@PathVariable("uid") Integer uid,@PathVariable("drug") String drug) {
        return userdrugrecordService.selectListByUid(uid,drug);
    }

    /**
     * 新增用户药物记录
     */
    @ApiOperation(value ="新增用户药物",notes = "绑定系统已经存在的药物")
    @BussinessLog(value = "API新增用户药物", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/uDrugRec/add",method = RequestMethod.POST)
    @ResponseBody
    public Object add(@RequestBody Userdrugrecord userdrugrecord) {
        userdrugrecordService.insert(userdrugrecord);
        return SUCCESS_TIP;
    }

    /**
     * 用户药物简单记录详情
     */

    @ApiOperation(value ="查看用户药物详细信息",notes = "查看用户药物信息")
    @BussinessLog(value = "API查看用户药物", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/uDrugRec/detail/{id}",method = RequestMethod.GET)
    public Object detail(@PathVariable Integer id) {
        return userdrugrecordService.selectUserDrugById(id).get(0);
    }

    /**
     * 删除用户药物记录
     */

    @ApiOperation(value ="删除用户药物",notes = "解绑用户的药物")
    @BussinessLog(value = "API删除用户药物", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/uDrugRec/delete/{id}",method = RequestMethod.GET)
    public Object delete(@PathVariable Integer id) {
        userdrugrecordService.deleteById(id);
        return SUCCESS_TIP;
    }

    /**
     * 查看用户药物详情
     */
    @ApiOperation(value ="查看用户药物",notes = "查看用户药物的详细信息")
    @BussinessLog(value = "API查看用户药物详情", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/uDrugRec/view/{id}",method = RequestMethod.GET)
    public Object view(@PathVariable Integer id) {
        return userdrugrecordService.selectById(id);

    }

    /**
     * 修改用户药物记录
     */
    @RequestMapping(value = "/uDrugRec/update",method = RequestMethod.POST)
    @ApiOperation(value ="修改用户药物",notes = " 修改用户自设的药物信息")
    @BussinessLog(value = "API修改用户药物", key = "id", dict = UserDict.class)
    @ApiImplicitParam(name = "userdrugrecord",value = "用户对药物的个性化属性设置值",required = true,dataType = "Userdrugrecord")
    public Object update(@RequestBody Userdrugrecord userdrugrecord) {
        userdrugrecordService.updateById(userdrugrecord);
        return SUCCESS_TIP;
    }
}
