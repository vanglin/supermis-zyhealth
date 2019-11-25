package com.smartpro.mis.modular.business.controller;

import com.smartpro.mis.core.log.LogObjectHolder;
import com.smartpro.mis.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.smartpro.mis.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.smartpro.mis.modular.system.model.Userdrugrecord;
import com.smartpro.mis.modular.business.service.IUserdrugrecordService;

/**
 * 用户药物记录控制器
 *
 * @author mengiy
 * @Date 2018-03-22 15:27:19
 */
@Controller
@RequestMapping("/userdrugrecord")
public class UserdrugrecordController extends BaseController {

    private String PREFIX = "/business/userdrugrecord/";

    @Autowired
    private IUserdrugrecordService userdrugrecordService;

    /**
     * 跳转到用户药物记录首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "userdrugrecord.html";
    }

    /**
     * 跳转到添加用户药物记录
     */
    @RequestMapping("/userdrugrecord_add")
    public String userdrugrecordAdd() {
        return PREFIX + "userdrugrecord_add.html";
    }

    /**
     * 跳转到修改用户药物记录
     */
    @RequestMapping("/userdrugrecord_update/{userdrugrecordId}")
    public String userdrugrecordUpdate(@PathVariable Integer userdrugrecordId, Model model) {
        Userdrugrecord userdrugrecord = userdrugrecordService.selectById(userdrugrecordId);
        model.addAttribute("item",userdrugrecord);
        LogObjectHolder.me().set(userdrugrecord);
        return PREFIX + "userdrugrecord_edit.html";
    }

    /**
     * 获取用户药物记录列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return userdrugrecordService.selectList(null);
    }

    /**
     * 新增用户药物记录
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Userdrugrecord userdrugrecord) {
        userdrugrecordService.insert(userdrugrecord);
        return SUCCESS_TIP;
    }

    /**
     * 删除用户药物记录
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer userdrugrecordId) {
        userdrugrecordService.deleteById(userdrugrecordId);
        return SUCCESS_TIP;
    }

    /**
     * 修改用户药物记录
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Userdrugrecord userdrugrecord) {
        userdrugrecordService.updateById(userdrugrecord);
        return SUCCESS_TIP;
    }

    /**
     * 用户药物记录详情
     */
    @RequestMapping(value = "/detail/{userdrugrecordId}")
    @ResponseBody
    public Object detail(@PathVariable("userdrugrecordId") Integer userdrugrecordId) {
        return userdrugrecordService.selectById(userdrugrecordId);
    }
}
