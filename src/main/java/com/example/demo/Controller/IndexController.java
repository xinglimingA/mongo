package com.example.demo.Controller;

import com.example.demo.Dao.MongoDao;
import com.example.demo.Domain.History;
import com.example.demo.Domain.QueryVo;
import com.example.demo.Service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by XingLM on 2019/8/29.
 */
@Controller
public class IndexController{

    @Autowired
    private MongoService mongoService;

    @RequestMapping("/index")
    public String index(Model model){

        Page<History> page = mongoService.findByQuery(new QueryVo(),1);
        Long count = mongoService.countByQuery(new QueryVo());

        List<History> list = new ArrayList<>();
        Iterator<History> iterator = page.iterator();

        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        model.addAttribute("list",list);
        model.addAttribute("page",1);
        model.addAttribute("count",count);
        return "index";
    }

    @RequestMapping("/query")
    public String query(@RequestBody QueryVo queryVo,Integer pageNumber,Model model){

        Page<History>page = mongoService.findByQuery(queryVo,pageNumber);
        Long count = mongoService.countByQuery(queryVo);
        List<History> list = new ArrayList<>();
        Iterator<History> iterator = page.iterator();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }

        model.addAttribute("list",list);
        model.addAttribute("page",pageNumber);
        model.addAttribute("count",count);
        return "index";
    }



}
