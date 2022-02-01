package com.modyo.controller;

import com.modyo.response.pokemon.PokemonResponse;
import com.modyo.service.PokemonService;
import org.springframework.stereotype.Component;

@Component
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    public PokemonResponse getPokemonInfo(String id){
        return pokemonService.obtainPokemonInfo(id);
    }
}
