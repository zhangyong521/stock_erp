package com.zy.sys.vo;

import com.zy.sys.domain.Dept;
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
public class DeptVo extends Dept {
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


}
