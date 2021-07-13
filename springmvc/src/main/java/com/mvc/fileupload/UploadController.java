package com.mvc.fileupload;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
//    单文件上传
    @RequestMapping("/upload")
    @ResponseBody
    public void upload(MultipartFile header){
        String name = header.getName();
        String originalFilename = header.getOriginalFilename();
        File file = new File("E:\\FileUpload\\"+originalFilename);
        try {
            header.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(name+":"+originalFilename);
    }


    //    多文件上传
    @RequestMapping("/uploads")
    @ResponseBody
    public void uploads(MultipartFile[] headers){
        for (MultipartFile header : headers) {
            String originalFilename = header.getOriginalFilename();
            File file = new File("E:\\FileUpload\\"+originalFilename);
            try {
                header.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
