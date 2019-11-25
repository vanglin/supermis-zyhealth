package com.smartpro.mis.modular.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.smartpro.mis.modular.system.service.IPatientuserService;
import com.smartpro.mis.modular.system.dao.PatientuserMapper;
import com.smartpro.mis.modular.system.model.Patientuser;
import com.smartpro.mis.modular.system.service.IPatientuserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 普通用户信息表 服务实现类
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-20
 */
@Service
public class PatientuserServiceImpl extends ServiceImpl<PatientuserMapper, Patientuser> implements IPatientuserService {
    /**
     * 通过手机号码获取用户信息
     */
    public Patientuser getByMobile(String mobile) {
        {
            return this.baseMapper.getByMobile(mobile);
        }
    }

    @Override
    public Integer insertObject(Patientuser entity) {
        return this.baseMapper.insert(entity);
    }

    @Override
    public int deleteByMobile(String mobile){
        return  this.baseMapper.deleteByMobile(mobile);
    }
}
