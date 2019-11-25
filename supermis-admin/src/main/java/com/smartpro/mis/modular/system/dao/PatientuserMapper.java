package com.smartpro.mis.modular.system.dao;

import com.smartpro.mis.modular.system.model.Patientuser;
import com.smartpro.mis.modular.system.model.Patientuser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 普通用户信息表 Mapper 接口
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-20
 */
public interface PatientuserMapper extends BaseMapper<Patientuser> {
    /**
     * 通过手机号码获取用户信息
     */
    Patientuser getByMobile(@Param("mobile") String mobile);

    /**
     * 插入实体
     */
    Integer insertObject(Patientuser entity);

    int deleteByMobile(@Param("mobile") String mobile);
}
