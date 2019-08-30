package com.example.demo.Domain;

import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * Created by XingLM on 2019/8/30.
 */
public class PageModel implements Serializable {

    private static final long serialVersionUID = 1L;
    // 当前页
    private Integer pagenumber = 1;
    // 当前页面条数
    private Integer pagesize = 20;
    // 排序条件
    private Sort sort;

    public Integer getPagenumber() {
        return pagenumber;
    }
    public void setPagenumber(Integer pagenumber) {
        this.pagenumber = pagenumber;
    }
    public Integer getPagesize() {
        return pagesize;
    }
    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }
    public Sort getSort() {
        return sort;
    }
    public void setSort(Sort sort) {
        this.sort = sort;
    }
}
