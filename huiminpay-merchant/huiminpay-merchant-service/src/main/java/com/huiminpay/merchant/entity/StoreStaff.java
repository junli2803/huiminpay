package com.huiminpay.merchant.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

@Data
@TableName("store_staff")
public class StoreStaff implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.ID_WORKER)
    private Long id;

    @TableField("STORE_ID")
    private Long storeId;

    @TableField("STAFF_ID")
    private Long staffId;


}
