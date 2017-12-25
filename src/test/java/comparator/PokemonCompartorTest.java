package comparator;

import factories.PokemonFactory;
import model.Pokemon;
import model.PokemonType;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokemonCompartorTest {

    public PokemonCompartor pokemonCompartor = new PokemonCompartor();

    @Test
    public void testShouldReturnEqual(){
        Pokemon pokemon1 = PokemonFactory.getPokemon();
        Pokemon pokemon2 = PokemonFactory.getPokemon();
        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(0,result);
    }

    @Test
    public void testShouldReturnOneWhenFirePokemonComparedWithGrass(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.FIRE);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.GRASS);
        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(1,result);
    }

    @Test
    public void testShouldReturnOneWhenFirePokemonComparedWithGhost(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.FIRE);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.GHOST);
        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(1,result);
    }

    @Test
    public void testShouldReturnOneWhenWaterPokemonComparedWithFire(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.WATER);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.FIRE);
        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(1,result);
    }

    @Test
    public void testShouldReturnOneWhenGrassPokemonComparedWithElectric(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.GRASS);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.ELECTRIC);
        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(1,result);
    }

    @Test
    public void testShouldReturnOneWhenGrassPokemonComparedWithFighting(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.GRASS);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.FIGHTING);
        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(1,result);
    }

    @Test
    public void testShouldReturnOneWhenElectricPokemonComparedWithWater(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.ELECTRIC);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.WATER);
        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(1,result);
    }

    @Test
    public void testShouldReturnOneWhenPsychicPokemonComparedWithGhost(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.PSYCHIC);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.GHOST);
        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(1,result);
    }

    @Test
    public void testShouldReturnOneWhenGhostPokemonComparedWithFighting(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.GHOST);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.FIGHTING);
        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(1,result);
    }

    @Test
    public void testShouldReturnOneWhenGhostPokemonComparedWithElectric(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.GHOST);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.ELECTRIC);
        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(1,result);
    }

    @Test
    public void testShouldReturnOneWhenFightingPokemonComparedWithElectric(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.FIGHTING);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.ELECTRIC);
        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(1,result);
    }

    @Test
    public void testShouldReturnMinusOneWhenElectricPokemonComparedWithFighting(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.ELECTRIC);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.FIGHTING);
        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(-1,result);
    }

    @Test
    public void testShouldReturnMinusOneWhenGrassPokemonComparedWithFire(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.GRASS);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.FIRE);
        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(-1,result);
    }

    @Test
    public void testShouldReturnMinusOneWhenFirePokemonComparedWithWater(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.FIRE);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.WATER);
        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(-1,result);
    }

    @Test
    public void testShouldReturnMinusOneWhenElectricPokemonComparedWithGrass(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.ELECTRIC);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.GRASS);
        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(-1,result);
    }

    @Test
    public void testShouldReturnMinusOneWhenFightingPokemonComparedWithGrass(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.FIGHTING);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.GRASS);
        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(-1,result);
    }

    @Test
    public void testShouldReturnMinusOneWhenWaterPokemonComparedWithElectric(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.WATER);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.ELECTRIC);
        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(-1,result);
    }

    @Test
    public void testShouldReturnMinusOneWhenGhostPokemonComparedWithPsychic(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.GHOST);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.PSYCHIC);
        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(-1,result);
    }

    @Test
    public void testShouldReturnMinusOneWhenFightingPokemonComparedWithGhost(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.FIGHTING);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.GHOST);
        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(-1,result);
    }

    @Test
    public void testShouldReturnMinusOneWhenGhostPokemonComparedWithElectric(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.ELECTRIC);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.GHOST);
        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(-1,result);
    }

    @Test
    public void testShouldReturnMinusOneWhenFirePokemonComparedWithGrassPokemonOf2xLevel(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.FIRE);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.GRASS);
        pokemon2.setLevel(2 * pokemon1.getLevel());
        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(-1,result);
    }

    @Test
    public void testShouldReturnMinusOneWhenFirePokemonComparedWithGhostOf2xLevel(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.FIRE);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.GHOST);
        pokemon2.setLevel(2 * pokemon1.getLevel());
        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(-1,result);
    }

    @Test
    public void testShouldReturnMinusOneWhenWaterPokemonComparedWithFireOf2xLevel(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.WATER);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.FIRE);
        pokemon2.setLevel(2 * pokemon1.getLevel());
        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(-1,result);
    }

    @Test
    public void testShouldReturnMinusOneWhenGrassPokemonComparedWithElectricOf2xLevel(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.GRASS);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.ELECTRIC);
        pokemon2.setLevel(2 * pokemon1.getLevel());
        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(-1,result);
    }

    @Test
    public void testShouldReturnMinusOneWhenGrassPokemonComparedWithFightingOf2xLevel(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.GRASS);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.FIGHTING);
        pokemon2.setLevel(2 * pokemon1.getLevel());

        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(-1,result);
    }

    @Test
    public void testShouldReturnMinusOneWhenElectricPokemonComparedWithWaterOf2xLevel(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.ELECTRIC);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.WATER);
        pokemon2.setLevel(2 * pokemon1.getLevel());

        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(-1,result);
    }

    @Test
    public void testShouldReturnOneWhenElectricPokemonOfHigherLevelComparedWithElectricWithLowerLevel(){
        Pokemon pokemon1 = PokemonFactory.getPokemon(PokemonType.ELECTRIC);
        Pokemon pokemon2 = PokemonFactory.getPokemon(PokemonType.ELECTRIC);
        pokemon1.setLevel(2 * pokemon1.getLevel());

        int result = pokemonCompartor.compare(pokemon1,pokemon2);
        assertEquals(1,result);
    }

}