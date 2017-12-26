package model;

import exceptions.InvalidPokeStringException;
import org.junit.Test;

import static factories.PokemonFactory.getPokemon;
import static org.junit.Assert.assertEquals;

public class BreederTest {

    @Test
    public void testSort() {
        Breeder breeder = new Breeder();

        PokeBag myPokeBag = new PokeBag();
        PokeBag opponentPokeBag = new PokeBag();

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


        breeder.setPokeBag(myPokeBag);

        breeder.arrangePokeMons(opponentPokeBag);
        String pokeBagString = "ELECTRIC#12;FIRE#10;PSYCHIC#10;WATER#20;FIGHTING#6";

        assertEquals(pokeBagString, myPokeBag.toString());
    }


}