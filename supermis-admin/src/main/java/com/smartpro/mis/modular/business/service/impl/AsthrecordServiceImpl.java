package com.smartpro.mis.modular.business.service.impl;

import com.smartpro.mis.modular.business.service.IAsthrecordService;
import com.smartpro.mis.modular.system.dao.AsthrecordMapper;
import com.smartpro.mis.modular.system.model.Asthrecord;
import com.smartpro.mis.modular.system.model.Asthrecord;
import com.smartpro.mis.modular.system.dao.AsthrecordMapper;
import com.smartpro.mis.modular.business.service.IAsthrecordService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 哮喘管理记录表 服务实现类
 * </p>
 *
 * @author mengiy123
 * @since 2018-03-22
 */
@Service
public class AsthrecordServiceImpl extends ServiceImpl<AsthrecordMapper, Asthrecord> implements IAsthrecordService {
    @Override
    public List<Map<String, Object>> selectListByCardNo(String cardNo){
        return  this.baseMapper.selectListByCardNo(cardNo);
    }

}
