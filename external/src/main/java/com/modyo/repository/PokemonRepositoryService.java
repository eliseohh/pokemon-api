package com.modyo.repository;

import com.modyo.entity.pokemon.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Repository
public class PokemonRepositoryService implements PokemonRepository {
    private String pokeApi;
    private String pokemon;
    private final RestTemplate restTemplate;

    public PokemonRepositoryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Pokemon obtainPokemon(String name) {
        URI uri = URI.create(String.format("%s%s%s", pokeApi, pokemon, name));
        ResponseEntity<Pokemon> entityResponse = restTemplate.getForEntity(uri, Pokemon.class);
        return entityResponse.getBody();
    }

    @Autowired
    public void setPokeApi(@Value("${service.poke-api.url}") String pokeApi) {
        this.pokeApi = pokeApi;
    }

    @Autowired
    public void setPokemon(@Value("${service.poke-api.pokemon-service.pokemon}") String pokemon) {
        this.pokemon = pokemon;
    }
}
