package com.wj.exception;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class FeignException implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        try {
            String errMsg = Util.toString(response.body().asReader());
            return new RuntimeException(errMsg);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
