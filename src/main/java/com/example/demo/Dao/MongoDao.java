package com.example.demo.Dao;

import com.example.demo.Domain.History;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by XingLM on 2019/8/30.
 */
public interface MongoDao extends MongoRepository<History,Long>{
}
