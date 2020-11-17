package com.zy.bus.service.impl;

import com.zy.bus.domain.Customer;
import com.zy.bus.mapper.CustomerMapper;
import com.zy.bus.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 张勇
 * @since 2020-11-17
 */
@Service
@Transactional
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Override
    public boolean save(Customer entity) {
        return super.save(entity);
    }

    @Override
    public boolean updateById(Customer entity) {
        return super.updateById(entity);
    }

    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }
    @Override
    public Customer getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return super.removeByIds(idList);
    }
}
