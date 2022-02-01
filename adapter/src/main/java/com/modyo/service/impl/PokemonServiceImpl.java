package com.modyo.service.impl;

import com.modyo.mapper.pokemon.PokemonResponseMapper;
import com.modyo.response.pokemon.PokemonResponse;
import com.modyo.service.EvolutionService;
import com.modyo.service.PokemonApiService;
import com.modyo.service.PokemonService;
import org.springframework.stereotype.Service;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final PokemonApiService pokemonApiService;
    private final PokemonResponseMapper pokemonResponseMapper;
    private final EvolutionService evolutionService;

    public PokemonServiceImpl(PokemonApiService pokemonApiService, PokemonResponseMapper pokemonResponseMapper, EvolutionService evolutionService) {
        this.pokemonApiService = pokemonApiService;
        this.pokemonResponseMapper = pokemonResponseMapper;
        this.evolutionService = evolutionService;
    }

    @Override
    public PokemonResponse obtainPokemonInfo(String id) {
        return pokemonResponseMapper.apply(pokemonApiService.findPokemonByIdOrName(id), evolutionService.findEvolutionById(id));
    }
}
