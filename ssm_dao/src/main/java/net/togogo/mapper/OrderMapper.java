package net.togogo.mapper;

import net.togogo.domain.Order;
import net.togogo.domain.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {

    @Select("select * from orders")
    @Results({
            @Result(property = "product",column = "productId",javaType = Product.class,
            one = @One(select = "net.togogo.mapper.ProductMapper.findById"))
    })
    List<Order> findAll();
}
