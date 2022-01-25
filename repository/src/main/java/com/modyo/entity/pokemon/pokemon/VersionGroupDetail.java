package com.modyo.entity.pokemon.pokemon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VersionGroupDetail {
    private Integer levelLearnedAt;
    private VersionGroup versionGroup;
    private MoveLearnMethod moveLearnMethod;
}
