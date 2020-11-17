package com.zy.commont;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 张勇
 * @Blog: https://blog.csdn.net/zy13765287861
 * @Version: 1.0
 * @Date: 2020-11-10 15:12
 * @PS: 返回需要的Json的格式
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataGridView {
    private Integer code = 0;
    private String msg = "";
    private Long count = 0L;
    private Object data;

    public DataGridView(Long count, Object data) {
        this.count = count;
        this.data = data;
    }

    public DataGridView(Object data) {
        this.data = data;
    }
}
