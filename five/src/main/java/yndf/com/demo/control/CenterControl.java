package yndf.com.demo.control;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yndf.com.demo.UsersData.UserData;
import yndf.com.demo.pojo.Users;
import yndf.com.demo.service.UserService;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
