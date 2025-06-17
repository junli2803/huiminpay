
package com.huiminpay.merchant.service;
import com.huiminpay.merchant.api.IMerchantService;
import com.huiminpay.merchant.entity.Merchant;
import com.huiminpay.merchant.mapper.MerchantMapper;
import com.huiminpay.merchant.dto.MerchantDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;



@Slf4j
@Service
public class MerchantServiceImpl implements IMerchantService {

    @Autowired
    MerchantMapper merchantMapper;

    @Override
    public MerchantDTO queryMerchantById(Long merchantId) {
        //根据商户的id，给到一个Merchant商户对象merchant
        Merchant merchant = merchantMapper.selectById(merchantId);
        //创建一个dto对象merchantDTO
        MerchantDTO merchantDTO=new MerchantDTO();
        //给merchantDTO对象的属性赋值,值是从merchantMapper里面获取的对象merchant的值;
//        merchantDTO.setId(merchant.getId());
//        merchantDTO.setMerchantNo(merchant.getMerchantNo());
//        merchantDTO.setUsername(merchant.getUsername());
//        merchantDTO.setMerchantName(merchant.getMerchantName());
        // merchant -> merchantDTO
        BeanUtils.copyProperties(merchant, merchantDTO);
        return merchantDTO;
    }

}
