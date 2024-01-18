package com.lumu.co.steps.validations;

import com.lumu.co.pages.validations.ValidationPage;
import net.thucydides.core.annotations.Step;

public class ValidationStep extends ValidationPage {
    @Step("Validar mensaje de placeholder del textarea")
    public Boolean placeholderVisible(){
        return ph_textarea.isDisplayed();
    }
    @Step("Validar que se muestre correctamente el numero de palabras")
    public Boolean numPalabrasCorrecto(){
        return num_palabras.isDisplayed();
    }

    @Step("Validar que se muestre correctamente el numero de palabras")
    public Boolean numCaracteresCorrecto(){
        return num_caracteres.isDisplayed();
    }

    @Step("Validar que se muestre correctamente el keyword Density 1,2 y 3")
    public Boolean KeywordDensity1_2_3(){
        if (nombre_keyword_density_1.isDisplayed() && nombre_keyword_density_2.isDisplayed() && nombre_keyword_density_3.isDisplayed() ){
            return true;
        }
        System.out.print("********No se muestran las Keyword Density correctamente**********");
        return false;
    }


}
