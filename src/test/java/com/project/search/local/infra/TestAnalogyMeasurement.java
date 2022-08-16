package com.project.search.local.infra;

import com.project.search.local.domain.AnalogyMeasurement;
import com.project.search.local.domain.LocalSearch;

public class TestAnalogyMeasurement implements AnalogyMeasurement {
    @Override
    public boolean measureAnalogy(LocalSearch leftLocalSearch, LocalSearch rightLocalSearch) {
        if (leftLocalSearch.getPlaceName().equals("카카오판교아지트") && rightLocalSearch.getPlaceName().equals("<b>카카오</b> 판교<b>아지트</b>")) {
            return true;
        }

        if (leftLocalSearch.getPlaceName().equals("<b>카카오</b> 판교<b>아지트</b>") && rightLocalSearch.getPlaceName().equals("카카오판교아지트")) {
            return true;
        }

        if (leftLocalSearch.getPlaceName().equals("레드텅 부티크 판교 카카오점") && rightLocalSearch.getPlaceName().equals("레드텅 부티크 <b>카카오</b>판교<b>아지트</b>점")) {
            return true;
        }

        if (leftLocalSearch.getPlaceName().equals("레드텅 부티크 <b>카카오</b>판교<b>아지트</b>점") && rightLocalSearch.getPlaceName().equals("레드텅 부티크 판교 카카오점")) {
            return true;
        }

        if (leftLocalSearch.getPlaceName().equals("카카오 판교 아지트 주차장") && rightLocalSearch.getPlaceName().equals("<b>카카오</b>판교<b>아지트</b> 주차장")) {
            return true;
        }

        if (leftLocalSearch.getPlaceName().equals("<b>카카오</b>판교<b>아지트</b> 주차장") && rightLocalSearch.getPlaceName().equals("카카오 판교 아지트 주차장")) {
            return true;
        }

        if (leftLocalSearch.getPlaceName().equals("카카오판교아지트 주차장입구") && rightLocalSearch.getPlaceName().equals("<b>카카오</b> 판교<b>아지트</b>주차장입구")) {
            return true;
        }

        if (leftLocalSearch.getPlaceName().equals("<b>카카오</b> 판교<b>아지트</b>주차장입구") && rightLocalSearch.getPlaceName().equals("카카오판교아지트 주차장입구")) {
            return true;
        }

        return false;
    }
}
