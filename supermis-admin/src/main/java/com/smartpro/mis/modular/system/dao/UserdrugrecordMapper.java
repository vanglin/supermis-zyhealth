package com.smartpro.mis.modular.system.dao;

import com.smartpro.mis.modular.system.model.Userdrugrecord;
import com.smartpro.mis.modular.system.model.Userdrugrecord;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户用药记录表 Mapper 接口
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-22
 */
public interface UserdrugrecordMapper extends BaseMapper<Userdrugrecord> {
    List<Map<String, Object>> selectListByUid(@Param("uid")int uid,@Param("drug")String drug);

    List<Map<String, Object>> selectUserDrugById(@Param("id")int id);

}
