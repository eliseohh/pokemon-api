package com.modyo.repository;

import com.modyo.entity.evolution.EvolutionChain;

public interface EvolutionChainRepository {
    EvolutionChain obtainEvolution(String id);
}
