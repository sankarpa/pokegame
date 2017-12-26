package model;

import exceptions.InvalidPokeStringException;
import org.junit.Test;

import static factories.PokemonFactory.getPokemon;
import static org.junit.Assert.assertEquals;

public class BreederTest {

    @Test
    public void testShouldCreatePokemonAndAddPokemonFromValidString() throws InvalidPokeStringException {
        String pokeMon = "Fire#10";
        Breeder breeder = new Breeder();

        boolean isAdded = breeder.addToBag(pokeMon);

        assertEquals(true, isAdded);
        Pokemon createdPokemon = breeder.getPokeBag().getPokemon(PokemonType.FIRE);
        assertEquals(PokemonType.FIRE, createdPokemon.getType());
        assertEquals(new Integer(10), createdPokemon.getLevel());
    }

    @Test(expected = InvalidPokeStringException.class)
    public void testShouldThrowInvalidPokeStringExceptionIfStringIsInvalid() throws InvalidPokeStringException {
        String pokeMon = "Fire10";
        Breeder breeder = new Breeder();
        boolean isAdded = breeder.addToBag(pokeMon);
    }

    @Test(expected = InvalidPokeStringException.class)
    public void testShouldThrowInvalidPokeStringExceptionStringIsEmpty() throws InvalidPokeStringException {
        String pokeMon = "";
        Breeder breeder = new Breeder();
        boolean isAdded = breeder.addToBag(pokeMon);
    }

    @Test(expected = InvalidPokeStringException.class)
    public void testShouldThrowInvalidPokeStringExceptionStringIsNull() throws InvalidPokeStringException {
        String pokeMon = null;
        Breeder breeder = new Breeder();
        boolean isAdded = breeder.addToBag(pokeMon);
    }

    @Test(expected = InvalidPokeStringException.class)
    public void testShouldThrowInvalidPokeStringExceptionStringIfLevelIsNotPresentInString() throws InvalidPokeStringException {
        String pokeMon = "Fire#";
        Breeder breeder = new Breeder();
        boolean isAdded = breeder.addToBag(pokeMon);
    }

    @Test(expected = InvalidPokeStringException.class)
    public void testShouldThrowInvalidPokeStringExceptionStringIfThereIsSpaceInString() throws InvalidPokeStringException {
        String pokeMon = "Fire# 10";
        Breeder breeder = new Breeder();
        boolean isAdded = breeder.addToBag(pokeMon);
    }

    @Test(expected = InvalidPokeStringException.class)
    public void testShouldThrowInvalidPokeStringExceptionStringIfTypeIsNotPresentInString() throws InvalidPokeStringException {
        String pokeMon = "#10";
        Breeder breeder = new Breeder();
        boolean isAdded = breeder.addToBag(pokeMon);
    }

    @Test(expected = InvalidPokeStringException.class)
    public void testShouldThrowInvalidPokeStringExceptionStringIfInvalidPokeTypeIsPresentInString() throws InvalidPokeStringException {
        String pokeMon = "India#10";
        Breeder breeder = new Breeder();
        boolean isAdded = breeder.addToBag(pokeMon);
    }

    @Test(expected = InvalidPokeStringException.class)
    public void testShouldThrowInvalidPokeStringExceptionStringIfInvalidLeveIsPresentInString() throws InvalidPokeStringException {
        String pokeMon = "India#India";
        Breeder breeder = new Breeder();
        boolean isAdded = breeder.addToBag(pokeMon);
    }

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