package com.smartpro.mis.core.util;

import com.smartpro.mis.core.node.MenuNode;
import com.smartpro.mis.core.common.constant.Const;
import com.smartpro.mis.config.properties.SupermisProperties;
import com.smartpro.mis.core.node.MenuNode;

import java.util.ArrayList;
import java.util.List;

/**
 * api接口文档显示过滤
 *
 * @author mengiy
 * @date 2017-08-17 16:55
 */
public class ApiMenuFilter extends MenuNode {

    public static List<MenuNode> build(List<MenuNode> nodes) {

        //如果关闭了接口文档,则不显示接口文档菜单
        SupermisProperties supermisProperties = SpringContextHolder.getBean(SupermisProperties.class);
        if (!supermisProperties.getSwaggerOpen()) {
            List<MenuNode> menuNodesCopy = new ArrayList<>();
            for (MenuNode menuNode : nodes) {
                if (Const.API_MENU_NAME.equals(menuNode.getName())) {
                    continue;
                } else {
                    menuNodesCopy.add(menuNode);
                }
            }
            nodes = menuNodesCopy;
        }

        return nodes;
    }
}
