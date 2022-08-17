package com.project.search.local.application;

import com.project.search.common.event.Event;
import com.project.search.common.event.Events;
import com.project.search.count.command.domain.SearchCountEvent;
import com.project.search.local.application.dto.LocalSearchSummary;
import com.project.search.local.application.dto.LocalSearchesSummary;
import com.project.search.local.domain.AnalogyMeasurement;
import com.project.search.local.domain.LocalSearchContainer;
import com.project.search.local.domain.LocalSearchFinder;
import com.project.search.local.domain.LocalSearchRepository;
import com.project.search.local.domain.LocalSearchSaveEvent;
import com.project.search.local.fixture.LocalSearchFixture;
import com.project.search.local.infra.TestAnalogyMeasurement;
import com.project.search.local.infra.kakao.LocalSearchKakaoFinder;
import com.project.search.local.infra.naver.LocalSearchNaverFinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class LocalSearchServiceTest {
    private LocalSearchService localSearchService;
    private List<LocalSearchFinder> localSearchFinders;

    @Mock
    private LocalSearchKakaoFinder localSearchKakaoFinder;
    @Mock
    private LocalSearchNaverFinder localSearchNaverFinder;
    @Mock
    private LocalSearchRepository localSearchRepository;
    @Mock
    private ApplicationEventPublisher applicationEventPublisher;
    @Captor
    private ArgumentCaptor<Event> eventArgumentCaptor;

    @BeforeEach
    void setup() {
        Events.setPublisher(applicationEventPublisher);

        localSearchFinders = new ArrayList<>();
        localSearchFinders.add(localSearchKakaoFinder);
        localSearchFinders.add(localSearchNaverFinder);
        AnalogyMeasurement analogyMeasurement = new TestAnalogyMeasurement();

        localSearchService = new LocalSearchService(localSearchFinders, analogyMeasurement, localSearchRepository);
    }

    @DisplayName("지역_키워드_검색_목_테스트")
    @Test
    void 지역_키워드_검색_목_테스트() {
        // given
        지역_키워드_검색_데이터_모킹();

        // when
        LocalSearchesSummary expected = localSearchService.searchLocalByKeyword("카카오 아지트");

        // then
        assertThat(expected.getKeyword()).isEqualTo("카카오 아지트");
        데이터_순서_검증(expected.getItems());
    }

    private void 지역_키워드_검색_데이터_모킹() {
        LocalSearchContainer 카카오_검색_컨테이너 = LocalSearchFixture.카카오_검색_컨테이너();
        LocalSearchContainer 네이버_검색_컨테이너 = LocalSearchFixture.네이버_검색_컨테이너();
        given(localSearchKakaoFinder.findLocalSearchByKeyword(anyString(), anyInt(), anyInt())).willReturn(카카오_검색_컨테이너);
        given(localSearchNaverFinder.findLocalSearchByKeyword(anyString(), anyInt(), anyInt())).willReturn(네이버_검색_컨테이너);
    }

    private void 데이터_순서_검증(List<LocalSearchSummary> items) {
        assertThat(items.get(0).getPlaceName()).isEqualTo("카카오판교아지트");
        assertThat(items.get(1).getPlaceName()).isEqualTo("카카오판교아지트 주차장입구");
        assertThat(items.get(2).getPlaceName()).isEqualTo("카카오 판교 아지트 주차장");
        assertThat(items.get(3).getPlaceName()).isEqualTo("레드텅 부티크 판교 카카오점");
        assertThat(items.get(4).getPlaceName()).isEqualTo("카카오판교아지트 전기차충전소");
        assertThat(items.get(5).getPlaceName()).isEqualTo("카카오T 카카오판교아지트주차장");
        assertThat(items.get(6).getPlaceName()).isEqualTo("카카오");
        assertThat(items.get(7).getPlaceName()).isEqualTo("카카오페이증권 본사");
        assertThat(items.get(8).getPlaceName()).isEqualTo("CJ프레시웨이 카카오아지트점");
        assertThat(items.get(9).getPlaceName()).isEqualTo("엑스익스프레스 카카오판교점");
    }

    @DisplayName("키워드_검색_이벤트에_따라_발행된_이벤트_확인")
    @Test
    void 키워드_검색_이벤트에_따라_발행된_이벤트_확인() {
        // given
        지역_키워드_검색_데이터_모킹();

        // when
        localSearchService.searchLocalByKeyword("카카오 아지트");

        // then
        verify(applicationEventPublisher, times(2)).publishEvent(eventArgumentCaptor.capture());
        assertThat(eventArgumentCaptor.getAllValues().get(0)).isExactlyInstanceOf(SearchCountEvent.class);
        assertThat(eventArgumentCaptor.getAllValues().get(1)).isExactlyInstanceOf(LocalSearchSaveEvent.class);
    }

    @DisplayName("List_모킹_확인")
    @Test
    void List_모킹_확인() {
        System.out.println(localSearchFinders.size());
    }
}
