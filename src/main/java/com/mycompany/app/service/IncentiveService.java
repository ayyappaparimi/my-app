package com.mycompany.app.service;

import com.mycompany.app.foundation.Transaction;
import com.mycompany.app.foundation.Incentive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

public class IncentiveService {

    @Autowired
    private RestTemplate restTemplate;

    public final String url = "http://localhoust:8080/incentive";

    public float fetchIncentive(Transaction transaction) {

        Incentive response = restTemplate.postForObject(url, transaction, Incentive.class);

        if (response == null) {
            return 0f;
        }

        return response.getIncentiveAmount();

    }
}
