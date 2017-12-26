package util;

import factories.PokemonFactory;
import model.PokeBag;
import model.Pokemon;
import model.PokemonType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static factories.PokemonFactory.getPokemon;
import static org.junit.Assert.*;

public class PokemonChooserTest {

    private static PokeBag myPokeBag = new PokeBag();
    private static PokeBag myPokeBag2 = new PokeBag();


    @BeforeClass
    public static void populatePokeBag() {

        Pokemon firePokemon = getPokemon(PokemonType.FIRE);
        Pokemon fightingPokemon = getPokemon(PokemonType.FIGHTING);
        Pokemon waterPokemon = getPokemon(PokemonType.WATER);
        Pokemon psychicPokemon = getPokemon(PokemonType.PSYCHIC);
        Pokemon electricPokemon = getPokemon(PokemonType.ELECTRIC);
        Pokemon ghostPokemon = getPokemon(PokemonType.GHOST);


        waterPokemon.setLevel(20);
        fightingPokemon.setLevel(6);
        electricPokemon.setLevel(12);

        myPokeBag.add(firePokemon);
        myPokeBag.add(waterPokemon);
        myPokeBag.add(fightingPokemon);
        myPokeBag.add(psychicPokemon);
        myPokeBag.add(electricPokemon);

        Pokemon grassPokemon = getPokemon(PokemonType.GRASS);
        myPokeBag2.add(grassPokemon);
        myPokeBag2.add(ghostPokemon);
        myPokeBag2.add(waterPokemon);
        myPokeBag2.add(fightingPokemon);


    }

    @Test
    public void testShouldChooseAndReturnElectricAndWaterPokemonForWaterTypeFromPokeBag() {
        Pokemon pokemon = PokemonFactory.getPokemon(PokemonType.WATER);
        PokemonChooser chooser = new PokemonChooser(myPokeBag);
        List<Pokemon> aggressivePokemon = chooser.findAggressivePokemonByType(pokemon).getResultList();
        assertEquals(2, aggressivePokemon.size());
        assertEquals(PokemonType.ELECTRIC, aggressivePokemon.get(0).getType());
        assertEquals(PokemonType.WATER, aggressivePokemon.get(1).getType());

    }

    @Test
    public void testShouldChooseAndReturnFirePokemonForGrassTypeFromPokeBag() {
        Pokemon pokemon = PokemonFactory.getPokemon(PokemonType.GRASS);
        PokemonChooser chooser = new PokemonChooser(myPokeBag);
        List<Pokemon> aggressivePokemon = chooser.findAggressivePokemonByType(pokemon).getResultList();
        assertEquals(1, aggressivePokemon.size());
        assertEquals(PokemonType.FIRE, aggressivePokemon.get(0).getType());
    }

    @Test
    public void testShouldChooseAndReturnFirePokemonForGhostTypeFromPokeBag() {
        Pokemon pokemon = PokemonFactory.getPokemon(PokemonType.GHOST);
        PokemonChooser chooser = new PokemonChooser(myPokeBag);
        List<Pokemon> aggressivePokemon = chooser.findAggressivePokemonByType(pokemon).getResultList();
        assertEquals(2, aggressivePokemon.size());
        assertEquals(PokemonType.FIRE, aggressivePokemon.get(0).getType());
    }

    @Test
    public void testShouldChooseAndReturnGrassAndGhostAndFightingPokemonForElectricTypeFromPokeBag() {
        Pokemon pokemon = PokemonFactory.getPokemon(PokemonType.ELECTRIC);
        PokemonChooser chooser = new PokemonChooser(myPokeBag2);
        List<Pokemon> aggressivePokemon = chooser.findAggressivePokemonByType(pokemon).getResultList();
        assertEquals(3, aggressivePokemon.size());
        assertEquals(PokemonType.GRASS, aggressivePokemon.get(0).getType());
        assertEquals(PokemonType.GHOST, aggressivePokemon.get(1).getType());
        assertEquals(PokemonType.FIGHTING, aggressivePokemon.get(2).getType());

    }

    @Test
    public void testShouldChooseAndReturnGrassAndGhostPokemonForFightingTypeFromPokeBag() {
        Pokemon pokemon = PokemonFactory.getPokemon(PokemonType.FIGHTING);
        PokemonChooser chooser = new PokemonChooser(myPokeBag2);
        List<Pokemon> aggressivePokemon = chooser.findAggressivePokemonByType(pokemon).getResultList();
        assertEquals(2, aggressivePokemon.size());
        assertEquals(PokemonType.GRASS, aggressivePokemon.get(0).getType());
        assertEquals(PokemonType.GHOST, aggressivePokemon.get(1).getType());

    }

    @Test
    public void testShouldChooseAndReturnPsychicAndFirePokemonForGhostTypeFromPokeBag() {
        Pokemon pokemon = PokemonFactory.getPokemon(PokemonType.GHOST);
        PokemonChooser chooser = new PokemonChooser(myPokeBag);
        List<Pokemon> aggressivePokemon = chooser.findAggressivePokemonByType(pokemon).getResultList();
        assertEquals(2, aggressivePokemon.size());
        assertEquals(PokemonType.FIRE, aggressivePokemon.get(0).getType());
        assertEquals(PokemonType.PSYCHIC, aggressivePokemon.get(1).getType());
    }

    @Test
    public void testShouldChooseAndReturnWaterPokemonForFireTypeFromPokeBag() {
        Pokemon pokemon = PokemonFactory.getPokemon(PokemonType.FIRE);
        PokemonChooser chooser = new PokemonChooser(myPokeBag2);
        List<Pokemon> aggressivePokemon = chooser.findAggressivePokemonByType(pokemon).getResultList();
        assertEquals(1, aggressivePokemon.size());
        assertEquals(PokemonType.WATER, aggressivePokemon.get(0).getType());
    }

    @Test
    public void testShouldReturnHigherLevelPokemonIfAggressionTypeisNotPresent() {
        Pokemon pokemon = PokemonFactory.getPokemon(PokemonType.WATER);
        PokemonChooser chooser = new PokemonChooser(myPokeBag2);
        List<Pokemon> aggressivePokemon = chooser.findAggressivePokemonByType(pokemon).getResultList();
        assertEquals(1, aggressivePokemon.size());
        assertNotEquals(PokemonType.ELECTRIC, aggressivePokemon.get(0).getType());
        assertTrue(pokemon.getLevel() < aggressivePokemon.get(0).getLevel());
    }

    @Test
    public void testShouldReturnElectricPokemonForWaterPokemon() {
        Pokemon pokemon = PokemonFactory.getPokemon(PokemonType.WATER);
        PokemonChooser chooser = new PokemonChooser(myPokeBag);
        List<Pokemon> aggressivePokemon = chooser.findAggressivePokemonByType(pokemon).getResultList();
        assertEquals(PokemonType.ELECTRIC, aggressivePokemon.get(0).getType());
        assertEquals(new Integer(12), new Integer(aggressivePokemon.get(0).getLevel()));
    }

    @Test
    public void testShouldReturnFirePokemonForFighting() {
        Pokemon pokemon = PokemonFactory.getPokemon(PokemonType.FIGHTING);
        PokemonChooser chooser = new PokemonChooser(myPokeBag);
        List<Pokemon> aggressivePokemon = chooser.findAggressivePokemonByType(pokemon).getResultList();
        assertEquals(PokemonType.FIRE, aggressivePokemon.get(0).getType());
        assertEquals(new Integer(10), new Integer(aggressivePokemon.get(0).getLevel()));
    }

    @Test
    public void testShouldReturnPsychicPokemonForPsychicOfEqualLevel() {
        Pokemon pokemon = PokemonFactory.getPokemon(PokemonType.PSYCHIC);
        PokemonChooser chooser = new PokemonChooser(myPokeBag);
        List<Pokemon> aggressivePokemon = chooser.findAggressivePokemonByType(pokemon).getResultList();
        assertEquals(PokemonType.PSYCHIC, aggressivePokemon.get(0).getType());
        assertEquals(new Integer(10), new Integer(aggressivePokemon.get(0).getLevel()));
    }

    @Test
    public void testShouldReturnWaterPokemonForFire() {
        Pokemon pokemon = PokemonFactory.getPokemon(PokemonType.FIRE);
        pokemon.setLevel(12);
        PokemonChooser chooser = new PokemonChooser(myPokeBag);
        List<Pokemon> aggressivePokemon = chooser.findAggressivePokemonByType(pokemon).getResultList();
        assertEquals(PokemonType.WATER, aggressivePokemon.get(0).getType());
        assertEquals(new Integer(20), new Integer(aggressivePokemon.get(0).getLevel()));
    }

}