package comparator;

import model.Pokemon;
import model.PokemonType;

import java.util.Comparator;

public class PokemonCompartor implements Comparator<Pokemon> {

    @Override
    public int compare(Pokemon o1, Pokemon o2) {

        if( o2.getLevel() >= (2 * o1.getLevel())) {
            return -1;
        }

        if(o1.getLevel() >= (2 * o2.getLevel())) {
            return 1;
        }

        else if (o1.equals(o2)) {
            return 0;
        } else if (o1.getType() == PokemonType.FIRE && (o2.getType() == PokemonType.GRASS || o2.getType() == PokemonType.GHOST)) {
            return 1;
        } else if (o1.getType() == PokemonType.WATER && o2.getType() == PokemonType.FIRE) {
            return 1;
        } else if (o1.getType() == PokemonType.GRASS && (o2.getType() == PokemonType.ELECTRIC || o2.getType() == PokemonType.FIGHTING)) {
            return 1;
        } else if (o1.getType() == PokemonType.ELECTRIC && o2.getType() == PokemonType.WATER) {
            return 1;
        } else if (o1.getType() == PokemonType.PSYCHIC && o2.getType() == PokemonType.GHOST) {
            return 1;
        } else if (o1.getType() == PokemonType.GHOST && (o2.getType() == PokemonType.FIGHTING
                || o2.getType() == PokemonType.ELECTRIC)) {
            return 1;
        } else if (o1.getType() == PokemonType.FIGHTING && o2.getType() == PokemonType.ELECTRIC){
            return 1;
        }else if( o1.getType() == o2.getType() && o1.getLevel() > o2.getLevel()){
            return 1;
        }

        return -1;
    }
}
