package yndf.com.demo.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import yndf.com.demo.pojo.Users;
import yndf.com.demo.service.UserService;

import java.util.Date;
import java.util.List;
@RestController
public class UserController{

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/find",method = RequestMethod.POST )
    public Users find(int usercode) {
        return userService.find(usercode);
    }

    @RequestMapping(value = "/insert" )
    public List<Users> insert(Users user) {
        System.out.println("newdata时间："+new Date("2017/11/24").toString());
        user.setUsercode(10004);
        user.setUsername("邢文极");
        user.setDepartment("开发部");
        user.setHiredate(new Date("2019/07/05"));
        System.out.println("创建时间："+user.getHiredate());
        userService.insert(user);
        System.out.println("a");
        return userService.findAll();
    }

    @RequestMapping(value = "/findAll")
    public List<Users> findAll() {
        return userService.findAll();
    }

    @RequestMapping("/index")

    public String index(){
        return "news";
    }
}