package com.qfedu.ssh.dao;

import com.qfedu.ssh.bean.Product;

import java.util.List;

public interface ProductDao {
    //增删查改
    void insertToProduct(Product product);
    void deleteProduct(Product product);
    Product selectOneById(Integer id);
    void updateProduct(Product product);
    //一页数据
    List<Product> selectProductByPage(int pageNo,int pageSize,String category);
    //查询总数
    long selectProdductCount(String category);

}
