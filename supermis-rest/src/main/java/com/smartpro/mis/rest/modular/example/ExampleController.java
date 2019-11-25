package com.smartpro.mis.rest.modular.example;

import com.smartpro.mis.rest.common.SimpleObject;
import com.smartpro.mis.rest.common.SimpleObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 常规控制器
 *
 * @author fengshuonan
 * @date 2017-08-23 16:02
 */
@RestController
@RequestMapping(value = "/hello",method = RequestMethod.POST)
//@RequiresRoles("admin")
public class ExampleController {
    @RequestMapping("")
    public ResponseEntity hello(@RequestBody SimpleObject simpleObject) {
        System.out.println(simpleObject.getUser());
        return ResponseEntity.ok("请求成功!");
    }
}
