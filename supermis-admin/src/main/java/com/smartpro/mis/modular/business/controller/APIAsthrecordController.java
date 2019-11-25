package com.smartpro.mis.modular.business.controller;

import com.smartpro.mis.core.base.controller.BaseController;
import com.smartpro.mis.core.common.annotion.BussinessLog;
import com.smartpro.mis.core.common.constant.dictmap.UserDict;
import com.smartpro.mis.modular.business.service.IAsthrecordService;
import com.smartpro.mis.modular.system.model.Asthrecord;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 哮喘记录管理控制器
 *
 * @author mengiy
 * @Date 2018-03-22 14:24:32
 */
@RestController
@RequestMapping("/api/service")
public class APIAsthrecordController extends BaseController {


    @Autowired
    private IAsthrecordService asthrecordService;

    /**
     * 获取哮喘记录管理列表
     */
    @ApiOperation(value ="获取哮喘记录管理列表")
    @BussinessLog(value = "API获取哮喘记录管理列表", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/asth/list",method = RequestMethod.GET)
    public Object list() {
        return asthrecordService.selectList(null);
    }

    /**
     * 获取指定用户的哮喘记录列表
     */
    @ApiOperation(value ="获取指定用户的哮喘记录列表",notes = "需要用户的身份证号，即cardNo不能为空")
    @BussinessLog(value = "API获取用户的哮喘记录列表", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/asth/aslist/{cardNo}",method = RequestMethod.GET)
    public Object selectAsthlist(@PathVariable String cardNo) {
        return asthrecordService.selectListByCardNo(cardNo);
    }
    /**
     * 新增哮喘记录管理
     */
    @ApiOperation(value ="新增哮喘记录",notes = "新增用户的哮喘记录")
    @BussinessLog(value = "API新增哮喘记录", key = "id", dict = UserDict.class)
    @ApiImplicitParam(name = "asthrecord",value = "哮喘记录的详细信息",required = true,dataType = "Asthrecord")
    @RequestMapping(value = "/asth/add",method = RequestMethod.POST)
    public Object add(@RequestBody Asthrecord asthrecord) {
        asthrecordService.insert(asthrecord);
        return SUCCESS_TIP;
    }

    /**
     * 删除哮喘记录管理
     */
    @RequestMapping(value = "/asth/delete/{id}",method = RequestMethod.GET)
    @ApiOperation(value ="删除哮喘记录",notes = "删除用户哮喘记录")
    @BussinessLog(value = "API删除用户设备", key = "id", dict = UserDict.class)
    @ApiImplicitParam(name = "userdeviceId",value = "用户设备编号",required = true,dataType = "Integer")
    public Object delete(@PathVariable("id") Integer asthrecordId) {
        asthrecordService.deleteById(asthrecordId);
        return SUCCESS_TIP;
    }

    /**
     * 修改哮喘记录管理
     */
    @RequestMapping(value = "/asth/update",method = RequestMethod.POST)
    @ApiOperation(value ="修改哮喘记录",notes = " 修改哮喘记录详细信息")
    @BussinessLog(value = "API修改哮喘记录", key = "id", dict = UserDict.class)
    @ApiImplicitParam(name = "asthrecord",value = "哮喘记录",required = true,dataType = "Asthrecord")
    public Object update(@RequestBody Asthrecord asthrecord) {
        asthrecordService.updateById(asthrecord);
        return SUCCESS_TIP;
    }

    /**
     * 哮喘记录管理详情
     */
    @RequestMapping(value = "/asth/detail/{asthrecordId}",method = RequestMethod.POST)
    @ApiOperation(value ="查看哮喘记录",notes = " 查看哮喘记录详细信息")
    @BussinessLog(value = "API查看哮喘记录", key = "id", dict = UserDict.class)
    @ApiImplicitParam(name = "asthrecordId",value = "哮喘记录ID",required = true,dataType = "Integer")
    public Object detail(@PathVariable("asthrecordId") Integer asthrecordId) {
        return asthrecordService.selectById(asthrecordId);
    }
}
