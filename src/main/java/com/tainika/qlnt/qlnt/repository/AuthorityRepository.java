package com.tainika.qlnt.qlnt.repository;

import com.tainika.qlnt.qlnt.model.Authority;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends MongoRepository<Authority, String> {
}
