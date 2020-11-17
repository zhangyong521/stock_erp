package com.zy.sys.vo;

import com.zy.sys.domain.Loginfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
public class LoginfoVo extends Loginfo {

    /**
     * 分页查询
     * page当前页
     * limit 每页显示数
     */
    private Integer page = 1;
    private Integer limit = 10;

    /**
     * 批量删除用于接受多个id
     */
    public Integer[] ids;

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
