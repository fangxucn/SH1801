package com.qfedu.ssm.bean;

import java.util.List;

/**
 * Author:方旭
 * Date:2018/6/13 0013
 */


public class PageInfo<T> {
    private int pageNo;//此页的页码
    private long pageCount;//一共多少页
    private int pageSize;//这一页有多少数据
    private List<T> items;//这一页的数据

    @Override
    public String toString() {
        return "PageInfo{" +
                "pageNo=" + pageNo +
                ", pageCount=" + pageCount +
                ", pageSize=" + pageSize +
                ", items=" + items +
                '}';
    }

    public int getPageNo() {
        return pageNo;
    }

    public PageInfo<T> setPageNo(int pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    public long getPageCount() {
        return pageCount;
    }

    public PageInfo<T> setPageCount(long pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageInfo<T> setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public List<T> getItems() {
        return items;
    }

    public PageInfo<T> setItems(List<T> items) {
        this.items = items;
        return this;
    }
}
