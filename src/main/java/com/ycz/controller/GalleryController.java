package com.ycz.controller;

import com.github.pagehelper.PageInfo;
import com.ycz.constant.WebConst;
import com.ycz.model.bo.RestResponseBo;
import com.ycz.model.vo.GalleryVo;
import com.ycz.model.vo.UserVo;
import com.ycz.service.IGalleryService;
import com.ycz.utils.CommonsUtil;
import com.ycz.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 */
@Controller
@RequestMapping( value = "/admin/gallery" )
public class GalleryController {

    @Autowired
    private IGalleryService galleryService;

    @GetMapping( value = "/index" )
    public String index(@RequestParam( value = "page", defaultValue = "1" ) int page,
                        @RequestParam( value = "limit", defaultValue = "12" ) int limit,
                        HttpServletRequest request) {
        PageInfo<GalleryVo> galleryVoPageInfo = galleryService.selectWithPage(page, limit);
        request.setAttribute("gallery", galleryVoPageInfo);
        return "admin/gallery";
    }

    @PostMapping( value = "/upload" )
    @ResponseBody
    public RestResponseBo uploadFile(@RequestParam( "file" ) MultipartFile[] multipartFiles, HttpServletRequest request) {
        List<String> errors = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            String fname = multipartFile.getOriginalFilename();
            String suffix = fname.substring(fname.lastIndexOf(".") + 1);
            //图片是否过大或者不为图片
            if (multipartFile.getSize() <= WebConst.MAX_FILE_SIZE
                    || (!"jpg".equals(suffix) && !"png".equals(suffix))) {
                String fkey = FileUploadUtil.getFileKey(fname);
                File file = new File(FileUploadUtil.getUploadFilePath() + fkey);
                try {
                    FileCopyUtils.copy(multipartFile.getInputStream(), new FileOutputStream(file));
                } catch (IOException e) {
                    String msg = "上传失败";
                    return RestResponseBo.fail(msg);
                }
                UserVo userVo = CommonsUtil.getLoginUser(request);
                galleryService.insert(fname, fkey, userVo.getId());
            } else {
                errors.add(fname);
            }
        }
        return RestResponseBo.ok(errors);
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    public RestResponseBo delGallery(Integer id){
        Integer result = galleryService.delete(id);
        if(null == result){
            return RestResponseBo.fail();
        }
        return RestResponseBo.ok();
    }
}
