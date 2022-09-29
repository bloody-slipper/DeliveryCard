import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class DeliveryCard {

    @Test

    void test(){
        Configuration.holdBrowserOpen=true;
        open("http://localhost:9999/");
        $x("//*[@data-test-id=\"city\"]//self::input").setValue("Санкт-Петербург");
        $x("//*[@data-test-id=\"name\"]//self::input").setValue("Алла-Виктория Киркорова");
        $x("//*[@data-test-id=\"phone\"]//self::input").setValue("+79876543210");
        $x("//*[@data-test-id=\"agreement\"]").click();
        $x("//*[@class=\"button__text\"]").click();
        $(withText("Встреча успешно забронирована")).shouldBe(Condition.visible,  Duration.ofSeconds(15));






    }
}
