package model;

import factories.PokemonFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokemonWalletTest {


    @Test
    public void testAddPokemonShouldReturnTrue(){
        //Arrange
        PokemonWallet wallet = new PokemonWallet();
        //Act
        boolean added = wallet.add(PokemonFactory.getPokemon());
        //Assert
        assertEquals(true,added);
    }

    @Test
    public void testShouldBeAbletoGetAddedPokemonByType(){
        //Arrange
        Pokemon pokemon = PokemonFactory.getPokemon();
        PokemonWallet wallet = new PokemonWallet();
        //Act
        boolean isAdded = wallet.add(pokemon);
        //Assert
        assertEquals(true,isAdded);
        assertEquals(pokemon,wallet.getPokemonType(pokemon.getType()));

    }

    @Test
    public void testShouldFalseIfAddMoreThanFivePokemons(){
        //Arrange
        PokemonWallet wallet = new PokemonWallet();
        PokemonFactory.getCollectionOfPokemonForEachType().subList(0,5).forEach(
                pokemon -> {
                    wallet.add(pokemon);
                }
        );

        //Act
        boolean added = wallet.add(PokemonFactory.getPokemon());

        assertEquals(false,added);
        assertEquals(5,wallet.size());
    }

    @Test
    public void testShouldNotAllowTwoPokemonOfSameTypeToBeAdded(){

        //Arrange
        PokemonWallet wallet = new PokemonWallet();
        wallet.add(PokemonFactory.getPokemon(PokemonType.ELECTRIC));

        //Act
        boolean isSameTypeAdded = wallet.add(PokemonFactory.getPokemon(PokemonType.ELECTRIC));

        //Assert
        assertEquals(false,isSameTypeAdded);
    }

}