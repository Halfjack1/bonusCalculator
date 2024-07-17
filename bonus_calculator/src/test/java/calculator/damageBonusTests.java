package calculator;

import java.util.ArrayList;

import javax.swing.JCheckBox;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class damageBonusTests {
    //tests the modifier getter for base damage modifiers
    @Test
    public void damageModifierReturn(){
        int[] testModifier = {3,6};
        DamageModifier damageModifier = new DamageModifier(testModifier);
        int[] target = {3,6};
        int[] value = damageModifier.getModifier();
        assertArrayEquals(target, value);
    }
    //tests the modifier getter for toggleable damage modifiers
    //tests it if it is on
    @Test
    public void damageModifierReturnTrue(){
        JCheckBox checkBox = Mockito.mock(JCheckBox.class);
        when(checkBox.isSelected()).thenReturn(true);
        int[] testModifier = {3,6};

        DamageModToggle damageModifier = new DamageModToggle("",testModifier,checkBox);
        int[] target = {3,6};
        int[] value = damageModifier.getModifier();
        assertArrayEquals(target, value);
    }
    //tests it if it is off
    public void damageModifierReturnFalse(){
        JCheckBox checkBox = Mockito.mock(JCheckBox.class);
        when(checkBox.isSelected()).thenReturn(false);
        int[] testModifier = {3,6};

        DamageModToggle damageModifier = new DamageModToggle("",testModifier,checkBox);
        int[] target = {0,0};
        int[] value = damageModifier.getModifier();
        assertArrayEquals(target, value);
    }
    //tests final string damage calculator produces using the damage modifiers
    @Test
    public void calculatorString(){
        ArrayList<DamageModifier> testBonuses = new ArrayList<> ();
        testBonuses.add(new DamageModifier(new int[] {3,6}));
        testBonuses.add(new DamageModifier(new int[] {5,1}));
        DamageCalculator dmgCalc = new DamageCalculator(testBonuses);
        String target = "3d6+5";
        String value = dmgCalc.damageBonusString();
        assertEquals(target,value);
    }
}
