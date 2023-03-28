package com.ojq.controller;

import com.ojq.common.AjaxResult;
import com.ojq.config.ProjectConfig;
import com.ojq.config.ServerConfig;
import com.ojq.service.FileProcessService;
import com.ojq.utils.FileUploadUtils;
import com.ojq.utils.FileUtils;
import com.ojq.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.util.HashMap;

/**
 * @Version 1.0
 * @Author Jin_quan Ou
 * @Date 2023-03-28 12:44
 */
@Slf4j
@RestController
@RequestMapping("/common")
public class FileProcessController {

    @Resource
    private ServerConfig serverConfig;

    @Resource
    private FileProcessService fileProcessService;


    /**
     * 上传请求接口
     */
    @PostMapping("/upload")
    public AjaxResult uploadFile(@RequestParam("uploadFile") MultipartFile file) throws Exception
    {
        String pathUrl = serverConfig.getUrl();
        HashMap<String, Object> data=fileProcessService.uploadFile(pathUrl,file);
        return AjaxResult.success(data);
    }


    /**
     * 下载请求接口
     *
     * @param fileName 文件名称
     */
    @GetMapping("/download")
    public void fileDownload(@PathParam("fileName") String fileName, HttpServletResponse response)
    {
        fileProcessService.downLoadFile(fileName,response);

    }


}
