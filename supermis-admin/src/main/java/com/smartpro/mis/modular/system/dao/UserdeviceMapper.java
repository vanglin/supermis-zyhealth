package com.smartpro.mis.modular.system.dao;

import com.smartpro.mis.modular.system.model.Userdevice;
import com.smartpro.mis.modular.system.model.Userdevice;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户设备关系表 Mapper 接口
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-22
 */
public interface UserdeviceMapper extends BaseMapper<Userdevice> {
    List<Map<String, Object>>  selectListByUid(Integer uid);
    List<Map<String, Object>> selectUserDeviceById(Integer id);
}
