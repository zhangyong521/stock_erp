package com.zy.sys.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 跳转前端控制器
 * </p>
 *
 * @author 张勇
 * @since 2020-11-09
 */
@Controller
@RequestMapping("sys")
public class SystemController {

    /**
     * 跳转到登录页
     *
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin() {
        return "system/index/login";
    }

    /**
     * 跳转到首页
     *
     * @return
     */
    @RequestMapping("index")
    public String index() {
        return "system/index/index";
    }

    /**
     * 跳转到工作台
     *
     * @return
     */
    @RequestMapping("toMain")
    public String ToMain() {
        return "system/index/main";
    }

    /**
     * 跳转到日志管理页
     *
     * @return
     */
    @RequestMapping("toLoginfoManager")
    public String toLoginfoManager() {
        return "system/loginfo/loginfoManager";
    }


    /**
     * 跳转系统公告页
     *
     * @return
     */
    @RequestMapping("toNoticeManager")
    public String toNoticeManager() {
        return "system/notice/NoticeManager";
    }

    /**
     * 跳转部门管理页
     *
     * @return
     */
    @RequestMapping("toDeptManager")
    public String toDeptManager() {
        return "system/dept/deptManager";
    }

    /**
     * 跳转部门管理页left
     *
     * @return
     */
    @RequestMapping("toDeptLeft")
    public String toDeptLeft() {
        return "system/dept/deptLeft";
    }

    /**
     * 跳转部门管理页right
     *
     * @return
     */
    @RequestMapping("toDeptRight")
    public String toDeptRight() {
        return "system/dept/deptRight";
    }


    /**
     * 跳转权限管理页
     *
     * @return
     */
    @RequestMapping("toPermissionManager")
    public String toPermissionManager() {
        return "system/permission/permissionManager";
    }

    /**
     * 跳转权限管理页left
     *
     * @return
     */
    @RequestMapping("toPermissionLeft")
    public String toPermissionLeft() {
        return "system/permission/permissionLeft";
    }

    /**
     * 跳转权限管理页right
     *
     * @return
     */
    @RequestMapping("toPermissionRight")
    public String toPermissionRight() {
        return "system/permission/permissionRight";
    }

    /**
     * 跳转权限管理页
     *
     * @return
     */
    @RequestMapping("toMenuManager")
    public String toMenuManager() {
        return "system/menu/menuManager";
    }

    /**
     * 跳转权限管理页left
     *
     * @return
     */
    @RequestMapping("toMenuLeft")
    public String toMenuLeft() {
        return "system/menu/menuLeft";
    }

    /**
     * 跳转权限管理页right
     *
     * @return
     */
    @RequestMapping("toMenuRight")
    public String toMenuRight() {
        return "system/menu/menuRight";
    }

    /**
     * 跳转角色管理页
     *
     * @return
     */
    @RequestMapping("toRoleManager")
    public String toRoleManager() {
        return "system/role/roleManager";
    }

    /**
     * 跳转用户页
     *
     * @return
     */
    @RequestMapping("toUserManager")
    public String toUserManager() {
        return "system/user/userManager";
    }

    /**
     * 跳转缓存页
     *
     * @return
     */
    @RequestMapping("toCacheManager")
    public String toCacheManager() {
        return "system/cache/cacheManager";
    }

}

