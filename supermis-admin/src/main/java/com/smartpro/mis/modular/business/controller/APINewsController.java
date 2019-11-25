package com.smartpro.mis.modular.business.controller;

import com.alibaba.fastjson.JSONObject;
import com.smartpro.mis.config.properties.SupermisProperties;
import com.smartpro.mis.core.base.controller.BaseController;
import com.smartpro.mis.core.common.annotion.BussinessLog;
import com.smartpro.mis.core.common.constant.dictmap.UserDict;
import com.smartpro.mis.core.common.exception.BizExceptionEnum;
import com.smartpro.mis.core.exception.SupermisException;
import com.smartpro.mis.modular.business.apiEntity.NewsParams;
import com.smartpro.mis.modular.business.service.INewsService;
import com.smartpro.mis.modular.system.model.News;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.UUID;

/**
 * 新闻资讯控制器
 *
 * @author mengiy
 * @Date 2018-03-28 13:27:31
 */
@RestController
@RequestMapping("/api/service")
public class APINewsController extends BaseController {

    @Autowired
    private INewsService newsService;
    @Autowired
    private SupermisProperties supermisProperties;

    /**
     * 获取新闻资讯列表
     */
    @ApiOperation(value ="获取新闻资讯列表")
    @BussinessLog(value = "API获取新闻资讯列表", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/news/list",method = RequestMethod.GET)
    @ResponseBody
    public Object list() {
        return newsService.selectList(null);
    }

    /**
     * 按照条件获取新闻资讯列表
     */
    @ApiOperation(value ="根据条件查询新闻资讯列表")
    @BussinessLog(value = "API查询新闻资讯列表", key = "id", dict = UserDict.class)
    @RequestMapping(value = "/news/seclist",method = RequestMethod.POST)
    @ApiImplicitParam(name = "newsParams",value = "新闻资讯的详细信息",required = true,dataType = "NewsParams")
    @ResponseBody
    public Object seclist(@RequestBody NewsParams newsParams) {

        return newsService.selectNewsList(newsParams.getNewsType(),newsParams.getRoleid(),newsParams.getEditor(),newsParams.getCreateTime(),newsParams.getStatus(),newsParams.getStart(),newsParams.getNum());
    }


    /**
     * 新增新闻资讯
     */
    @ApiOperation(value ="新增新闻资讯",notes = "新增新闻资讯")
    @BussinessLog(value = "API新增新闻资讯", key = "id", dict = UserDict.class)
    @ApiImplicitParam(name = "news",value = "新闻资讯的详细信息",required = true,dataType = "News")
    @RequestMapping(value = "/news/add",method = RequestMethod.POST)
    @ResponseBody
    public Object add(@RequestBody News news) {
        news.setCreateTime(new Date());
        if(null==news.getOutlink())
            news.setOutlink("#");
        newsService.insert(news);
        return SUCCESS_TIP;
    }

    /**
     * 删除新闻资讯
     */
    @RequestMapping(value = "/news/delete/{newsId}",method = RequestMethod.GET)
    @ApiOperation(value ="删除新闻资讯",notes = "删除新闻资讯")
    @BussinessLog(value = "AP删除新闻资讯", key = "id", dict = UserDict.class)
    @ApiImplicitParam(name = "newsId",value = "新闻编号",required = true,dataType = "Integer")
    public Object delete(@PathVariable Integer newsId) {
        newsService.deleteById(newsId);
        return SUCCESS_TIP;
    }

    /**
     * 修改新闻资讯
     */
    @RequestMapping(value = "/news/update",method = RequestMethod.POST)
    @ApiOperation(value ="修改新闻资讯",notes = " 修改新闻资讯详细信息")
    @BussinessLog(value = "API修改新闻资讯", key = "id", dict = UserDict.class)
    @ApiImplicitParam(name = "news",value = "新闻资讯",required = true,dataType = "News")
    public Object update(@RequestBody News news) {
        news.setModTime(new Date());
        newsService.updateById(news);
        return SUCCESS_TIP;
    }

    /**
     * 新闻资讯详情
     */
    @RequestMapping(value = "/news/detail/{newsId}",method = RequestMethod.POST)
    @ApiOperation(value ="查看新闻资讯详情",notes = " 查看新闻资讯详细信息")
    @BussinessLog(value = "API查看新闻记录", key = "id", dict = UserDict.class)
    @ApiImplicitParam(name = "newsId",value = "新闻ID",required = true,dataType = "Integer")
    public Object detail(@PathVariable("newsId") Integer newsId) {
        return newsService.selectById(newsId);
    }




    /**
     * 上传图片(上传到项目的webapp/static/img)
     */
    @ApiOperation(value ="上传图片",notes = "上传新闻标题图片")
    @ApiImplicitParam(name = "picture", value = "需要图片", required = true, dataType = "MultipartFile")
    @RequestMapping(method = RequestMethod.POST, path = "/news/upload")
    @ResponseBody
    public JSONObject upload(@RequestParam("file") MultipartFile picture, HttpServletRequest request) {
        JSONObject result = new JSONObject();
        String pictureName = UUID.randomUUID().toString() + ".jpg";
        try {
            String fileSavePath = supermisProperties.getFileUploadPath();

            picture.transferTo(new File(fileSavePath + pictureName));
            try{
                String os = System.getProperty("os.name");
                if(!os.toLowerCase().startsWith("win")){
                    String cmdStrs[] = new String[]{"chmod","-R","775",fileSavePath + pictureName};
                    Process child = Runtime.getRuntime().exec(cmdStrs);
                }

            }catch(Exception e){
                System.out.println("########################chmod error!!!!");
//                e.printStackTrace();
            }
//            System.out.println("文件上传路径##########################"+fileSavePath + pictureName);
            result.put("code",200);
            result.put("pictureName",pictureName);
            String url =  request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
            result.put("pictureUrl",url+"kaptcha/"+ pictureName);
            result.put("saveUrl",fileSavePath + pictureName);
//            result.put("pictureUrl",url+ fileSavePath + pictureName);

        } catch (Exception e) {
            throw new SupermisException(BizExceptionEnum.UPLOAD_ERROR);
        }

        return result;
    }
}
