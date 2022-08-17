package com.project.search.local.fixture;

import com.project.search.local.domain.LocalSearch;
import com.project.search.local.domain.LocalSearchContainer;
import com.project.search.local.domain.SearchType;

import java.util.Arrays;
import java.util.List;

public class LocalSearchFixture {
    public static LocalSearch 카카오_아지트_카카오_결과1() {
        return new LocalSearch(
                "카카오 아지트",
                "경기 성남시 분당구 백현동 532",
                "경기 성남시 분당구 판교역로 166",
                "카카오판교아지트",
                "http://place.map.kakao.com/1437795442",
                SearchType.KAKAO
        );
    }

    public static LocalSearch 카카오_아지트_카카오_결과2() {
        return new LocalSearch(
                "카카오 아지트",
                "경기 성남시 분당구 백현동 532",
                "경기 성남시 분당구 판교역로 166",
                "카카오판교아지트 주차장입구",
                "http://place.map.kakao.com/8996128",
                SearchType.KAKAO
        );
    }

    public static LocalSearch 카카오_아지트_카카오_결과3() {
        return new LocalSearch(
                "카카오 아지트",
                "경기 성남시 분당구 백현동 532",
                "경기 성남시 분당구 판교역로 166",
                "카카오판교아지트 전기차충전소",
                "http://place.map.kakao.com/658608910",
                SearchType.KAKAO
        );
    }

    public static LocalSearch 카카오_아지트_카카오_결과4() {
        return new LocalSearch(
                "카카오 아지트",
                "경기 성남시 분당구 백현동 532",
                "경기 성남시 분당구 판교역로 166",
                "카카오T 카카오판교아지트주차장",
                "http://place.map.kakao.com/1426663940",
                SearchType.KAKAO
        );
    }

    public static LocalSearch 카카오_아지트_카카오_결과5() {
        return new LocalSearch(
                "카카오 아지트",
                "경기 성남시 분당구 백현동 532",
                "경기 성남시 분당구 판교역로 166",
                "카카오 판교 아지트 주차장",
                "http://place.map.kakao.com/1426910645",
                SearchType.KAKAO
        );
    }

    public static LocalSearch 카카오_아지트_카카오_결과6() {
        return new LocalSearch(
                "카카오 아지트",
                "경기 성남시 분당구 백현동 532",
                "경기 성남시 분당구 판교역로 166",
                "카카오",
                "http://place.map.kakao.com/18577297",
                SearchType.KAKAO
        );
    }

    public static LocalSearch 카카오_아지트_카카오_결과7() {
        return new LocalSearch(
                "카카오 아지트",
                "경기 성남시 분당구 백현동 532",
                "경기 성남시 분당구 판교역로 166",
                "카카오페이증권 본사",
                "http://place.map.kakao.com/1173603697",
                SearchType.KAKAO
        );
    }

    public static LocalSearch 카카오_아지트_카카오_결과8() {
        return new LocalSearch(
                "카카오 아지트",
                "경기 성남시 분당구 백현동 532",
                "경기 성남시 분당구 판교역로 166",
                "레드텅 부티크 판교 카카오점",
                "http://place.map.kakao.com/768350671",
                SearchType.KAKAO
        );
    }

    public static LocalSearch 카카오_아지트_카카오_결과9() {
        return new LocalSearch(
                "카카오 아지트",
                "경기 성남시 분당구 백현동 532",
                "경기 성남시 분당구 판교역로 166",
                "CJ프레시웨이 카카오아지트점",
                "http://place.map.kakao.com/371551649",
                SearchType.KAKAO
        );
    }

    public static LocalSearch 카카오_아지트_카카오_결과10() {
        return new LocalSearch(
                "카카오 아지트",
                "경기 성남시 분당구 백현동 532",
                "경기 성남시 분당구 판교역로 166",
                "엑스익스프레스 카카오판교점",
                "http://place.map.kakao.com/777924352",
                SearchType.KAKAO
        );
    }

    public static LocalSearch 카카오_아지트_네이버_결과1() {
        return new LocalSearch(
                "카카오 아지트",
                "경기도 성남시 분당구 백현동 532",
                "경기도 성남시 분당구 판교역로 166",
                "<b>카카오</b> 판교<b>아지트</b>",
                "http://www.kakaocorp.com/",
                SearchType.NAVER
        );
    }

    public static LocalSearch 카카오_아지트_네이버_결과2() {
        return new LocalSearch(
                "카카오 아지트",
                "경기도 성남시 분당구 백현동 532 1층 11호",
                "경기도 성남시 분당구 판교역로 166 1층 11호",
                "레드텅 부티크 <b>카카오</b>판교<b>아지트</b>점",
                "",
                SearchType.NAVER
        );
    }

    public static LocalSearch 카카오_아지트_네이버_결과3() {
        return new LocalSearch(
                "카카오 아지트",
                "경기도 성남시 분당구 백현동 532",
                "경기도 성남시 분당구 판교역로 166",
                "<b>카카오</b>판교<b>아지트</b> 주차장",
                "",
                SearchType.NAVER
        );
    }

    public static LocalSearch 카카오_아지트_네이버_결과4() {
        return new LocalSearch(
                "카카오 아지트",
                "경기도 성남시 분당구 백현동",
                "",
                "<b>카카오</b> 판교<b>아지트</b>주차장입구",
                "",
                SearchType.NAVER
        );
    }

    public static LocalSearch 카카오_아지트_네이버_결과5() {
        return new LocalSearch(
                "카카오 아지트",
                "경기도 성남시 분당구 삼평동",
                "",
                "<b>카카오</b> 판교<b>아지트</b>입구",
                "",
                SearchType.NAVER
        );
    }

    public static LocalSearchContainer 카카오_검색_컨테이너() {
        LocalSearch 카카오_검색1 = LocalSearchFixture.카카오_아지트_카카오_결과1(); // 네이버 결과 1과 유사
        LocalSearch 카카오_검색2 = LocalSearchFixture.카카오_아지트_카카오_결과2(); // 네이버 결과 4와 유사
        LocalSearch 카카오_검색3 = LocalSearchFixture.카카오_아지트_카카오_결과3();
        LocalSearch 카카오_검색4 = LocalSearchFixture.카카오_아지트_카카오_결과4();
        LocalSearch 카카오_검색5 = LocalSearchFixture.카카오_아지트_카카오_결과5(); // 네이버 결과 3과 유사
        LocalSearch 카카오_검색6 = LocalSearchFixture.카카오_아지트_카카오_결과6();
        LocalSearch 카카오_검색7 = LocalSearchFixture.카카오_아지트_카카오_결과7();
        LocalSearch 카카오_검색8 = LocalSearchFixture.카카오_아지트_카카오_결과8(); // 네이버 결과 2와 유사
        LocalSearch 카카오_검색9 = LocalSearchFixture.카카오_아지트_카카오_결과9();
        LocalSearch 카카오_검색10 = LocalSearchFixture.카카오_아지트_카카오_결과10();
        List<LocalSearch> 카카오_검색_결과들 = Arrays.asList(카카오_검색1, 카카오_검색2, 카카오_검색3, 카카오_검색4, 카카오_검색5, 카카오_검색6, 카카오_검색7, 카카오_검색8, 카카오_검색9, 카카오_검색10);
        return new LocalSearchContainer(SearchType.KAKAO, 카카오_검색_결과들, 1, 10, false);
    }

    public static LocalSearchContainer 네이버_검색_컨테이너() {
        LocalSearch 네이버_검색1 = LocalSearchFixture.카카오_아지트_네이버_결과1();
        LocalSearch 네이버_검색2 = LocalSearchFixture.카카오_아지트_네이버_결과2();
        LocalSearch 네이버_검색3 = LocalSearchFixture.카카오_아지트_네이버_결과3();
        LocalSearch 네이버_검색4 = LocalSearchFixture.카카오_아지트_네이버_결과4();
        LocalSearch 네이버_검색5 = LocalSearchFixture.카카오_아지트_네이버_결과5();
        List<LocalSearch> 네이버_검색_결과들 = Arrays.asList(네이버_검색1, 네이버_검색2, 네이버_검색3, 네이버_검색4, 네이버_검색5);
        return new LocalSearchContainer(SearchType.NAVER, 네이버_검색_결과들, 1, 5, true);
    }
}
