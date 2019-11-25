package com.smartpro.mis.modular.system.controller;

import com.smartpro.mis.core.log.LogObjectHolder;
import com.smartpro.mis.modular.system.model.Patientuser;
import com.smartpro.mis.modular.system.service.IPatientuserService;
import com.smartpro.mis.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.smartpro.mis.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.smartpro.mis.modular.system.model.Patientuser;
import com.smartpro.mis.modular.system.service.IPatientuserService;

/**
 * 普通用户信息管理控制器
 *
 * @author mengiy
 * @Date 2018-03-20 00:35:47
 */
@Controller
@RequestMapping("/patientuser")
public class PatientuserController extends BaseController {

    private String PREFIX = "/system/patientuser/";

    @Autowired
    private IPatientuserService patientuserService;

    /**
     * 跳转到普通用户信息管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "patientuser.html";
    }

    /**
     * 跳转到添加普通用户信息管理
     */
    @RequestMapping("/patientuser_add")
    public String patientuserAdd() {
        return PREFIX + "patientuser_add.html";
    }

    /**
     * 跳转到修改普通用户信息管理
     */
    @RequestMapping("/patientuser_update/{patientuserId}")
    public String patientuserUpdate(@PathVariable Integer patientuserId, Model model) {
        Patientuser patientuser = patientuserService.selectById(patientuserId);
        model.addAttribute("item",patientuser);
        LogObjectHolder.me().set(patientuser);
        return PREFIX + "patientuser_edit.html";
    }

    /**
     * 获取普通用户信息管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return patientuserService.selectList(null);
    }

    /**
     * 新增普通用户信息管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Patientuser patientuser) {
        patientuserService.insert(patientuser);
        return SUCCESS_TIP;
    }

    /**
     * 删除普通用户信息管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer patientuserId) {
        patientuserService.deleteById(patientuserId);
        return SUCCESS_TIP;
    }

    /**
     * 修改普通用户信息管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Patientuser patientuser) {
        patientuserService.updateById(patientuser);
        return SUCCESS_TIP;
    }

    /**
     * 普通用户信息管理详情
     */
    @RequestMapping(value = "/detail/{patientuserId}")
    @ResponseBody
    public Object detail(@PathVariable("patientuserId") Integer patientuserId) {
        return patientuserService.selectById(patientuserId);
    }
}
