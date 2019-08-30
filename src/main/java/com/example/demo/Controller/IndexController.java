package com.example.demo.Controller;

import com.example.demo.Dao.MongoDao;
import com.example.demo.Domain.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by XingLM on 2019/8/29.
 */
@Controller
@RequestMapping("/index")
public class IndexController{

    @Autowired
    private MongoDao mongoDao;
    @RequestMapping("/home")
    public String index(){
        List<Entity> list = mongoDao.findAll();
        return "index";
    }
}
