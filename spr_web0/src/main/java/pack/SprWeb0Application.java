package pack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SprWeb0Application {
	
	// 웹서버를 실행시킨다.
	// 기본이 html이라서 브라우저 창에서 html 생략이 가능하다.
	// 이클립스와는 다르게 바로 브라우저가 실행되지 않는다.
	public static void main(String[] args) {
		SpringApplication.run(SprWeb0Application.class, args);
	}

}
