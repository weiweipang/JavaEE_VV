package cn.pww.thymeleaf.controller;

import cn.pww.thymeleaf.entities.Department;
import cn.pww.thymeleaf.entities.Employee;
import cn.pww.thymeleaf.utils.UploadUtil;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("hello")
    public String helloThymeleaf(Map<String,Object> map){
        map.put("hello","测试");
        map.put("hello1","<h4>是否转义</h4>");
        map.put("users",Arrays.asList("tom","jerry","kitty"));
        return "success";
    }
    @RequestMapping("/")
    public String login() throws FileNotFoundException {
        String path = ResourceUtils.getURL("classpath:").getPath();
        System.out.println(path);
        return "login";
    }

    @RequestMapping("/index")
    public String index(Map<String,Object> map){
        List<Employee> employees = new ArrayList<>();
        Employee e1 = new Employee(1001, "E-AA", "aa@163.com", 1, new Department(101, "D-AA"));
        Employee e2 = new Employee(1002, "E-BB", "bb@163.com", 1, new Department(102, "D-BB"));
        Employee e3 = new Employee(1003, "E-CC", "cc@163.com", 0, new Department(103, "D-CC"));
        Employee e4 = new Employee(1004, "E-DD", "dd@163.com", 0, new Department(104, "D-DD"));
        Employee e5 = new Employee(1005, "E-EE", "ee@163.com", 1, new Department(105, "D-EE"));
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);

        map.put("employees",employees);

        return "index";
    }


    @RequestMapping("/upload")
    @ResponseBody
    public R upload(HttpServletRequest request){
        Map<String, String> map = UploadUtil.upload(request);
        return R.ok(map);
    }

}
