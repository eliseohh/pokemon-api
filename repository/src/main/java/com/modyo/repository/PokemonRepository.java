package com.modyo.repository;

import com.modyo.entity.pokemon.pokemon.Pokemon;

public interface PokemonRepository {
    Pokemon obtainPokemon(String name);
}
