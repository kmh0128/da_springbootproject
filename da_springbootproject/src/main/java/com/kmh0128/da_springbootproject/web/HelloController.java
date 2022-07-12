package com.kmh0128.da_springbootproject.web;

import com.kmh0128.da_springbootproject.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController는컨 트롤러를 JSON을 반환하는 컨트롤러로 만들어준다.
//각 매소드마다 @responsbody를 선언했지만 한 번에 할 수 있도록 통합시킨것이다.
@RestController
public class HelloController {

    //@GetMapping은 http method인 get의 요청을 받을 수 있는 api를 만들어준다.
    // "/hello"로 요청이 오면 문자열 hello를 반환한다.
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        //@RequestParam은 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션입니다.
        //여기서는 외부에서 (@RequestParam("name"))이란 이름으로 넘긴 파라미터를 메소드 파라미터 (name(String naem)에 저장하게 된다
        return new HelloResponseDto(name, amount);
    }
    //참고서적 -> 스프링부트와 AWS로 혼자 구현하는 웹서비스
}


