package net.togogo.controller;

import net.togogo.domain.Role;
import net.togogo.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Resource
    RoleService roleService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){

        List<Role> roles = roleService.findAll();

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("roles",roles);
        modelAndView.setViewName("role-list");

        return modelAndView;
    }

}
