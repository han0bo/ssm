package net.togogo.controller;

import net.togogo.domain.Order;
import net.togogo.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Resource
    OrderService orderService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();

        List<Order> orders =  orderService.findAll ();
        modelAndView.addObject("orders",orders);
        modelAndView.setViewName("order-list");

        return modelAndView;
    }

}
