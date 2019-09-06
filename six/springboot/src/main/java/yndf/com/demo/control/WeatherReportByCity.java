package yndf.com.demo.control;

import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 根据城市名/id查询天气 
 * @author silk
 *
 */

@RestController
@CrossOrigin
public class WeatherReportByCity {
    /**
     * 根据城市名获取 
     * @param cityName
     * @return
     */
    public static String excute(String cityName){
        String url=//此处以返回json格式数据示例,所以format=2,以根据城市名称为例,cityName传入中文  
                "http://v.juhe.cn/weather/index?cityname="+cityName+"&key=39c7b92ad0718b5544e4dcbffca027d3";
        return PureNetUtil.get(url);//通过工具类获取返回数据
    }

    public static StringBuilder GetTodayTemperatureByCity(String city) {
        String result=excute(city);
//        List list=new ArrayList();
        StringBuilder stbu = new StringBuilder();
        String text=null;
        if(result!=null){
            JSONObject obj= JSONObject.fromObject(result);
            System.out.println("11"+obj);
            /*获取返回状态码*/
            result=obj.getString("resultcode");
            /*如果状态码是200说明返回数据成功*/
            if(result!=null&&result.equals("200")){
                result=obj.getString("result");
                System.out.println("22"+result);
                //此时result中数据有多个key,可以对其key进行遍历,得到对个属性
                obj= JSONObject.fromObject(result);
                //今日温度对应的key是today
                System.out.println(obj);

                result=obj.getString("future");
                obj= JSONObject.fromObject(result);


                for (Object obj1:obj.keySet()){
                    String key=(String)obj1;
                    //List list=new ArrayList();
                    result=obj.getString(key);
                    JSONObject one= JSONObject.fromObject(result);
                    //今日温度对应当key是temperature
                    //今日天气对应当key是weather
                    //今日星期week
                    text=  "日期:"+  one.getString("date")+"||"
                            + "温度:"+ one.getString("temperature")+"||"
                            + "天气:"+one.getString("weather" )+"||"
                            +"星期:"+one.getString("week")+"\n";
                    System.out.println();
                    stbu.append(text);
                    System.out.println("121"+text);

                }
//                List list1=new ArrayList();
//                result=obj.getString("day_20190905");
//                JSONObject one=JSONObject.fromObject(result);
//                //今日温度对应当key是temperature
//                list1.add(one.getString("temperature"));
//                //今日天气对应当key是weather
//                list1.add(one.getString("weather"));
//                //今日星期
//                list1.add(one.getString("week"));
//
//                List list2=new ArrayList();
//                result=obj.getString("day_20190906");
//                JSONObject two=JSONObject.fromObject(result);
//                //今日温度对应当key是temperature
//                list2.add(two.getString("temperature"));
//                //今日天气对应当key是weather
//                list2.add(two.getString("weather"));
//                //今日星期
//                list2.add(two.getString("week"));
//
//                List list3=new ArrayList();
//                result=obj.getString("day_20190907");
//                JSONObject three=JSONObject.fromObject(result);
//                //今日温度对应当key是temperature
//                list3.add(three.getString("temperature"));
//                //今日天气对应当key是weather
//                list3.add(three.getString("weather"));
//                //今日星期
//                list3.add(three.getString("week"));
//
//                list.add(list1);
//                list.add(list2);
//                list.add(list3);
                System.out.println("qqqq"+stbu);
                return stbu;
            }
        }
        return stbu;
    }
    @RequestMapping(value = "/weathercity/{city}")
    public StringBuilder list(@PathVariable("city")String city){
//        List list=GetTodayTemperatureByCity(city);
//        System.out.println("今天天气"+list.get(0));
//        System.out.println("明天天气"+list.get(1));
        StringBuilder s=GetTodayTemperatureByCity(city);
        return s;
    }
}  