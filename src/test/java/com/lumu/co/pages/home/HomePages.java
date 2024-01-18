package com.lumu.co.pages.home;


import net.serenitybdd.core.annotations.findby.FindBy;
import  net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomePages extends PageObject {
    @FindBy(id = "box")
    protected WebElementFacade textArea;

}
