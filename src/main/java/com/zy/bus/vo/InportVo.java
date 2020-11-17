package com.zy.bus.vo;

import com.zy.bus.domain.Inport;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: 张勇
 * @Blog: https://blog.csdn.net/zy13765287861
 * @Version: 1.0
 * @Date: 2020-11-10 19:48
 * @PS:
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class InportVo extends Inport {

    /**
     * 分页查询
     * page当前页
     * limit 每页显示数
     */
    private Integer page = 1;
    private Integer limit = 10;


    /**
     * 条件查询的开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 条件查询的开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}
