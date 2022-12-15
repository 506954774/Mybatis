package com.llkj.retire.manage.mapper;



import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

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


}
