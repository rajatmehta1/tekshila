package com.tekshila.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.tekshila.domain.Instructor;

@Repository
public interface InstructorRepository extends MongoRepository<Instructor, String> {

}
