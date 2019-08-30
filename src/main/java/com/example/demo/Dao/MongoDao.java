package com.example.demo.Dao;

import com.example.demo.Domain.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by XingLM on 2019/8/30.
 */
public interface MongoDao extends MongoRepository<History,String>{

    Page<History> findById(String id, Pageable pageable);

    Page<History> findByIp(String ip,Pageable pageable);

    Page<History> findByDomin(String domin,Pageable pageable);

    List<History> findByIp(String ip);

    List<History> findByDomin(String domin);
}
