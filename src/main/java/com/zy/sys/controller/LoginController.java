package com.zy.sys.controller;


import com.zy.shiro.ActiverUser;
import com.zy.sys.commont.ResultObj;
import com.zy.sys.commont.WebUtils;
import com.zy.sys.domain.Loginfo;
import com.zy.sys.service.LoginfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 * 登录的前端控制器
 * </p>
 *
 * @author 张勇
 * @since 2020-11-09
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginfoService loginfoService;

    /**
     * 登录
     *
     * @param loginname 用户名
     * @param pwd       密码
     * @return code最后做
     */
    @RequestMapping("login")
    public ResultObj login(String loginname, String pwd) {
        //获取shiro的连接subject
        Subject subject = SecurityUtils.getSubject();
        //验证密码是否正确
        AuthenticationToken token = new UsernamePasswordToken(loginname, pwd);
        try {
            //把token放入subject
            subject.login(token);
            ActiverUser user = (ActiverUser) subject.getPrincipal();
            //保存到session
            WebUtils.getSession().setAttribute("user", user.getUser());
            //记录登录日志
            Loginfo entity = new Loginfo();
            entity.setLoginname(user.getUser().getName()+"-"+user.getUser().getLoginname());
            entity.setLoginip(WebUtils.getRequest().getRemoteAddr());
            entity.setLogintime(new Date());

            loginfoService.save(entity);
            return ResultObj.LOGIN_SUCCESS;
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResultObj.LOGIN_ERROR_PASS;
        }
    }

}

