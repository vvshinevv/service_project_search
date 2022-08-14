package com.project.search.local.infra;

import com.project.search.local.domain.AnalogyMeasurement;
import com.project.search.local.domain.LocalSearch;
import org.springframework.stereotype.Component;

@Component
public class ETRIAnalogyMeasurement implements AnalogyMeasurement {
    @Override
    public boolean measureAnalogy(LocalSearch leftLocalSearch, LocalSearch rightLocalSearch) {
        return false;
    }
}
