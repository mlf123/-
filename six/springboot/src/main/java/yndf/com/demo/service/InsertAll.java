package yndf.com.demo.service;

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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import yndf.com.demo.pojo.Users;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Service
public class InsertAll {
    @Autowired
    UserService userService;
//    @RequestMapping(value = "/insertAll" )
//cron = "0/3 40 11 * * ?" 每天11:40触发，没三秒执行一次
 @Scheduled(cron = "0/3 07 14 * * ?")
    public void insertAll() {
        Users users=new Users();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
//        String url = "http://localhost:8080/searchAll";
//        HttpClient
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Get请求
        HttpGet httpGet = new HttpGet("http://localhost:8080/searchAll");

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("a1:"+responseEntity);

            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                String str= EntityUtils.toString(responseEntity);
                System.out.println("响应内容为:" +str);
                //String转json
                JSONArray obj= JSONArray.fromObject(str);
//               JSONArray obj2=JSONArray.fromObject(obj);
                System.out.println("obj"+obj);
//                System.out.println(obj);
                JSONArray jsonArray=JSONArray.fromObject(obj);
                System.out.println(jsonArray);
                for(int i=0;i<jsonArray.size();i++){
                    JSONObject jsonObject=jsonArray.getJSONObject(i);
                    //通过key获取value
                    System.out.println(jsonObject);
//                    System.out.println(jsonObject.getString("username"));
                    users.setUsercode(jsonObject.getInt("usercode"));
//                    System.out.println(users.getUsercode());
                    users.setUsername(jsonObject.getString("username"));
                    users.setDepartment(jsonObject.getString("department"));

//                    System.out.println(jsonObject.getString("hiredate"));
                    Date date = dateFormat.parse(jsonObject.getString("hiredate"));
                    users.setHiredate(new Date(date.getTime()));
                    System.out.println(users.getHiredate());
                    System.out.println("用户："+users);
                    if (userService.find(users.getUsercode())==null){
                        System.out.println("insert"+jsonObject.getInt("usercode"));
                        userService.insert(users);
                    }else {
                        System.out.println("重复了");
                    }

                    //直接获取key-value
//                    Iterator<String> it = jsonObject.keys();
//                    while(it.hasNext()){
//                        String key = it.next();
//                        Object value = jsonObject.get(key)+"";
//                        System.out.println(key+"   :    "+value);
//                    }
                }
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
