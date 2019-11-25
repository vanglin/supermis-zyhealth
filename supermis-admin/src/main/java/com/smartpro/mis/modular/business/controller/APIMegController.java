package com.smartpro.mis.modular.business.controller;

import com.smartpro.mis.core.base.controller.BaseController;
import com.smartpro.mis.core.common.annotion.BussinessLog;
import com.smartpro.mis.core.common.constant.dictmap.UserDict;
import com.smartpro.mis.modular.business.apiEntity.MegParams;
import com.smartpro.mis.modular.business.service.IInteractmessageService;
import com.smartpro.mis.modular.system.model.Interactmessage;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 留言控制器
 *
 * @author mengiy
 * @Date 2018-03-22 16:24:06
 */
@RestController
@RequestMapping("/api/service")
public class APIMegController extends BaseController {

    @Autowired
    private IInteractmessageService interactmessageService;

    /**
     * 获取留言列表
     */
    @ApiOperation(value = "查询留言列表",notes="获取全部留言列表" )
    @BussinessLog(value = "API查询留言列表", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/meg/list",method = RequestMethod.GET)
    public Object list() {
        return interactmessageService.selectList(null);
    }

    /**
     * 获取特定用户的留言列表
     */
    @ApiOperation(value ="获取用户留言列表",notes = "需要用户的ID，查询与某人的交互聊天消息")
    @ApiImplicitParam(name = "megParams", value = "留言查询条件，uid为必选，其余为可选", required = true, dataType = "MegParams")
    @BussinessLog(value = "API获取用户留言列表", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/meg/listMegs",method = RequestMethod.POST)
    public Object listMegs(@RequestBody MegParams megParams) {
        return interactmessageService.selectListMegs(megParams);
    }


    /**
     * 新增留言
     */
    @ApiOperation(value ="新增留言")
    @ApiImplicitParam(name = "interactmessage", value = "留言详细信息", required = true, dataType = "Interactmessage")
    @BussinessLog(value = "API新增留言", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/meg/add",method = RequestMethod.POST)
    public Object add(@RequestBody Interactmessage interactmessage) {
        /**
         * 每条消息记录保存两条，用空间换时间效率
         */
         Date currTime = new Date();
        interactmessage.setSendTime(currTime);
        interactmessage.setMesOwner(interactmessage.getMegSender());
        interactmessage.setContraid(interactmessage.getMegReciver());
        interactmessage.setMegType(1);
        Interactmessage meg = new Interactmessage();
        meg.setMegType(1);
        meg.setSendTime(currTime);
        meg.setMesOwner(interactmessage.getMegReciver());
        meg.setContraid(interactmessage.getMegSender());
        meg.setMegSender(interactmessage.getMegSender());
        meg.setMegReciver(interactmessage.getMegReciver());
        meg.setMegContent(interactmessage.getMegContent());
        meg.setAltercol(interactmessage.getAltercol());
        List<Interactmessage> meglist = new ArrayList<Interactmessage>();
        meglist.add(interactmessage);
        meglist.add(meg);
//        interactmessageService.insertMeg(interactmessage);
        interactmessageService.insertBatch(meglist);
        return SUCCESS_TIP;
    }

    /**
     * 删除留言
     */
    @ApiOperation(value ="删除留言")
    @ApiImplicitParam(name = "interactmessageId", value = "留言编号", required = true, dataType = "interactmessageId")
    @BussinessLog(value = "API删除留言", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/meg/delete/{interactmessageId}",method = RequestMethod.GET)
    public Object delete(@PathVariable Integer interactmessageId) {
        interactmessageService.deleteById(interactmessageId);
        return SUCCESS_TIP;
    }

    /**
     * 修改留言
     */
    @ApiOperation(value ="修改留言")
    @ApiImplicitParam(name = "interactmessage", value = "留言详细信息", required = true, dataType = "Interactmessage")
    @BussinessLog(value = "API修改留言信息", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/meg/update",method = RequestMethod.POST)
    public Object update(@RequestBody Interactmessage interactmessage) {
        interactmessageService.updateById(interactmessage);
        return SUCCESS_TIP;
    }

    /**
     * 留言详情
     */
    @ApiOperation(value ="查看留言详情",notes = "需要留言的唯一标识")
    @ApiImplicitParam(name = "interactmessageId", value = "留言的唯一标识", required = true, dataType = "Integer")
    @BussinessLog(value = "API查看留言", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/meg/detail/{interactmessageId}",method = RequestMethod.GET)
    public Object detail(@PathVariable("interactmessageId") Integer interactmessageId) {
        Interactmessage meg = interactmessageService.selectById(interactmessageId);
        interactmessageService.viewMeg(interactmessageId);
        return meg;
    }


    /**
     * 查询未读消息
     */
    @ApiOperation(value ="查看未读消息",notes = "需要当前用户编号，即megReciver")
    @ApiImplicitParam(name = "megReciver", value = "药物的唯一标识", required = true, dataType = "Integer")
    @BussinessLog(value = "API查询未读消息", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/meg/secUnread/{megReciver}",method = RequestMethod.GET)
    public Object secUnread(@PathVariable("megReciver") Integer megReciver) {
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("isRead","0");
        condition.put("contraid",megReciver);
        condition.put("megReciver",megReciver);
        return interactmessageService.selectByMap(condition);
    }
}
