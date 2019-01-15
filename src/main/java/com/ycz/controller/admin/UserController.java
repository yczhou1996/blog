package com.ycz.controller.admin;

import com.ycz.constant.WebConst;
import com.ycz.model.bo.RestResponseBo;
import com.ycz.model.vo.UserVo;
import com.ycz.service.IUserService;
import com.ycz.utils.CommonsUtil;
import com.ycz.utils.FileUploadUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author admin
 */
@Controller
@RequestMapping(value = "admin/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping(value = "")
    public String index(HttpServletRequest request){
        UserVo userVo = CommonsUtil.getLoginUser(request);
        userVo = userService.queryById(userVo.getId());
        if(null != userVo.getPhoto() && StringUtils.isNotBlank(userVo.getPhoto())) {
            request.setAttribute("src", userVo.getPhoto());
        }
        return "admin/user";
    }

    @PostMapping(value = "")
    @ResponseBody
    public RestResponseBo profile(HttpServletRequest request){
        UserVo userVo = CommonsUtil.getLoginUser(request);
        userVo = userService.queryById(userVo.getId());
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
            UserVo userVo = CommonsUtil.getLoginUser(request);
            userService.update(new UserVo(userVo.getId(), fkey));
        } else {
            String msg = "文件过大";
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }
}
