package com.smartpro.mis.modular.business.service;

import com.smartpro.mis.modular.system.model.Userdrugrecord;
import com.smartpro.mis.modular.system.model.Userdrugrecord;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户用药记录表 服务类
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-22
 */
public interface IUserdrugrecordService extends IService<Userdrugrecord> {

    List<Map<String, Object>> selectListByUid(int uid,String drug);

    List<Map<String, Object>> selectUserDrugById(int id);
}
