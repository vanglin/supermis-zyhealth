package com.smartpro.mis.modular.business.controller;

import com.smartpro.mis.core.log.LogObjectHolder;
import com.smartpro.mis.modular.business.service.IAsthrecordService;
import com.smartpro.mis.modular.system.model.Asthrecord;
import com.smartpro.mis.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.smartpro.mis.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.smartpro.mis.modular.system.model.Asthrecord;
import com.smartpro.mis.modular.business.service.IAsthrecordService;

/**
 * 哮喘记录管理控制器
 *
 * @author mengiy
 * @Date 2018-03-22 14:24:32
 */
@Controller
@RequestMapping("/asthrecord")
public class AsthrecordController extends BaseController {

    private String PREFIX = "/business/asthrecord/";

    @Autowired
    private IAsthrecordService asthrecordService;

    /**
     * 跳转到哮喘记录管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "asthrecord.html";
    }

    /**
     * 跳转到添加哮喘记录管理
     */
    @RequestMapping("/asthrecord_add")
    public String asthrecordAdd() {
        return PREFIX + "asthrecord_add.html";
    }

    /**
     * 跳转到修改哮喘记录管理
     */
    @RequestMapping("/asthrecord_update/{asthrecordId}")
    public String asthrecordUpdate(@PathVariable Integer asthrecordId, Model model) {
        Asthrecord asthrecord = asthrecordService.selectById(asthrecordId);
        model.addAttribute("item",asthrecord);
        LogObjectHolder.me().set(asthrecord);
        return PREFIX + "asthrecord_edit.html";
    }

    /**
     * 获取哮喘记录管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return asthrecordService.selectList(null);
    }

    /**
     * 新增哮喘记录管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Asthrecord asthrecord) {
        asthrecordService.insert(asthrecord);
        return SUCCESS_TIP;
    }

    /**
     * 删除哮喘记录管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer asthrecordId) {
        asthrecordService.deleteById(asthrecordId);
        return SUCCESS_TIP;
    }

    /**
     * 修改哮喘记录管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Asthrecord asthrecord) {
        asthrecordService.updateById(asthrecord);
        return SUCCESS_TIP;
    }

    /**
     * 哮喘记录管理详情
     */
    @RequestMapping(value = "/detail/{asthrecordId}")
    @ResponseBody
    public Object detail(@PathVariable("asthrecordId") Integer asthrecordId) {
        return asthrecordService.selectById(asthrecordId);
    }
}
