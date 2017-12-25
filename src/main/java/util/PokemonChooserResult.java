package util;

import comparator.PokemonCompartor;
import lombok.Data;
import model.Pokemon;

import java.util.ArrayList;
import java.util.List;

public @Data
class PokemonChooserResult {

    PokemonCompartor compartor = new PokemonCompartor();
    private Pokemon opponentPokemon;
    private List<Pokemon> resultList;

    public PokemonChooserResult(Pokemon opponentPokemon) {
        this.opponentPokemon = opponentPokemon;
        this.resultList = new ArrayList<>();
    }

    public boolean add(Pokemon pokemon) {

        if ( (pokemon == null || compartor.compare(pokemon, opponentPokemon) < 0 || !pokemon.isAvailable())) {
            return false;
        }
        return resultList.add(pokemon);
    }

}
