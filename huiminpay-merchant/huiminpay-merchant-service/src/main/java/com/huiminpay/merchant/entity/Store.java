package com.huiminpay.merchant.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

@Data
@TableName("store")
public class Store implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.ID_WORKER)
    private Long id;

    @TableField("STORE_NAME")
    private String storeName;

    @TableField("STORE_NUMBER")
    private Long storeNumber;

    @TableField("MERCHANT_ID")
    private Long merchantId;

    @TableField("PARENT_ID")
    private Long parentId;

    @TableField("STORE_STATUS")
    private Boolean storeStatus;

    @TableField("STORE_ADDRESS")
    private String storeAddress;


}
