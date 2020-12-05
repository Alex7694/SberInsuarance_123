package steps;

import pages.RegistrationPage;
import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

public class RegistrationSteps extends BaseSteps {

    @Step("поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value) {
        new RegistrationPage(driver).fillField(field, value);
    }

    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value) {
        String actual = new RegistrationPage(driver).getFillField(field);
        Assert.assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    @Step("заполняются поля:")
    public void stepFillFields(HashMap<String, String> fields) {
        fields.forEach(this::stepFillField);
    }

    @Step("Нажатие на кнопку Оформить онлайн")
    public void stepSendAppButton() {
        new RegistrationPage(driver).continueButton.click();
    }

    @Step("поля заполнены верно")
    public void checkFillFields(HashMap<String, String> fields) {
        fields.forEach((k, v) -> checkFillField(k, v));
    }

    @Step("в поле {0} присутствует сообщение об ошибке {1}")
    public void checkErrorMessageField(String field, String value) {
        new RegistrationPage(driver).checkFieldErrorMessage(field, value);
    }
}

