package com.lumu.co.pages.validations;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;


public class ValidationPage extends PageObject {

    @FindBy(xpath = "//textarea[@placeholder='Start typing, or copy and paste your document here...']")
    protected WebElementFacade ph_textarea;

    @FindBy(xpath = "//span[contains(text(),'17 words')]")
    protected WebElementFacade num_palabras;

    @FindBy(xpath = "//span[contains(text(),'81 characters')]")
    protected WebElementFacade num_caracteres;

    @FindBy(xpath = "//span[contains(text(),'coco') and //span[contains(text(),'4 (24%)')]]")
    protected WebElementFacade nombre_keyword_density_1;

    @FindBy(xpath = "//span[contains(text(),'compadre') and //span[contains(text(),'2 (12%)')]]")
    protected WebElementFacade nombre_keyword_density_2;

    @FindBy(xpath = "//span[contains(text(),'no') and //span[contains(text(),'2 (12%)')]]")
    protected WebElementFacade nombre_keyword_density_3;
}
