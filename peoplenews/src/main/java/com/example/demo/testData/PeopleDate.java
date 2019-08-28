package com.example.demo.testData;

import com.example.demo.entity.People;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class PeopleDate {
    private static Map<Integer, People> peoples=null;
    static {
        peoples=new HashMap<Integer, People>();
        peoples.put(10001, new People(10001, "张三", "技术开发部1"));
        peoples.put(10002, new People(10002, "张四", "技术开发部2"));
        peoples.put(10003, new People(10003, "张五", "技术开发部3"));
    }

    public People getPeopleData(int usercode){
        return peoples.get(usercode);
    }
}
