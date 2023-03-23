package ui.google;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

public class LinkSberLeasing {
    public void transitionToTheSiteSberLeasing_Success() {
        actions().moveToElement($x("//h3[text()='СберЛизинг — официальный сайт лизинговой компании ...']")).click().perform();
    }

}
