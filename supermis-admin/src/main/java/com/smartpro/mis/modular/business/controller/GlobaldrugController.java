package com.smartpro.mis.modular.business.controller;

import com.smartpro.mis.core.log.LogObjectHolder;
import com.smartpro.mis.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.smartpro.mis.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.smartpro.mis.modular.system.model.Globaldrug;
import com.smartpro.mis.modular.business.service.IGlobaldrugService;

import java.util.Date;

/**
 * 药物库控制器
 *
 * @author mengiy
 * @Date 2018-03-22 15:18:09
 */
@Controller
@RequestMapping("/globaldrug")
public class GlobaldrugController extends BaseController {

    private String PREFIX = "/business/globaldrug/";

    @Autowired
    private IGlobaldrugService globaldrugService;

    /**
     * 跳转到药物库首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "globaldrug.html";
    }

    /**
     * 跳转到添加药物库
     */
    @RequestMapping("/globaldrug_add")
    public String globaldrugAdd() {
        return PREFIX + "globaldrug_add.html";
    }

    /**
     * 跳转到修改药物库
     */
    @RequestMapping("/globaldrug_update/{globaldrugId}")
    public String globaldrugUpdate(@PathVariable Integer globaldrugId, Model model) {
        Globaldrug globaldrug = globaldrugService.selectById(globaldrugId);
        model.addAttribute("item",globaldrug);
        LogObjectHolder.me().set(globaldrug);
        return PREFIX + "globaldrug_edit.html";
    }

    /**
     * 获取药物库列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return globaldrugService.selectList(null);
    }

    /**
     * 新增药物库
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Globaldrug globaldrug) {
        globaldrug.setCreateTime(new Date());
        globaldrugService.insert(globaldrug);
        return SUCCESS_TIP;
    }

    /**
     * 删除药物库
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer globaldrugId) {
        globaldrugService.deleteById(globaldrugId);
        return SUCCESS_TIP;
    }

    /**
     * 修改药物库
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Globaldrug globaldrug) {
        globaldrugService.updateById(globaldrug);
        return SUCCESS_TIP;
    }

    /**
     * 药物库详情
     */
    @RequestMapping(value = "/detail/{globaldrugId}")
    @ResponseBody
    public Object detail(@PathVariable("globaldrugId") Integer globaldrugId) {
        return globaldrugService.selectById(globaldrugId);
    }
}
