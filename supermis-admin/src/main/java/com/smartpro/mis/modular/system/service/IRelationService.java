package com.smartpro.mis.modular.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.smartpro.mis.modular.system.model.Relation;
import com.smartpro.mis.modular.system.model.Relation;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色和菜单关联表 服务类
 * </p>
 *
 * @author smartpro123
 * @since 2018-02-22
 */
public interface IRelationService extends IService<Relation> {
    /**
     * 查询我的医生列表
     * @param id
     * @return
     */
    List<Map<String, Object>> selectDocsByKey(int id);

    /**
     * 查询我的病人列表
     * @param id
     * @return
     */

    List<Map<String, Object>>selectPacsByKey(int id);
}
