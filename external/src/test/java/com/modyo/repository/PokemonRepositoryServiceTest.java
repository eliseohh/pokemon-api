package com.modyo.repository;

import com.modyo.entity.pokemon.pokemon.Pokemon;
import com.modyo.repository.PokemonRepositoryService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PokemonRepositoryServiceTest {

    @Test
    void obtainPokemon() {
        //arrange
        RestTemplate restTemplate = mock(RestTemplate.class);
        PokemonRepositoryService pokemonRepositoryService = new PokemonRepositoryService(restTemplate);
        pokemonRepositoryService.setPokemon("/some_pokemon");
        pokemonRepositoryService.setPokeApi("http://some_poke_api.test");
        when(restTemplate.getForEntity(any(URI.class), any())).thenReturn(ResponseEntity.status(HttpStatus.OK).body(new Pokemon()));

        //act
        pokemonRepositoryService.obtainPokemon("some_name");

        //assert
        verify(restTemplate).getForEntity(any(URI.class), any());
    }
}