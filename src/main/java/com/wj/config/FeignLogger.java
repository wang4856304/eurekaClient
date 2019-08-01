package com.wj.config;

import feign.Request;
import feign.Response;
import feign.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

/**
 * @author jun.wang
 * @title: FeignLogger
 * @projectName ownerpro
 * @description: TODO
 * @date 2019/7/30 16:11
 */
public class FeignLogger extends feign.Logger {

    private final Logger logger;

    public FeignLogger() {
        this(feign.Logger.class);
    }

    public FeignLogger(Class<?> clazz) {
        this(LoggerFactory.getLogger(clazz));
    }

    public FeignLogger(String name) {
        this(LoggerFactory.getLogger(name));
    }

    FeignLogger(Logger logger) {
        this.logger = logger;
    }


    @Override
    protected void logRequest(String configKey, Level logLevel, Request request) {
        if (logger.isInfoEnabled()) {
            this.log(configKey, "---> %s %s HTTP/1.1", request.method(), request.url());
            if (logLevel.ordinal() >= feign.Logger.Level.HEADERS.ordinal()) {
                String bodyText;
                if (request.body() != null) {
                    if (logLevel.ordinal() >= feign.Logger.Level.FULL.ordinal()) {
                        bodyText = request.charset() != null ? new String(request.body(), request.charset()) : null;
                        this.log(configKey, "request=%s", bodyText != null ? bodyText : "Binary data");
                    }
                }
            }
        }
    }

    @Override
    protected Response logAndRebufferResponse(String configKey, Level logLevel, Response response, long elapsedTime)
            throws IOException {
        if (logger.isInfoEnabled()) {
            String reason = response.reason() != null && logLevel.compareTo(feign.Logger.Level.NONE) > 0 ? " " + response.reason() : "";
            int status = response.status();
            this.log(configKey, "<--- HTTP/1.1 %s%s (%sms)", status, reason, elapsedTime);
            if (logLevel.ordinal() >= feign.Logger.Level.HEADERS.ordinal()) {

                int bodyLength;
                if (response.body() != null && status != 204 && status != 205) {
                    byte[] bodyData = Util.toByteArray(response.body().asInputStream());
                    bodyLength = bodyData.length;
                    if (logLevel.ordinal() >= feign.Logger.Level.FULL.ordinal() && bodyLength > 0) {
                        this.log(configKey, "response=%s", Util.decodeOrDefault(bodyData, Util.UTF_8, "Binary data"));
                    }
                    return response.toBuilder().body(bodyData).build();
                }
            }

            return response;
        }
        return response;
    }

    @Override
    protected void log(String configKey, String format, Object... objects) {
        if (logger.isInfoEnabled()) {
            logger.info(String.format(methodTag(configKey) + format, objects));
        }
    }
}
