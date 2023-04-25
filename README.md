# android-movie-theater

## 기능 목록

- 네비게이션으로 영화 예매 앱의 기능을 사용할 수 있다.
  - 예매 내역 : 예매한 영화 리스트
  - 홈 : 영화 리스트
  - 설정 : 빈 화면
- 예매 내역(예매한 영화 리스트) 상세
  - 예매 내역에는 "yyyy.M.D | HH:mm" 형식의 시간 표시와 예매한 영화 제목이 포함되어 있다.
  - 예매 내역을 터치하면 예매 정보를 보여준다.
  - 리스트 항목을 누르는 효과를 줘야 한다. (시안 참고)

---

# android-movie-ticket

## 기능 목록

- 하나의 영화가 목록에서 보인다.
- 영화의 상영일은 단 하루다.
- 영화를 선택하면 상세 정보가 나타나며, 예약할 인원을 선택할 수 있다.
- 영화 티켓 한 장은 13,000원이다.
- 예약할 인원에 맞게 영화 티켓값을 계산한다.

## step2 추가된 기능 목록

- 영화를 선택한 후 날짜와 시간을 정할 수 있다.
    - 할인 조건에 따라 적절한 할인 정책이 적용된다.
    - 적용된 할인 정책에 따른 가격을 확인할 수 있다.
    - 화면이 회전되어도 입력한 정보는 유지되어야 한다.
- 날짜 및 시간 정책
    - 각 영화의 상영일은 각자의 범위를 갖는다(예: 2023.4.1 ~ 2023.4.28).
    - 영화 상영 시간 범위는 오전 9시부터 자정까지다.
    - 주말에는 오전 9시부터 두 시간 간격으로 상영한다.
    - 평일에는 오전 10시부터 두 시간 간격으로 상영한다.
    - 날짜와 시간은 기본값으로 초기화되어있다.
- 할인 정책
    - 무비데이(매월 10, 20, 30일)일 때: 10% 할인
    - 조조(11시 이전)/야간(20시 이후)일 때: 2,000원 할인
    - 두 조건은 겹칠 수 있고 무비데이 할인이 선적용되어야 한다.

## step3 추가된 기능 목록

- 사용자는 인원/날짜 선택 후에 좌석을 고를 수 있다.
- 좌석은 총 5행 4열로 구성되어 있고 각 행은 알파벳, 열은 숫자로 표현한다.
- 좌석을 선택하면 배경색이 바뀌고, 하단에 할인정책과 좌석 등급을 고려한 최종 가격이 표시된다.
- 선택된 좌석을 재선택하면 선택이 해제된다.

- 등급 정책
  - 1, 2행은 B등급, 보라색 글자로 표시한다. (10,000원)
  - 3, 4행은 S등급, 초록색 글자로 표시한다. (15,000원)
  - 5행은 A등급, 파란색 글자로 표시한다. (12,000원)

- 최종적으로 예매를 확인하는 다이얼로그가 표시되고 배경을 터치해도 사라지지 않아야 한다.
