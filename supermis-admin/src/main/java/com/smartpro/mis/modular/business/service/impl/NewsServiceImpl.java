package com.smartpro.mis.modular.business.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.smartpro.mis.modular.business.service.INewsService;
import com.smartpro.mis.modular.system.dao.NewsMapper;
import com.smartpro.mis.modular.system.model.News;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 新闻资讯表 服务实现类
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-28
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements INewsService {
    @Override
    public List<News> selectNewsList(int newsType, String roleid, String editor, String createTime,int status, int start, int num){
        return  this.baseMapper.selectNewsList(newsType,roleid,editor,createTime,status,start,num);
    }


}
