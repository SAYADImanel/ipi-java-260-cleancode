import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class BowlingGameTest {
	
	//frame comprend 10 lancers
	//fait tomber 10 : strike
	//fait tomber 10 en 2 lancers : spare
	//si on a un strike alors il reste 9 frames.

    BowlingGame game = new BowlingGame();

    @Test
    public void queDesGoutieresDonne0Points() {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    public void uneSeuleQuille(){
    	//1 lancer et 1 seule quille
    	game.roll(1);
        //19 lancers avec 0 quilles
        rollMany(19, 0);
        assertEquals(1, game.score());
    }

    @Test
    public void bonusDuSpare(){
    	//1 lancer et 8 quilles
        game.roll(8);
        //1 lancer et 2 quilles
        game.roll(2);
        //1 lancer et une quille
        game.roll(1);
        //17 lancers avec 0 quille
        rollMany(17, 0);
        //normalement 11 mais on ajoute 1 du troisieme lancer donne 12.
        assertEquals(12, game.score());
    }
    
    @Test
    public void doubleStrike() {
    game.roll(10);
   
   game.roll(10);
    
    game.roll(5);
    game.roll(4);
    rollMany(14,0);
    assertEquals(53,game.score());
    	
    	
    	
    }
    
    // spare  bonus : ajoute le score du prochain lancer.
    
    @Test
    public void deuxQuilles() {
    game.roll(2);
    rollMany(19, 0);
    assertEquals(2, game.score());
    
    }
    
    
    @Test
    public void PlusqueDixQuilles() {
    CoupInvalideException plus = null;
    try {
    game.roll(15);
    }
    
    catch (CoupInvalideException dix) {
    plus = dix;
    }
    
    assertNotNull(plus);
    	
    	
    }
    
    @Test
    public void nombreQuillesNegatif() {
    CoupInvalideException negatif = null;
    
  try {
    game.roll(-1);
   } 
    
    catch (CoupInvalideException erreur) {
    
    negatif = erreur;	
    
    }
   
  	assertNotNull(negatif);
    	
    }
    
   
    @Test
    public void deuxLances() {
    CoupInvalideException nombre = null;
    try {
        game.roll(7);
        game.roll(6);
       } 
    catch (CoupInvalideException erreur1) {
        
        nombre = erreur1;	
        
        }
    assertNotNull(nombre);
    	
    }

    
    
    private void rollMany(int numberRolls, int numberPins) {
        for (int i = 0; i < numberRolls; i++) {
            game.roll(numberPins);
        }
        
        //plus que 10 quilles est une errure
    }
 
    
    
    
}
