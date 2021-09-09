package com.tekshila.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.tekshila.domain.Subscribe;

@Repository
public interface SubscribeRepository extends MongoRepository<Subscribe, String> {
}
