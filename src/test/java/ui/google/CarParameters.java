package ui.google;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;


public class CarParameters {
    public SelenideElement buttonSelectByOptions = $(".d-none.d-xl-block.text-right > a");
    public SelenideElement cityInput = $("#filter-city .sbl-filter-block__search-string");
    public SelenideElement cityElement = $(".sbl-filter-checkbox");
    public SelenideElement carMarkInput = $("#filter-mark .sbl-filter-block__search-string");
    public SelenideElement carMarkElement = $("[for=arrFilter_248_2795057384]");
    public SelenideElement carModelInput = $("#filter-model .sbl-filter-block__search-string");
    public SelenideElement carModelElement = $("[for='arrFilter_249_3458203964']");
    public SelenideElement privod= $(".horizontal-filter-block__checkboxes");
    public SelenideElement gearbox=$("[for='arrFilter_240_3408718099']");
    public SelenideElement carBodyType = $ (".checkboxes-body-type");
    public SelenideElement enginePower = $(".horizontal-filter-block__property-block .el-slider__button.el-tooltip__trigger.el-tooltip__trigger");
    public SelenideElement colorAuto = $("[placeholder='Выберите или введите']");
    public SelenideElement buttonShowAllOffers = $x ("//a[text()=' Показать все предложения ']");
    public SelenideElement buttonCookie = $("#cookie-warning button");

    public void fillInTheCarParameters(String city,String carMark, String carModel) {
        cityInput.click();
        cityInput.setValue(city);
        actions().moveToElement(cityElement).click().perform();
        carMarkInput.click();
        carMarkInput.setValue(carMark);
        actions().moveToElement(carMarkElement).click().perform();
        carModelInput.click();
        carModelInput.setValue(carModel);
        actions().moveToElement(carModelElement).click().perform();
        privod.find(byText("полный")).click();
        actions().moveToElement(enginePower).clickAndHold().moveByOffset(130,0).release().perform();
        gearbox.click();
        carBodyType.find(byText("пикап")).click();
        colorAuto.setValue("Черный");
        buttonCookie.click();
        actions().moveToElement(buttonShowAllOffers).click().perform();

    }

}
