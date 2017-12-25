package model;

import factories.PokemonFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokeBagTest {


    @Test
    public void testAddPokemonShouldReturnTrue(){
        //Arrange
        PokeBag bag = new PokeBag();
        //Act
        boolean added = bag.add(PokemonFactory.getPokemon());
        //Assert
        assertEquals(true,added);
    }

    @Test
    public void testShouldBeAbletoGetAddedPokemonByType(){
        //Arrange
        Pokemon pokemon = PokemonFactory.getPokemon();
        PokeBag bag = new PokeBag();
        //Act
        boolean isAdded = bag.add(pokemon);
        //Assert
        assertEquals(true,isAdded);
        assertEquals(pokemon,bag.getPokemon(pokemon.getType()));

    }

    @Test
    public void testShouldFalseIfAddMoreThanFivePokemons(){
        //Arrange
        PokeBag bag = new PokeBag();
        PokemonFactory.getCollectionOfPokemonForEachType().subList(0,5).forEach(
                pokemon -> {
                    bag.add(pokemon);
                }
        );

        //Act
        boolean added = bag.add(PokemonFactory.getPokemon());

        assertEquals(false,added);
        assertEquals(5,bag.size());
    }

    @Test
    public void testShouldNotAllowTwoPokemonOfSameTypeToBeAdded(){

        //Arrange
        PokeBag bag = new PokeBag();
        bag.add(PokemonFactory.getPokemon(PokemonType.ELECTRIC));

        //Act
        boolean isSameTypeAdded = bag.add(PokemonFactory.getPokemon(PokemonType.ELECTRIC));

        //Assert
        assertEquals(false,isSameTypeAdded);
    }

    @Test
    public void testToString(){
        //Arrange
        PokeBag bag = new PokeBag();
        PokemonFactory.getCollectionOfPokemonForEachType().subList(0,5).forEach(
                pokemon -> {
                    bag.add(pokemon);
                }
        );
        String pokeBagString = "FIRE#10;" +
                "WATER#10;" +
                "GRASS#10;" +
                "ELECTRIC#10;" +
                "PSYCHIC#10";

        //Act
        boolean added = bag.add(PokemonFactory.getPokemon());

        assertEquals(pokeBagString,bag.toString());

    }

}