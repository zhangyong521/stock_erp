package com.zy.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zy.sys.commont.Constast;
import com.zy.sys.domain.Permission;
import com.zy.sys.domain.User;
import com.zy.sys.service.PermissionService;
import com.zy.sys.service.RoleService;
import com.zy.sys.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: 张勇
 * @Blog: https://blog.csdn.net/zy13765287861
 * @Version: 1.0
 * @Date: 2020-11-09 21:22
 * @PS: shiro的自定义类用来做授权以及认证
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    @Lazy
    private UserService userService;

    @Autowired
    @Lazy
    private PermissionService permissionService;

    @Autowired
    @Lazy
    private RoleService roleService;

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("loginname", token.getPrincipal().toString());
        User user = userService.getOne(queryWrapper);
        if (null != user) {
            ActiverUser activerUser = new ActiverUser();
            activerUser.setUser(user);

            //根据用户ID查询percode
            //查询所有菜单
            QueryWrapper<Permission> qw=new QueryWrapper<>();
            //设置只能查询菜单
            qw.eq("type",Constast.TYPE_PERMISSION);
            qw.eq("available", Constast.AVAILABLE_TRUE);

            //根据用户ID+角色+权限去查询
            Integer userId=user.getId();
            //根据用户ID查询角色
            List<Integer> currentUserRoleIds = roleService.queryUserRoleIdsByUid(userId);
            //根据角色ID取到权限和菜单ID
            Set<Integer> pids=new HashSet<>();
            for (Integer rid : currentUserRoleIds) {
                List<Integer> permissionIds = roleService.queryRolePermissionIdsByRid(rid);
                pids.addAll(permissionIds);
            }
            List<Permission> list=new ArrayList<>();
            //根据角色ID查询权限
            if(pids.size()>0) {
                qw.in("id", pids);
                list=permissionService.list(qw);
            }
            List<String> percodes=new ArrayList<>();
            for (Permission permission : list) {
                percodes.add(permission.getPercode());
            }
            //放到
            activerUser.setPermissions(percodes);

            ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activerUser, user.getPwd(), credentialsSalt,
                    this.getName());
            return info;
        }
        return null;
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        ActiverUser activerUser=(ActiverUser) principals.getPrimaryPrincipal();
        User user=activerUser.getUser();
        List<String> permissions = activerUser.getPermissions();
        if(user.getType().equals(Constast.USER_TYPE_SUPER)) {
            authorizationInfo.addStringPermission("*:*");
        }else {
            if(null!=permissions&&permissions.size()>0) {
                authorizationInfo.addStringPermissions(permissions);
            }
        }
        return authorizationInfo;
    }
}