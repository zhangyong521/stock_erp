package com.zy.sys.vo;

import com.zy.sys.domain.Notice;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: 张勇
 * @Blog: https://blog.csdn.net/zy13765287861
 * @Version: 1.0
 * @Date: 2020-11-12 10:27
 * @PS:
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NoticeVo extends Notice {
    /**
     * 当前页
     */
    private Integer page = 1;
    /**
     * 每页显示页
     */
    private Integer limit = 10;

    /**
     * 接受多个Id
     */
    private Integer[] ids;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}
