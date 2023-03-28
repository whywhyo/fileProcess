package com.ojq.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @Version 1.0
 * @Author Jin_quan Ou
 * @Date 2023-03-28 14:13
 */
public interface FileProcessService {
    HashMap<String, Object> uploadFile(String pathUrl,MultipartFile file);

    void downLoadFile(String path, HttpServletResponse response);
}
