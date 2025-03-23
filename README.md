|   기능    | Method | URL                     | request                | response               |  상태코드  |
|:-------:|:------:|:------------------------|:-----------------------|:-----------------------|:------:|
|  일정 생성  |  POST  | /schedules              | 요청 body                | 등록 정보                  | 200:정상 |
|         |        |                         | {                      | {                      |        |
|         |        |                         | "Name":"작성자",          | "scheduleID":"일정 번호"   |        |
|         |        |                         | "Title":"일정명",         | }                      |        |
|         |        |                         | "Contents":"일정 내용",    |                        |        |
|         |        |                         | "Start_Date":"일정 시작일", |                        |        |
|         |        |                         | "Last_Date":"일정 종료일"   |                        |        |
|         |        |                         | }                      |                        |        |
|  일정 조회  |  GET   | /schedules/{scheduleID} | 요청 param               | 단건 응답 정보               | 200:정상 |
|         |        |                         |                        | {                      |        |
|         |        |                         |                        | "Title":"일정명",         |        |
|         |        |                         |                        | "Contents":"일정 내용"     |        |
|         |        |                         |                        | "Start_Date":"일정 시작일", |        |
|         |        |                         |                        | "Last_Date":"일정 종료일"   |        |
|         |        |                         |                        | }                      |        |
| 일정 업데이트 |  PUT   | /schedules/{scheduleID} | 요청 body                | 수정 정보                  | 200:정상 |
|         |        |                         | {                      | {                      |        |
|         |        |                         | "Name":"작성자",          | "Title":"일정명",         |        |
|         |        |                         | "Password":"비밀번호"      | "Contents":"일정 내용",    |        |
|         |        |                         | "Title":"일정명",         | "Start_Date":"일정 시작일", |        |
|         |        |                         | "Contents":"일정 내용",    | "Last_Date":"일정 종료일"   |        |
|         |        |                         | "Start_Date":"일정 시작일", | }                      |        |
|         |        |                         | "Last_Date":"일정 종료일"   |                        |        |
|         |        |                         | }                      |                        |        |
|  일정 삭제  | DELETE | /schedules/{scheduleID} | 요청 param               | -                      | 200:정상 |

![](https://velog.velcdn.com/images/deabaind/post/71d8eaa4-47dd-40ad-8ef7-9890caf6db8c/image.png)
