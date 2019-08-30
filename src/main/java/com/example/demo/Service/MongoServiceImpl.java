package com.example.demo.Service;

import com.example.demo.Dao.MongoDao;
import com.example.demo.Domain.History;
import com.example.demo.Domain.PageModel;
import com.example.demo.Domain.QueryVo;
import com.example.demo.Domain.SpringbootPageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by XingLM on 2019/8/30.
 */
@Service
public class MongoServiceImpl implements MongoService {

    @Autowired
    private MongoDao mongoDao;

    public Page<History> findByQuery(QueryVo queryVo, Integer page){

        if(page < 1){
            page = 1;
        }

        History history = new History();
        history.setIp(queryVo.getIp());
        history.setDomin(queryVo.getDomin());

        Sort sort = new Sort(Sort.Direction.DESC,"id");

        PageModel pageModel = new PageModel();
        pageModel.setSort(sort);
        pageModel.setPagenumber(page);

        SpringbootPageable pageable = new SpringbootPageable();
        pageable.setPage(pageModel);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.EXACT);

        Example<History> example = Example.of(history,matcher);

        Page<History> pageList = mongoDao.findAll(example,pageable);

        return pageList;


    }


    public Long countByQuery(QueryVo queryVo){

        History history = new History();
        history.setIp(queryVo.getIp());
        history.setDomin(queryVo.getDomin());

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.EXACT);

        Example<History> example = Example.of(history,matcher);
        return mongoDao.count(example);
    }
}
