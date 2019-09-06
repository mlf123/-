package yndf.com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import yndf.com.demo.dao.UserDao;
import yndf.com.demo.pojo.Users;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;
//@Service
@Component
@WebService(serviceName="UserService",//对外发布的服务名
            targetNamespace = "http://service.demo.com.yndf/",//指定你想要的名称空间，通常使用使用包名反转
            endpointInterface = "yndf.com.demo.service.UserService")//服务接口全路径, 指定做SEI（Service EndPoint Interface）服务端点接口
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public List<Users> findAll() {
        return userDao.findAll();
    }
    //添加
    @Override
    public int insert(Users user) {
        System.out.println("添加时间"+user.getHiredate());
        return userDao.insert(user);
    }
    //查询一个
    @Override
    public Users find(int usercode) {
        return userDao.find(usercode);
    }
    @Override
    public int update(Users user) {
        return 0;
    }

    @Override
    public int delete(int usercode) {
        return 0;
    }


}