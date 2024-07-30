package calculator;

import java.util.Map;

import javax.swing.JComboBox;

public class DamageModDropdown extends DamageModifier {
    JComboBox<String> dropdown;
    Map<String,int[]> modifiers;

    DamageModDropdown(String name, Map<String, int[]> modifiers, GUI gui) {
        super(null);
        this.modifiers = modifiers;
        dropdown = gui.addDropdown(modifiers.keySet().toArray(new String[modifiers.keySet().size()]));
    }

    DamageModDropdown(String name, Map<String, int[]> modifiers, JComboBox<String> dropdown) {
        super(null);
        this.modifiers = modifiers;
        this.dropdown = dropdown;
    }
    @Override
    public int[] getModifier(){
        int[] toReturn = modifiers.get((String) dropdown.getSelectedItem());
        return toReturn;
    }

}
