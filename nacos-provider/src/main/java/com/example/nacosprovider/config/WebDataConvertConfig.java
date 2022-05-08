package com.example.nacosprovider.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebDataConvertConfig extends WebMvcConfigurationSupport {


    /**
     * 拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        //registry.addInterceptor(new TestInterceptor()).addPathPatterns("/**");
    }

    /*
    ViewController配置，处理器映射器。将请求映射到某个页面，不通过@RequestMapping配置
    最经常用到的就是"/"、"/index"路径，只有在请求目标页面时不需要做什么数据处理才可这样使用
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/").setViewName("/index");
    }*/

    /*
    ViewReslover配置，controller执行的结果modelAndView交给ViewReslover进行解析
    swagger-ui.html相关的所有前端静态文件都在springfox-swagger-ui-2.6.1.jar
    spring Boot自动配置本身不会自动把/swagger-ui.html这个路径
    映射到对应的目录META-INF/resources/下面。加上这个映射即可*/
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/**").addResourceLocations(
                "classpath:/static/");
        registry.addResourceHandler("doc.html").addResourceLocations(
                "classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/");
    }

    /**
     * 跨域CORS配置
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        super.addCorsMappings(registry);
        registry.addMapping("/cors/**")
                .allowedHeaders("*")
                .allowedMethods("POST","GET")
                .allowedOrigins("*");
    }


}