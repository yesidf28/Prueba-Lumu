package com.lumu.co.utilities.website;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class WebSite {
    @Steps(shared = true)
    PageObject lumu;
    @Step("Navegar al sitio web")
    public void navigateTO(String url) {
        lumu.setDefaultBaseUrl(url);
        lumu.open();


    }
}
