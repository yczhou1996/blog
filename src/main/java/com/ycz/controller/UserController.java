package com.ycz.controller;

import com.ycz.constant.WebConst;
import com.ycz.model.Bo.RestResponseBo;
import com.ycz.model.Vo.UserVo;
import com.ycz.service.IUserService;
import com.ycz.utils.FileUploadUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


@Controller
@RequestMapping(value = "admin/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping(value = "")
    public String index(Model model){
        UserVo userVo = userService.queryUserById(1);
        if(null != userVo.getPhoto() && StringUtils.isNotBlank(userVo.getPhoto())) {
            model.addAttribute("src", userVo.getPhoto());
        }
        return "admin/user";
    }

    @PostMapping(value = "")
    @ResponseBody
    public RestResponseBo profile(){
        UserVo userVo = userService.queryUserById(1);//todo 登录
        return RestResponseBo.ok(userVo);
    }

    @PostMapping(value = "/saveInfo")
    @ResponseBody
    public RestResponseBo saveUser(@Valid UserVo userVo){
        String result = userService.saveInfo(userVo);
        if(!WebConst.SUCCESS_RESULT.equals(result)){
            return RestResponseBo.fail(result);
        }
        return RestResponseBo.ok();
    }

    @PostMapping(value = "/savePhoto")
    @ResponseBody
    public RestResponseBo uploadPhoto(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request){
        String fname = multipartFile.getOriginalFilename();
        if (multipartFile.getSize() <= WebConst.MAX_FILE_SIZE) {
            String fkey = FileUploadUtil.getFileKey(fname);
            File file = new File(FileUploadUtil.getUploadFilePath() + fkey);
            try {
                FileCopyUtils.copy(multipartFile.getInputStream(), new FileOutputStream(file));
            } catch (IOException e) {
                String msg = "上传失败";
                return RestResponseBo.fail(msg);
            }
            userService.update(new UserVo(1, fkey));
        } else {
            String msg = "文件过大";
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }
}
