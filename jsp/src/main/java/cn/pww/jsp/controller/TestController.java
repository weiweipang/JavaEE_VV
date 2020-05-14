package cn.pww.jsp.controller;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class TestController {
    @RequestMapping("/hello")
    public String helloJsp(Map<String,Object> map, HttpServletResponse response,HttpServletRequest request){
        map.put("hello","hellpJsp");
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        System.out.println(contextPath);
        System.out.println(servletPath);
        return "helloJsp";

    }


    @RequestMapping("test")
    @ResponseBody
    public R test(){
        return R.ok("成功");
    }
}