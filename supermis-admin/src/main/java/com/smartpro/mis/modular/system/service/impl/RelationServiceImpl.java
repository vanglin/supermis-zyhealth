package com.smartpro.mis.modular.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.smartpro.mis.modular.system.dao.RelationMapper;
import com.smartpro.mis.modular.system.model.Relation;
import com.smartpro.mis.modular.system.service.IRelationService;
import com.smartpro.mis.modular.system.dao.RelationMapper;
import com.smartpro.mis.modular.system.model.Relation;
import com.smartpro.mis.modular.system.service.IRelationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色和菜单关联表 服务实现类
 * </p>
 *
 * @author smartpro123
 * @since 2018-02-22
 */
@Service
public class RelationServiceImpl extends ServiceImpl<RelationMapper, Relation> implements IRelationService {

    @Override
    public List<Map<String, Object>> selectDocsByKey(int id) {
        return  this.selectDocsByKey(id);
    }

    @Override
    public List<Map<String, Object>> selectPacsByKey(int id) {
        return this.selectPacsByKey(id);
    }
}
