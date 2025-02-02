# Komofunding
'Komofunding은 크라우드 펀딩 플랫폼으로 사용자의 프로젝트를 홍보하고 다른 사용자로부터 후원을 받을 수 있도록 지원하는 웹 서비스입니다. 
* 기간 : 2024.11.04 ~ 2024.12.18

* 인원 : 8명

* 기술스택
  - Frontend : JavaScript, React.js, HTML, CSS
  - Backend : Java, Spring Boot, JPA, MariaDB
  - Database : MariaDB
  - Design : Figma
  - Diagram : draw.io, PlantUML

* 기여부분
  -  유스케이스 다이어그램, 개념 ERD, 클래스다이어그램, API명세서 작성
  -  Project, QnA(1:1문의, 문의댓글) 백엔드 로직 구현 및 데이터베이스 설계
  -  Payment 관련 외부 결제 API 연동, 백엔드 로직 구현 및 데이터베이스 설계

* Github 주소 : https://github.com/coding-ji/komofunding.git
<br>

## 소개

>### 메인
#### 메인 화면
- ###### 메인 화면은 프로젝트의 달성률과 대표 이미지를 중심으로 간결하게 구성하였습니다. Framer motion을 활용하여 다양한 애니메이션을 적용하여 동적인 사용자 경험을 제공합니다.
![main](https://github.com/user-attachments/assets/4d91e8cd-14d5-425d-a95b-7d1c6750df53)
---
#### 홈 화면 
- ###### 홈 화면은 전체 프로젝트를 카테고리 별로 확인할 수 있도록 구성하였습니다. 후원하는 품목에 집중할 수 있도록 이미지를 중심으로 한 레이아웃을 구성하였습니다.
~~~
Home: 운영자의 승인을 받은 모든 프로젝트 | Upcoming : 아직 후원이 시작되지 않은 프로젝트 | Active : 현재 후원이 진행 중인 프로젝트
~~~
![home](https://github.com/user-attachments/assets/ff4a7e5d-d1a5-4324-a5a8-05e4a4f0ebb8)
<br>

>### 유저
<br>

>### 프로젝트
#### 프로젝트 관리
- ###### 프로젝트는 제작자 전환 후 생성할 수 있으며, 사용자는 마이페이지에서 본인의 프로젝트를 직접 생성, 수정, 삭제할 수 있습니다.
![mypage-projects](https://github.com/user-attachments/assets/d7b593e7-163d-4eab-97ec-139711e920b6)
---
#### 프로젝트 생성
- ###### 프로젝트 생성 시 프로젝트 제목, 짧은 소개 글, 카테고리, 프로젝트 상품 등 작성을 하게되며 운영자의 승인을 받은 후, 메인 페이지에서 프로젝트가 노출됩니다.
![new-project](https://github.com/user-attachments/assets/9c668ba9-638f-4e3b-8ab8-672d989e891f)
---
#### 프로젝트 확인
- ###### 마이페이지에서 본인이 생성한 프로젝트의 제목을 클릭하면 프로젝트 상세 페이지를 확인할 수 있습니다.
![view-projects](https://github.com/user-attachments/assets/32ff80ee-97cf-4f20-abfe-c344c6d5fe3f)
---
#### 프로젝트 수정
- ###### 프로젝트 수정 시 프로젝트 제목, 짧은 소개 글, 카테고리 및 프로젝트 소개 글만 수정이 가능합니다. 
![edit-projects](https://github.com/user-attachments/assets/9b18c681-3bd0-499a-bfcc-a9ee105ae02a)
![edit-project](https://github.com/user-attachments/assets/f66b80d4-a798-44bc-a1f6-f4510ca0c67e)
---
#### 프로젝트 삭제
- ###### 프로젝트 삭제는 프로젝트가 시작되지 않은 경우에만 가능합니다.
![delete-projects](https://github.com/user-attachments/assets/ef2c935a-e2b4-433d-acfa-a5e2de36b838)  
---
>### 결제
- ###### 결제는 포트원API(토스페이먼츠)를 통해 연동되어 있습니다.
![payment](https://github.com/user-attachments/assets/22a8054b-8337-4911-bb26-23ed2b9b7c26)





