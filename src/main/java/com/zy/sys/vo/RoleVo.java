package com.zy.sys.vo;

import com.zy.sys.domain.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: 张勇
 * @Blog: https://blog.csdn.net/zy13765287861
 * @Version: 1.0
 * @Date: 2020-11-12 10:27
 * @PS:
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RoleVo extends Role {
    private static final long serialVersionUID = 1L;
    /**
     * 当前页
     */
    private Integer page = 1;
    /**
     * 每页显示页
     */
    private Integer limit = 10;


}
