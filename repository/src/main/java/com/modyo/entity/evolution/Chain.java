package com.modyo.entity.evolution;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class Chain{
    private ArrayList<EvolutionDetail> evolutionDetails;
    private ArrayList<Chain> evolvesTo;
    private boolean isBaby;
    private Species species;
}
