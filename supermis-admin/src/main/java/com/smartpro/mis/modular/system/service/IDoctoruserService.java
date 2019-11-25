package com.smartpro.mis.modular.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.smartpro.mis.modular.system.model.Doctoruser;
import com.smartpro.mis.modular.system.model.Doctoruser;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 医生信息表 服务类
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-20
 */
public interface IDoctoruserService extends IService<Doctoruser> {
    /**
     * 通过手机号码获取用户信息
     */
    Doctoruser getByMobile(@Param("mobile") String mobile);

    int deleteByMobile(@Param("mobile") String mobile);
}
