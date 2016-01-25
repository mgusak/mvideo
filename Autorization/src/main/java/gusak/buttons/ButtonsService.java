package gusak.buttons;

import java.util.HashMap;
import java.util.Map;


public class ButtonsService {
    public static Map<Buttons, String> buttonsContainer = new HashMap<Buttons, String>();
    public static String getXpath(Buttons button){
        return buttonsContainer.get(button);
    }
}
