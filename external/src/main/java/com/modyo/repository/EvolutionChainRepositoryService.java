package com.modyo.repository;

import com.modyo.entity.evolution.EvolutionChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Repository
public class EvolutionChainRepositoryService implements EvolutionChainRepository {
    private String pokeApi;
    private String evolutionChain;
    private final RestTemplate restTemplate;

    public EvolutionChainRepositoryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public EvolutionChain obtainEvolution(String id) {
        URI uri = URI.create(String.format("%s%s%s", pokeApi, evolutionChain, id));
        ResponseEntity<EvolutionChain> entityResponse = restTemplate.getForEntity(uri, EvolutionChain.class);
        return entityResponse.getBody();
    }

    @Autowired
    public void setPokeApi(@Value("${service.poke-api.url}") String pokeApi) {
        this.pokeApi = pokeApi;
    }

    @Autowired
    public void setEvolutionChain(@Value("${service.poke-api.evolution-service.chain}") String evolutionChain) {
        this.evolutionChain = evolutionChain;
    }
}
