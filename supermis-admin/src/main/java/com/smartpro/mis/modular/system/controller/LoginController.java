package com.smartpro.mis.modular.system.controller;

import com.google.code.kaptcha.Constants;
import com.smartpro.mis.core.common.exception.InvalidKaptchaException;
import com.smartpro.mis.core.log.LogManager;
import com.smartpro.mis.core.log.factory.LogTaskFactory;
import com.smartpro.mis.core.node.MenuNode;
import com.smartpro.mis.core.shiro.ShiroKit;
import com.smartpro.mis.core.support.HttpKit;
import com.smartpro.mis.core.util.ApiMenuFilter;
import com.smartpro.mis.modular.system.model.User;
import com.smartpro.mis.modular.system.service.IMenuService;
import com.smartpro.mis.core.base.controller.BaseController;
import com.smartpro.mis.core.common.exception.InvalidKaptchaException;
import com.smartpro.mis.core.log.LogManager;
import com.smartpro.mis.core.log.factory.LogTaskFactory;
import com.smartpro.mis.core.node.MenuNode;
import com.smartpro.mis.core.shiro.ShiroKit;
import com.smartpro.mis.core.shiro.ShiroUser;
import com.smartpro.mis.core.util.ApiMenuFilter;
import com.smartpro.mis.core.util.KaptchaUtil;
import com.smartpro.mis.core.util.ToolUtil;
import com.smartpro.mis.modular.system.model.User;
import com.smartpro.mis.modular.system.service.IMenuService;
import com.smartpro.mis.modular.system.service.IUserService;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static com.smartpro.mis.core.support.HttpKit.getIp;

/**
 * 登录控制器
 *
 * @author mengiy
 * @Date 2017年1月10日 下午8:25:24
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    private IMenuService menuService;

    @Autowired
    private IUserService userService;

    /**
     * 跳转到主页
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        //获取菜单列表
        List<Integer> roleList = ShiroKit.getUser().getRoleList();
        if (roleList == null || roleList.size() == 0) {
            ShiroKit.getSubject().logout();
            model.addAttribute("tips", "该用户没有角色，无法登陆");
            return "/login.html";
        }
        List<MenuNode> menus = menuService.getMenusByRoleIds(roleList);

//       System.out.println("##########################菜单列表############################"+ JSON.toJSONString(menus));
        List<MenuNode> titles = MenuNode.buildTitle(menus);
//        System.out.println("##########################清洗后的菜单列表############################"+ JSON.toJSONString(titles));
        titles = ApiMenuFilter.build(titles);
//        System.out.println("##########################接口过滤后的的菜单列表############################"+ JSON.toJSONString(titles));
        model.addAttribute("titles", titles);

        //获取用户头像
        Integer id = ShiroKit.getUser().getId();
        User user = userService.selectById(id);
        String avatar = user.getAvatar();
        model.addAttribute("avatar", avatar);

        return "/index.html";
    }

    /**
     * 跳转到登录页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        if (ShiroKit.isAuthenticated() || ShiroKit.getUser() != null) {
            return REDIRECT + "/";
        } else {
            return "/login.html";
        }
    }

    /**
     * 点击登录执行的动作
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginVali() {

        String username = super.getPara("username").trim();
        String password = super.getPara("password").trim();
        String remember = super.getPara("remember");

        //验证验证码是否正确
        if (KaptchaUtil.getKaptchaOnOff()) {
            String kaptcha = super.getPara("kaptcha").trim();
            String code = (String) super.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if (ToolUtil.isEmpty(kaptcha) || !kaptcha.equalsIgnoreCase(code)) {
                throw new InvalidKaptchaException();
            }
        }

        Subject currentUser = ShiroKit.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());

        if ("on".equals(remember)) {
            token.setRememberMe(true);
        } else {
            token.setRememberMe(false);
        }

        currentUser.login(token);

        ShiroUser shiroUser = ShiroKit.getUser();
        super.getSession().setAttribute("shiroUser", shiroUser);
        super.getSession().setAttribute("username", shiroUser.getAccount());

        LogManager.me().executeLog(LogTaskFactory.loginLog(shiroUser.getId(), HttpKit.getIp()));

        ShiroKit.getSession().setAttribute("sessionFlag", true);

        return REDIRECT + "/";
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut() {
        LogManager.me().executeLog(LogTaskFactory.exitLog(ShiroKit.getUser().getId(), HttpKit.getIp()));
        ShiroKit.getSubject().logout();
        return REDIRECT + "/login";
    }
}
