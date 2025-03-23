|   기능    | Method | URL                     | request                                                                                                                                                                                     | response                                                                                                                           |  상태코드  |
|:-------:|:------:|:------------------------|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:-----------------------------------------------------------------------------------------------------------------------------------|:------:|
|  일정 생성  |  POST  | /schedules              | 요청 body<br>{<br>"User": {<br>"Name":"작성자"<br>},<br>"Schedule": {<br>"Title":"일정명",<br>"Contents":"일정 내용",<br>"Start_Date":"일정 시작일",<br>"Last_Date":"일정 종료일"<br>}<br>}                      | 등록 정보 <br>{<br>"Schedule": {<br>"scheduleID":"일정 번호"<br>}<br>}                                                                     | 200:정상 |
|  일정 조회  |  GET   | /schedules/{scheduleID} | 요청 param                                                                                                                                                                                    | 단건 응답 정보<br>{<br>"Schedule": {<br>"Title":"일정명",<br>"Contents":"일정 내용"<br>"Start_Date":"일정 시작일",<br>"Last_Date":"일정 종료일"<br>}<br>} | 200:정상 |
| 일정 업데이트 |  PUT   | /schedules/{scheduleID} | 요청 body<br>{<br>"User": {<br>"Name":"작성자",<br>"Password":"비밀번호"<br>},<br>"Schedule": {<br>"Title":"일정명",<br>"Contents":"일정 내용",<br>"Start_Date":"일정 시작일",<br>"Last_Date":"일정 종료일"<br>}<br>} | 수정 정보<br>{<br>"Schedule": {<br>"Title":"일정명",<br>"Contents":"일정 내용",<br>"Start_Date":"일정 시작일",<br>"Last_Date":"일정 종료일"<br>}<br>}   | 200:정상 |
|  일정 삭제  | DELETE | /schedules/{scheduleID} | 요청 param                                                                                                                                                                                    | -                                                                                                                                  | 200:정상 |

![](https://velog.velcdn.com/images/deabaind/post/71d8eaa4-47dd-40ad-8ef7-9890caf6db8c/image.png)
