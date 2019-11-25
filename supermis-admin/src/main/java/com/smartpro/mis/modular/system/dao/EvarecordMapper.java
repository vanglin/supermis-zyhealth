package com.smartpro.mis.modular.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.smartpro.mis.modular.system.model.Evarecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 评测记录表 Mapper 接口
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-21
 */
public interface EvarecordMapper extends BaseMapper<Evarecord> {

    /**
     *  * 根据条件查询评测记录列表
     * @param uid
     * @param evaType
     * @param deviceId
     * @param startTime
     * *@param endTime
     * @return
     */
    List<Evarecord> selectEvaList(@Param("uid") int uid, @Param("evaType")String evaType,@Param("deviceId") String deviceId, @Param("startTime")  String startTime, @Param("endTime") String endTime);

}
