package com.tekshila.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.tekshila.domain.Counters;
import com.tekshila.domain.Course;

import java.util.List;

@Repository
public interface CountersRepository extends MongoRepository<Counters, String> {

    Counters findBySequenceName(String sequenceName);

}
