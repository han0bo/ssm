package net.togogo.service;


import com.github.pagehelper.PageInfo;
import net.togogo.domain.PageBean;
import net.togogo.domain.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();

    public String save(Product product);

    public Product findById(Integer id);

    public void update(Product product);

    void delOne(Integer id);

    void delMeny(Integer[] ids);

    PageBean<Product> findByPage(Integer currPage, Integer pageSize);

    public PageInfo<Product> findByPageHelper(Integer currPage, Integer pageSize);
}
