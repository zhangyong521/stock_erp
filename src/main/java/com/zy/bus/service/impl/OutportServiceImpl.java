package com.zy.bus.service.impl;

import com.zy.bus.domain.Goods;
import com.zy.bus.domain.Inport;
import com.zy.bus.domain.Outport;
import com.zy.bus.mapper.GoodsMapper;
import com.zy.bus.mapper.InportMapper;
import com.zy.bus.mapper.OutportMapper;
import com.zy.bus.service.OutportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.commont.WebUtils;
import com.zy.sys.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 张勇
 * @since 2020-11-17
 */
@Service
@Transactional
public class OutportServiceImpl extends ServiceImpl<OutportMapper, Outport> implements OutportService {
    @Autowired
    private InportMapper inportMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public void addOutPort(Integer id, Integer number, String remark) {
        //1,根据进货单ID查询进货单信息
        Inport inport = this.inportMapper.selectById(id);
        //2,根据商品ID查询商品信息
        Goods goods = this.goodsMapper.selectById(inport.getGoodsid());
        goods.setNumber(goods.getNumber() - number);
        this.goodsMapper.updateById(goods);
        //3,添加退货单信息
        Outport entity = new Outport();
        entity.setGoodsid(inport.getGoodsid());
        entity.setNumber(number);
        User user = (User) WebUtils.getSession().getAttribute("user");
        entity.setOperateperson(user.getName());
        entity.setOutportprice(inport.getInportprice());
        entity.setOutputtime(new Date());
        entity.setPaytype(inport.getPaytype());
        entity.setProviderid(inport.getProviderid());
        entity.setRemark(remark);
        this.getBaseMapper().insert(entity);
    }

}
