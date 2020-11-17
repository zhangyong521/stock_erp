package com.zy.bus.vo;


import com.zy.bus.domain.Goods;
import com.zy.bus.domain.Provider;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: 张勇
 * @Blog: https://blog.csdn.net/zy13765287861
 * @Version: 1.0
 * @Date: 2020-11-17 11:04
 * @PS: 客户管理VO
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GoodsVo extends Goods {

	private static final long serialVersionUID = 1L;

	private Integer page = 1;
	private Integer limit = 10;

}
