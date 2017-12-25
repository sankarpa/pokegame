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
            sortScore+=aggressivePokemonByType.getScore();
            List<Pokemon> aggressivePokemons = aggressivePokemonByType.getResultList();
            Pokemon chosenPokemon = aggressivePokemons.get(0);
            chosenPokemon.setAvailable(false);
            printMessage(pokemon, aggressivePokemonByType, chosenPokemon);
            sortedPokemon.add(chosenPokemon);
        }

        myPokeBag.setSortedPokemons(sortedPokemon);
        System.out.print("Sort Score:"+ sortScore+"/"+opponentPokemons.size());
        if(sortScore >= 3){
            System.out.print(" - Possible Victory");
        }else{
            System.out.print(" - No Chance to win");
        }
        return sortScore;
    }

    private void printMessage(Pokemon pokemon, PokemonChooserResult aggressivePokemonByType, Pokemon chosenPokemon) {

        if( aggressivePokemonByType.getScore() > 0){
            System.out.println(chosenPokemon.getType() +" pokemon with level "+chosenPokemon.getLevel()+" " +
                    "has advantage over "+pokemon.getType() +" with level "+pokemon.getLevel());

        }else if( aggressivePokemonByType.getScore() == 0){
            System.out.println(chosenPokemon.getType() +" pokemon with level "+chosenPokemon.getLevel()+" " +
                    "may have advantage over "+pokemon.getType() +" with level "+pokemon.getLevel());
        }else{
            System.out.println(chosenPokemon.getType() +" pokemon with level "+chosenPokemon.getLevel()+" " +
                    "does not have advantage over "+pokemon.getType() +" with level "+pokemon.getLevel());
        }
    }

}



