package com.smartpro.mis.modular.business.controller;

import com.smartpro.mis.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.smartpro.mis.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.smartpro.mis.modular.system.model.Interactmessage;
import com.smartpro.mis.modular.business.service.IInteractmessageService;

/**
 * 留言控制器
 *
 * @author mengiy
 * @Date 2018-03-22 16:24:06
 */
@Controller
@RequestMapping("/interactmessage")
public class InteractmessageController extends BaseController {

    private String PREFIX = "/business/interactmessage/";

    @Autowired
    private IInteractmessageService interactmessageService;

    /**
     * 跳转到留言首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "interactmessage.html";
    }

    /**
     * 跳转到添加留言
     */
    @RequestMapping("/interactmessage_add")
    public String interactmessageAdd() {
        return PREFIX + "interactmessage_add.html";
    }

    /**
     * 跳转到修改留言
     */
    @RequestMapping("/interactmessage_update/{interactmessageId}")
    public String interactmessageUpdate(@PathVariable Integer interactmessageId, Model model) {
        Interactmessage interactmessage = interactmessageService.selectById(interactmessageId);
        model.addAttribute("item",interactmessage);
        LogObjectHolder.me().set(interactmessage);
        return PREFIX + "interactmessage_edit.html";
    }

    /**
     * 获取留言列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return interactmessageService.selectList(null);
    }

    /**
     * 新增留言
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Interactmessage interactmessage) {
        interactmessageService.insert(interactmessage);
        return SUCCESS_TIP;
    }

    /**
     * 删除留言
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer interactmessageId) {
        interactmessageService.deleteById(interactmessageId);
        return SUCCESS_TIP;
    }

    /**
     * 修改留言
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Interactmessage interactmessage) {
        interactmessageService.updateById(interactmessage);
        return SUCCESS_TIP;
    }

    /**
     * 留言详情
     */
    @RequestMapping(value = "/detail/{interactmessageId}")
    @ResponseBody
    public Object detail(@PathVariable("interactmessageId") Integer interactmessageId) {
        return interactmessageService.selectById(interactmessageId);
    }
}
