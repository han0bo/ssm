package net.togogo.controller;

import net.togogo.domain.Permission;
import net.togogo.service.PermissionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Resource
    PermissionService permissionService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){

        List<Permission> permissions =  permissionService.findAll();

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("permissions",permissions);

        modelAndView.setViewName("permission-list");

        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Permission permission){

        permissionService.save(permission);

        return "redirect:/permission/findAll";

    }

}
