package com.project.search.local.domain;

import lombok.Getter;
import org.springframework.util.CollectionUtils;

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
                    outerContainer.decideScoreWithAnalogyMeasurement(innerContainer.getItems(), analogyMeasurement);
                }
            }
        }
    }

    public List<LocalSearch> mergeLocalSearch() {
        List<LocalSearch> results = new ArrayList<>();
        for (LocalSearchContainer container : containers) {
            if (CollectionUtils.isEmpty(results)) {
                results.addAll(container.getItems());
            } else {
                List<LocalSearch> differentLocalSearch = container.findNotAnalogyDocuments();
                results.addAll(differentLocalSearch);
            }
        }

        return results;
    }
}
