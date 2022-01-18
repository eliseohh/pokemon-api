package com.modyo.repository;

import com.modyo.entity.berry.Berry;
import com.modyo.entity.berry.BerryFirmness;
import com.modyo.entity.berry.Firmness;
import com.modyo.entity.berry.Flavor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class BerryRepositoryService implements BerryRepository {

    @Value("${service.poke-api.url}")
    private String pokeApi;

    @Value("${service.berry-service.berries}")
    private String berries;

    @Value("${service.berry-service.berry-firmness}")
    private String firmness;

    @Value("${service.berry-service.berry-flavor}")
    private String flavor;

    private final RestTemplate restTemplate;

    public BerryRepositoryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Berry findBerryByNameOrId(String id) throws InternalServerError {
        URI uri = URI.create(String.format("%s/%s/%s", pokeApi, berries, id));
        ResponseEntity<Berry> entityResponse = restTemplate.getForEntity(uri, Berry.class);
        return entityResponse.getBody();
    }

    @Override
    public BerryFirmness findFirmnessByIdOrName(String id) {
        URI uri = URI.create(String.format("%s/%s/%s", pokeApi, firmness, id));
        ResponseEntity<BerryFirmness> entityResponse = restTemplate.getForEntity(uri, BerryFirmness.class);
        return entityResponse.getBody();
    }

    @Override
    public Flavor findFirmnessByIdOrName(String id) {
        URI uri = URI.create(String.format("%s/%s/%s", pokeApi, flavor, id));
        ResponseEntity<Flavor> entityResponse = restTemplate.getForEntity(uri, Flavor.class);
        return entityResponse.getBody();
    }
}
