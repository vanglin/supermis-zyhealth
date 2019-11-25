package com.smartpro.mis.modular.business.service.impl;

import com.smartpro.mis.modular.business.service.IUserdrugrecordService;
import com.smartpro.mis.modular.system.dao.UserdrugrecordMapper;
import com.smartpro.mis.modular.system.model.Userdrugrecord;
import com.smartpro.mis.modular.system.model.Userdrugrecord;
import com.smartpro.mis.modular.system.dao.UserdrugrecordMapper;
import com.smartpro.mis.modular.business.service.IUserdrugrecordService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户用药记录表 服务实现类
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-22
 */
@Service
public class UserdrugrecordServiceImpl extends ServiceImpl<UserdrugrecordMapper, Userdrugrecord> implements IUserdrugrecordService {
    @Override
    public List<Map<String, Object>> selectListByUid(int uid,String drug){
        return this.baseMapper.selectListByUid(uid,drug);
    }
    @Override
    public List<Map<String, Object>> selectUserDrugById(int id){
        return this.baseMapper.selectUserDrugById(id);
    }
}
