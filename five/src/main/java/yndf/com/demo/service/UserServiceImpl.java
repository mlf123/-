package yndf.com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yndf.com.demo.dao.UserDao;
import yndf.com.demo.pojo.Users;

import java.util.List;
@Service
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