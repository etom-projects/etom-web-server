# etom-web-server
ETOM팀의 컬리 딜리버리 웹서버 프로젝트
# etom-batch
kurly 물류 데이터를 자동으로 생성하여 저장해주기 위한 배치 프로그램
---
## feature
- 유저 회원가입, 로그인
- 유저 개인신상정보 수집  
- 배송지역 선택
- 배송 물류 할당
- 배송 시작 및 배송 위치 안내
- 차량 등록 및 조회
- 적재 리스트 조회
- 배송 상품별 위치 안내
- 배송 위치를 클러스터링 처리한 후 최적화된 배송순서안내

## folder structure
- domain: 모델 및 레파지토리, 핵심 비지니스 로직과 쿼리가 있는 디렉토리
- controller: 이벤트 요청시 해당 요청을 처리하는 레이어
- service: 핵심 비지니스로직이 담겨있는 레이어
- model: table과 거의 1:1매핑이 된 Entity
- enumerablee: enumType 디렉토리
- repositort: 데이터베이스에 실제 접근하여 동작하는 래이어
## applicaation.yml
```yml
spring:
  datasource:
    url: 
    username: 
    password: 
    driver-class: 
  jpa:
    hibernate:
      naming:
        implicit-strategy: org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
    properties:
      hibernate:
        jdbc:
          batch_size: 500
        ddl-auto: none
        format_sql: flase
        show-sql: false

kurly:
  app:
    jwtSecret: 
    jwtExpirationMs: 
```

## 개선사항
- 테스트 코드 작성을 통해 해당 로직이 변경되어도 사용할 수 있도록 테스트 코드 작성
- 자동화된 배포나 자동화된 API 문서처리 작업을 하여 생산성을 높여야 합니다.
- 공통 모듈은 Jar파일로 분리시켜 모듈화하여 사용할 수 있도록 변경
