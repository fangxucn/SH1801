package com.qfedu.ssh.service;

import com.qfedu.ssh.bean.Product;
import com.qfedu.ssh.bean.ProductPage;

public interface ProductService {
    //添加一个商品
    void addProduct(Product product);

    //删除一个商品
    void removeProduct(Product product);

    //查询一个商品
    Product selectOneById(Integer id);

    //编辑商品
    void editProduct(Product product);

    //返回一页数据
    ProductPage getPage(int pageNo,int pageSize,String category);

}
