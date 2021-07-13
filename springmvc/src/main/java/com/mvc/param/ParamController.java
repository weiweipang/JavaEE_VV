package com.mvc.param;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ParamController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // 1、日期
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor dateEditor = new CustomDateEditor(df, true);
        // 表示如果命令对象有Date类型的属性，将使用该属性编辑器进行类型转换
        binder.registerCustomEditor(Date.class, dateEditor);
    }


//    测试使用@DateTimeFormat
//    @RequestMapping("param")
//    public String testParam(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
//        return "hello";
//    }
//    @RequestMapping("param1")
//    public String testParam1(User userMapper){
//        return "hello";
//    }

//测试使用WebDataBinder
    @RequestMapping("param2")
    public String testParam2(Date date){
        return "hello";
    }
}
