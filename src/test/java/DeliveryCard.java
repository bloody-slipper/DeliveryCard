import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class DeliveryCard {

    @Test

    void shouldDateDeliveryAfter3(){
        Configuration.holdBrowserOpen=true;
        open("http://localhost:9999/");
        $x("//*[@data-test-id=\"city\"]//self::input").setValue("Санкт-Петербург");
        $x("//*[@data-test-id=\"date\"]//self::input").doubleClick().sendKeys(Keys.DELETE);
        String dateDelivery = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $x("//*[@data-test-id=\"date\"]//self::input").setValue(dateDelivery);
        $x("//*[@data-test-id=\"name\"]//self::input").setValue("Алла-Виктория Киркорова");
        $x("//*[@data-test-id=\"phone\"]//self::input").setValue("+79876543210");
        $x("//*[@data-test-id=\"agreement\"]").click();
        $x("//*[@class=\"button__text\"]").click();
        $("[data-test-id=notification]").shouldHave(Condition.text("Успешно! Встреча успешно забронирована на " + dateDelivery),  Duration.ofSeconds(15));

    }

    @Test
    void shouldDateDeliveryAfter5(){
        Configuration.holdBrowserOpen=true;
        open("http://localhost:9999/");
        $x("//*[@data-test-id=\"city\"]//self::input").setValue("Санкт-Петербург");
        $x("//*[@data-test-id=\"date\"]//self::input").doubleClick().sendKeys(Keys.DELETE);
        String dateDelivery = LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $x("//*[@data-test-id=\"date\"]//self::input").setValue(dateDelivery);
        $x("//*[@data-test-id=\"name\"]//self::input").setValue("Алла-Виктория Киркорова");
        $x("//*[@data-test-id=\"phone\"]//self::input").setValue("+79876543210");
        $x("//*[@data-test-id=\"agreement\"]").click();
        $x("//*[@class=\"button__text\"]").click();
        $("[data-test-id=notification]").shouldHave(Condition.text("Успешно! Встреча успешно забронирована на " + dateDelivery),  Duration.ofSeconds(15));

    }
}
