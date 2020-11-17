package com.zy.bus.vo;

import com.zy.bus.domain.Outport;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: 张勇
 * @Blog: https://blog.csdn.net/zy13765287861
 * @Version: 1.0
 * @Date: 2020-11-17 16:00
 * @PS:
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class OutportVo extends Outport {

    private Integer page=1;
    private Integer limit=10;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
