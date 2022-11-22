package com.example.feign.feign.intercepter;


import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor(staticName = "of")
public class DemoFeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {

        if(template.method() == Request.HttpMethod.GET.name()) {
            //해당 요청에서 사용하는 쿼리들을 출력
            System.out.println("[GET] [DemoFeignInterceptor] queries " + template.queries());
            return;
        }

        //post 요청일 경우
        String encodedRequestBody = StringUtils.toEncodedString(template.body(), StandardCharsets.UTF_8);
        System.out.println("[POST] [DemoFeignInterceptor] requestBody " + encodedRequestBody);

        // 로직 추가

        String covertRequestBody = encodedRequestBody;
        template.body(covertRequestBody);

    }
}
