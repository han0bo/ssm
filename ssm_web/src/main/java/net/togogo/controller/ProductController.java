package net.togogo.controller;

import com.github.pagehelper.PageInfo;
import net.togogo.domain.Product;
import net.togogo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Arrays;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Resource
    ProductService productService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(
            @RequestParam(value = "currPage", defaultValue = "1") Integer currPage,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        ModelAndView modelAndView = new ModelAndView();

        PageInfo<Product> pageInfo = productService.findByPageHelper(currPage, pageSize);

        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("product-list");

        return modelAndView;
    }

    /*  *//**
     * 手动分页查询
     * @return
     *//*
    @RequestMapping("/findAll")
    public ModelAndView findAll(
            @RequestParam(value = "currPage",defaultValue = "1") Integer currPage,
            @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize){
        ModelAndView modelAndView = new ModelAndView();

        List<Product> products = productService.findAll();
        PageBean<Product> pageBean = productService.findByPage(currPage,pageSize);

       modelAndView.addObject("pageBean",pageBean);
       modelAndView.setViewName("product-list");

        return modelAndView;
    }

    @RequestMapping("/findAll1")
    public ModelAndView findAll1(){
        ModelAndView modelAndView = new ModelAndView();

        List<Product> products = productService.findAll();

        modelAndView.addObject("products",products);
        modelAndView.setViewName("product-list");

        return modelAndView;
    }
*/

    /**
     * 添加商品
     *
     * @param product
     * @return
     */
    @RequestMapping("/save")
    public String save(Product product) {

        productService.save(product);

        return "redirect:/product/findAll";
    }

    /**
     * 跳转更新页面
     *
     * @param id
     * @return
     */
    @RequestMapping("/updateUI")
    public ModelAndView updateUI(Integer id) {

        ModelAndView modelAndView = new ModelAndView();

        Product product = productService.findById(id);

        modelAndView.addObject("product", product);
        modelAndView.setViewName("product-update");

        return modelAndView;
    }

    @RequestMapping("/update")
    public String update(Product product) {

        productService.update(product);

        return "redirect:/product/findAll";
    }

    @RequestMapping("/delOne")
    public String delOne(Integer id) {

        productService.delOne(id);

        return "redirect:/product/findAll";
    }

    @RequestMapping("/delMeny")
    public String delMeny(Integer[] ids) {

        productService.delMeny(ids);
        System.out.println(Arrays.toString(ids));
        return "redirect:/product/findAll";
    }
}
