package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JLabel;

public final class DamageCalculator {

    final private ArrayList<DamageModifier> bonuses;
    JLabel damageBonusLabel;

    DamageCalculator(ArrayList<DamageModifier> bonuses, GUI gui) {
        this.bonuses = bonuses;
        damageBonusLabel = gui.addLabel(damageBonusString());
    }
    public DamageCalculator(ArrayList<DamageModifier> bonuses){
        this.bonuses = bonuses;
    }

    String damageBonusString() {
        String toReturn = "";
        Map<Integer, Integer> damageDice = this.getDamageDice();
        for (Map.Entry<Integer, Integer> entry : damageDice.entrySet()) {
            int dieType = entry.getKey();
            int dieNumber = entry.getValue();
            if(dieNumber != 0){
                if(dieType != 1){
                    toReturn += dieNumber;  
                    toReturn += "d";
                    toReturn += dieType;
                }else{
                    toReturn += dieNumber;
                }

                toReturn += "+";
            }
        }
        //cuts the + off the end
        toReturn = toReturn.substring(0,toReturn.length()-1);
        return toReturn;
    }

    //loops through all damage bonuses and totals the numbers of dice by their types
    Map<Integer, Integer> getDamageDice(){
        //sorts in reverse order
        Map<Integer, Integer> damageDice = new TreeMap<>(Collections.reverseOrder());
        for(DamageModifier dmgSrc : bonuses) {
            int[] damageBonus = dmgSrc.getModifier();
            int dieNumber = damageBonus[0];
            int dieType = damageBonus[1];
            if(damageDice.containsKey(dieType)){
                damageDice.put(dieType, dieNumber + damageDice.get(dieType));
            }else{
                damageDice.put(dieType, dieNumber);
            }
        }
        return damageDice;
    }
}
