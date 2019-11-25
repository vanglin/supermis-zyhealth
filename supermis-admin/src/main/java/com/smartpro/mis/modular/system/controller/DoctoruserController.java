package com.smartpro.mis.modular.system.controller;

import com.smartpro.mis.core.base.controller.BaseController;
import com.smartpro.mis.core.log.LogObjectHolder;
import com.smartpro.mis.modular.system.model.Doctoruser;
import com.smartpro.mis.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.smartpro.mis.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.smartpro.mis.modular.system.model.Doctoruser;
import com.smartpro.mis.modular.system.service.IDoctoruserService;

/**
 * 医生信息控制器
 *
 * @author mengiy
 * @Date 2018-03-20 14:00:36
 */
@Controller
@RequestMapping("/doctoruser")
public class DoctoruserController extends BaseController {

    private String PREFIX = "/system/doctoruser/";

    @Autowired
    private IDoctoruserService doctoruserService;

    /**
     * 跳转到医生信息首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "doctoruser.html";
    }

    /**
     * 跳转到添加医生信息
     */
    @RequestMapping("/doctoruser_add")
    public String doctoruserAdd() {
        return PREFIX + "doctoruser_add.html";
    }

    /**
     * 跳转到修改医生信息
     */
    @RequestMapping("/doctoruser_update/{doctoruserId}")
    public String doctoruserUpdate(@PathVariable Integer doctoruserId, Model model) {
        Doctoruser doctoruser = doctoruserService.selectById(doctoruserId);
        model.addAttribute("item",doctoruser);
        LogObjectHolder.me().set(doctoruser);
        return PREFIX + "doctoruser_edit.html";
    }

    /**
     * 获取医生信息列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return doctoruserService.selectList(null);
    }

    /**
     * 新增医生信息
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Doctoruser doctoruser) {
        doctoruserService.insert(doctoruser);
        return SUCCESS_TIP;
    }

    /**
     * 删除医生信息
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer doctoruserId) {
        doctoruserService.deleteById(doctoruserId);
        return SUCCESS_TIP;
    }

    /**
     * 修改医生信息
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Doctoruser doctoruser) {
        doctoruserService.updateById(doctoruser);
        return SUCCESS_TIP;
    }

    /**
     * 医生信息详情
     */
    @RequestMapping(value = "/detail/{doctoruserId}")
    @ResponseBody
    public Object detail(@PathVariable("doctoruserId") Integer doctoruserId) {
        return doctoruserService.selectById(doctoruserId);
    }
}
