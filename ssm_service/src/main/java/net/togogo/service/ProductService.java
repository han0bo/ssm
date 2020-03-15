package net.togogo.service;


import net.togogo.domain.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();

    public String save(Product product);

    public Product findById(Integer id);

    public void update(Product product);

    void delOne(Integer id);

    void delMeny(Integer[] ids);
}
