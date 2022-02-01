package com.modyo.service;

import com.modyo.response.pokemon.PokemonResponse;

public interface PokemonService {
    PokemonResponse obtainPokemonInfo(String id);
}
