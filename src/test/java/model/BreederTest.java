package model;

import exceptions.InvalidPokeStringException;
import factories.PokemonFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class BreederTest {

    @Test
    public void testShouldCreatePokemonAndAddPokemonFromValidString() throws InvalidPokeStringException {
        String pokeMon = "Fire#10";
        Breeder breeder = new Breeder();

        boolean isAdded = breeder.addToBag(pokeMon);

        assertEquals(true,isAdded);
        Pokemon createdPokemon = breeder.getPokeBag().getPokemon(PokemonType.FIRE);
        assertEquals(PokemonType.FIRE,createdPokemon.getType());
        assertEquals(new Integer(10),createdPokemon.getLevel());
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


}