package com.smartpro.mis.modular.business.controller;

import com.smartpro.mis.core.log.LogObjectHolder;
import com.smartpro.mis.modular.business.service.IUserdeviceService;
import com.smartpro.mis.modular.system.model.Userdevice;
import com.smartpro.mis.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.smartpro.mis.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.smartpro.mis.modular.system.model.Userdevice;
import com.smartpro.mis.modular.business.service.IUserdeviceService;

/**
 * 用户设备管理控制器
 *
 * @author mengiy
 * @Date 2018-03-22 12:07:52
 */
@Controller
@RequestMapping("/userdevice")
public class UserdeviceController extends BaseController {

    private String PREFIX = "/business/userdevice/";

    @Autowired
    private IUserdeviceService userdeviceService;

    /**
     * 跳转到用户设备管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "userdevice.html";
    }

    /**
     * 跳转到添加用户设备管理
     */
    @RequestMapping("/userdevice_add")
    public String userdeviceAdd() {
        return PREFIX + "userdevice_add.html";
    }

    /**
     * 跳转到修改用户设备管理
     */
    @RequestMapping("/userdevice_update/{userdeviceId}")
    public String userdeviceUpdate(@PathVariable Integer userdeviceId, Model model) {
        Userdevice userdevice = userdeviceService.selectById(userdeviceId);
        model.addAttribute("item",userdevice);
        LogObjectHolder.me().set(userdevice);
        return PREFIX + "userdevice_edit.html";
    }

    /**
     * 获取用户设备管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return userdeviceService.selectList(null);
    }

    /**
     * 新增用户设备管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Userdevice userdevice) {
        userdeviceService.insert(userdevice);
        return SUCCESS_TIP;
    }

    /**
     * 删除用户设备管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer userdeviceId) {
        userdeviceService.deleteById(userdeviceId);
        return SUCCESS_TIP;
    }

    /**
     * 修改用户设备管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Userdevice userdevice) {
        userdeviceService.updateById(userdevice);
        return SUCCESS_TIP;
    }

    /**
     * 用户设备管理详情
     */
    @RequestMapping(value = "/detail/{userdeviceId}")
    @ResponseBody
    public Object detail(@PathVariable("userdeviceId") Integer userdeviceId) {
        return userdeviceService.selectById(userdeviceId);
    }
}
