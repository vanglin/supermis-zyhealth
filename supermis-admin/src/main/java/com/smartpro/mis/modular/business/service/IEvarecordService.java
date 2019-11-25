package com.smartpro.mis.modular.business.service;

import com.smartpro.mis.modular.system.model.Evarecord;
import com.smartpro.mis.modular.system.model.Evarecord;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 评测记录表 服务类
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-21
 */
public interface IEvarecordService extends IService<Evarecord> {
    /**
     *  * 根据条件查询评测记录列表
     * @param uid
     * @param evaType
     * @param deviceId
     * @param startTime
     * *@param endTime
     * @return
     */
    List<Evarecord> selectEvaList(int uid, String evaType, String deviceId, String startTime, String endTime);
}
