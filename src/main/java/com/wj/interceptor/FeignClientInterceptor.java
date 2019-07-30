package com.wj.interceptor;

import com.alibaba.fastjson.JSONObject;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * @author jun.wang
 * @title: FeignClientInterceptor
 * @projectName ownerpro
 * @description: TODO
 * @date 2019/7/12 14:09
 */

@Component
public class FeignClientInterceptor implements RequestInterceptor {


    private static final String base64Regex = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$";

    private static final List<String> appNameList = Arrays.asList("base-identity");

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Map<Object, Object> map = (Map<Object, Object>)servletRequestAttributes.getRequest().getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        if (map != null && map.size() != 0) {
            Object s = map.get("name");
            if (s != null) {
                String str = s.toString();
            }
        }
        try {
            byte[] bytes = requestTemplate.body();
            if (bytes != null) {
                String str = new String(bytes, "UTF-8");
                System.out.println(str);
                /*JSONObject json = JSONObject.parseObject(str);
                json.put("checkAlarm", true);
                requestTemplate.body(json.toJSONString());*/
            }
            Enumeration<String> enumeration = servletRequestAttributes.getRequest().getParameterNames();
            while (enumeration.hasMoreElements()) {
                String name = enumeration.nextElement();
                //servletRequestAttributes.getRequest().setAttribute(name, "111");
                requestTemplate.query(name, "1111");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
