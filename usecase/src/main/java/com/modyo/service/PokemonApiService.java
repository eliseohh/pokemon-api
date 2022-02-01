package com.modyo.service;

import com.modyo.entity.pokemon.pokemon.Pokemon;

public interface PokemonApiService {
    Pokemon findPokemonByIdOrName(String id);
}
