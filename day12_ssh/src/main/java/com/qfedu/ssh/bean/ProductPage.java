package com.qfedu.ssh.bean;

import java.util.List;

public class ProductPage {
    private int pageNo;//此页的页码
    private long pageCount;//一共有多少页
    private int pageSize;//这一页有多少数据
    private String category;//这一页的类型
    private List<Product> products;//这一页的数据

    public int getPageNo() {
        return pageNo;
    }

    public ProductPage setPageNo(int pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    public long getPageCount() {
        return pageCount;
    }

    public ProductPage setPageCount(long pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public ProductPage setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ProductPage setCategory(String category) {
        this.category = category;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public ProductPage setProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    @Override
    public String toString() {
        return "ProductPage{" +
                "pageNo=" + pageNo +
                ", pageCount=" + pageCount +
                ", pageSize=" + pageSize +
                ", category='" + category + '\'' +
                ", products=" + products +
                '}';
    }
}
