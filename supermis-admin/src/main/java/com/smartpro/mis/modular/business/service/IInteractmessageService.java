package com.smartpro.mis.modular.business.service;

import com.baomidou.mybatisplus.service.IService;
import com.smartpro.mis.modular.business.apiEntity.MegParams;
import com.smartpro.mis.modular.system.model.Interactmessage;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 互动留言表 服务类
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-22
 */
public interface IInteractmessageService extends IService<Interactmessage> {
    public List<Map<String, Object>>selectListMegs(MegParams megParams);
    public List<Map<String, Object>> insertMeg(Interactmessage interactmessage);
    public void viewMeg(int id);
}
