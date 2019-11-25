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
import com.smartpro.mis.modular.system.model.Dprelation;
import com.smartpro.mis.modular.business.service.IDprelationService;

/**
 * 控制器
 *
 * @author mengiy
 * @Date 2018-03-29 22:25:01
 */
@Controller
@RequestMapping("/dprelation")
public class DprelationController extends BaseController {

    private String PREFIX = "/business/dprelation/";

    @Autowired
    private IDprelationService dprelationService;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "dprelation.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/dprelation_add")
    public String dprelationAdd() {
        return PREFIX + "dprelation_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/dprelation_update/{dprelationId}")
    public String dprelationUpdate(@PathVariable Integer dprelationId, Model model) {
        Dprelation dprelation = dprelationService.selectById(dprelationId);
        model.addAttribute("item",dprelation);
        LogObjectHolder.me().set(dprelation);
        return PREFIX + "dprelation_edit.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return dprelationService.selectList(null);
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Dprelation dprelation) {
        dprelationService.insert(dprelation);
        return SUCCESS_TIP;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer dprelationId) {
        dprelationService.deleteById(dprelationId);
        return SUCCESS_TIP;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Dprelation dprelation) {
        dprelationService.updateById(dprelation);
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail/{dprelationId}")
    @ResponseBody
    public Object detail(@PathVariable("dprelationId") Integer dprelationId) {
        return dprelationService.selectById(dprelationId);
    }
}
