package com.smartpro.mis.modular.system.warpper;

import com.smartpro.mis.core.base.warpper.BaseControllerWarpper;
import com.smartpro.mis.core.common.constant.factory.ConstantFactory;
import com.smartpro.mis.core.base.warpper.BaseControllerWarpper;

import java.util.Map;

/**
 * 部门列表的包装
 *
 * @author mengiy
 * @date 2017年4月25日 18:10:31
 */
public class NoticeWrapper extends BaseControllerWarpper {

    public NoticeWrapper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        Integer creater = (Integer) map.get("creater");
        map.put("createrName", ConstantFactory.me().getUserNameById(creater));
    }

}
