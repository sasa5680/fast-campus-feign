package com.example.feign.service;

import com.example.feign.feign.client.DemoFeignClient;
import com.example.feign.feign.common.dto.BaseRequestInfo;
import com.example.feign.feign.common.dto.BaseResponseInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {

    private final DemoFeignClient demoFeignClient;

    public String get() {
        ResponseEntity<BaseResponseInfo> response =
                demoFeignClient.callGet("CustomHeaeder", "CustomName", 1L);

        System.out.println(response.getBody());
        return "get";
    }

    public String post() {

        BaseRequestInfo baseRequestInfo = BaseRequestInfo.builder()
                .name("customName")
                .age(2L)
                .build();

        ResponseEntity<BaseResponseInfo> response =
                demoFeignClient.callPost("CustomHeader", baseRequestInfo);

        System.out.println(response.getBody());
        return "get";
    }
}
