package net.togogo.mapper;

import net.togogo.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProductMapper {

    @Select("select * from product")
    public List<Product> findAll();

    @Select("select p.*,DATE_FORMAT(departureTime,'%Y-%m-%d') departureTimeStr from product p where id = #{id}")
    Product findById(Integer id);

    @Insert("insert into product values(null,#{productNum},#{productName}," +
            "#{cityName},#{departureTime},#{productPrice}," +
            "#{productDesc},#{productStatus})")
    public void save(Product product);

    @Update("update product set productNum=#{productNum},productName=#{productName},cityName=#{cityName},departureTime=#{departureTime}," +
            "productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} where id = #{id}")
    public void update(Product product);

    @Delete("delete from product where id = #{id}")
    void delById(Integer id);

    @Select("select count(1) from product ")
    Long findTotalCount();

    @Select("select * from product limit #{param1},#{param2} ")
    List<Product> findByPage(Integer startIndex, Integer pageSize);
}
