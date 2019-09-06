package yndf.com.demo.control;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 *新闻调用示例代码 － 聚合数据
 **/
@CrossOrigin
@RestController
public class NewsDemo {
    public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

    //配置您申请的KEY
    public static final String APPKEY = "BuvGqtJuQo7+h5uM8Yg6RmfJPQTgsJeZ/px16A";

    //1.新闻检索
    @RequestMapping("/news")
    public static JSONObject getRequest1() {
        String result = null;
        JSONObject object = null;
//        Object a = null;
        String url = "http://zhouxunwang.cn/data/";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("id", "75");//需要检索的关键字,请UTF8 URLENCODE
        params.put("key", APPKEY);//应用APPKEY(应用详细页查询)
        params.put("type", "top");//返回数据的格式,xml或json，默认json
        params.put("type", "shehui");
        params.put("type", "guonei");
        params.put("type", "guoji");
        params.put("type", "yule");
        params.put("type", "tiyu");
        params.put("type", "junshi");
        params.put("type", "keji");
        params.put("type", "caijing");
        params.put("type", "shishang");

        try {
            result = net(url, params, "GET");
            //转换为json格式
            object = JSONObject.fromObject(result);
            object = JSONObject.fromObject(object.get("result"));
            System.out.println("4"+result);
            System.out.println("3"+object);
            System.out.println("1"+object.get("result"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }


    /**
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return 网络请求字符串
     * @throws Exception
     */
    public static String net(String strUrl, Map params, String method) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            if (method == null || method.equals("GET")) {
                strUrl = strUrl + "?" + urlencode(params);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if (method == null || method.equals("GET")) {
                conn.setRequestMethod("GET");
            } else {
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("User-agent", userAgent);
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params != null && method.equals("POST")) {
                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                    out.writeBytes(urlencode(params));
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }

    //将map型转为请求参数型
    public static String urlencode(Map<String, Object> data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    public static JSONArray GetNewsTop() {
        //getRequest1();
        JSONObject s = getRequest1();
        //转换为json格式
        JSONObject jsonObject = JSONObject.fromObject(s);
        JSONArray array = jsonObject.getJSONObject("result").getJSONArray("data");
        return array;
    }
}
