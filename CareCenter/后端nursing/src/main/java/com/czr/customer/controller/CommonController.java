package com.czr.customer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
public class CommonController {

    @Value("${web.upload-path}")
    private String path;

    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file){
        System.out.println(file.getOriginalFilename());
        //UUID.randomUUID().toString()
        //取原文件名
        String oName = file.getOriginalFilename();
        //取原文件扩展名
        String ext = oName.substring(oName.lastIndexOf("."));
        //构造新文件名
        String nName = UUID.randomUUID().toString() + ext;
        System.out.println(nName);
        try {
            //构造输出流
            FileOutputStream fos = new FileOutputStream(path+nName);
            //复制文件
            FileCopyUtils.copy(file.getInputStream(),fos);
            System.out.println("copy success");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nName;
    }


}
