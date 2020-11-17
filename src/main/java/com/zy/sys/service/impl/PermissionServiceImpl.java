package com.zy.sys.service.impl;

import com.zy.sys.domain.Permission;
import com.zy.sys.mapper.PermissionMapper;
import com.zy.sys.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 张勇
 * @since 2020-11-10
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Override
    public boolean removeById(Serializable id) {
        PermissionMapper permissionMapper = getBaseMapper();
        //根据权限或者菜单ID删除权限表和角色的关系表里的数据
        permissionMapper.deleteRolePermissionByPid(id);

        return super.removeById(id);
    }
}
