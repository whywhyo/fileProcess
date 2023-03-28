package com.ojq.service.impl;

import com.ojq.common.AjaxResult;
import com.ojq.config.ProjectConfig;
import com.ojq.service.FileProcessService;
import com.ojq.utils.FileUploadUtils;
import com.ojq.utils.FileUtils;
import com.ojq.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;

/**
 * @Version 1.0
 * @Author Jin_quan Ou
 * @Date 2023-03-28 14:13
 */
@Slf4j
@Service
public class FileProcessServiceImpl implements FileProcessService {
    @Override
    public HashMap<String, Object> uploadFile(String pathUrl,MultipartFile file) {
        try
        {
            // 上传文件路径
            String filePath = ProjectConfig.getProfile();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = pathUrl + fileName;

            HashMap<String, Object> data = new HashMap<>();
            data.put("url", url);
            data.put("fileName", fileName);
            data.put("newFileName", FileUtils.getName(fileName));
            data.put("originalFilename", file.getOriginalFilename());
            return data;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }

    @Override
    public void downLoadFile(String fileName, HttpServletResponse response) {
        try
        {
            if (!FileUtils.checkAllowDownload(fileName))
            {
                throw new Exception(StringUtils.format("文件名称({})非法，不允许下载。 ", fileName));
            }
            fileName=fileName.substring(8);
            String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
            String filePath = ProjectConfig.getProfile() + fileName;
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, realFileName);
            FileUtils.writeBytes(filePath, response.getOutputStream());

        }
        catch (Exception e)
        {
            log.error("下载文件失败", e);
        }

    }
}
