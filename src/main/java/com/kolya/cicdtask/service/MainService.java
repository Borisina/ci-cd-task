package com.kolya.cicdtask.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class MainService {
    public int getSum(int a, int b){
        return a+b;
    }
}
