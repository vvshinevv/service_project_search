package com.project.search.local.infra;

import com.project.search.local.domain.AnalogyMeasurement;
import com.project.search.local.domain.LocalSearch;
import com.project.search.local.infra.vo.ReformLocalSearch;
import org.springframework.stereotype.Component;

@Component
public class SimpleAnalogyMeasurement implements AnalogyMeasurement {

    @Override
    public boolean measureAnalogy(LocalSearch leftLocalSearch, LocalSearch rightLocalSearch) {
        ReformLocalSearch leftReform = ReformLocalSearch.of(leftLocalSearch);
        ReformLocalSearch rightReform = ReformLocalSearch.of(rightLocalSearch);
        return leftReform.equals(rightReform);
    }
}
