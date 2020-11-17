package com.zy.sys.mapper;

import com.zy.sys.domain.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 张勇
 * @since 2020-11-10
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 根据权限或者菜单ID删除权限表和角色的关系表里的数据
     * @param id
     */
    void deleteRolePermissionByPid(@Param("id") Serializable id);
}
