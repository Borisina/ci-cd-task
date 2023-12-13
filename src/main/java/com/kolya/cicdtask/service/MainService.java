package com.kolya.cicdtask.service;

import com.kolya.cicdtask.model.Record;
import com.kolya.cicdtask.repo.RecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MainService {

    @Autowired
    private RecordRepo recordRepo;

    public int getSum(int a, int b){
        return a+b;
    }

    public List<Record> getAllRecords(){
        return recordRepo.findAll();
    }

    public void addRecord(String str){
        Record record = new Record();
        record.setStr(str);
        recordRepo.save(record);
    }
}
