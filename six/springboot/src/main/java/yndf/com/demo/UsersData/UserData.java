package yndf.com.demo.UsersData;

import org.springframework.stereotype.Repository;
import yndf.com.demo.pojo.Users;

import java.util.*;

//@Mapper  //自动生成xml时需要
//@Component
@Repository
public class UserData {
    private static List<Users> peoples=null;
    static {
        peoples=new ArrayList<Users>();
        peoples.add(new Users(10001, "张三", "技术开发部1",new Date("2011/02/01")));
        peoples.add(new Users(10002, "张四", "技术开发部2",new Date("2021/02/01")));
        peoples.add(new Users(10003, "张五", "技术开发部3",new Date("2031/02/01")));
    }

    public List<Users> getUserData(){

//        Users users=new Users();
//        for (Users value : peoples.values()){
//            users.setUsercode(value.getUsercode());
//            users.setUsername(value.getUsername());
//            users.setDepartment(value.getDepartment());
//            users.setHiredate(value.getHiredate());
//            return users;
//        }
       return peoples;
    }
}
