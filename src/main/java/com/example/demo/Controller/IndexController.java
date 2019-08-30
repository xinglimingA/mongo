package com.example.demo.Controller;

import com.example.demo.Dao.MongoDao;
import com.example.demo.Domain.History;
import com.example.demo.Domain.QueryVo;
import com.example.demo.Service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Created by XingLM on 2019/8/29.
 */
@Controller
public class IndexController{

    @Autowired
    private MongoService mongoService;

    @Autowired
    private MongoDao mongoDao;

    @Autowired
    private MongoTemplate mongoTemplate;

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
        model.addAttribute("ip","");
        model.addAttribute("domin","");
        return "index";
    }

    @RequestMapping("/query")
    @ResponseBody
    public List<History> query( QueryVo queryVo,Integer pageNumber,Model model){

        queryVo.setDomin(queryVo.getDomin().trim());
        queryVo.setIp(queryVo.getIp().trim());
        Page<History>page = mongoService.findByQuery(queryVo,pageNumber);
        List<History> list = new ArrayList<>();
        Iterator<History> iterator = page.iterator();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        return list;
    }

    @RequestMapping("/querybyvo")
    public String querybyvo( QueryVo queryVo,Model model){

        queryVo.setDomin(queryVo.getDomin().trim());
        queryVo.setIp(queryVo.getIp().trim());
        Page<History>page = mongoService.findByQuery(queryVo,1);
        Long count = mongoService.countByQuery(queryVo);
        List<History> list = new ArrayList<>();
        Iterator<History> iterator = page.iterator();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        model.addAttribute("list",list);
        model.addAttribute("page",1);
        model.addAttribute("count",count);
        model.addAttribute("ip",queryVo.getIp());
        model.addAttribute("domin",queryVo.getDomin());

        System.out.println(count);
        return "index";
    }



}
