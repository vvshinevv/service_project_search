package com.project.search.local.infra;

import com.project.search.local.domain.AnalogyMeasurement;
import com.project.search.local.domain.LocalSearch;
import com.project.search.local.infra.model.ETRIArgumentRequest;
import com.project.search.local.infra.model.ETRIParaphraseRequest;
import com.project.search.local.infra.model.ETRIParaphraseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class ETRIAnalogyMeasurement implements AnalogyMeasurement {
    private final ETRIAnalogyClient etriAnalogyClient;
    private final String restApiKey;

    public ETRIAnalogyMeasurement(
            ETRIAnalogyClient etriAnalogyClient,
            @Value("${etri.rest.api.key}") String restApiKey
    ) {
        this.etriAnalogyClient = etriAnalogyClient;
        this.restApiKey = restApiKey;
    }

    @Override
    public boolean measureAnalogy(LocalSearch leftLocalSearch, LocalSearch rightLocalSearch) {
        ETRIParaphraseRequest request = populateRequest(leftLocalSearch, rightLocalSearch);
        ETRIParaphraseResponse response = etriAnalogyClient.queryParaphraseAnalogy(request);
        return response.getEtriReturnObjectResponse().getResult().equals("paraphrase");
    }

    private ETRIParaphraseRequest populateRequest(LocalSearch leftLocalSearch, LocalSearch rightLocalSearch) {
        String firstSentence = leftLocalSearch.getAddressName() + " " + leftLocalSearch.getPlaceName();
        String secondSentence = rightLocalSearch.getAddressName() + " " + rightLocalSearch.getPlaceName();
        ETRIArgumentRequest argument = new ETRIArgumentRequest(firstSentence, secondSentence);

        return new ETRIParaphraseRequest(UUID.randomUUID().toString(), restApiKey, argument);
    }
}
