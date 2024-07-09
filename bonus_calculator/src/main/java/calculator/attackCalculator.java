package calculator;

import java.util.ArrayList;

public class attackCalculator {

    final private ArrayList<attackModifier> bonuses;

    public attackCalculator(ArrayList<attackModifier> bonuses){
        this.bonuses = bonuses;
    }

    public String attackBonusString() {
        int[] bonusTotals = {0,0,0};
        for(int i=0; i < bonuses.size(); i++){
            int[] modifierBonuses = bonuses.get(i).getModifiers();
            bonusTotals[0] += modifierBonuses[0];
            bonusTotals[1] += modifierBonuses[1];
            bonusTotals[2] += modifierBonuses[2];
        }
        String toReturn = "+" + bonusTotals[0] + "/+" + bonusTotals[1] + "/+" + bonusTotals[2];
        return toReturn;
    }

}
