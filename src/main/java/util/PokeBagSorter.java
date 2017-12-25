package util;

import com.google.common.collect.ImmutableList;
import comparator.PokemonCompartor;
import model.PokeBag;
import model.Pokemon;
import model.PokemonType;

import java.util.*;

public class PokeBagSorter{


    public Integer sort(PokeBag myPokeBag, PokeBag opponentPokeBag) {

        PokemonChooser chooser = new PokemonChooser(myPokeBag);

        List<Pokemon> opponentPokemons = opponentPokeBag.getAllPokemons();
        List<Pokemon> sortedPokemon = new ArrayList<>();
        Integer sortScore = 0;
        for(Pokemon pokemon : opponentPokemons){
            PokemonChooserResult aggressivePokemonByType = chooser.findAggressivePokemonByType(pokemon);
            List<Pokemon> aggressivePokemons = aggressivePokemonByType.getResultList();
            aggressivePokemons.get(0).setAvailable(false);
            sortedPokemon.add(aggressivePokemons.get(0));
        }

        myPokeBag.setSortedPokemons(sortedPokemon);
        return sortScore;
    }

}



