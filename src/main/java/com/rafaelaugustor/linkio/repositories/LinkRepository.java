package com.rafaelaugustor.linkio.repositories;

import com.rafaelaugustor.linkio.domain.Link;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LinkRepository extends MongoRepository<Link, String>{
}