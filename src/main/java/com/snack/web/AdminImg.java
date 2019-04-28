package com.snack.web;

import com.snack.utils.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
@RequestMapping("/admin/img/")
public class AdminImg {

    @RequestMapping("mainToAdminImg")
    public String mainToAdminImg() {
        return "admin/Img/adminImg";
    }


    @RequestMapping(value = "/upload")
    @ResponseBody
    public String upload(String fileName, @RequestParam("file") MultipartFile file) {
        System.out.println(fileName);
        try {
            file.transferTo(new File("D:\\ssm_snack\\snack\\src\\main\\webapp\\image\\trimImg\\" + fileName));
            return ResponseUtil.successToClient();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.errorToClient();
        }

    }
}
