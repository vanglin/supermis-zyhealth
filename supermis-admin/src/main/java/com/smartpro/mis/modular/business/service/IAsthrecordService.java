package com.smartpro.mis.modular.business.service;

import com.smartpro.mis.modular.system.model.Asthrecord;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 哮喘管理记录表 服务类
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-22
 */
public interface IAsthrecordService extends IService<Asthrecord> {
    public List<Map<String, Object>> selectListByCardNo(String cardNo);
}
