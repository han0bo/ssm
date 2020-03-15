package net.togogo.service.impl;

import net.togogo.domain.Product;
import net.togogo.mapper.ProductMapper;
import net.togogo.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductMapper productMapper;

    /**
     * 查询所有商品
     * @return
     */
    @Override
    public List<Product> findAll() {
        return productMapper.findAll();
    }

    /**
     * 添加商品
     * @param product
     * @return
     */
    public String save(Product product){

        productMapper.save(product);

        return "redirect:/product/findAll";

    }

    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    @Override
    public Product findById(Integer id) {
        return productMapper.findById(id);
    }

    /*
    * 更新产品
    * */
    @Override
    public void update(Product product) {
        productMapper.update(product);
    }

    /**
     * 根据id删除一个商品
     * @param id
     */
    @Override
    public void delOne(Integer id) {
        productMapper.delById(id);
    }

    /**
     * 删除多个商品
     * @param ids
     */
    @Override
    public void delMeny(Integer[] ids) {
        if(ids != null){
            for (Integer id : ids) {
                productMapper.delById(id);
            }
        }
    }
}
