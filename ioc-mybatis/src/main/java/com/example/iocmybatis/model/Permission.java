package com.example.iocmybatis.model;



import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Jason on 2019/9/11.
 */

public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer menuId;


    private String name;


    private String permission;


    private Integer parentId;


    private String icon;


    private String path;


    private Integer sort;


    private String type;


    private String keepAlive;


    private LocalDateTime createTime;


    private LocalDateTime updateTime;


    private String delFlag;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(String keepAlive) {
        this.keepAlive = keepAlive;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "menuId=" + menuId +
                ", name='" + name + '\'' +
                ", permission='" + permission + '\'' +
                ", parentId=" + parentId +
                ", icon='" + icon + '\'' +
                ", path='" + path + '\'' +
                ", sort=" + sort +
                ", type='" + type + '\'' +
                ", keepAlive='" + keepAlive + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", delFlag='" + delFlag + '\'' +
                '}';
    }
}
