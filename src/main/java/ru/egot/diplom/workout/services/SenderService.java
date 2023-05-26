package ru.egot.diplom.workout.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class SenderService {

    private final RestTemplate restTemplate;

    public <T> ResponseEntity<T> get(String url,Class<T> tClass, HttpEntity<?> headers, Map<String, String> uriVariables) {
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                headers,
                tClass,
                uriVariables
        );
    }

}
