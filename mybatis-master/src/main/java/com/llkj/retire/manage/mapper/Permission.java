package com.llkj.retire.manage.mapper;



import java.io.Serializable;
import java.util.Date;

/**
 * Created by Jason on 2019/9/11.
 */

public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限ID, 唯一
     */
    private String permId;
    /**
     * 父级权限ID
     */
    private String parentId;
    /**
     * 权限名称
     */
    private String permName;
    /**
     * 权限编码
     */
    private String permCode;
    /**
     * 权限资源
     */
    private String permResource;
    /**
     * 路由名称
     */
    private String permRouteName;
    /**
     * 正常状态图标
     */
    private String permIcon;
    /**
     * 选中状态图标
     */
    private String permIconSel;
    /**
     * 排序位置，值越小越靠前
     */
    private int permSort;
    /**
     * 权限资源类型 1：菜单、2：导航栏 3：操作
     */
    private int permType;
    /**
     * 权限可用状态，1：可用、2：不可用
     */
    private int permStatus;
    /**
     * 是否匿名访问，0：否、1：是
     */
    private int permAnonymous;
    /**
     * 权限描述信息
     */
    private String permDesc;
    /**
     * 创建时间
     */
    private Date ctime;
    /**
     * 更新时间
     */
    private Date utime;



    public String getPermId() {
        return permId;
    }

    public void setPermId(String permId) {
        this.permId = permId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName;
    }

    public String getPermCode() {
        return permCode;
    }

    public void setPermCode(String permCode) {
        this.permCode = permCode;
    }

    public String getPermResource() {
        return permResource;
    }

    public void setPermResource(String permResource) {
        this.permResource = permResource;
    }

    public String getPermRouteName() {
        return permRouteName;
    }

    public void setPermRouteName(String permRouteName) {
        this.permRouteName = permRouteName;
    }

    public String getPermIcon() {
        return permIcon;
    }

    public void setPermIcon(String permIcon) {
        this.permIcon = permIcon;
    }

    public String getPermIconSel() {
        return permIconSel;
    }

    public void setPermIconSel(String permIconSel) {
        this.permIconSel = permIconSel;
    }

    public int getPermSort() {
        return permSort;
    }

    public void setPermSort(int permSort) {
        this.permSort = permSort;
    }

    public int getPermType() {
        return permType;
    }

    public void setPermType(int permType) {
        this.permType = permType;
    }

    public int getPermStatus() {
        return permStatus;
    }

    public void setPermStatus(int permStatus) {
        this.permStatus = permStatus;
    }

    public int getPermAnonymous() {
        return permAnonymous;
    }

    public void setPermAnonymous(int permAnonymous) {
        this.permAnonymous = permAnonymous;
    }

    public String getPermDesc() {
        return permDesc;
    }

    public void setPermDesc(String permDesc) {
        this.permDesc = permDesc;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permId='" + permId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", permName='" + permName + '\'' +
                ", permCode='" + permCode + '\'' +
                ", permResource='" + permResource + '\'' +
                ", permRouteName='" + permRouteName + '\'' +
                ", permIcon='" + permIcon + '\'' +
                ", permIconSel='" + permIconSel + '\'' +
                ", permSort=" + permSort +
                ", permType=" + permType +
                ", permStatus=" + permStatus +
                ", permAnonymous=" + permAnonymous +
                ", permDesc='" + permDesc + '\'' +
                ", ctime=" + ctime +
                ", utime=" + utime +
                '}';
    }
}
