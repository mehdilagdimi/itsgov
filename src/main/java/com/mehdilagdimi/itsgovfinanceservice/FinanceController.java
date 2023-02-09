package com.mehdilagdimi.itsgovfinanceservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/finance")
public class FinanceController {

    @GetMapping
    public void financeHello(){
        System.out.println(" hello from finance ");
    }
}
