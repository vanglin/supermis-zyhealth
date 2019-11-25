package com.smartpro.mis.modular.business.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.smartpro.mis.core.base.controller.BaseController;
import com.smartpro.mis.core.common.annotion.BussinessLog;
import com.smartpro.mis.core.common.constant.dictmap.UserDict;
import com.smartpro.mis.modular.business.service.IAnswerService;
import com.smartpro.mis.modular.system.model.Answer;
import com.smartpro.mis.modular.system.model.User;
import com.smartpro.mis.modular.system.service.IUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 互动问答控制器
 *
 * @author fengshuonan
 * @Date 2018-04-22 20:58:15
 */
@RestController
@RequestMapping("/api/service")
public class APIAnswerController extends BaseController {

    @Autowired
    private IAnswerService answerService;

    @Autowired
    private IUserService userService;



    /**
     * 获取互动问答列表
     */
    @ApiOperation(value = "查询互动问答列表",notes="获取全部问答列表" )
    @BussinessLog(value = "API查询互动问答列表", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/qaMeg/list",method = RequestMethod.GET)
    @ResponseBody
    public Object list(String condition) {
        return answerService.selectList(null);
    }

    /**
     * 获取特定用户的问答列表
     */
    @ApiOperation(value ="获取互动问答列表",notes = "需要用户的ID，查询与某人的交互问答信息")
    @ApiImplicitParam(name = "map", value = "问答查询条件，uid为必选，其余为可选", required = true, dataType = "HashMap")
    @BussinessLog(value = "API获取用户问答列表", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/qaMeg/listQas",method = RequestMethod.POST)
    public List<JSONObject>  listQaMegs(@RequestBody HashMap map) {
        map.put("isValid",1);
        List<Answer> answers = answerService.selectByMap(map);
        answers.sort((s1, s2) -> s2.getReplyTime().compareTo(s1.getReplyTime()));
        List<JSONObject> jsonList = new LinkedList<>();
        for(Answer answer:answers){
            JSONObject json = (JSONObject)JSONObject.toJSON(answer);
            User answerUser = this.userService.selectById(answer.getAnswerId());
            User megOwner = this.userService.selectById(answer.getMegOwner());
            json.put("answerName",answerUser.getName());
            json.put("megOwnerName",megOwner.getName());
            jsonList.add(json);
        }

        return jsonList;
    }

    /**
     * 新增互动问答
     */
    @ApiOperation(value ="新增问答",notes = "需要问答的详细信息")
    @ApiImplicitParam(name = "answer", value = "问答详情", required = true, dataType = "Answer")
    @BussinessLog(value = "API新增留言", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/qaMeg/add",method = RequestMethod.POST)
    @ResponseBody
    public Object add(@RequestBody Answer answer) {
        answer.setIsValid(1);
        answer.setQaTime(new Date());
        answer.setReplyTime(new Date());
        answerService.insert(answer);
        return SUCCESS_TIP;
    }

    /**
     * 删除互动问答
     */
    @ApiOperation(value ="删除问答",notes = "需要问答的id")
    @ApiImplicitParam(name = "answerId", value = "问答ID", required = true, dataType = "Integer")
    @BussinessLog(value = "API新增互动问答", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/qaMeg/delete/{answerId}",method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable Integer answerId) {
        Answer answer = this.answerService.selectById(answerId);
        answer.setIsValid(0);
        //伪删除
        this.answerService.updateById(answer);
//        answerService.deleteById(answerId);
        return SUCCESS_TIP;
    }

    /**
     * 修改互动问答
     */
    @ApiOperation(value ="修改问答",notes = "需要待更新的字段")
    @ApiImplicitParam(name = "answer", value = "更新的问答", required = true, dataType = "Answer")
    @BussinessLog(value = "API更新互动问答", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/qaMeg/update",method = RequestMethod.POST)
    @ResponseBody
    public Object update(@RequestBody Answer answer) {
        answerService.updateById(answer);
        return SUCCESS_TIP;
    }

    /**
     * 回复互动问答
     */
    @ApiOperation(value ="回复问答",notes = "需要问答编号：id，回复内容：answer")
    @ApiImplicitParam(name = "answer", value = "回答的内容", required = true, dataType = "Answer")
    @BussinessLog(value = "API回复问答", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/qaMeg/reply",method = RequestMethod.POST)
    @ResponseBody
    public Object reply(@RequestBody Answer answer) {
        answer.setIsReply(1);
        answer.setAlterCon("1");
        answer.setReplyTime(new Date());
        answerService.updateById(answer);
        return SUCCESS_TIP;
    }

    /**
     * 互动问答详情
     */
    @ApiOperation(value ="查看问答详情",notes = "需要问答ID")
    @ApiImplicitParam(name = "answerId", value = "更新的问答", required = true, dataType = "Integer")
    @BussinessLog(value = "API查看互动问答", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/qaMeg/detail/{answerId}",method = RequestMethod.GET)
    @ResponseBody
    public Object detail(@PathVariable("answerId") Integer answerId) {
        return answerService.selectById(answerId);
    }

    /**
     * 普通用户查看未读问答,alterCon字段为1表示未读，0表示已读
     */
    @ApiOperation(value ="普通用户查看未读问答详情",notes = "需要问答ID")
    @ApiImplicitParam(name = "answerId", value = "未读问答ID", required = true, dataType = "Integer")
    @BussinessLog(value = "API普通用户查看未读问答", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/qaMeg/readAnswer/{answerId}",method = RequestMethod.GET)
    @ResponseBody
    public Object readAnswer(@PathVariable("answerId") Integer answerId) {
        Answer answer = this.answerService.selectById(answerId);
        if(null!=answer){
            answer.setAlterCon("0");
            this.answerService.updateById(answer);
        }
        return answer;
    }

    /**
     * 获普通用户查看自己的未读问答列表
     */
    @ApiOperation(value ="获取普通用户未读互动问答列表",notes = "需要用户的ID，查询与某人的未读交互问答信息")
    @ApiImplicitParam(name = "map", value = "问答查询条件，uid为必选，其余为可选", required = true, dataType = "HashMap")
    @BussinessLog(value = "API获取用户未读问答列表", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/qaMeg/unReadMeg",method = RequestMethod.POST)
    public List<Answer> listUnReadMeg(@RequestBody HashMap map) {
        map.put("alterCon","1");
        map.put("isValid",1);
        return answerService.selectByMap(map);
    }
}
