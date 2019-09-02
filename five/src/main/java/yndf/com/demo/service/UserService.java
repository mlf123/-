package yndf.com.demo.service;

import org.apache.ibatis.annotations.*;
import yndf.com.demo.pojo.Users;

import java.util.List;

public interface UserService {

    List<Users> findAll();

    int insert(Users user);

    int update(Users user);

    int delete(int usercode);

    Users find(@Param("usercode") int usercode);
}