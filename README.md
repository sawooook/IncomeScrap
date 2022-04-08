# IncomeScrap

## API 구축

## 1. 회원가입
요청 정보 
```
{
    "userId": "1",
    "password": "123",
    "name": "홍길동",
    "regNo": "860824-1655068"
}
```
응답 정보
```
{
    "data": "OK",
    "error": null
}
```

## 구현 방법
```
회원가입 허용가능한 유저인지 체크를 한 후 
회원가입 중복체크를 진행하는 방식으로 구현하였습니다.
```

## 2. 로그인
요청 정보
```
{
    "userId" : "1",
    "password" : "123"
}
```

응답 정보
```
{
    "data": {
        "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNjQ5NDI4MDM0LCJleHAiOjE2NDk1MTQ0MzR9.mktvc6ASUFEsiW1aGXZEi5-GDfL8eEGo9SLBk_MZA8o"
    },
    "error": null
}
```

## 구현 방법
```
비밀번호가 일치하는지 체크를 진행하고 token을 주도록 하였습니다.
```



## 3. 마이페이지
요청 정보
header부분에 
```
Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNjQ5NDI2NDMzLCJleHAiOjE2NDk1MTI4MzN9._d7TXWFtskfJDzFcbabY20qmC5T4IKWqz-qi938n5Dg
```

응답 정보
```
{
    "data": {
        "userId": "1",
        "name": "홍길동"
    },
    "error": null
}
```

## 구현 방법
```
토큰을 통해 유저정보를 받아온 후 유저 정보들을 보여주도록 구현하였습니다.
```

## 4. 스크랩하기
요청 정보
header부분에 
```
Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNjQ5NDI2NDMzLCJleHAiOjE2NDk1MTI4MzN9._d7TXWFtskfJDzFcbabY20qmC5T4IKWqz-qi938n5Dg
```
응답 정보
```
{
    "data": "OK",
    "error": null
}
```


## 구현 방법
```
응답시간이 최대 20초까지 걸리므로 해당 부분을 비동기 요청하도록 처리하였습니다.
혹여 네트워크 이슈가 발생하여 실패할 수 있으니 1회까지 재시도 하도록 구현하였습니다.
```


## 5. 환급금액 받기

요청 정보
header부분에 
```
Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNjQ5NDI2NDMzLCJleHAiOjE2NDk1MTI4MzN9._d7TXWFtskfJDzFcbabY20qmC5T4IKWqz-qi938n5Dg
```

응답 정보
```
{
    "data": {
        "이름": "홍길동",
        "한도": "74만원",
        "공제액": "92만 5천원",
        "환급액": "74만원"
    },
    "error": null
}
```

## 구현 방법
```
스크랩해온 값들을 조건에 맞게 분기처리하도록 하였습니다.
후에 조건들은 추가될 가능성이 있으므로 팩토리 패턴을 통해 확장에 열려 있도록 기능을 구현하였습니다.
```



## 주관식 과제
```
6번
회사의 컨벤션을 따라 개발을 진행할것이다. 
시간이 없다는 이유로 컨벤션을 무시한채로 코드를 작성하게 되면 후에 작성되는 코드 또한 컨벤션을 무시한채로 작성될 가능성이 매우높다.
이렇게 컨벤션이 계속 무너지게되면 오히려 생산성이 악화가되고 후에 유지보수하는데 힘들수가 있기 떄문이다.
```
