package com.example.feign.feign.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL) //해당하는 값이 없을 경우 Json 변환 시 해당 필드 제외 "???" : null로 나오지 않음
public class BaseResponseInfo {
    private String header;
    private String name;
    private Long age;
}
