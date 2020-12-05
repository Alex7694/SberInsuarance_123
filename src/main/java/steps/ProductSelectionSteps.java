package steps;

import pages.ProductSelectionPage;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class ProductSelectionSteps extends BaseSteps {


    @Step("Нажатие на кнопку Оформить")
    public void checkoutButton() {
        new ProductSelectionPage(driver).checkoutBtn.click();
    }

    @Step("Ожидание загрузки страницы")
    public void waitSendApplickable(WebDriver driver) {
        ProductSelectionPage productSelectionSteps = new ProductSelectionPage(driver);
        productSelectionSteps.waitSendAppClickable(driver);
    }
}
