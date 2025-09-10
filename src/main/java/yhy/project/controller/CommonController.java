package yhy.project.controller;

import cn.hutool.core.io.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import yhy.project.util.Result;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

@RequestMapping({"/common"})
@RestController
public class CommonController {
    private static final Logger log = LoggerFactory.getLogger((Class<?>) CommonController.class);

    @Value("${upload.path}")
    private String uploadPath;

    @PostMapping({"/upload"})
    public Result upload(@RequestParam("file") MultipartFile multipartFile) {
        String name = UUID.randomUUID().toString() + multipartFile.getOriginalFilename();
        try {
            FileUtil.writeBytes(multipartFile.getBytes(), this.uploadPath + name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.success(name);
    }

    @GetMapping({"/download"})
    public void download(String name, HttpServletResponse response) {
        byte[] bytes = FileUtil.readBytes(this.uploadPath + name);
        try {
            OutputStream os = response.getOutputStream();
            os.write(bytes);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}