package com.huiminpay.merchant.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

@Data
@TableName("merchant")
public class Merchant implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableId(value = "ID", type = IdType.ID_WORKER)
    private Long id;

    @TableField("MERCHANT_NAME")
    private String merchantName;


    @TableField("MERCHANT_NO")
    private String merchantNo;


    @TableField("MERCHANT_ADDRESS")
    private String merchantAddress;

    @TableField("MERCHANT_TYPE")
    private String merchantType;


    @TableField("BUSINESS_LICENSES_IMG")
    private String businessLicensesImg;


    @TableField("ID_CARD_FRONT_IMG")
    private String idCardFrontImg;


    @TableField("ID_CARD_AFTER_IMG")
    private String idCardAfterImg;


    @TableField("USERNAME")
    private String username;

    @TableField("MOBILE")
    private String mobile;

    @TableField("CONTACTS_ADDRESS")
    private String contactsAddress;

    @TableField("AUDIT_STATUS")
    private String auditStatus;


    @TableField("TENANT_ID")
    private Long tenantId;


}
