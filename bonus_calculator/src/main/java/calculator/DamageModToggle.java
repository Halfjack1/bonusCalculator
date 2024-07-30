package calculator;

import javax.swing.JCheckBox;

public class DamageModToggle extends DamageModifier{
    JCheckBox checkBox;
    
    public DamageModToggle(String name, int[] modifier, GUI gui, boolean state){
        super(modifier);
        this.modifier = modifier;
        this.checkBox = gui.addCheckBox(name, state);
    }

    public DamageModToggle(String name, int[] modifier, JCheckBox checkBox) {
        super(modifier);
        this.modifier = modifier;
        this.checkBox = checkBox;
    }

    @Override
    public int[] getModifier() {
        int[] toReturn = {0,0};
        if(checkBox.isSelected()){
            toReturn = modifier;
        }
        return toReturn;
    }
}
