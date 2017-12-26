import exceptions.InvalidPokeStringException;
import model.Breeder;
import model.Pokemon;
import model.PokemonType;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PokeGameTest {
    PokeGame game = new PokeGame();

    @Test
    public void testShouldGeneratePokemonsFromValidString() throws InvalidPokeStringException {
        String input = "Fire#10;Water#20;Fighting#6;Psychic#10;Electric#12";
        List<Pokemon> pokemons = game.generatePokemons(input);
        assertNotEquals(null, pokemons);
        assertEquals(5, pokemons.size());
        assertEquals(PokemonType.FIRE, pokemons.get(0).getType());
        assertEquals(PokemonType.WATER, pokemons.get(1).getType());
        assertEquals(PokemonType.FIGHTING, pokemons.get(2).getType());
        assertEquals(PokemonType.PSYCHIC, pokemons.get(3).getType());
        assertEquals(PokemonType.ELECTRIC, pokemons.get(4).getType());

        assertEquals(new Integer(10), pokemons.get(0).getLevel());
        assertEquals(new Integer(20), pokemons.get(1).getLevel());
        assertEquals(new Integer(6), pokemons.get(2).getLevel());
        assertEquals(new Integer(10), pokemons.get(3).getLevel());
        assertEquals(new Integer(12), pokemons.get(4).getLevel());

    }

    @Test(expected = InvalidPokeStringException.class)
    public void testShouldThrowInvalidPokeStringExceptionForInvalidInput() throws InvalidPokeStringException {
        String input = "Fire#10;Water#20Fighting#6Psychic#10Electric#12";
        game.generatePokemons(input);
    }

    @Test
    public void testShouldCreateBreedersForEachInput() throws InvalidPokeStringException {
        String input = "Fire#10;Water#20;Fighting#6;Psychic#10;Electric#12";
        Breeder breeder = game.createBreeder(input);
        assertNotEquals(null, breeder);

        List<Pokemon> pokemons = breeder.getPokeBag().getAllPokemons();

        assertNotEquals(null, pokemons);
        assertEquals(5, pokemons.size());
        assertEquals(PokemonType.FIRE, pokemons.get(0).getType());
        assertEquals(PokemonType.WATER, pokemons.get(1).getType());
        assertEquals(PokemonType.FIGHTING, pokemons.get(2).getType());
        assertEquals(PokemonType.PSYCHIC, pokemons.get(3).getType());
        assertEquals(PokemonType.ELECTRIC, pokemons.get(4).getType());

        assertEquals(new Integer(10), pokemons.get(0).getLevel());
        assertEquals(new Integer(20), pokemons.get(1).getLevel());
        assertEquals(new Integer(6), pokemons.get(2).getLevel());
        assertEquals(new Integer(10), pokemons.get(3).getLevel());
        assertEquals(new Integer(12), pokemons.get(4).getLevel());
    }

    @Test(expected = InvalidPokeStringException.class)
    public void testShouldThrowExceptionForInvalidInput() throws InvalidPokeStringException {
        String input = "Fire#10;Water#20Fighting#6Psychic#10Electric#12";
        Breeder breeder = game.createBreeder(input);
    }


}