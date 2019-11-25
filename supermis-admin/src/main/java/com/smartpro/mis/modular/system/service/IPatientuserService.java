package com.smartpro.mis.modular.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.smartpro.mis.modular.system.model.Patientuser;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 普通用户信息表 服务类
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-20
 */
public interface IPatientuserService extends IService<Patientuser> {

    /**
            * 通过手机号码获取用户信息
     */
    Patientuser getByMobile(@Param("mobile") String mobile);

    /**
     * <p>
     * 插入一条记录（选择字段，策略插入）
     * </p>
     *
     * @param entity 实体对象
     * @return boolean
     */
    Integer insertObject(Patientuser entity);


    int deleteByMobile(@Param("mobile") String mobile);


}
