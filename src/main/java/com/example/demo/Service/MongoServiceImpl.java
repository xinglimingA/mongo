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
import org.springframework.util.StringUtils;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        Sort sort = new Sort(Sort.Direction.DESC,"times");

        PageModel pageModel = new PageModel();
        pageModel.setSort(sort);
        pageModel.setPagenumber(page);

        SpringbootPageable pageable = new SpringbootPageable();
        pageable.setPage(pageModel);

        Page<History> pageList = null;

        if(StringUtils.isEmpty(queryVo.getDomin())&&StringUtils.isEmpty(queryVo.getIp())){
            pageList = mongoDao.findAll(pageable);
        }else if(!StringUtils.isEmpty(queryVo.getDomin())&&StringUtils.isEmpty(queryVo.getIp())){
            pageList = mongoDao.findByDomin(queryVo.getDomin(),pageable);
        }else if(StringUtils.isEmpty(queryVo.getDomin())&&!StringUtils.isEmpty(queryVo.getIp())){
            pageList = mongoDao.findByIp(queryVo.getIp(),pageable);
        }else{
            String id = queryVo.getIp()+"_"+queryVo.getDomin();
            pageList = mongoDao.findById(id,pageable);
        }

        return pageList;


    }


    public Long countByQuery(QueryVo queryVo){

        Long count = 0L;
        List<History> list = null;
        if(StringUtils.isEmpty(queryVo.getDomin())&&StringUtils.isEmpty(queryVo.getIp())){
            count = mongoDao.count();
        }else if(!StringUtils.isEmpty(queryVo.getDomin())&&StringUtils.isEmpty(queryVo.getIp())){
            list = mongoDao.findByDomin(queryVo.getDomin());
            count = Long.valueOf(list.size());
        }else if(StringUtils.isEmpty(queryVo.getDomin())&&!StringUtils.isEmpty(queryVo.getIp())){
            list = mongoDao.findByIp(queryVo.getIp());
            count = Long.valueOf(list.size());
        }else{
            String id = queryVo.getIp()+"_"+queryVo.getDomin();
            Optional<History> optional = mongoDao.findById(id);
            if(optional.get()!=null){
                count = 1L;
            }else{
                count = 0L;
            }
        }
        return count;
    }
}
