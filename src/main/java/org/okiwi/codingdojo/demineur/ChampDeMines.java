package org.okiwi.codingdojo.demineur;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.BinaryOperator;

public class ChampDeMines {

    public ChampDeMines(int largeur, int hauteur, String champ) {
        this.champ = champ;
    }

    public String signaleLesMines() {
        String champSignalé = "";
        for (int i = 0; i < champ.length(); i++) {
          champSignalé += signalementALaPosition(i);
        }
        return champSignalé;
    }

    private String signalementALaPosition(int positionCourante) {
        if(estUneBombe(positionCourante)) return "*";
        return String.valueOf(calculLeNombreDeBombesAProximité(positionCourante));
    }

    private int calculLeNombreDeBombesAProximité(int positionCourante){
        return voisinesDe(positionCourante).stream().reduce(0, compteBombes());

    }

    private BinaryOperator<Integer> compteBombes() {
        return (bombes, position) -> {
            if(estUneBombe(position)) {
                return bombes+1;
            }
            return bombes;
        };
    }

    private List<Integer> voisinesDe(int positionCourante) {
        List<Integer> positionsVoisines = Lists.newArrayList();
        if(positionCourante+1<champ.length()) positionsVoisines.add(positionCourante+1);
        if(positionCourante-1>= 0) positionsVoisines.add(positionCourante-1);
        return positionsVoisines;
    }


    private boolean estUneBombe(int position) {
        return champ.charAt(position)=='*';
    }


    private final String champ;
}
