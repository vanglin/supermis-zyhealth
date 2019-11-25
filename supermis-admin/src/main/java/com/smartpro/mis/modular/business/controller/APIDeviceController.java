package com.smartpro.mis.modular.business.controller;

import com.smartpro.mis.core.base.controller.BaseController;
import com.smartpro.mis.core.common.annotion.BussinessLog;
import com.smartpro.mis.core.common.constant.dictmap.UserDict;
import com.smartpro.mis.modular.business.service.IDeviceService;
import com.smartpro.mis.modular.system.model.Device;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 设备管理控制器
 *
 * @author mengiy
 * @Date 2018-03-22 11:25:46
 */
@RestController
@RequestMapping("/api/service")
public class APIDeviceController extends BaseController {

    @Autowired
    private IDeviceService deviceService;


    /**
     * 获取设备管理列表
     */
    @ApiOperation(value = "查询设备列表",notes="获取全部设备列表" )
    @BussinessLog(value = "API查询设备列表", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/device/list",method = RequestMethod.GET)
    public Object list() {
        return deviceService.selectList(null);
    }

    /**
     * 新增设备管理
     */
    @ApiOperation(value ="新增设备")
    @ApiImplicitParam(name = "device", value = "评测结果详细信息", required = true, dataType = "Device")
    @BussinessLog(value = "API新增设备", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/device/add",method = RequestMethod.POST)
    public Object add(@RequestBody  Device device) {
        device.setCreateTime(new Date());
        deviceService.insert(device);
        return SUCCESS_TIP;
    }

    /**
     * 删除设备管理
     */
    @ApiOperation(value ="删除设备")
    @ApiImplicitParam(name = "deviceId", value = "设备编号", required = true, dataType = "Integer")
    @BussinessLog(value = "API删除设备", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/device/delete/{deviceId}",method = RequestMethod.GET)
    public Object delete(@PathVariable Integer deviceId) {
        deviceService.deleteById(deviceId);
        return SUCCESS_TIP;
    }

    /**
     * 修改设备管理
     */
    @ApiOperation(value ="修改设备")
    @ApiImplicitParam(name = "device", value = "设备详细信息", required = true, dataType = "Device")
    @BussinessLog(value = "API修改设备信息", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/device/update",method = RequestMethod.POST)
    public Object update(@RequestBody Device device) {
        deviceService.updateById(device);
        return SUCCESS_TIP;
    }

    /**
     * 设备管理详情
     */
    @ApiOperation(value ="查看设备详情",notes = "需要设备的唯一标识")
    @ApiImplicitParam(name = "deviceId", value = "设备的唯一标识", required = true, dataType = "Integer")
    @BussinessLog(value = "API修改设备", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/device/detail/{deviceId}",method = RequestMethod.GET)
    public Object detail(@PathVariable("deviceId") Integer deviceId) {
        return deviceService.selectById(deviceId);
    }
}
