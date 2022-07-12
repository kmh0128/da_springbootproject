package com.kmh0128.da_springbootproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@@SpringBootApplication 스프링부트의 자동 설정, 스프링 bean읽기와 생성 자동 설정.
//  시작한 위치부터 설정을 읽어들어가기 때문에 프로젝트 최상단에 있어야 한다
@SpringBootApplication
public class DaSpringbootprojectApplication {
	//메인 메소드에서 실행하는 SpringApplication.run 으로 인해
	//내장 WAS(Wep Application Server)가 실행된다.
	//서버에 톰켓을 설치할 필요가 없게 됩니다 그리고 스프링부트로 만들어진 jar파일을 실행하면된다.
	public static void main(String[] args) {
		SpringApplication.run(DaSpringbootprojectApplication.class, args);
	}

}

//참조 서적 -> 스프링부트와 AWS로 혼자 구현하는 웹서비스
