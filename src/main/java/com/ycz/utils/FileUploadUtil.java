package com.ycz.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;

@Component
public class FileUploadUtil {

    public static String getFileKey(String name) {
        String prefix = "/upload/" + DateUtil.dateFormat(new Date(), "yyyy/MM");
        if (!new File(FileUploadUtil.getUploadFilePath() + prefix).exists()) {
            new File(FileUploadUtil.getUploadFilePath() + prefix).mkdirs();
        }

        name = StringUtils.trimToNull(name);
        if (name == null) {
            return prefix + "/" + DateUtil.dateFormat(new Date(), "yyyyMMddHHmmss") + "." + null;
        } else {
            name = name.replace('\\', '/');
            name = name.substring(name.lastIndexOf("/") + 1);
            int index = name.lastIndexOf(".");
            String ext = null;
            if (index >= 0) {
                ext = StringUtils.trimToNull(name.substring(index + 1));
            }
            return prefix + "/" + DateUtil.dateFormat(new Date(), "yyyyMMddHHmmss") + "." + (ext == null ? null : (ext));
        }
    }

    public static String getUploadFilePath() {
        String path = FileUploadUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        path = path.substring(1, path.length());
        try {
            path = java.net.URLDecoder.decode(path, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int lastIndex = path.lastIndexOf("/") + 1;
        path = path.substring(0, lastIndex);
        File file = new File("");
        return file.getAbsolutePath() + "/";
    }
}
