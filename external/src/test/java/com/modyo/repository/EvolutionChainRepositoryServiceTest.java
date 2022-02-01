package com.modyo.repository;

import com.modyo.entity.evolution.EvolutionChain;
import com.modyo.repository.EvolutionChainRepositoryService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EvolutionChainRepositoryServiceTest {

    @Test
    void obtainEvolution() {
        //arrange
        RestTemplate restTemplate = mock(RestTemplate.class);
        EvolutionChainRepositoryService evolutionChainRepositoryService = new EvolutionChainRepositoryService(restTemplate);
        evolutionChainRepositoryService.setEvolutionChain("/some_evolution_chain");
        evolutionChainRepositoryService.setPokeApi("http://some_poke_api.test");
        when(restTemplate.getForEntity(any(URI.class), any())).thenReturn(ResponseEntity.status(HttpStatus.OK).body(new EvolutionChain()));

        //act
        evolutionChainRepositoryService.obtainEvolution("some_id");

        //assert
        verify(restTemplate).getForEntity(any(URI.class), any());
    }
}