package com.example.feign.controller;

import com.example.feign.feign.common.dto.BaseRequestInfo;
import com.example.feign.feign.common.dto.BaseResponseInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/target_server")
@RequiredArgsConstructor
public class TargetController {

    @GetMapping("/get")
    public BaseResponseInfo demoGet(@RequestHeader("CustomHeaderName") String customHeader,
                                    @RequestParam("name") String name,
                                    @RequestParam("age") Long age){

        return BaseResponseInfo.builder()
                .header(customHeader)
                .name(name)
                .age(age)
                .build();
    }

    @PostMapping("/post")
    public BaseRequestInfo demoPost(@RequestHeader("CustomHeaderName") String customHeader,
                                    @RequestBody BaseRequestInfo body) {
        return BaseRequestInfo.builder()
                .header("header")
                .age(body.getAge())
                .name(body.getName())
                .build();
    }
}
