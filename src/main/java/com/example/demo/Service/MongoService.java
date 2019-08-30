package com.example.demo.Service;

import com.example.demo.Domain.History;
import com.example.demo.Domain.QueryVo;
import org.springframework.data.domain.Page;

/**
 * Created by XingLM on 2019/8/30.
 */
public interface MongoService {
    Page<History> findByQuery(QueryVo queryVo,Integer page);
    Long countByQuery(QueryVo queryVo);
}
