package com.smartpro.mis.modular.business.service;

import com.smartpro.mis.modular.system.model.Userdevice;
import com.smartpro.mis.modular.system.model.Userdevice;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户设备关系表 服务类
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-22
 */
public interface IUserdeviceService extends IService<Userdevice> {

    List<Map<String, Object>> selectListByUid(Integer uid);

    List<Map<String, Object>> selectUserDeviceById(Integer id);
}
