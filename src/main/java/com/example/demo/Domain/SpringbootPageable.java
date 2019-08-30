package com.example.demo.Domain;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * Created by XingLM on 2019/8/30.
 */
public class SpringbootPageable implements Serializable,Pageable{

    private static final long serialVersionUID = 1L;

    private PageModel page;

    public SpringbootPageable(PageModel page){
        this.page = page;
    }

    public SpringbootPageable(){

    }

    public PageModel getPage() {
        return page;
    }

    public void setPage(PageModel page) {
        this.page = page;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public long getOffset() {
        return (page.getPagenumber() - 1) * page.getPagesize();
    }

    @Override
    public int getPageNumber() {
        return page.getPagenumber();
    }

    @Override
    public int getPageSize() {
        return page.getPagesize();
    }


    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Sort getSort() {
        return page.getSort();
    }
}
