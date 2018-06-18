package com.qfedu.ssh.bean;

import javax.persistence.*;
import java.math.BigDecimal;

//软件=程序+数据+文档
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;//商品id
    @Column(name="name")
    private String name;//商品名称
    @Column(name="price")
    private BigDecimal price;//商品价格
    @Column(name="pnum")
    private Integer pnum;//库存剩余量
    @Column(name="category")
    private String category;//商品类型
    @Column(name="description")
    private String description;//商品描述

    public Integer getId() {
        return id;
    }

    public Product setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getPnum() {
        return pnum;
    }

    public Product setPnum(Integer pnum) {
        this.pnum = pnum;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Product setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pnum=" + pnum +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
