:calendar: Schedule
===
:large_blue_diamond: 개요
---
일정 관리 앱 서버 프로젝트를 작성하였습니다.

API 명세서와 ERD를 만들고 이를 바탕으로 Spring과 SQL을 통해 DB와 CRUD를 구현합니다.

**개발 환경**
Oracle JDK 17.0.14
IDE: IntelliJ
Framework: Spring

- - -
## :large_blue_diamond: 요구사항
Lv 0 요구사항
    프로젝트 최상위 경로에 README.md 생성하기
    API 명세서를 구성하고 README.md에 작성하기
    ERD를 설계하고 README.md에 첨부하기
    프로젝트 최상위 경로에 schedule.sql 파일 생성 후 테이블 생성에 필요한 query 작성하기

Lv 1 요구사항
    일정 생성 기능 구현
        할일, 작성자명, 비밀번호, 작성일, 수정일을 데이터로써 포함하고 있어야 한다.
        작성/수정일은 날짜와 시간을 포함하는 상태이다.
>- 각 일정의 고유 식별 (ID)를 자동으로 생성하여 관리한다.
>- 프로젝트 생성 시 수정일은 작성일과 동일하다.

- - -
## :large_blue_diamond: API 명세서 & ERD 작성
### [:memo: API 명세서 & ERD 노션 링크](https://colorful-pyjama-65b.notion.site/Calendar-API-ERD-1c0f7369191680129ec6e609669300b4?pvs=4)

- - -
## :large_blue_diamond: 구현된 기능

일정 생성
일정 목록 조회
선택 일정 조회
선택 일정 수정

- - -
## :large_blue_diamond: 미구현 기능

일정 생성
>* POST


일정 목록 조회
>
선택 일정 조회
>
선택 일정 수정
>
선택 일정 삭제



- - -
## :large_blue_diamond: 구현 예시


- - -
## :large_blue_diamond: TroubleShouting
### [:memo: TroubleShouting](링크)
