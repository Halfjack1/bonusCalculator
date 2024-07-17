package calculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        GUI gui = new GUI();
        //opens the modifiers file and gets its contents into variables
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> modifiersMap= objectMapper.readValue(new File("modifiers.json"), new TypeReference<Map<String,Object>>(){});
        
        Map<String,Object> attackModifiersMap = objectMapper.convertValue(modifiersMap.get("attackModifiers"), new TypeReference<Map<String, Object>>() {});
        Map<String,int[]> flatAtkModsMap = objectMapper.convertValue(attackModifiersMap.get("flat"), new TypeReference<Map<String, int[]>>() {});
        
        Map<String,Object> toggleAtkModsMap = objectMapper.convertValue(attackModifiersMap.get("toggle"), new TypeReference<Map<String, Object>>() {});
        Map<String,Object> dropdownAtkModsMap = objectMapper.convertValue(attackModifiersMap.get("dropdown"), new TypeReference<Map<String,Object>>() {});

        //list of all attack modifiers
        ArrayList<AttackModifier> attackModifiersList = new ArrayList<>();
        //converts the flat attack modifiers into attackModifier objects and puts them in a list
        for(String i : flatAtkModsMap.keySet()){
            attackModifiersList.add(new AttackModifier(flatAtkModsMap.get(i)));
        }
        //converts the dropdown modifiers into AttackModDropdown objects and adds them to the list
        for(String i : dropdownAtkModsMap.keySet()){
            Map<String,int[]> dropdownAtkModModifiers = objectMapper.convertValue(dropdownAtkModsMap.get(i), new TypeReference<Map<String, int[]>>() {});
            System.out.println(dropdownAtkModModifiers);
            attackModifiersList.add(new AttackModDropdown(i,dropdownAtkModModifiers,gui));
        }
        //converts the toggled attack modifiers into attackModToggle objects and puts them in the list
        for(String i : toggleAtkModsMap.keySet()){
            Map<String,Object> toggleAtkMod = objectMapper.convertValue(toggleAtkModsMap.get(i), new TypeReference<Map<String, Object>>() {});
            int[] toggleAtkModModifiers = objectMapper.convertValue(toggleAtkMod.get("modifiers"),new TypeReference<int[]>() {});
            boolean toggleAtkModState = (boolean) toggleAtkMod.get("state");
            attackModifiersList.add(new AttackModToggle(i, toggleAtkModModifiers, gui, toggleAtkModState));
        }
        //creates an attack bonus calculator using the list of attack bonuses
        AttackCalculator attackCalculator = new AttackCalculator(attackModifiersList, gui);
        gui.addAttackCalculator(attackCalculator);
    }
}
