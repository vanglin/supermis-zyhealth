package com.smartpro.mis.modular.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.smartpro.mis.core.datascope.DataScope;
import com.smartpro.mis.modular.system.dao.UserMapper;
import com.smartpro.mis.modular.system.model.User;
import com.smartpro.mis.modular.system.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author smartpro123
 * @since 2018-02-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    /**
     * 查询用户
     */
    @Override
    public List<User> selectByMaps(Map<String,Object> condition){
        return  this.baseMapper.selectByMaps(condition);
    }
    @Override
    public int setStatus(Integer userId, int status) {
        return this.baseMapper.setStatus(userId, status);
    }

    @Override
    public int changePwd(Integer userId, String pwd) {
        return this.baseMapper.changePwd(userId, pwd);
    }

    @Override
    public List<Map<String, Object>> selectUsers(DataScope dataScope, String name, String beginTime, String endTime, Integer deptid) {
        return this.baseMapper.selectUsers(dataScope, name, beginTime, endTime, deptid);
    }
    @Override
    public List<Map<String, Object>> selectUsersByRoles(DataScope dataScope, String name, String beginTime, String endTime, Integer roleid) {
        return this.baseMapper.selectUsersByRoles(dataScope, name, beginTime, endTime, roleid);
    }

    @Override
    public List<Map<String, Object>> selectUsersByDeptRoles(DataScope dataScope, String name, String beginTime, String endTime, Integer deptid, Integer roleid) {
        return this.baseMapper.selectUsersByDeptRoles(dataScope, name, beginTime, endTime, deptid,roleid);
    }

    @Override
    public int setRoles(Integer userId, String roleIds) {
        return this.baseMapper.setRoles(userId, roleIds);
    }

    @Override
    public User getByAccount(String account) {
        return this.baseMapper.getByAccount(account);
    }
}
