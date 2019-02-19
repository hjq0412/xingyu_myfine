package cn.xingyu.myfine.controller;

import cn.xingyu.myfine.util.Constant;
import cn.xingyu.myfine.util.Data;
import cn.xingyu.myfine.util.UploadFile;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

/**
 * @author 何嘉琦
 * @date 2019-01-24-10:13
 */
@Controller
@RequestMapping(value = "/upload")
public class UploadController {
    private UploadFile uploadFile= new UploadFile();
    @RequestMapping("/save.html")
    @ResponseBody
    public Object upload(@RequestParam(value = "file") MultipartFile file, HttpSession session) {
       return null;

    }

    @RequestMapping("/toUpload.html")
    public String toUpload() {
        return "upload";
    }
}
