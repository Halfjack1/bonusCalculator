package calculator;

import javax.swing.JCheckBox;

public class AttackModToggle extends AttackModifier{
    JCheckBox checkBox;
    int[] modifiers;

    public AttackModToggle(String name, int[] modifiers, GUI gui, boolean state){
        super(modifiers);
        this.modifiers = modifiers;
        this.checkBox = gui.addCheckBox(name, state);
    }
    public AttackModToggle(String name, int[] modifiers, JCheckBox checkBox){
        super(modifiers);
        this.modifiers = modifiers;
        this.checkBox = checkBox;
    }
    @Override
    public int[] getModifiers() {
        int[] toReturn = {0,0,0};
        if(checkBox.isSelected()){
            toReturn = modifiers;
        }
        return toReturn;
    }
}
