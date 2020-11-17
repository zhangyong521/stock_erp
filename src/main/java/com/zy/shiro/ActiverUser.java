package com.zy.shiro;

import com.zy.sys.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author: 张勇
 * @Blog: https://blog.csdn.net/zy13765287861
 * @Version: 1.0
 * @Date: 2020-11-09 21:23
 * @PS: 类用于包装用户信息和用户对于的角色，对应的权限
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActiverUser {
    private User user;

    private List<String> roles;

    private List<String> permissions;

}
