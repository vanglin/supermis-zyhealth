package com.smartpro.mis.modular.business.service.impl;

import com.smartpro.mis.modular.system.model.Dprelation;
import com.smartpro.mis.modular.system.dao.DprelationMapper;
import com.smartpro.mis.modular.business.service.IDprelationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 医患关系表 服务实现类
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-29
 */
@Service
public class DprelationServiceImpl extends ServiceImpl<DprelationMapper, Dprelation> implements IDprelationService {
    @Override
    public List<Map<String, Object>> selectDocsByKey(int id) {
        return  this.baseMapper.selectDocsByKey(id);
    }

    @Override
    public List<Map<String, Object>> selectPacsByKey(int id) {
        return this.baseMapper.selectPacsByKey(id);
    }

    @Override
    public List<Map<String, Object>> selectDocs(int id, int status) {
        return  this.baseMapper.selectDocs(id,status);
    }

    @Override
    public List<Map<String, Object>> selectPacs(int id, int status) {
        return this.baseMapper.selectPacs(id,status);
    }

    @Override
    public int setStatus(Integer id, int status) {
        return this.baseMapper.setStatus(id, status);
    }

}
