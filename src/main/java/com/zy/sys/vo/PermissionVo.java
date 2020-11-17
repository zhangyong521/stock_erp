package com.zy.sys.vo;

import com.zy.sys.domain.Permission;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: 张勇
 * @Blog: https://blog.csdn.net/zy13765287861
 * @Version: 1.0
 * @Date: 2020-11-10 15:11
 * @PS:  继承Permission
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PermissionVo extends Permission {
    /**
     * 当前页
     */
    private Integer page = 1;
    /**
     * 每页显示页
     */
    private Integer limit = 10;
}
