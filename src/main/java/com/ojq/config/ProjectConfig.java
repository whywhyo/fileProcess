package com.ojq.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Version 1.0
 * @Author Jin_quan Ou
 * @Date 2023-03-28 13:01
 */

@Data
@Component
@ConfigurationProperties(prefix = "ojq")
public class ProjectConfig {

    private String name;
    private String version;
    private static String profile;


    public static String getProfile()
    {
        return profile;
    }
    public void setProfile(String profile)
    {
        ProjectConfig.profile = profile;
    }



    /**
     * 获取导入上传路径
     */
    public static String getImportPath()
    {
        return getProfile() + "/import";
    }

    /**
     * 获取头像上传路径
     */
    public static String getAvatarPath()
    {
        return getProfile() + "/avatar";
    }

    /**
     * 获取下载路径
     */
    public static String getDownloadPath()
    {
        return getProfile() + "/download/";
    }

    /**
     * 获取上传路径
     */
    public static String getUploadPath()
    {
        return getProfile() + "/upload";
    }

}
