package com.smartpro.mis.modular.business.controller;

import com.smartpro.mis.core.base.controller.BaseController;
import com.smartpro.mis.core.log.LogObjectHolder;
import com.smartpro.mis.modular.business.service.IEvarecordService;
import com.smartpro.mis.modular.system.model.Evarecord;
import com.smartpro.mis.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.smartpro.mis.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.smartpro.mis.modular.system.model.Evarecord;
import com.smartpro.mis.modular.business.service.IEvarecordService;

/**
 * 评测记录管理控制器
 *
 * @author mengiy
 * @Date 2018-03-21 20:02:55
 */
@Controller
@RequestMapping("/evarecord")
public class EvarecordController extends BaseController {

    private String PREFIX = "/business/evarecord/";

    @Autowired
    private IEvarecordService evarecordService;

    /**
     * 跳转到评测记录管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "evarecord.html";
    }

    /**
     * 跳转到添加评测记录管理
     */
    @RequestMapping("/evarecord_add")
    public String evarecordAdd() {
        return PREFIX + "evarecord_add.html";
    }

    /**
     * 跳转到修改评测记录管理
     */
    @RequestMapping("/evarecord_update/{evarecordId}")
    public String evarecordUpdate(@PathVariable Integer evarecordId, Model model) {
        Evarecord evarecord = evarecordService.selectById(evarecordId);
        model.addAttribute("item",evarecord);
        LogObjectHolder.me().set(evarecord);
        return PREFIX + "evarecord_edit.html";
    }

    /**
     * 获取评测记录管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return evarecordService.selectList(null);
    }

    /**
     * 新增评测记录管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Evarecord evarecord) {
        evarecordService.insert(evarecord);
        return SUCCESS_TIP;
    }

    /**
     * 删除评测记录管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer evarecordId) {
        evarecordService.deleteById(evarecordId);
        return SUCCESS_TIP;
    }

    /**
     * 修改评测记录管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Evarecord evarecord) {
        evarecordService.updateById(evarecord);
        return SUCCESS_TIP;
    }

    /**
     * 评测记录管理详情
     */
    @RequestMapping(value = "/detail/{evarecordId}")
    @ResponseBody
    public Object detail(@PathVariable("evarecordId") Integer evarecordId) {
        return evarecordService.selectById(evarecordId);
    }
}
