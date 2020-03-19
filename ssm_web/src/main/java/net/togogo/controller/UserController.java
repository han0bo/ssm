package net.togogo.controller;

import net.togogo.domain.SysUser;
import net.togogo.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    SysUserService sysUserService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){

        List<SysUser> users = sysUserService.findAll();

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("users",users);
        modelAndView.setViewName("user-list");

        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(SysUser sysUser){

        sysUserService.save(sysUser);

        return "redirect:/user/findAll";
    }

    @RequestMapping("/isUniqueName")
    @ResponseBody
    public String isUniqueName(String username){
        boolean result = sysUserService.findByUserName(username);
        return String.valueOf(result);
    }
}
