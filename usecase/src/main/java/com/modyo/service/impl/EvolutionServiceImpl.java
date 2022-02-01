package com.modyo.service.impl;

import com.modyo.entity.evolution.EvolutionChain;
import com.modyo.repository.EvolutionChainRepository;
import com.modyo.service.EvolutionService;
import org.springframework.stereotype.Service;

@Service
public class EvolutionServiceImpl implements EvolutionService {

    private final EvolutionChainRepository evolutionChainRepository;

    public EvolutionServiceImpl(EvolutionChainRepository evolutionChainRepository) {
        this.evolutionChainRepository = evolutionChainRepository;
    }

    @Override
    public EvolutionChain findEvolutionById(String id) {
        return evolutionChainRepository.obtainEvolution(id);
    }
}
