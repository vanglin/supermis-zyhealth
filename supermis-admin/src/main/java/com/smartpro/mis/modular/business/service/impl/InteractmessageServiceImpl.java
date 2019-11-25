package com.smartpro.mis.modular.business.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.smartpro.mis.modular.business.apiEntity.MegParams;
import com.smartpro.mis.modular.business.service.IInteractmessageService;
import com.smartpro.mis.modular.system.dao.InteractmessageMapper;
import com.smartpro.mis.modular.system.model.Interactmessage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 互动留言表 服务实现类
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-22
 */
@Service
public class InteractmessageServiceImpl extends ServiceImpl<InteractmessageMapper, Interactmessage> implements IInteractmessageService {
    @Override
    public List<Map<String, Object>> selectListMegs(MegParams megParams){
        return this.baseMapper.selectListMegs(megParams);
    }
    @Override
    public List<Map<String, Object>> insertMeg(Interactmessage interactmessage){
        return this.baseMapper.insertMeg(interactmessage);
    }

    @Override
    public void viewMeg(int id) {
        this.baseMapper.viewMeg(id);
    }
}
