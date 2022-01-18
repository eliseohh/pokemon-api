package com.modyo.repository;

import com.modyo.entity.berry.berries.Berry;
import com.modyo.entity.berry.berries.Flavor;
import com.modyo.entity.berry.firmness.BerryFirmness;
import com.modyo.entity.berry.flavor.BerryFlavors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class BerryRepositoryService implements BerryRepository {

    @Value("${service.poke-api.url}")
    private String pokeApi;

    @Value("${service.poke-api.berry-service.berries}")
    private String berries;

    @Value("${service.poke-api.berry-service.berry-firmness}")
    private String firmness;

    @Value("${service.poke-api.berry-service.berry-flavor}")
    private String flavor;

    private final RestTemplate restTemplate;

    public BerryRepositoryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Berry findBerryByNameOrId(String id) throws InternalServerError {
        URI uri = URI.create(String.format("%s%s%s", pokeApi, berries, id));
        ResponseEntity<Berry> entityResponse = restTemplate.getForEntity(uri, Berry.class);
        return entityResponse.getBody();
    }

    @Override
    public BerryFirmness findFirmnessByIdOrName(String id) {
        URI uri = URI.create(String.format("%s%s%s", pokeApi, firmness, id));
        ResponseEntity<BerryFirmness> entityResponse = restTemplate.getForEntity(uri, BerryFirmness.class);
        return entityResponse.getBody();
    }

    @Override
    public BerryFlavors findFlavorByIdOrName(String id) {
        URI uri = URI.create(String.format("%s%s%s", pokeApi, flavor, id));
        ResponseEntity<BerryFlavors> entityResponse = restTemplate.getForEntity(uri, BerryFlavors.class);
        return entityResponse.getBody();
    }
}
