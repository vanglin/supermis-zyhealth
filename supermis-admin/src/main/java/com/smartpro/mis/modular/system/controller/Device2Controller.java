package com.smartpro.mis.modular.system.controller;

import com.smartpro.mis.core.log.LogObjectHolder;
import com.smartpro.mis.modular.system.model.Device;
import com.smartpro.mis.modular.system.service.IDevice2Service;
import com.smartpro.mis.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.smartpro.mis.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.smartpro.mis.modular.system.model.Device;
import com.smartpro.mis.modular.system.service.IDevice2Service;

/**
 * 设备管理控制器
 *
 * @author mengiy
 * @Date 2018-03-22 11:23:50
 */
@Controller
@RequestMapping("/device2")
public class Device2Controller extends BaseController {

    private String PREFIX = "/system/device/";

    @Autowired
    private IDevice2Service deviceService;

    /**
     * 跳转到设备管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "device.html";
    }

    /**
     * 跳转到添加设备管理
     */
    @RequestMapping("/device_add")
    public String deviceAdd() {
        return PREFIX + "device_add.html";
    }

    /**
     * 跳转到修改设备管理
     */
    @RequestMapping("/device_update/{deviceId}")
    public String deviceUpdate(@PathVariable Integer deviceId, Model model) {
        Device device = deviceService.selectById(deviceId);
        model.addAttribute("item",device);
        LogObjectHolder.me().set(device);
        return PREFIX + "device_edit.html";
    }

    /**
     * 获取设备管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return deviceService.selectList(null);
    }

    /**
     * 新增设备管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Device device) {
        deviceService.insert(device);
        return SUCCESS_TIP;
    }

    /**
     * 删除设备管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer deviceId) {
        deviceService.deleteById(deviceId);
        return SUCCESS_TIP;
    }

    /**
     * 修改设备管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Device device) {
        deviceService.updateById(device);
        return SUCCESS_TIP;
    }

    /**
     * 设备管理详情
     */
    @RequestMapping(value = "/detail/{deviceId}")
    @ResponseBody
    public Object detail(@PathVariable("deviceId") Integer deviceId) {
        return deviceService.selectById(deviceId);
    }
}
