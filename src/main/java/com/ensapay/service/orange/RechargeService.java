package com.ensapay.service.orange;

import com.ensapay.entity.orange.Pass;
import com.ensapay.entity.orange.Recharge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RechargeService {

    private static final String URL_GET_ALL_RERCHARGES = "http://68.183.138.82:5000/api/recharges";
    private static final String URL_GET_RECHARGE_BY_PHONE = "http://68.183.138.82:5000/api/recharges/byphone?phoneNumber=";

    @Autowired
    RestTemplate restTemplate;

    public List<Recharge> getAllRecharges()
    {
        Recharge[] recharges = restTemplate.getForEntity(URL_GET_ALL_RERCHARGES, Recharge[].class).getBody();
        return Arrays.asList(recharges);
    }

    public List<Recharge> getRechargeByPhoneNumber(String phone)
    {
        Recharge[] recharges = restTemplate.getForEntity(URL_GET_RECHARGE_BY_PHONE + phone, Recharge[].class).getBody();
        return Arrays.asList(recharges);
    }
}
