package com.smartpro.mis.modular.business.controller;

import com.smartpro.mis.core.base.controller.BaseController;
import com.smartpro.mis.core.common.annotion.BussinessLog;
import com.smartpro.mis.core.common.constant.dictmap.UserDict;
import com.smartpro.mis.modular.business.service.IUserdeviceService;
import com.smartpro.mis.modular.system.model.Userdevice;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户设备管理控制器
 * 设备由系统后台添加，用户只能操作后台系统存在的设备
 * @author mengiy
 * @Date 2018-03-22 12:07:52
 */
@RestController
@RequestMapping("/api/service")
public class APIUserdeviceController extends BaseController {

    @Autowired
    private IUserdeviceService userdeviceService;

    /**
     * 获取用户设备管理列表
     */
    @ApiOperation(value ="获取用户设备列表",notes = "需要用户的唯一标识")
    @BussinessLog(value = "API获取用户设备列表", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/udevice/list/{uid}",method = RequestMethod.GET)
    public Object list(@PathVariable int uid) {
        return userdeviceService.selectListByUid(uid);
    }

    /**
     * 新增用户设备管理
     */
    @ApiOperation(value ="新增用户设备",notes = "绑定系统已经存在的设备")
    @BussinessLog(value = "API新增用户设备", key = "id", dict = UserDict.class)
    @ApiImplicitParam(name = "userdevice",value = "用户对设备的个性化属性设置值",required = true,dataType = "Userdevice")
    @RequestMapping(value = "/udevice/add",method = RequestMethod.POST)
    public Object add(@RequestBody Userdevice userdevice) {
        userdeviceService.insert(userdevice);
        return SUCCESS_TIP;
    }

    /**
     * 删除用户设备管理
     */
    @RequestMapping(value = "/udevice/delete/{userdeviceId}",method = RequestMethod.GET)
    @ApiOperation(value ="删除用户设备",notes = "解绑用户的设备")
    @BussinessLog(value = "API删除用户设备", key = "id", dict = UserDict.class)
    @ApiImplicitParam(name = "userdeviceId",value = "用户设备编号",required = true,dataType = "Integer")
    public Object delete(@PathVariable Integer userdeviceId) {
        userdeviceService.deleteById(userdeviceId);
        return SUCCESS_TIP;
    }

    /**
     * 修改用户设备管理
     */
    @RequestMapping(value = "/udevice/update",method = RequestMethod.POST)
    @ApiOperation(value ="修改用户设备",notes = " 修改用户自设的设备信息")
    @BussinessLog(value = "API修改用户设备", key = "id", dict = UserDict.class)
    @ApiImplicitParam(name = "userdevice",value = "用户对设备的个性化属性设置值",required = true,dataType = "Userdevice")
    public Object update(@RequestBody Userdevice userdevice) {
        userdeviceService.updateById(userdevice);
        return SUCCESS_TIP;
    }

    /**
     * 用户设备简单信息
     */

    @ApiOperation(value ="查看用户设备详细信息",notes = "修改用户自设的设备信息")
    @BussinessLog(value = "API修改用户设备", key = "id", dict = UserDict.class)
    @ApiImplicitParam(name = "userdeviceId",value = "用户对设备的个性化属性设置值",required = true,dataType = "Integer")
    @RequestMapping(value = "/udevice/detail/{userdeviceId}",method = RequestMethod.GET)
    public Object detail(@PathVariable("userdeviceId") Integer userdeviceId) {
        return userdeviceService.selectById(userdeviceId);
    }

    /**
     * 查看用户设备详情
     */
    @RequestMapping(value = "/udevice/view/{userdeviceId}",method = RequestMethod.GET)
    @ApiOperation(value ="查看用户设备",notes = "查看用户设备的详细信息")
    @BussinessLog(value = "API查看用户设备详情", key = "id", dict = UserDict.class)
    @ApiImplicitParam(name = "userdeviceId",value = "用户设备关系记录id",required = true,dataType = "Integer")
    public Object view(@PathVariable("userdeviceId") Integer userdeviceId) {
        return userdeviceService.selectUserDeviceById(userdeviceId).get(0);
    }
}
