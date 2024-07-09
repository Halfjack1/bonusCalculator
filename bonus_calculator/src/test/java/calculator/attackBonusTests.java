package calculator;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class attackBonusTests 
{
    //tests the modifier getter for base attack modifiers
    @Test
    public void attackModifierReturn(){
        int[] testModifiers = {0,-5,-10};
        attackModifier atkMod = new attackModifier(testModifiers);
        int[] target = {0,-5,-10};
        int[] value = atkMod.getModifiers();
        assertArrayEquals(target, value);
    }
    //tests the final string the attack calculator produces using the attack modifiers
    @Test
    public void calculatorString(){
        ArrayList<attackModifier> testBonuses = new ArrayList<>();
        testBonuses.add(new attackModifier(new int[] {10,10,10}));
        testBonuses.add(new attackModifier(new int[] {0,-5,-10}));
        attackCalculator atkCalc = new attackCalculator(testBonuses);
        String target = "+10/+5/+0";
        String value = atkCalc.attackBonusString();
        assertEquals(target, value);
    }
}
