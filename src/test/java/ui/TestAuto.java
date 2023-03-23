package ui;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import ui.google.CarParameters;
import ui.google.GoogleLink;
import ui.google.LinkSberLeasing;

import static com.codeborne.selenide.Selenide.*;

public class TestAuto extends TestBase {

    GoogleLink google = new GoogleLink();
    CarParameters carParameters = new CarParameters();
    LinkSberLeasing linkSberLeasing = new LinkSberLeasing();


    @Test
    public void pickUpACarForLeasing_Success() {
        //arrange
        open("https://www.google.com/");
        //act
        google.inputGoogle.setValue("СберЛизинг").pressEnter();
        linkSberLeasing.transitionToTheSiteSberLeasing_Success();
        carParameters.buttonSelectByOptions.click();
        carParameters.fillInTheCarParameters("Москва", "Mitsubishi", "L200");
        //assert
        $(".car-card__item-mark").shouldHave(Condition.text("L200"));

    }
}
