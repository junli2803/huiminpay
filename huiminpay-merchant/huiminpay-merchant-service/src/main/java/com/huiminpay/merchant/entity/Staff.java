package com.huiminpay.merchant.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

@Data
@TableName("staff")
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.ID_WORKER)
    private Long id;

    @TableField("MERCHANT_ID")
    private Long merchantId;

    @TableField("FULL_NAME")
    private String fullName;

    @TableField("POSITION")
    private String position;

    @TableField("USERNAME")
    private String username;

    @TableField("MOBILE")
    private String mobile;

    @TableField("STORE_ID")
    private Long storeId;

    @TableField("LAST_LOGIN_TIME")
    private LocalDateTime lastLoginTime;

    @TableField("STAFF_STATUS")
    private Boolean staffStatus;


}
