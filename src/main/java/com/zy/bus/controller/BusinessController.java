package com.zy.bus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 张勇
 * @Blog: https://blog.csdn.net/zy13765287861
 * @Version: 1.0
 * @Date: 2020-11-17 11:04
 * @PS: 客户管理跳转页
 */
@Controller
@RequestMapping("bus")
public class BusinessController {

    /**
     * 跳转到客户管理页
     */
    @RequestMapping("toCustomerManager")
    public String toCustomerManager() {
        return "business/customer/customerManager";
    }

    /**
     * 跳转到供应商管理
     */
    @RequestMapping("toProviderManager")
    public String toProviderManager() {
        return "business/provider/providerManager";
    }

    /**
     * 跳转到商品管理
     */
    @RequestMapping("toGoodsManager")
    public String toGoodsManager() {
        return "business/goods/goodsManager";
    }

    /**
     * 跳转到进货管理
     */
    @RequestMapping("toInportManager")
    public String toInportManager() {
        return "business/inport/inportManager";
    }

    /**
     * 跳转到退货管理
     */
    @RequestMapping("toOutportManager")
    public String toOutportManager() {
        return "business/outport/outportManager";
    }

}
