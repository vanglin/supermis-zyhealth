package com.smartpro.mis.modular.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.smartpro.mis.modular.system.dao.DoctoruserMapper;
import com.smartpro.mis.modular.system.model.Doctoruser;
import com.smartpro.mis.modular.system.dao.DoctoruserMapper;
import com.smartpro.mis.modular.system.model.Doctoruser;
import com.smartpro.mis.modular.system.service.IDoctoruserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 医生信息表 服务实现类
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-20
 */
@Service
public class DoctoruserServiceImpl extends ServiceImpl<DoctoruserMapper, Doctoruser> implements IDoctoruserService {
    /**
     * 通过手机号码获取用户信息
     */
    public Doctoruser getByMobile(String mobile) {
        {
            return this.baseMapper.getByMobile(mobile);
        }
    }
    @Override
    public int deleteByMobile(String mobile){
        return  this.baseMapper.deleteByMobile(mobile);
    }

}
