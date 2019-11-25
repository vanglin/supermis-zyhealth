package com.smartpro.mis.modular.business.controller;

import com.smartpro.mis.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.smartpro.mis.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.smartpro.mis.modular.system.model.News;
import com.smartpro.mis.modular.business.service.INewsService;

import java.util.Date;

/**
 * 新闻资讯控制器
 *
 * @author mengiy
 * @Date 2018-03-28 13:27:31
 */
@Controller
@RequestMapping("/news")
public class NewsController extends BaseController {

    private String PREFIX = "/business/news/";

    @Autowired
    private INewsService newsService;

    /**
     * 跳转到新闻资讯首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "news.html";
    }

    /**
     * 跳转到添加新闻资讯
     */
    @RequestMapping("/news_add")
    public String newsAdd() {
        return PREFIX + "news_add.html";
    }

    /**
     * 跳转到修改新闻资讯
     */
    @RequestMapping("/news_update/{newsId}")
    public String newsUpdate(@PathVariable Integer newsId, Model model) {
        News news = newsService.selectById(newsId);
        model.addAttribute("item",news);
        LogObjectHolder.me().set(news);
        return PREFIX + "news_edit.html";
    }

    /**
     * 获取新闻资讯列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return newsService.selectList(null);
    }

    /**
     * 新增新闻资讯
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(News news) {
        news.setCreateTime(new Date());
        newsService.insert(news);
        return SUCCESS_TIP;
    }

    /**
     * 删除新闻资讯
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer newsId) {
        newsService.deleteById(newsId);
        return SUCCESS_TIP;
    }

    /**
     * 修改新闻资讯
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(News news) {
        newsService.updateById(news);
        return SUCCESS_TIP;
    }

    /**
     * 新闻资讯详情
     */
    @RequestMapping(value = "/detail/{newsId}")
    @ResponseBody
    public Object detail(@PathVariable("newsId") Integer newsId) {
        return newsService.selectById(newsId);
    }
}
