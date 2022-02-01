package com.modyo.entity.evolution;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EvolutionDetail{
    private String gender;
    private String heldItem;
    private String item;
    private String knownMove;
    private String knownMoveType;
    private String location;
    private String minAffection;
    private String minBeauty;
    private String minHappiness;
    private String minLevel;
    private boolean needsOverworldRain;
    private String partySpecies;
    private String partyType;
    private String relativePhysicalStats;
    private String timeOfDay;
    private String tradeSpecies;
    private Trigger trigger;
    private boolean turnUpsideDown;
}
