package com.kolya.cicdtask.repo;

import com.kolya.cicdtask.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepo extends JpaRepository<Record, Integer> {
}


