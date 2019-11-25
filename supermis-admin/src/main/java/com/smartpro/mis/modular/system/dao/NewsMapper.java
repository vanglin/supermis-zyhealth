package com.smartpro.mis.modular.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.smartpro.mis.modular.system.model.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 新闻资讯表 Mapper 接口
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-28
 */
public interface NewsMapper extends BaseMapper<News> {

    List<News> selectNewsList(@Param("newsType") int newsType, @Param("roleid") String roleid, @Param("editor") String editor, @Param("createTime") String createTime, @Param("status") int status, @Param("start") int start,@Param("num") int num);

}
