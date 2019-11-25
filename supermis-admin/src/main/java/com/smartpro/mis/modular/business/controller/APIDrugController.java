package com.smartpro.mis.modular.business.controller;

import com.alibaba.fastjson.JSONObject;
import com.smartpro.mis.core.base.controller.BaseController;
import com.smartpro.mis.core.common.annotion.BussinessLog;
import com.smartpro.mis.core.common.constant.dictmap.UserDict;
import com.smartpro.mis.modular.business.service.IGlobaldrugService;
import com.smartpro.mis.modular.system.model.Answer;
import com.smartpro.mis.modular.system.model.Globaldrug;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 药物库控制器
 *
 * @author mengiy
 * @Date 2018-03-22 15:18:09
 */
@RestController
@RequestMapping("/api/service")
public class APIDrugController extends BaseController {


    @Autowired
    private IGlobaldrugService globaldrugService;

    /**
     * 获取药物库列表
     */
    @ApiOperation(value = "查询药物列表",notes="获取全部药物列表" )
    @BussinessLog(value = "API查询药物列表", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/drug/list",method = RequestMethod.GET)
    public Object list() {
        return globaldrugService.selectList(null);
    }

    /**
     * 获取特定条件药物列表
     */
    @ApiOperation(value ="获取可用药物列表",notes = "需要药物的查询条件信息")
    @ApiImplicitParam(name = "map", value = "药物查询条件，Key/Value形式", required = true, dataType = "HashMap")
    @BussinessLog(value = "API获取指定药物列表", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/drug/listDrugs",method = RequestMethod.POST)
    public List<Globaldrug> listDrugs(@RequestBody HashMap map) {
       return this.globaldrugService.selectByMap(map);
    }


    /**
     * 新增药物库：
     * 字段对应关系：
     * 药物名称：drug
     * 药物类型：alterCol
     * 药物描述：functionDescript
     * 治疗症状：treatSymptoms
     * 规格：advEffect
     * 用量和用法：dosageManage
     * 编辑人：supplier
     *
     *
     */
    @ApiOperation(value ="新增药物")
    @ApiImplicitParam(name = "globaldrug", value = "药物详细信息", required = true, dataType = "Globaldrug")
    @BussinessLog(value = "API新增药物", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/drug/add",method = RequestMethod.POST)
    public Object add(@RequestBody  Globaldrug globaldrug) {
        globaldrug.setCreateTime(new Date());
        globaldrugService.insert(globaldrug);
        return SUCCESS_TIP;
    }

    /**
     * 删除药物库
     */
    @ApiOperation(value ="删除药物")
    @ApiImplicitParam(name = "globaldrugId", value = "药物编号", required = true, dataType = "globaldrugId")
    @BussinessLog(value = "API删除药物", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/drug/delete/{globaldrugId}",method = RequestMethod.GET)
    public Object delete(@PathVariable Integer globaldrugId) {
        globaldrugService.deleteById(globaldrugId);
        return SUCCESS_TIP;
    }

    /**
     * 修改药物库
     */
    @ApiOperation(value ="修改药物")
    @ApiImplicitParam(name = "globaldrug", value = "药物详细信息", required = true, dataType = "Globaldrug")
    @BussinessLog(value = "API修改药物信息", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/drug/update",method = RequestMethod.POST)
    public Object update(@RequestBody Globaldrug globaldrug) {
        globaldrugService.updateById(globaldrug);
        return SUCCESS_TIP;
    }

    /**
     * 药物库详情
     */
    @ApiOperation(value ="查看药物详情",notes = "需要药物的唯一标识")
    @ApiImplicitParam(name = "globaldrugId", value = "药物的唯一标识", required = true, dataType = "Integer")
    @BussinessLog(value = "API查看药物", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/drug/detail/{globaldrugId}",method = RequestMethod.GET)
    public Object detail(@PathVariable("globaldrugId") Integer globaldrugId) {
        return globaldrugService.selectById(globaldrugId);
    }
}
