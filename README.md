# near-subway-api
특정 좌표 기준 반경 1km이내 지하철 검색 (수도권)

## IDEA
Intellij IDEA

## DATABASE
Oracle DB

## 좌표체계
UTM-K 좌표계 입력만 허용
위 경도 좌표 입력시 이상하게 될꺼에요..ㅎ

*xml 반환형식만 지원합니다.*

## 호출 스택 예시
GET
`/api/v1/subway/near?resultCnt=5&x=202172.4457&y=452966.9537`
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<stationInfo>
    <row>
        <statnId>1001000126</statnId>
        <statnNm>신설동</statnNm>
        <subwayId>1001</subwayId>
        <subwayNm>1호선</subwayNm>
        <x>202172.4457</x>
        <y>452966.9537</y>
        <ord>0</ord>
    </row>
    <row>
        <statnId>1092004713</statnId>
        <statnNm>신설동</statnNm>
        <subwayId>1092</subwayId>
        <subwayNm>우이신설선</subwayNm>
        <x>202045.9497</x>
        <y>453015.5772</y>
        <ord>1</ord>
    </row>
</statinInfo>
```

## 200922
- directory 변경 (domain 변경 board -> subway)