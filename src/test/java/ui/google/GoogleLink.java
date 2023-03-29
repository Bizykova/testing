package ui.google;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.openqa.selenium.By.className;

public class GoogleLink {
    public SelenideElement inputGoogle = $x("//input[@name='q']");

}
