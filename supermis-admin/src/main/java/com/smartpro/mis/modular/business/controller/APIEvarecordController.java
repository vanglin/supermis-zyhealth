package com.smartpro.mis.modular.business.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.smartpro.mis.core.base.controller.BaseController;
import com.smartpro.mis.core.common.annotion.BussinessLog;
import com.smartpro.mis.core.common.constant.dictmap.UserDict;
import com.smartpro.mis.core.common.exception.BizExceptionEnum;
import com.smartpro.mis.core.exception.SupermisException;
import com.smartpro.mis.core.util.ToolUtil;
import com.smartpro.mis.modular.business.apiEntity.EvaRecordParams;
import com.smartpro.mis.modular.business.service.IEvarecordService;
import com.smartpro.mis.modular.system.model.Evarecord;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.sf.jsqlparser.expression.operators.relational.OldOracleJoinBinaryExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 评测记录管理控制器
 *
 * @author mengiy
 * @Date 2018-03-21 20:02:55
 */
@RestController
@RequestMapping("/api/service")
public class APIEvarecordController extends BaseController {

    @Autowired
    private IEvarecordService evarecordService;


    /**
     * 获取评测记录管理列表
     */
    @ApiOperation(value = "条件查询评测列表",notes="根据条件查询评测列表" )
    @ApiImplicitParam(name = "evaRecordParams", value = "查询条件，uid为必选，其余为可选项,且startTime与endTime是成对出现",required = true,dataType = "EvaRecordParams")
    @BussinessLog(value = "API条件查询评测列表", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/evaRec/getList",method = RequestMethod.POST)
    public Object getList(@RequestBody EvaRecordParams evaRecordParams ) {
        if(ToolUtil.isEmpty(evaRecordParams.getUid())){
            throw  new SupermisException(BizExceptionEnum.ERROR_WRAPPER_FIELD);
        }
        return evarecordService.selectEvaList(evaRecordParams.getUid(),evaRecordParams.getEvaType(),evaRecordParams.getDeviceId(),
                evaRecordParams.getStartTime(),evaRecordParams.getEndTime());
    }

    /**
     * 自定义查询评测记录列表
     */
    @ApiOperation(value = "自定义条件查询评测列表",notes="根据条件查询评测列表" )
    @BussinessLog(value = "API自定义条件查询评测列表", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/evaRec/listEva",method = RequestMethod.POST)
    public List<Evarecord> listEva(@RequestBody HashMap map) {

        return evarecordService.selectByMap(map);
    }

    /**
     * 获取评测记录管理列表
     */
    @ApiOperation(value = "获取评测列表",notes="获取所有的评测列表" )
    @RequestMapping(value = "/evaRec/list",method = RequestMethod.GET)
    @BussinessLog(value = "API获取评测列表", key = "id", dict = UserDict.class)
    public Object list() {
        return evarecordService.selectList(null);
    }

    /**
     * 新增评测记录管理
     */
    @ApiOperation(value ="新增用户评测",notes = "根据不同评测类型添加")
    @ApiImplicitParam(name = "evarecord", value = "评测结果详细信息", required = true, dataType = "Evarecord")
    @BussinessLog(value = "API用户新增评测", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/evaRec/add",method = RequestMethod.POST)
    public Object add(@RequestBody Evarecord evarecord) {
        if(ToolUtil.isEmpty(evarecord.getUid())){
            throw  new SupermisException(BizExceptionEnum.ERROR_WRAPPER_FIELD);
        }
        if(null == evarecord.getEvaTime()){
            evarecord.setEvaTime( new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        }
        evarecordService.insert(evarecord);
        return SUCCESS_TIP;
    }

    /**
     * 删除评测记录管理
     */
    @ApiOperation(value ="删除用户评测")
    @ApiImplicitParam(name = "evarecordId", value = "评测编号", required = true, dataType = "Integer")
    @BussinessLog(value = "API删除评测", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/evaRec/delete/{evarecordId}",method = RequestMethod.GET)
    public Object delete(@PathVariable Integer evarecordId) {
        evarecordService.deleteById(evarecordId);
        return SUCCESS_TIP;
    }

    /**
     * 修改评测记录管理
     */
    @ApiOperation(value ="修改评测记录")
    @ApiImplicitParam(name = "evarecord", value = "评测记录详细信息", required = true, dataType = "Evarecord")
    @BussinessLog(value = "API修改评测记录", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/evaRec/update",method = RequestMethod.POST)
    public Object update(@RequestBody Evarecord evarecord) {
        evarecordService.updateById(evarecord);
        return SUCCESS_TIP;
    }

    /**
     * 评测记录详情
     */
    @ApiOperation(value ="查看评测记录详情",notes = "需要评测记录的唯一标识")
    @ApiImplicitParam(name = "evarecordId", value = "评测记录的唯一标识", required = true, dataType = "Integer")
    @BussinessLog(value = "API修改评测记录", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/evaRec/detail/{evarecordId}",method = RequestMethod.GET)
    public Object detail(@PathVariable("evarecordId") Integer evarecordId) {
        return evarecordService.selectById(evarecordId);
    }


    /**
     * 根据自定义查询条件统计评测
     */
    @ApiOperation(value = "统计自定义条件查询评测列表",notes="根据查询条件统计评测症状描述和用药记录" )
    @BussinessLog(value = "API统计自定义条件查询的评测", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/evaRec/statSymp",method = RequestMethod.POST)
    public Map<String,Object> statSymp(@RequestBody EvaRecordParams evaRecordParams ) {
        Map<String,Integer> sysmMap = new HashMap<String,Integer>();
        Map<String,Integer> medMap = new HashMap<String,Integer>();
        Map<String,Integer> pefMap = new HashMap<String,Integer>();
//        Map<String,Integer> fev1Map = new HashMap<String,Integer>();
//        Map<String,Integer> fvcMap = new HashMap<String,Integer>();
        float flag = 13;
        pefMap.put("low",0);
        pefMap.put("high",0);
        List evalist = evarecordService.selectEvaList(evaRecordParams.getUid(),evaRecordParams.getEvaType(),evaRecordParams.getDeviceId(),
                evaRecordParams.getStartTime(),evaRecordParams.getEndTime());
        List<JSONObject> jsonList =  JSONObject.parseArray(JSON.toJSONString(evalist),JSONObject.class);
        for(JSONObject eva : jsonList){
            //统计症状
            String sysm = eva.getString("symDescription");
            if(null!=sysm && sysm.contains(",")){
             String[] sysms = sysm.split(",");
             for(String sys: sysms){
                 if(sysmMap.keySet().contains(sys)){
                     sysmMap.put(sys,sysmMap.get(sys)+1);
                 }else{
                     sysmMap.put(sys,1);
                 }
             }
         }else if(null!=sysm && !sysm.contains(",")){
             if(sysmMap.keySet().contains(sysm)){
                 sysmMap.put(sysm,sysmMap.get(sysm)+1);
             }else{
                 sysmMap.put(sysm,1);
             }
         }

         //统计用药记录
            String med = eva.getString("medRecord");
            if(null!=med && med.contains(",")){
                String[] meds = med.split(",");
                for(String m: meds){
                    if(null!=medMap.keySet() && medMap.keySet().contains(m)){
                        sysmMap.put(m,sysmMap.get(m)+1);
                    }else{
                        sysmMap.put(m,1);
                    }
                }
            }else if(null!=med && !med.contains(",")){
                if(null!=medMap.keySet() && medMap.keySet().contains(med)){
                    medMap.put(med,medMap.get(med)+1);
                }else{
                    medMap.put(med,1);
                }
            }

            //统计PEF值区间个数
            String evaType = eva.getString("evaType");
            String evaValue = eva.getString("evaValue");
//            System.out.println("evaValue##########"+evaValue);
            if(evaType.equals("PEF") && null != evaValue){
                JSONObject json = JSONObject.parseObject(evaValue.replace("'","\""));
                if(null != json.getString("PEF")) {
                    float PEF = Float.parseFloat(json.getString("PEF"));
                    if (PEF < flag) {
                        pefMap.put("low", pefMap.get("low") + 1);
                    } else {
                        pefMap.put("high", pefMap.get("high") + 1);
                    }
                }
            }
        }
        HashMap<String,Object> result = new HashMap<String,Object>();
        result.put("symDescription",sysmMap);
        result.put("medRecord",medMap);
        result.put("PEF",pefMap);
        return result;
    }
}
