package com.modyo.repository;

import com.modyo.entity.berry.berries.Berry;
import com.modyo.entity.berry.firmness.BerryFirmness;
import com.modyo.entity.berry.flavor.BerryFlavors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BerryRepositoryServiceTest {

    private RestTemplate restTemplate;
    private BerryRepositoryService service;

    @BeforeEach
    void setUp() {
        restTemplate = mock(RestTemplate.class);
        service = new BerryRepositoryService(restTemplate);
        service.setBerries("/some_berries");
        service.setFirmness("/some_firmness");
        service.setFlavor("/some_flavor");
        service.setPokeApi("http://some_poke_api.test");
    }

    @Test
    void findBerryByNameOrId() {
        //arrange
        when(restTemplate.getForEntity(any(URI.class), any())).thenReturn(ResponseEntity.status(HttpStatus.OK).body(Berry.builder().build()));

        //act
        service.findBerryByNameOrId("some_id");

        //assert
        verify(restTemplate).getForEntity(any(URI.class), any());
    }

    @Test
    void findFirmnessByIdOrName() {
        //arrange
        when(restTemplate.getForEntity(any(URI.class), any())).thenReturn(ResponseEntity.status(HttpStatus.OK).body(new BerryFirmness()));

        //act
        service.findFirmnessByIdOrName("some_id");

        //assert
        verify(restTemplate).getForEntity(any(URI.class), any());
    }

    @Test
    void findFlavorByIdOrName() {
        //arrange
        when(restTemplate.getForEntity(any(URI.class), any())).thenReturn(ResponseEntity.status(HttpStatus.OK).body(new BerryFlavors()));

        //act
        service.findFlavorByIdOrName("some_id");

        //assert
        verify(restTemplate).getForEntity(any(URI.class), any());
    }
}