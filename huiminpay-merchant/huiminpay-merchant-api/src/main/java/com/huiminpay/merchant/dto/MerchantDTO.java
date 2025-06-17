package com.huiminpay.merchant.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("Merchant basic information")
@Data
public class MerchantDTO implements Serializable {
    /**
     * Primary key
     */
    // @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * Merchant name
     */
    @ApiModelProperty(name = "merchantName", value = "Merchant name", example = "Braised Chicken")
    private String merchantName;

    /**
     * Merchant number
     */
    @ApiModelProperty(name = "merchantNo", value = "Merchant number", example = "10000")
    private String merchantNo;

    /**
     * Merchant address
     */
    @ApiModelProperty(name = "merchantAddress", value = "Merchant address", example = "Zhengzhou E-commerce Park")
    private String merchantAddress;

    /**
     * Merchant type
     */
    @ApiModelProperty(name = "merchantType", value = "Merchant type")
    private String merchantType;

    /**
     * Business license (company certificate)
     */
    @ApiModelProperty(name = "businessLicensesImg", value = "Business license image")
    private String businessLicensesImg;

    /**
     * Front of legal person's ID card
     */
    @ApiModelProperty(name = "idCardFrontImg", value = "Front of legal person's ID card")
    private String idCardFrontImg;

    /**
     * Back of legal person's ID card
     */
    @ApiModelProperty(name = "idCardAfterImg", value = "Back of legal person's ID card")
    private String idCardAfterImg;

    /**
     * Contact person's name
     */
    @ApiModelProperty(name = "username", value = "Contact person's name")
    private String username;

    /**
     * Contact person's phone number (linked to unified account)
     */
    @ApiModelProperty(name = "mobile", value = "Contact person's phone number (linked to unified account)")
    private String mobile;

    /**
     * Contact person's address
     */
    @ApiModelProperty(name = "contactsAddress", value = "Contact person's address")
    private String contactsAddress;

    /**
     * Audit status: 0 - Not applied, 1 - Applied and pending, 2 - Approved, 3 - Rejected
     */
    @ApiModelProperty(name = "auditStatus", value = "Audit status")
    private String auditStatus;

    /**
     * Tenant ID, linked to unified user
     */
    @ApiModelProperty(name = "tenantId", value = "Tenant ID")
    private Long tenantId;

    /**
     * Password
     */
    @ApiModelProperty(name = "password", value = "")
    private String password;
}

