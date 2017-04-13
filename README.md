# TTS
Test Tracking System

테스트 login 계정

id: test1
passwd: test1


### Intellj Spring Devtools 작동 방법
   * Java 파일 수정
   * Build > Recompile 또는 Rebuild Project
   
### Intellj 에서 embed tomcat 사용시 설정  
#### 아래와 같이 jasper 와 tomcat 의 <scope> 를 주석처리 하고 사용
```xml
        <dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
			<!--<scope>provided</scope>-->
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<!--<scope>provided</scope>-->
		</dependency>
```