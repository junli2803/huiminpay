package com.huiminpay.merchant.api;

import com.huiminpay.merchant.dto.MerchantDTO;

public interface IMerchantService {

    MerchantDTO queryMerchantById(Long merchantId);
}