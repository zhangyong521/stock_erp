package com.zy.commont;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * @Author: 张勇
 * @Blog: https://blog.csdn.net/zy13765287861
 * @Version: 1.0
 * @Date: 2020-11-10 15:24
 * @PS: 返回的json的格式
 * 用于返回菜单信息
 * {
 * "title": "图片管理",
 * "icon": "&#xe634;",
 * "href": "/resources/page/img/images.html",
 * "spread": false #false代表没有打开下拉
 * },
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {
    private Integer id;
    @JsonProperty("parentId")
    private Integer pid;
    private String title;
    private String icon;
    private String href;
    private boolean spread;
    private ArrayList<TreeNode> children = new ArrayList<>();

    /**
     * 0代表不选中 1代表选中
     * 用于权限分配
     */
    private String checkArr = "0";

    /**
     * 用于菜单导航
     * @param id
     * @param pid
     * @param title
     * @param icon
     * @param href
     * @param spread
     */
    public TreeNode(Integer id, Integer pid, String title, String icon, String href, boolean spread) {
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.icon = icon;
        this.href = href;
        this.spread = spread;
    }

    /**
     * dtree
     * 部门管理的树形结构（用于增添删的选择）
     *
     * @param id
     * @param pid
     * @param title
     * @param spread
     */
    public TreeNode(Integer id, Integer pid, String title, boolean spread) {
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.spread = spread;
    }

    /**
     * 用于dtree复选树的构造器（用于角色分配）
     * @param id
     * @param pid
     * @param title
     * @param spread
     * @param checkArr
     */
    public TreeNode(Integer id, Integer pid, String title, boolean spread, String checkArr) {
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.spread = spread;
        this.checkArr = checkArr;
    }
}
