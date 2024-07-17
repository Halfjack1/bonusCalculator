package calculator;

import java.util.Map;

import javax.swing.JComboBox;

public class AttackModDropdown extends AttackModifier{
    JComboBox<String> dropdown;
    Map<String,int[]> modifiers;
    public AttackModDropdown(String name, Map<String,int[]> modifiers, GUI gui){
        super(null);
        this.modifiers = modifiers;
        dropdown = gui.addDropdown(modifiers.keySet().toArray(new String[modifiers.keySet().size()]));
        
    }
    public AttackModDropdown(String name, Map<String,int[]> modifiers, JComboBox<String> dropdown){
        super(null);
        this.modifiers = modifiers;
        this.dropdown = dropdown;
    }

    @Override
    public int[] getModifiers(){
        int[] toReturn = modifiers.get((String) dropdown.getSelectedItem());
        return toReturn;
    }

}
