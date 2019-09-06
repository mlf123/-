package yndf.com.demo.service;

import org.apache.ibatis.annotations.*;
import yndf.com.demo.pojo.Users;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;
@WebService(targetNamespace = "http://service.demo.com.yndf/")
public interface UserService {
    @WebMethod//标注该方法为webservice暴露的方法,用于向外公布，它修饰的方法是webservice方法，去掉也没影响的，类似一个注释信息。
    List<Users> findAll();
    @WebMethod
    int insert(Users user);
    @WebMethod
    int update(Users user);
    @WebMethod
    int delete(int usercode);
    @WebMethod
    Users find(@Param("usercode") int usercode);
}