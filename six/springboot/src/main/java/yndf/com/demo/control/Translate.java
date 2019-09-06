package yndf.com.demo.control;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.TranslatorWebService;
import cn.com.webxml.TranslatorWebServiceSoap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class Translate {
    @GetMapping("/translate/{word}")
    public List search(@PathVariable("word") String things) {
        System.out.println(things);
        // 获取服务类
        TranslatorWebService englishChinese = new TranslatorWebService();
        // 实现接口
        TranslatorWebServiceSoap englishChineseSoap = englishChinese.getTranslatorWebServiceSoap();
        // 调用方法：中英文双向翻译
        ArrayOfString arrayOfString = englishChineseSoap.getEnCnTwoWayTranslator(things);


        System.out.println(arrayOfString.getString());
        List<String> list=arrayOfString.getString();
        return list;
        // 调用方法：中英文双向翻译（例句）
//        ArrayOfString translatorSentenceString = englishChineseSoap.getEnCnTwoWayTranslator("中国广告");
//        System.out.println("2"+translatorSentenceString.getString());
    }
}
