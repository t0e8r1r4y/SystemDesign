# SystemDesign
> 대규모 시스템 설계 기초 책을 읽고 스터디한 내용을 정리합니다.  
> 시간과 기회가 허락한다면 토이프로젝트로 관련 내용을 직접 개발도 해봅니다.

<br/>

## :eight_spoked_asterisk:  목표
- 백엔드 면접에서 최근 시스템 설계에 대한 문제들이 토스를 비롯한 일부 회사들에서 요구되고 있습니다.
- 또한 과제전형에서 '대규모 트래픽'을 고려한, 혹은 '적재된 데이터 규모가 크다고 가정한다. ' 등 요구사항이 있는바, 시스템 설계에 대한 어느정도의 이해는 필요하다고 생각합니다.
- 이 스터디를 한다고해서 면접이나 과제전형 대비가 100%되지는 않겠지만 적어도 접근 방법에 대해서 인사이트를 얻고자합니다.
- 함께하는 구성원들의 경험담과 현업에서 사용하는 방식 등 공유가능한 범위에서 함께 공유하고 인사이트를 얻으면 더욱더 멋진 스터디가 되지 않을까 합니다.

<br/>


## :book: 도서
- [가상 면접 사례로 배우는 대규모 시스템][도서링크]


## :clock130: 일정
- [스터디 모집][모집]
- 정리 및 리뷰 : 11/7 ~ 11/30
- OT : 11월 7일
- 스터디 시간 : 수요일 9시 부터 2~3시간 (11월 16일, 23일, 30일)
- 자료 공유 : 월요일 24시까지 -> 자료 링크는 카톡에 공유 요청 -> 깃헙 레포 정리 -> 이슈로 질의 응답 진행

<br/>

## :link: 챕터 구분
- 발표 자료는 wiki에 저장합니다.
- 코드는 각 챕터 디렉터리에 정리합니다. 개발이 메인이 되기 어렵기 때문에 필요시 개인이 적절히 올려주시기 바랍니다.
- 챕터 구분
   - 1, 2, 3장은 개별적으로 읽기
   - 4, 5, 6, 7 장 -> 1주차(11월 8일 ~ 11월 16일)
   - 8, 9, 10, 11장 -> 2주차(11월 17일 ~ 11월 23일)
   - 12, 13, 14, 15장 -> 3주차(11월 24일 ~ 11월 30일)

| Chapter | 발표자료 링크 | 비고 |
| ----- | ----- | ----- |
| 1장 | [신중현][1장]  | [DB이중화](https://terrys-tech-log.tistory.com/11) |
| 2장 | [신중현][2장] | 스터디 일정을 고려하여 각자 읽는 파트입니다. |
| 3장 |[신중현][3장] | 스터디 일정을 고려하여 각자 읽는 파트입니다. |
| 4장 | [신중현][4장] | [관련 프로젝트][처리율 제한반영 프로젝트] |
| 5장 | [지승훈][5장] | 관련 예제코드 example dir 참고 |
| 6장 | [지승훈][6장]| 관련 예제코드 example dir 참고 |
| 7장 | [박다정][7장]| [박다정님 개인 블로그][7장 블로그 링크] |
| 8장 | [김승찬][8장]| hash 설계 관련 함께  |
| 9장 | [신중현][9장]| 차주 발표 |
| 10장 | [박다정][10장]| 다정님이 공유해주신 SQS 사용한 예시 공유하면 같이 참고 |
| 11장 | [지승훈][11장]| 관련 예제코드에서 Spring kafka 참고  |
| 12장 | [신중현][12장]| |
| 13장 | [신중현][13장]| |
| 14장 | [지승훈][14장]| 관련 예제코드에서 Spring Redis 참고 |
| 15장 | [김승찬][15장]| |




<br/>

## :beginner: 진행 방법
- '가상 면접 사례로 배우는 대규모 시스템 설계 기초'라는 책을 읽고 리뷰를 진행합니다.
- 챕터별로 책을 읽고 내용을 정리하고 발표합니다. 정리 내용은 각자 블로그 작성해주시거나, 해당 레포에 올려주세요.
- 올려주신 내용에 대해 목차만 정리하여 wiki에서 전체 관리 예정입니다. 각 위키 페이지에는 작성자님 블로그 링크를 함께 연동할거에요.
- 온라인에서 구글 미트 혹은 줌 미팅으로 진행 예정입니다.
- 발표자는 매주 스터디 시작 최소 2일전까지 발표자료를 올립니다.
- 그 외 인원은 스터디 시작전 각 장마다 질문 혹은 중요하다고 생각되는 부분을 Issue로 남겨주세요.
- 발표가 모두 끝나면 10분 내외(혹은 그 여유가 된다면 그 이상) 회고를 진행합니다. 회고에 대한 내용은 아래를 참고해주세요.


<br/>

## 🧑‍🤝‍🧑 회고
- 1주일 동안 책을 읽으면서 느낀점, 발표를 보고 느낀점 등을 자유롭게 이야기 해주시면 됩니다.
- 자유롭게 각자 하고 싶은 말을 하면 되니 부담 가지실 필요는 없습니다.


<br/>

## 패널티
- 패널티는 없습니다.
- 어느정도 책임감을 가지고 임해주실 것을 믿고, 혹시나 빠지게 되는 상황이 생기면 사전에 구성원에게 양해를 구해주세요.


<br/>


## 기타
- 커뮤니케이션을 위해 카톡 사용하겠습니다.


<br/>


[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)
   [모집]: <https://okky.kr/articles/1344881>
   [1장]: <https://github.com/t0e8r1r4y/SystemDesign/wiki/1%EC%9E%A5-%EC%82%AC%EC%9A%A9%EC%9E%90-%EC%88%98%EC%97%90-%EB%94%B0%EB%A5%B8-%EA%B7%9C%EB%AA%A8-%ED%99%95%EC%9E%A5%EC%84%B1>
   [2장]: <https://github.com/t0e8r1r4y/SystemDesign/wiki/2%EC%9E%A5-%EA%B0%9C%EB%9E%B5%EC%A0%81%EC%9D%B8-%EA%B7%9C%EB%AA%A8-%EC%B6%94%EC%A0%95>
   [3장]: <https://github.com/t0e8r1r4y/SystemDesign/wiki/3%EC%9E%A5-%EC%8B%9C%EC%8A%A4%ED%85%9C-%EC%84%A4%EA%B3%84-%EB%A9%B4%EC%A0%91-%EA%B3%B5%EB%9E%B5%EB%B2%95>
   [4장]: <https://github.com/t0e8r1r4y/SystemDesign/wiki/4%EC%9E%A5-%EC%B2%98%EB%A6%AC%EC%9C%A8-%EC%A0%9C%ED%95%9C-%EC%9E%A5%EC%B9%98%EC%9D%98-%EC%84%A4%EA%B3%84>
   [5장]: <https://github.com/t0e8r1r4y/SystemDesign/wiki/5%EC%9E%A5-%EC%95%88%EC%A0%95-%ED%95%B4%EC%8B%9C-%EC%84%A4%EA%B3%84>
   [6장]: <https://github.com/t0e8r1r4y/SystemDesign/wiki/6%EC%9E%A5-%ED%82%A4-%EA%B0%92-%EC%A0%80%EC%9E%A5%EC%86%8C-%EC%84%A4%EA%B3%84>
   [7장]: <https://github.com/t0e8r1r4y/SystemDesign/wiki/7%EC%9E%A5-%EB%B6%84%EC%82%B0-%EC%8B%9C%EC%8A%A4%ED%85%9C%EC%9D%84-%EC%9C%84%ED%95%9C-%EC%9C%A0%EC%9D%BC-ID-%EC%83%9D%EC%84%B1%EA%B8%B0-%EC%84%A4%EA%B3%84>
   [8장]: <https://github.com/t0e8r1r4y/SystemDesign/wiki/8%EC%9E%A5-URL-%EB%8B%A8%EC%B6%95%ED%82%A4-%EC%84%A4%EA%B3%84>
   [9장]: <https://github.com/t0e8r1r4y/SystemDesign/wiki/9%EC%9E%A5-%EC%9B%B9-%ED%81%AC%EB%A1%A4%EB%9F%AC-%EC%84%A4%EA%B3%84>
   [10장]: <https://github.com/t0e8r1r4y/SystemDesign/wiki/10%EC%9E%A5-%EC%95%8C%EB%A6%BC-%EC%8B%9C%EC%8A%A4%ED%85%9C-%EC%84%A4%EA%B3%84>
   [11장]: <https://github.com/t0e8r1r4y/SystemDesign/wiki/11%EC%9E%A5-%EB%89%B4%EC%8A%A4-%ED%94%BC%EB%93%9C-%EC%8B%9C%EC%8A%A4%ED%85%9C-%EC%84%A4%EA%B3%84>
   [12장]: <https://github.com/t0e8r1r4y/SystemDesign/wiki/12%EC%9E%A5-%EC%B1%84%ED%8C%85-%EC%8B%9C%EC%8A%A4%ED%85%9C-%EC%84%A4%EA%B3%84>
   [13장]: <https://github.com/t0e8r1r4y/SystemDesign/wiki/13%EC%9E%A5-%EA%B2%80%EC%83%89%EC%96%B4-%EC%9E%90%EB%8F%99%EC%99%84%EC%84%B1-%EC%8B%9C%EC%8A%A4%ED%85%9C>
   [14장]: <https://github.com/t0e8r1r4y/SystemDesign/wiki/14%EC%9E%A5-%EC%9C%A0%ED%8A%9C%EB%B8%8C-%EC%84%A4%EA%B3%84>
   [15장]: <https://github.com/t0e8r1r4y/SystemDesign/wiki/15%EC%9E%A5-%EA%B5%AC%EA%B8%80-%EB%93%9C%EB%9D%BC%EC%9D%B4%EB%B8%8C-%EC%84%A4%EA%B3%84>
   [도서링크]: <http://www.yes24.com/Product/Goods/102819435>
   [7장 블로그 링크]: <https://dimsss.notion.site/ID-87a308438a0341e2b755d1735837c22c>
   [처리율 제한반영 프로젝트]: <https://github.com/t0e8r1r4y/PointReserve>
