package calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class attackBonusTests 
{
    //tests the modifier getter for base attack modifiers
    @Test
    public void attackModifierReturn(){
        int[] testModifiers = {0,-5,-10};
        AttackModifier atkMod = new AttackModifier(testModifiers);
        int[] target = {0,-5,-10};
        int[] value = atkMod.getModifiers();
        assertArrayEquals(target, value);
    }
    //tests the modifier getter for toggleable attack modifiers
    //tests it if it is on
    @Test
    public void attackModifierReturnTrue(){
        JCheckBox checkBox = Mockito.mock(JCheckBox.class);
        when(checkBox.isSelected()).thenReturn(true);

        int[] testModifiers = {5,5,5};
        AttackModToggle atkMod = new AttackModToggle("", testModifiers,checkBox);
        int[] target = {5,5,5};
        int[] value = atkMod.getModifiers();
        assertArrayEquals(target, value);
    }
    //tests it if it is off
    @Test
    public void attackModifierReturnFalse(){
        JCheckBox checkBox = Mockito.mock(JCheckBox.class);
        when(checkBox.isSelected()).thenReturn(false);

        int[] testModifiers = {5,5,5};
        AttackModToggle atkMod = new AttackModToggle("", testModifiers,checkBox);
        int[] target = {0,0,0};
        int[] value = atkMod.getModifiers();
        assertArrayEquals(target, value);
    }
    //tests getter from a dropdown attack modifier
    @Test
    public void attackModifierDropdown(){
        JComboBox<String> dropdown = Mockito.mock(JComboBox.class);
        when(dropdown.getSelectedItem()).thenReturn("correct");
        Map<String,int[]> testModifiers = new HashMap<>();
        testModifiers.put("wrong", new int[] {10,10,10});
        testModifiers.put("correct", new int[] {0,0,0});

        AttackModDropdown atkMod = new AttackModDropdown("", testModifiers, dropdown);
        int[] target = {0,0,0};
        int[] value = atkMod.getModifiers();
        assertArrayEquals(target, value);
    }
    //tests the final string the attack calculator produces using the attack modifiers
    @Test
    public void calculatorString(){
        ArrayList<AttackModifier> testBonuses = new ArrayList<>();
        testBonuses.add(new AttackModifier(new int[] {10,10,10}));
        testBonuses.add(new AttackModifier(new int[] {0,-5,-10}));
        AttackCalculator atkCalc = new AttackCalculator(testBonuses);
        String target = "+10/+5/+0";
        String value = atkCalc.attackBonusString();
        assertEquals(target, value);
    }
}
