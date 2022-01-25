package com.modyo.entity.pokemon.pokemon;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Move {
    private MoveDetail move;
    private List<VersionGroupDetail> versionGroupDetails;
}
