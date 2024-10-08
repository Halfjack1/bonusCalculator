package calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI {
    private final JFrame frame;
    private final JPanel panel;

    AttackCalculator attackCalculator;
    DamageCalculator damageCalculator;

    //constructor that creates the window
    public GUI(){
        frame = new JFrame();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10,30,30,30));
        panel.setLayout(new GridLayout(0,1));

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Erevan Calculator");
        frame.pack();
        frame.setVisible(true);
    }
    //adds a label
    public JLabel addLabel(String text){
        JLabel label = new JLabel(text);
        panel.add(label);
        frame.pack();
        return label;
    }
    //adds a checkbox with text
    public JCheckBox addCheckBox(String text, Boolean defaultState){
        JCheckBox checkBox = new JCheckBox(text);
        checkBox.setSelected(defaultState);
        panel.add(checkBox);
        checkBox.addActionListener(new ActionListener() {
            @Override
            //recalculates the attack and damage when the checkbox is toggled
            public void actionPerformed(ActionEvent event) {
                attackCalculator.attackBonusLabel.setText(attackCalculator.attackBonusString());
                damageCalculator.damageBonusLabel.setText(damageCalculator.damageBonusString());
            }
        });
        frame.pack();
        return checkBox;
    }
    //adds a dropdown
    public JComboBox<String> addDropdown(String[] elements){
        JComboBox<String> dropdown = new JComboBox<>();
        panel.add(dropdown);
        for(String element : elements){
            dropdown.addItem(element);
        }
        dropdown.addActionListener(new ActionListener() {
            @Override
            //recalculates the attack and damage when the dropdown is modified
            public void actionPerformed(ActionEvent event) {
                attackCalculator.attackBonusLabel.setText(attackCalculator.attackBonusString());
                damageCalculator.damageBonusLabel.setText(damageCalculator.damageBonusString());
            }
        });
        frame.pack();
        return dropdown;
    }
    //gives the gui access to the attack calculator
    public void addAttackCalculator(AttackCalculator attackCalculator){
        this.attackCalculator = attackCalculator;
    }
    public void addDamageCalculator(DamageCalculator damageCalculator) {
        this.damageCalculator = damageCalculator;
    }
}
