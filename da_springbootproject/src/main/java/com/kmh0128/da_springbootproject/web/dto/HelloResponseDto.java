package com.kmh0128.da_springbootproject.web.dto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter//선언된 모든필드의 get 메소드를 생성해준다
@RequiredArgsConstructor
//선언된 모든 final필드가 포함된 생성자를 생성해준다
//final이 없는 필드는 생성자에 포함되지 않습니다.
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
//참고서적 -> 스프링부트와 AWS로 혼자 구현하는 웹서비스