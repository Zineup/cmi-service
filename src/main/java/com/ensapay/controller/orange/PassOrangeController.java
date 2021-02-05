package com.ensapay.controller.orange;

import com.ensapay.entity.orange.Pass;
import com.ensapay.service.orange.PassOrangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orange/passes")
public class PassOrangeController {

    @Autowired
    private PassOrangeService passOrangeService;

    @GetMapping
    public List<Pass> getAllPasses(){
        return passOrangeService.getAllPass();
    }

    @GetMapping("{id}")
    public Pass getPassById(@PathVariable String id){
        return passOrangeService.getPassById(id);
    }
}
