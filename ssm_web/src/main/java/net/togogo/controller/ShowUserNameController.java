package net.togogo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Controller
public class ShowUserNameController {

    /**
     * 显示用户名
     */
    @RequestMapping("/showUserName")
    public void showUserName(HttpServletRequest request){
        HttpSession session = request.getSession();

//        获取登录信息
//        获取所有的属性名
        Enumeration names = session.getAttributeNames();

//        遍历枚举类型
        while (names.hasMoreElements()){
            System.out.println(names.nextElement()); // SPRING_SECURITY_CONTEXT：存储用户登录信息的session中的名称
        }

//        获取的是Security的上下文对象
        SecurityContext securityContext = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");

//        获取认证信息
        Authentication authentication = securityContext.getAuthentication();
//        获取重要信息-----用户详情（User）
        User user = (User) authentication.getPrincipal();
//        获取用户名
        String username = user.getUsername();

//        获取上下文对象的方法二
//        SecurityContext context = SecurityContextHolder.getContext();

    }

}
