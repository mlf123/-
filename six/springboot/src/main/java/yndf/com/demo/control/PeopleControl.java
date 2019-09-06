package yndf.com.demo.control;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yndf.com.demo.UsersData.UserData;
import yndf.com.demo.pojo.Users;
import yndf.com.demo.service.UserService;
@RestController
@CrossOrigin  //跨域
public class PeopleControl {

    @RequestMapping(value = "/peoplenews/{code}")
    public Users search(@PathVariable("code")String code) { //接受前端传值
        // 接口地址
        String address = "http://127.0.0.1:8080/services/user?wsdl";
        // 代理工厂
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        // 设置代理地址
        jaxWsProxyFactoryBean.setAddress(address);
        // 设置接口类型
        jaxWsProxyFactoryBean.setServiceClass(UserService.class);
        // 创建一个代理接口实现
        UserService userService = (UserService) jaxWsProxyFactoryBean.create();
        //强转code为int
        int usercode=Integer.parseInt(code);
        System.out.println("a:"+usercode);
        System.out.println(code);
        System.out.println(userService.find(usercode));
        Users users=new Users();
        //获取查询信息peopleDate.getPeopleData(usercode)
        if (userService.find(usercode)!=null){
//            people.setUsercode(peopleDate.getPeopleData(usercode).getUsercode());
//            people.setUsername(peopleDate.getPeopleData(usercode).getUsername());
//            people.setDepartment(peopleDate.getPeopleData(usercode).getDepartment());
//            System.out.println(users.getDepartment()+users.getHiredate());
            return userService.find(usercode);
        }else {
            System.out.println("查无此人");
        }
//        return people;
        System.out.println("查无"+userService.find(usercode));
        return userService.find(usercode);
    }
}
