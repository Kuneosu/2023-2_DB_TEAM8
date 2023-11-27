# 2023-2_DB_TEAM8 - KKS
2023-2 데이터베이스 프로그래밍, 8조 팀장 개인 작업 폴더 입니다.


## 2023.11.23. 작업 내용
- DB_LAW : LAW DB와 자바 연동
- mainFrame : 메인 시작 프레임 제작, 변호사 메뉴와 고객 메뉴 프레임 연결
- lawyerFrame : 변호사 프레임 제작, 레이아웃 구성
- customerFrame : 고객 프레임 제작, 레이아웃 구성

## 2023.11.27 작업 내용
- DB_LAW : 
    - mainSql() : CALC_STATUS() 프로시져를 호출하여 현재 진행중인 사건 수, 전체 승률, 변호사 수를 가져옴
    - checkLawyer() : createCounselFrame 으로부터 변호사 이름을 넘겨받고, 해당 변호사 이름이 데이터베이스에 존재할 경우 변호사 번호를 반환, 존재하지 않을 경우 "존재하지 않느 변호사"값 반환
    - checkCustomer() : 위와 동일, 변호사 대신 고객 정보를 다루는 것만 다름
    - createCounsel() : CREATE_COUNSEL() 프로시져를 호출. 사용자로부터 입력받은 변호사 번호, 고객 번호, 상담종류, 상담내용을 넘겨줘서 데이터베이스에 새로운 상담 튜플을 생성
- mainFrame :
    - mainSql() 을 실행하여 진행중인 사건 수, 전체 승률, 변호사 수를 가져와 mainFrame 에 출력함
- mainResult :
    - mainSql() 에서 결과값을 가져올때 사용하는 데이터 객체, totalCase, winRate, countLawyer 로 이루어져 있음
- createCounselFrame:
    - 사용자로부터 데이터를 입력/선택 받고 입력받은 데이터를 DB_LAW의 createCounsel() 메소드로 넘겨 튜플을 생성