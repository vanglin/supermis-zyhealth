package com.smartpro.mis.modular.system.dao;

import com.smartpro.mis.modular.system.model.Asthrecord;
import com.smartpro.mis.modular.system.model.Asthrecord;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 哮喘管理记录表 Mapper 接口
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-22
 */
public interface AsthrecordMapper extends BaseMapper<Asthrecord> {
    public List<Map<String, Object>> selectListByCardNo(String cardNo);
}
