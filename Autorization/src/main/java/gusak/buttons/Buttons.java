package gusak.buttons;


public enum Buttons {

      LOGIN("//*[@id=\"login-form\"]/input[3]");


    Buttons(String xpath) {
        ButtonsService.buttonsContainer.put(this, xpath);
    }
}
