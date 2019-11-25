package com.smartpro.mis.modular.business.service.impl;

import com.smartpro.mis.modular.business.service.IUserdeviceService;
import com.smartpro.mis.modular.system.dao.UserdeviceMapper;
import com.smartpro.mis.modular.system.model.Userdevice;
import com.smartpro.mis.modular.system.model.Userdevice;
import com.smartpro.mis.modular.system.dao.UserdeviceMapper;
import com.smartpro.mis.modular.business.service.IUserdeviceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户设备关系表 服务实现类
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-22
 */
@Service
public class UserdeviceServiceImpl extends ServiceImpl<UserdeviceMapper, Userdevice> implements IUserdeviceService {
    @Override
    public List<Map<String, Object>> selectListByUid(Integer uid){
        return this.baseMapper.selectListByUid(uid);
    }
    @Override
    public List<Map<String, Object>> selectUserDeviceById(Integer id){
        return this.baseMapper.selectUserDeviceById(id);
    }

}
