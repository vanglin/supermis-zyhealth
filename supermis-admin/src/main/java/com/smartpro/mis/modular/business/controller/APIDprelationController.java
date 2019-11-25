package com.smartpro.mis.modular.business.controller;

import com.smartpro.mis.core.base.controller.BaseController;
import com.smartpro.mis.core.common.annotion.BussinessLog;
import com.smartpro.mis.core.common.constant.dictmap.UserDict;
import com.smartpro.mis.core.common.exception.BizExceptionEnum;
import com.smartpro.mis.core.exception.SupermisException;
import com.smartpro.mis.modular.business.service.IDprelationService;
import com.smartpro.mis.modular.system.model.Dprelation;
import com.smartpro.mis.modular.system.model.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 控制器
 *
 * @author mengiy
 * @Date 2018-03-29 22:25:01
 */
@RestController
@RequestMapping("/api/service")
public class APIDprelationController extends BaseController {


    @Autowired
    private IDprelationService dprelationService;

    /**
     * 获取列表
     */

    @ApiOperation(value = "查询关系列表",notes="获取全部关系列表" )
    @BussinessLog(value = "API查询关系列表", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/dpRel/list",method = RequestMethod.GET)
    public Object list() {
        return dprelationService.selectList(null);
    }


    /**
     * 获取某个医生的已经绑定的病人列表
     */

    @ApiOperation(value = "查询病人关系列表",notes="获取医生下全部绑定医患关系列表" )
    @BussinessLog(value = "API查询病人列表", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/dpRel/patlist/{docid}",method = RequestMethod.GET)
    public Object paclist(@PathVariable Integer docid) {
//        Map<String,Object> condition = new HashMap<>();
////        condition.put("doctorId",docid);
////        return  dprelationService.selectByMap(condition);
        return dprelationService.selectPacsByKey(docid);
    }

    /**
     * 获取病人的已经绑定的医生列表
     */

    @ApiOperation(value = "查询医生关系列表",notes="获取普通用户下绑定医生关系列表" )
    @BussinessLog(value = "API查询医生列表", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/dpRel/doclist/{pacid}",method = RequestMethod.GET)
    public Object doclist(@PathVariable Integer pacid) {
//        Map<String,Object> condition = new HashMap<>();
//        condition.put("patientId",pacid);
//        return  dprelationService.selectByMap(condition);
        return dprelationService.selectDocsByKey(pacid);
    }

    /**
     * 获取某个医生的病人列表，包括绑定和已发送请求绑定
     */

    @ApiOperation(value = "查询病人关系列表",notes="获取医生下全部绑定医患关系列表" )
    @BussinessLog(value = "API查询病人列表", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/dpRel/allPatlist/{docid}",method = RequestMethod.GET)
    public Object allPatlist(@PathVariable Integer docid) {
//        Map<String,Object> condition = new HashMap<>();
////        condition.put("doctorId",docid);
////        return  dprelationService.selectByMap(condition);
        return dprelationService.selectPacs(docid,-1);
    }

    /**
     * 获取病人的已经的医生列表，包括绑定和已发送请求绑定
     */

    @ApiOperation(value = "查询医生关系列表",notes="获取普通用户下绑定医生关系列表" )
    @BussinessLog(value = "API查询医生列表", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/dpRel/allDoclist/{pacid}",method = RequestMethod.GET)
    public Object allDoclist(@PathVariable Integer pacid) {
//        Map<String,Object> condition = new HashMap<>();
//        condition.put("patientId",pacid);
//        return  dprelationService.selectByMap(condition);
        /**
         * * status 为 -1 表示忽略status字段查询条件；
         *      * status 为 1 表示已经建立绑定关系的列表；
         *      * status 为 2 表示医生发出与病人建立绑定关系的请求等待病人同意的列表；
         *      * status 为 5 表示病人发出与医生建立绑定关系的请求等待医生同意的列表；
         */
        return dprelationService.selectDocs(pacid,-1);
    }


    /**
     * 新增
     */
    @ApiOperation(value ="新增关系")
    @ApiImplicitParam(name = "dprelation", value = "新增绑定关系", required = true, dataType = "Dprelation")
    @BussinessLog(value = "API绑定关系", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/dpRel/add",method = RequestMethod.POST)
    public Object add(@RequestBody  Dprelation dprelation) {
        Map<String,Object> res = new HashMap<>();
        String message="";
        dprelation.setCreateTime(new Date());
        Map<String,Object> condition = new HashedMap();
        condition.put("doctorId",dprelation.getDoctorId());
//        condition.put("cardNo",cardNo);
        condition.put("patientId",dprelation.getPatientId());
        List<Dprelation> dlist = this.dprelationService.selectByMap(condition);
        if(dlist.size()==0){
            dprelationService.insert(dprelation);
            return SUCCESS_TIP;
        }else {
            if(dlist.get(0).getStatus()==1){
                message="已经绑定";
            }else {
                message="已经发出请求，待同意.";
            }
            res.put("code",401);
            res.put("message",message);
            return res;
        }


    }

    /**
     * 修改
     */

    @ApiOperation(value ="更新关系")
    @ApiImplicitParam(name = "condition", value = "更新绑定关系,条件数据格式：{'id':3,'status':5}", required = true, dataType = "Map")
    @BussinessLog(value = "API更新绑定关系", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/dpRel/update",method = RequestMethod.POST)
    @ResponseBody
    public Object update(@RequestBody Map<String,Object> condition) {
//        dprelation.setUpdateTime(new Date());
//        dprelationService.updateById(dprelation);
        int id,status;
        try {
             id = (Integer) condition.get("id");
            status = (Integer) condition.get("status");

        }catch (Exception e){
            throw new SupermisException(BizExceptionEnum.REQUEST_INVALIDATE);
        }
        dprelationService.setStatus(id,status);
        return SUCCESS_TIP;
    }


    /**
     * 删除(伪删除)
     */
    @ApiOperation(value ="删除医生普通用户关系")
    @ApiImplicitParam(name = "dprelationId", value = "关系编号", required = true, dataType = "Integer")
    @BussinessLog(value = "API删除关系", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/dpRel/delete/{dprelationId}",method = RequestMethod.GET)
    public Object delete(@PathVariable Integer dprelationId) {
       Dprelation dprelation = dprelationService.selectById(dprelationId);
        dprelation.setStatus(-1);
        dprelation.setUpdateTime(new Date());
        dprelationService.updateById(dprelation);
        return SUCCESS_TIP;
    }

    /**
     * 物理删除
     */
    @ApiOperation(value ="删除医生普通用户关系")
    @ApiImplicitParam(name = "dprelationId", value = "关系编号", required = true, dataType = "Integer")
    @BussinessLog(value = "API删除关系", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/dpRel/relDel/{dprelationId}",method = RequestMethod.GET)
    public Object relDel(@PathVariable Integer dprelationId) {
        dprelationService.deleteById(dprelationId);
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/dpRel/detail/{dprelationId}")
    @ResponseBody
    public Object detail(@PathVariable("dprelationId") Integer dprelationId) {
        return dprelationService.selectById(dprelationId);
    }
}
