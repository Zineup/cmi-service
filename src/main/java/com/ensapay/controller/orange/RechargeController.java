package com.ensapay.controller.orange;

import com.ensapay.entity.orange.Pass;
import com.ensapay.entity.orange.Recharge;
import com.ensapay.service.orange.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orange/recharges")
public class RechargeController {

    @Autowired
    private RechargeService rechargeService;

    @GetMapping
    public List<Recharge> getAllRecharges(){
        return rechargeService.getAllRecharges();
    }

    @GetMapping("byphone/{phoneNumber}")
    public List<Recharge>  getRechargeByPhoneNumber(@PathVariable String phoneNumber){
        return rechargeService.getRechargeByPhoneNumber(phoneNumber);
    }

}
