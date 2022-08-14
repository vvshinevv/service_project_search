package com.project.search.local.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class LocalSearchContainers {
    private final List<LocalSearchContainer> containers;

    public LocalSearchContainers(List<LocalSearchContainer> containers) {
        this.containers = new ArrayList<>(containers);
    }

    public void decideScoreWithAnalogyMeasurement(AnalogyMeasurement analogyMeasurement) {
        for (LocalSearchContainer outerContainer : containers) {
            for (LocalSearchContainer innerContainer : containers) {
                if (outerContainer.getSearchType() != innerContainer.getSearchType()) {
                    outerContainer.decideScoreWithAnalogyMeasurement(outerContainer.getItems(), analogyMeasurement);
                }
            }
        }
    }
}
