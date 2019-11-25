package com.smartpro.mis.modular.system.warpper;

import com.smartpro.mis.core.base.warpper.BaseControllerWarpper;
import com.smartpro.mis.core.common.constant.factory.ConstantFactory;
import com.smartpro.mis.modular.system.model.Dict;
import com.smartpro.mis.core.common.constant.factory.ConstantFactory;
import com.smartpro.mis.modular.system.model.Dict;
import com.smartpro.mis.core.base.warpper.BaseControllerWarpper;
import com.smartpro.mis.core.util.ToolUtil;

import java.util.List;
import java.util.Map;

/**
 * 字典列表的包装
 *
 * @author mengiy
 * @date 2017年4月25日 18:10:31
 */
public class DictWarpper extends BaseControllerWarpper {

    public DictWarpper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        StringBuffer detail = new StringBuffer();
        Integer id = (Integer) map.get("id");
        List<Dict> dicts = ConstantFactory.me().findInDict(id);
        if(dicts != null){
            for (Dict dict : dicts) {
                detail.append(dict.getNum() + ":" +dict.getName() + ",");
            }
            map.put("detail", ToolUtil.removeSuffix(detail.toString(),","));
        }
    }

}
