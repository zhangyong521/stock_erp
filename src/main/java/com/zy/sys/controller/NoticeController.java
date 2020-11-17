package com.zy.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.commont.DataGridView;
import com.zy.commont.ResultObj;
import com.zy.commont.WebUtils;
import com.zy.sys.domain.Notice;
import com.zy.sys.domain.User;
import com.zy.sys.service.NoticeService;
import com.zy.sys.vo.NoticeVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 张勇
 * @since 2020-11-12
 */
@RestController
@RequestMapping("notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     * 全查询+分页
     * @param noticeVo
     * @return
     */
    @RequestMapping("loadAllNotice")
    public DataGridView loadAllNotice(NoticeVo noticeVo) {
        Page<Notice> page = new Page<>(noticeVo.getPage(), noticeVo.getLimit());
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(noticeVo.getTitle()), "title", noticeVo.getTitle());
        queryWrapper.like(StringUtils.isNotBlank(noticeVo.getOpername()), "opername", noticeVo.getOpername());
        queryWrapper.ge(noticeVo.getStartTime() != null, "createtime", noticeVo.getStartTime());
        queryWrapper.le(noticeVo.getStartTime() != null, "createtime", noticeVo.getEndTime());
        queryWrapper.orderByDesc("createtime");
        noticeService.page(page, queryWrapper);

        return new DataGridView(page.getTotal(), page.getRecords());
    }

    /**
     * 添加公告
     * @param noticeVo
     * @return
     */
    @RequestMapping("addNotice")
    public ResultObj addNotice(NoticeVo noticeVo){
        try {
            noticeVo.setCreatetime(new Date());
            User user = (User) WebUtils.getSession().getAttribute("user");
            noticeVo.setOpername(user.getName());
            noticeService.save(noticeVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改
     * @param noticeVo
     * @return
     */
    @RequestMapping("updateNotice")
    public ResultObj updateNotice(NoticeVo noticeVo){
        try {
            noticeService.updateById(noticeVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 单个删除
     * @param id
     * @return
     */
    @RequestMapping("deleteNotice")
    public ResultObj deleteNotice(Integer id){
        try {
            noticeService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除
     * @param noticeVo
     * @return
     */
    @RequestMapping("batchDeleteNotice")
    public ResultObj batchDeleteNotice(NoticeVo noticeVo){
        try {
            Collection<Serializable> idList = new ArrayList<>();
            for (Integer id : noticeVo.getIds()) {
                idList.add(id);
            }
            noticeService.removeByIds(idList);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }


}

