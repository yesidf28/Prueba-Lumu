package com.lumu.co.definitions;

import com.lumu.co.pages.validations.ValidationPage;
import com.lumu.co.steps.home.HomeStep;
import com.lumu.co.steps.validations.ValidationStep;
import com.lumu.co.utilities.website.WebSite;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class HomeDef {
    @Steps(shared = true)
    WebSite url;
    @Steps(shared = true)
    HomeStep home;
    @Steps(shared = true)
    ValidationStep validate;

    @Given("el usuario tiene acceso al sitio web")
    public void ingresarUrl() {
        url.navigateTO("https://wordcounter.net/");
    }
    @When("El placeholder del textarea contiene el texto 'Start typing, or copy and paste your document here...'")
    public void validPlaceholder(){
        home.validPlaceholder();
    }
    @Then("Se muestra el texto en el placeholder.")
    public void muestraPlaceholder(){
        Assert.assertTrue(validate.placeholderVisible());
    }

    @When("Ingresar un texto en el text area que contenga 17 palabras")
    public void ingresarTextoPalabras(){
        home.inputText("Este texto contiene muchas palabras, el numero exacto de palabras se indicará al final del mismo Diecisiete");
    }
    @Then("Se muestra el numero correcto de palabras del texto ingresado en este caso 17")
    public void validarNumPalabras(){
        Assert.assertTrue(validate.numPalabrasCorrecto());
    }

    @When("Ingresar un texto en el text area que contenga 81 caracteres")
    public void ingresarTextoCaracteres(){
        home.inputText("el numero exacto de caracteres se indicará al final del mismo es ochenta y uno 81");
    }
    @Then("Se muestra el numero correcto de caracteres del texto ingresado en este caso 81")
    public void validarNumCaracteres(){
        Assert.assertTrue(validate.numCaracteresCorrecto());
    }

    @When("Ingresar un texto en el text area que contenga palabras repetidas")
    public void ingresarTextoKEywordDensity(){
        home.inputText("compadre compreme un coco, no compadre yo no compro coco, como poco coco como poco coco compro.");
    }
    @Then("Se muestran correctamente las Keyword density")
    public void validarKeywordDensity(){
        Assert.assertTrue(validate.KeywordDensity1_2_3());
    }
}
