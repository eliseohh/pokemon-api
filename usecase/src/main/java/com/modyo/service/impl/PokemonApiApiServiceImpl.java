package com.modyo.service.impl;

import com.modyo.entity.pokemon.pokemon.Pokemon;
import com.modyo.repository.PokemonRepository;
import com.modyo.service.PokemonApiService;
import org.springframework.stereotype.Service;

@Service
public class PokemonApiApiServiceImpl implements PokemonApiService {

    private final PokemonRepository pokemonRepository;

    public PokemonApiApiServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public Pokemon findPokemonByIdOrName(String id) {
        return pokemonRepository.obtainPokemon(id);
    }
}
