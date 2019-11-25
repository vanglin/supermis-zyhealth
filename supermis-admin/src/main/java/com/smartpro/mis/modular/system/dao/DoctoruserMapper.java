package com.smartpro.mis.modular.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.smartpro.mis.modular.system.model.Doctoruser;
import com.smartpro.mis.modular.system.model.Doctoruser;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 医生信息表 Mapper 接口
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-20
 */
public interface DoctoruserMapper extends BaseMapper<Doctoruser> {
    /**
     * 通过手机号码获取用户信息
     */
    Doctoruser getByMobile(@Param("mobile") String mobile);

    int deleteByMobile(@Param("mobile") String mobile);
}
