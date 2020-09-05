package com.sun.Controller;

import com.sun.utils.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/ueditor")
public class UeditorController {

    @RequestMapping("/saveFile")
    @ResponseBody
//    如果ueditor上传的是一个图片，然后处理图片
    public Map<String,Object> saveFile(@RequestParam(value="upfile",required = false)MultipartFile file, HttpServletRequest  request) throws IOException {
            Map<String,Object> params = new HashMap<>();
            String n = UUIDUtils.create();
            String path = request.getServletContext().getRealPath("/ueditor/" + n + file.getOriginalFilename());
            File newFile = new File(path);
            file.transferTo(newFile);
//            相对路径
            String visitUrl = "/ueditor/" + n + file.getOriginalFilename();
            params.put("state","SUCCESS");
            params.put("url",visitUrl);
            params.put("size",file.getSize());
            params.put("original",file.getOriginalFilename());
            params.put("type",file.getContentType());
            return params;
    }
}
