package com.smartpro.mis.modular.business.service.impl;

import com.smartpro.mis.modular.business.service.IEvarecordService;
import com.smartpro.mis.modular.system.dao.EvarecordMapper;
import com.smartpro.mis.modular.system.model.Evarecord;
import com.smartpro.mis.modular.system.model.Evarecord;
import com.smartpro.mis.modular.system.dao.EvarecordMapper;
import com.smartpro.mis.modular.business.service.IEvarecordService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 评测记录表 服务实现类
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-21
 */
@Service
public class EvarecordServiceImpl extends ServiceImpl<EvarecordMapper, Evarecord> implements IEvarecordService {
    /**
     *  * 根据条件查询评测记录列表
     * @param uid
     * @param evaType
     * @param deviceId
     * @param startTime
     * *@param endTime
     * @return
     */
    @Override
   public  List<Evarecord> selectEvaList(int uid, String evaType, String deviceId, String startTime, String endTime){
         return this.baseMapper.selectEvaList(uid, evaType, deviceId, startTime, endTime);
   }
}
