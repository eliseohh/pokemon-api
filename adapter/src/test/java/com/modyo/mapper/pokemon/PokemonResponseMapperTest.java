package com.modyo.mapper.pokemon;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.modyo.entity.evolution.EvolutionChain;
import com.modyo.entity.pokemon.pokemon.Pokemon;
import com.modyo.response.pokemon.AbilityPokemonResponse;
import com.modyo.response.pokemon.PokemonResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class PokemonResponseMapperTest {

    @Test
    void apply() {
        //arrange
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        PokemonResponseMapper mapper = new PokemonResponseMapper();
        Pokemon pokemon;
        EvolutionChain evolutionChain;
        List<AbilityPokemonResponse> expectedList = new ArrayList<>();
        expectedList.add(AbilityPokemonResponse.builder().name("overgrow").build());
        expectedList.add(AbilityPokemonResponse.builder().name("chlorophyll").build());

        try {
            pokemon = objectMapper.readValue(new File("src/test/resources/repository/pokemonapi.json"), Pokemon.class);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try {
            evolutionChain = objectMapper.readValue(new File("src/test/resources/repository/evolutionapi.json"), EvolutionChain.class);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        //act
        PokemonResponse response = mapper.apply(pokemon, evolutionChain);

        //assert
        Assertions.assertEquals("bulbasaur", response.getName());
        Assertions.assertEquals("bulbasaur, This pokemon is type(s) grass, poison", response.getDescription());
        Assertions.assertEquals("grass, poison", response.getType());
        Assertions.assertEquals(69, response.getWeight());
        //TODO: validar valores internos
        Assertions.assertEquals(expectedList.size(), response.getAbilities().size());
        Assertions.assertEquals(3, response.getEvolutions().size());
    }
}