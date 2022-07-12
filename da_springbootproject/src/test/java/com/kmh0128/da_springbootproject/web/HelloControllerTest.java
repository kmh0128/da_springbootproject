package com.kmh0128.da_springbootproject.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@RunWith->테스트를 진행할 때 junit에 내장된 실행자 외 다른 실행자를 실행시킨다.
//스프링러너라는 스프링 실행자를 실행하는데 테스트와 junit사이에 연결자 역할을 한다.
@RunWith(SpringRunner.class)
//web(spring mvc)에 집중할 수 있는 어노테이션이다.
//선언시 controller, controllerAdvice등을 사용할 수 있겠지만
//@service, Component, respository 등은 사용할 수 없습니다.
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired//스프링을 관리하는 빈(bean)을 주입받습니다
    private MockMvc mvc;//웹 API를테스트할때 사용한다
                         //스프링 MVC의 테스트의 시작점
                        //이 클래스를 통해 HTTP GET,POST등에 대한 API를 테스트할수 있습니다.
    @Test
    public void hello_is_return() throws Exception {
        String hello = "hello";
        //mockmvc를 통해 /hello 주소로 http get을 요청한다.[mvc.perform(get("/hello"))]
        //체이닝이 지원되어 여러 검증 기능을 이어서 선언할 수 있다.
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                //mvc.perform의 결과를 검증한다.(.andExpect(status().isOk()))
                //http header의 status를 검증한다
                //200,404,500등의 상태를 검증하는데 isok는 200번, 즉 성공인지 아닌지 검증한다
                .andExpect(content().string(hello));
        //결과값과 응답본문의 내용을 검증해 준다. controller에서 hello를 리턴하기 때문에 이 값이 맞는지 검증하게 된다.
    }

    @Test
    public void helloDto_is_return() throws Exception{
        String name ="hello";
        int amount = 1000;

        mvc.perform(
                        get("/hello/dto")
                                //parme은 Api테스트 할 때 사용할 요청 파라미터를 설정하는 것 이다.
                                //string값만 설정할 수 있으며 int등의 값을 받고싶을땐 문자열로 변경해야 합니다.
                                .param("name",name)
                                .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                //sjonpath는 json응답값을 필드별로 검증할 수 있는 메소드 이다.
                //$를 기준으로 필드명을 명시한다. 여기서는 name, amount를 검증한다.
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}

//참고서적 -> 스프링부트와 AWS로 혼자 구현하는 웹서비스