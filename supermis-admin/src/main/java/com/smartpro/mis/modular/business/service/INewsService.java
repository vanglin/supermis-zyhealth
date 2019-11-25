package com.smartpro.mis.modular.business.service;

import com.baomidou.mybatisplus.service.IService;
import com.smartpro.mis.modular.system.model.News;

import java.util.List;

/**
 * <p>
 * 新闻资讯表 服务类
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-28
 */
public interface INewsService extends IService<News> {
    /**
     *  根据条件查询新闻列表
     * @param newsType
       * @param roleid
     * @param editor
     * @param createTime
     *  * @param status
     * @param start 查询的起点
     * @param num 要查询的数量
     * @return
     */
    List<News> selectNewsList(int newsType, String roleid,  String editor, String createTime,int status, int start, int num);

}
