package com.zy.commont;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 张勇
 * @Blog: https://blog.csdn.net/zy13765287861
 * @Version: 1.0
 * @Date: 2020-11-10 15:40
 * @PS: 把没有阶层管理的菜单转变成层级关系
 */
public class TreeNodeBuilder {
    public static List<TreeNode> build(List<TreeNode> treeNodes, Integer topPid) {
        //用于保存菜单
        ArrayList<TreeNode> nodes = new ArrayList<>();
        //遍历菜单
        for (TreeNode n1 : treeNodes) {
            //判断Id是否与topPid相等，等于就加入一级标题
            if (n1.getPid().equals(topPid)) {
                nodes.add(n1);
            }
            //遍历菜单
            for (TreeNode n2 : treeNodes) {
                //判断id==pid表示，pid为二级菜单
                if (n1.getId().equals(n2.getPid())) {
                    n1.getChildren().add(n2);
                }
            }
        }
        return nodes;
    }

}
