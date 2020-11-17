package com.zy.bus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.bus.domain.Customer;
import com.zy.bus.service.CustomerService;
import com.zy.bus.vo.CustomerVo;
import com.zy.commont.DataGridView;
import com.zy.commont.ResultObj;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 张勇
 * @since 2020-11-17
 */
@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 分页+全查询
     *
     * @param customerVo
     * @return
     */
    @RequestMapping("loadAllCustomer")
    public DataGridView loadAllCustomer(CustomerVo customerVo) {
        Page<Customer> page = new Page<>(customerVo.getPage(), customerVo.getLimit());
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(customerVo.getCustomername()), "customername", customerVo.getCustomername());
        queryWrapper.like(StringUtils.isNotBlank(customerVo.getPhone()), "phone", customerVo.getPhone());
        queryWrapper.like(StringUtils.isNotBlank(customerVo.getConnectionperson()), "connectionperson", customerVo.getConnectionperson());

        customerService.page(page, queryWrapper);

        return new DataGridView(page.getTotal(), page.getRecords());
    }

    /**
     * 添加
     *
     * @param customerVo
     * @return
     */
    @RequestMapping("addCustomer")
    public ResultObj addCustomer(CustomerVo customerVo) {
        try {
            customerService.save(customerVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改
     *
     * @param customerVo
     * @return
     */
    @RequestMapping("updateCustomer")
    public ResultObj updateCustomer(CustomerVo customerVo) {
        try {
            customerService.updateById(customerVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping("deleteCustomer")
    public ResultObj deleteCustomer(Integer id) {
        try {
            customerService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除
     *
     * @param customerVo
     * @return
     */
    @RequestMapping("batchDeleteCustomer")
    public ResultObj batchDeleteCustomer(CustomerVo customerVo) {
        try {
            Collection<Serializable> idList = new ArrayList<Serializable>();
            for (Integer id : customerVo.getIds()) {
                idList.add(id);
            }
            customerService.removeByIds(idList);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

}


