package yndf.com.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yndf.com.demo.UsersData.UserData;

import java.util.*;

@RestController
//@CrossOrigin  //跨域
public class CenterControl {
    @Autowired
    UserData userData;
    @RequestMapping(value = "/searchAll" )
    public List searchAll() {
        System.out.println(1);
        System.out.println(userData.getUserData());
//        userData.getUserData().entrySet();
        System.out.println(2);
        //System.out.println(userData.getUserData().entrySet());
        System.out.println(3);
        //System.out.println(userData.getUserData().keySet());
        System.out.println(4);
        //System.out.println(userData.getUserData().values());
        return userData.getUserData();
    }





}
