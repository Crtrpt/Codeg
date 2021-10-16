package com.dj.codeg.system.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig  extends WebMvcConfigurationSupport {

    @Value("${file.upload.path:''}")
    private String uploadPath;

    //长传资源访问地址
    @Value("${file.upload.url:''}")
    private String uploadURL;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/statics/");
        registry.addResourceHandler(uploadURL+"**").addResourceLocations("file:"+uploadPath);
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        //registry.addResourceHandler("csrf").addResourceLocations("classpath:/META-INF/resources/");
        //registry.addResourceHandler("/").addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

}
