package com.smartpro.mis.rest.modular.auth.controller;

import com.alibaba.fastjson.JSONObject;
import com.smartpro.mis.rest.common.database.UserBean;
import com.smartpro.mis.rest.common.database.UserService;
import com.smartpro.mis.rest.modular.auth.controller.dto.ResponseBean;
import com.smartpro.mis.rest.modular.auth.util.JwtTokenUtil;
import com.smartpro.mis.rest.common.database.UserBean;
import com.smartpro.mis.rest.common.database.UserService;
import com.smartpro.mis.rest.modular.auth.controller.dto.ResponseBean;
import com.smartpro.mis.rest.modular.auth.util.JwtTokenUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/api/")
public class WebController {

    private static final Logger LOGGER = LogManager.getLogger(WebController.class);

    private UserService userService;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    public void setService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseBean login(@RequestParam("username") String username,
                              @RequestParam("password") String password) {
        UserBean userBean = userService.getUser(username);
        if (userBean.getPassword().equals(password)) {
//            JWTUtil.sign(username, password)
            return new ResponseBean(200, "Login success",jwtTokenUtil.generateToken(username,jwtTokenUtil.getRandomKey()) );
        } else {
            throw new UnauthorizedException();
        }
    }

    @PostMapping("/test")
    public ResponseBean test(HttpServletRequest request) {

        JSONObject simpleObject = null;
        try {
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null) responseStrBuilder.append(inputStr);
            simpleObject = JSONObject.parseObject (responseStrBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            System.out.println("#################" +  simpleObject.getString("username"));
//        return ResponseEntity.ok("请求成功!");
            return new ResponseBean(200,"hello success", simpleObject);
        } else {
            throw new UnauthorizedException();
        }
    }

    @GetMapping("/article")
    public ResponseBean article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return new ResponseBean(200, "You are already logged in", null);
        } else {
            return new ResponseBean(200, "You are guest", null);
        }
    }

    @GetMapping("/require_auth")
    @RequiresAuthentication
    public ResponseBean requireAuth() {
        return new ResponseBean(200, "You are authenticated", null);
    }

    @GetMapping("/require_role")
    @RequiresRoles("admin")
    public ResponseBean requireRole() {
        return new ResponseBean(200, "You are visiting require_role", null);
    }

    @GetMapping("/require_permission")
    @RequiresPermissions(logical = Logical.AND, value = {"view", "edit"})
    public ResponseBean requirePermission() {
        return new ResponseBean(200, "You are visiting permission require edit,view", null);
    }

    @RequestMapping(path = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseBean unauthorized() {
        return new ResponseBean(401, "Unauthorized", null);
    }
}
