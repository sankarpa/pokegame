package util;

import factories.PokemonFactory;
import model.PokeBag;
import model.Pokemon;
import model.PokemonType;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static factories.PokemonFactory.*;
import static org.junit.Assert.*;


public class PokeBagSorterTest {

    private  PokeBag myPokeBag = new PokeBag();
    private  PokeBag opponentPokeBag = new PokeBag();

    @Before
    public  void populatePokeBags(){
        Pokemon firePokemon = getPokemon(PokemonType.FIRE);
        Pokemon fightingPokemon = getPokemon(PokemonType.FIGHTING);
        Pokemon waterPokemon = getPokemon(PokemonType.WATER);
        Pokemon psychicPokemon = getPokemon(PokemonType.PSYCHIC);
        Pokemon electricPokemon = getPokemon(PokemonType.ELECTRIC);

        waterPokemon.setLevel(20);
        fightingPokemon.setLevel(6);
        electricPokemon.setLevel(12);

        myPokeBag.add(firePokemon);
        myPokeBag.add(waterPokemon);
        myPokeBag.add(fightingPokemon);
        myPokeBag.add(psychicPokemon);
        myPokeBag.add(electricPokemon);

        firePokemon = getPokemon(PokemonType.FIRE);
        fightingPokemon = getPokemon(PokemonType.FIGHTING);
        waterPokemon = getPokemon(PokemonType.WATER);
        psychicPokemon = getPokemon(PokemonType.PSYCHIC);
        Pokemon grassPokemon = getPokemon(PokemonType.GRASS);

        waterPokemon.setLevel(10);
        fightingPokemon.setLevel(10);
        firePokemon.setLevel(12);
        grassPokemon.setLevel(2);

        opponentPokeBag.add(waterPokemon);
        opponentPokeBag.add(fightingPokemon);
        opponentPokeBag.add(psychicPokemon);
        opponentPokeBag.add(firePokemon);
        opponentPokeBag.add(grassPokemon);

    }

    @Test
    public void testCase1Sort(){
        PokeBagSorter sorter = new PokeBagSorter();
        Integer score = sorter.sort(myPokeBag,opponentPokeBag);
        String pokeBagString = "ELECTRIC#12;FIRE#10;PSYCHIC#10;WATER#20;FIGHTING#6";
        assertEquals(pokeBagString,myPokeBag.toString());
        assertEquals(new Integer(3),new Integer(score));

    }

}