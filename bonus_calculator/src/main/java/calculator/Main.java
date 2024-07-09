package calculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        GUI gui = new GUI();
        gui.addLabel("test");
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> modifiersList= objectMapper.readValue(new File("modifiers.json"), new TypeReference<Map<String,Object>>(){});
        System.out.println(modifiersList.get("attackModifiers"));
    }
}
