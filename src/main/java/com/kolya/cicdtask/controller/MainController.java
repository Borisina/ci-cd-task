package com.kolya.cicdtask.controller;

import com.kolya.cicdtask.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private MainService service;

    @GetMapping("/")
    public ResponseEntity getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllRecords());
    }


    @GetMapping("/sum")
    public ResponseEntity getSum(@RequestParam(name = "a") String aStr, @RequestParam(name = "b") String bStr){
        int a = 0;
        int b = 0;
        try{
            a = parseNum(aStr);
            b = parseNum(bStr);
        }catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong parameters!");
        }
        int result = service.getSum(a,b);
        String sign = "+";
        if (b<0){
            sign="";
        }
        service.addRecord(a+sign+b+"="+result);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public int parseNum(String num) throws NumberFormatException{
        return Integer.parseInt(num);
    }
}
