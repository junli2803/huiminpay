package com.huiminpay.merchant.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

@Data
@TableName("app")
public class App implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.ID_WORKER)
    private Long id;

    @TableField("APP_ID")
    private String appId;

    @TableField("APP_NAME")
    private String appName;


    @TableField("MERCHANT_ID")
    private Long merchantId;


    @TableField("PUBLIC_KEY")
    private String publicKey;


    @TableField("NOTIFY_URL")
    private String notifyUrl;


}
