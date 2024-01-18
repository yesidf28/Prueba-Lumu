package com.lumu.co.steps.home;

import com.lumu.co.pages.home.HomePages;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomeStep extends HomePages {

    @Step("Validar Place holder")
    public boolean validPlaceholder (){
        return textArea.isDisplayed();
    }

    @Step("Ingresar texto")
    public void  inputText(String texto){
        textArea.sendKeys(texto);
    }

}
