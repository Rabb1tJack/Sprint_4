package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //кнопка "Заказать" (верхняя)
    private final By newOrderButtonUp = By.className("Button_Button__ra12g");

    //кнопка "Заказать" (нижняя)
    private final By newOrderButtonDown = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //поле "Имя"
    private final By firstNameField = By.xpath(".//input[@placeholder='* Имя']");

    //поле "Фамилия"
    private final By lastNameField = By.xpath(".//input[@placeholder='* Фамилия']");

    //поле "Адрес:куда привезти заказ"
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //поле "Станция метро"
    private final By metroField = By.xpath(".//input[@placeholder='* Станция метро']");

    //поле "Телефон: на него позвонит курьер"
    private final By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //кнопка "Далее"
    private final By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");

    //поле "Когда привезти самокат"
    private final By dateDeliveryField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //поле "Срок аренды"
    private final By termRentField = By.xpath(".//div[@class='Dropdown-placeholder']");

    //чекбокс цвета "черный жемчуг"
    private final By blackColourCheckbox = By.id("black");

    //чекбокс цвета "серая безысходность"
    private final By greyColourCheckbox = By.id("grey");

    //поле "Комментарий для курьера"
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //кнопка "Заказать" после заполнения полей
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //кнопка подтверждения заказа "Да"
    private final By yesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    //окно "Заказ оформлен"
    private final By orderSuccess = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");


    public void startNewOrder(String newOrderButton) {
        switch (newOrderButton) {
            case "up":
                driver.findElement(newOrderButtonUp).click();
                break;
            case "down":
                driver.findElement(newOrderButtonDown).click();
                break;
            default:
                break;
        }
    }
    public void inputFirstName(String fName) {
        driver.findElement(firstNameField).sendKeys(fName);
    }
    public void inputLastName(String lName) {
        driver.findElement(lastNameField).sendKeys(lName);
    }
    public void inputAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }
    public void inputMetroStation(String metroStation) {
        driver.findElement(metroField).click();
        driver.findElement(By.xpath(".//li[@data-index='" + metroStation + "']")).click();
    }
    public void inputPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }
    public void nextButtonClick() {
        driver.findElement(nextButton).click();
    }
    public void setDeliveryDate(String deliveryDate) {
        String datePath = ".//div[@class='react-datepicker__day react-datepicker__day--0" + deliveryDate + " react-datepicker__day--weekend' or @class='react-datepicker__day react-datepicker__day--0" + deliveryDate + "']";
        driver.findElement(dateDeliveryField).click();
        driver.findElement(By.xpath(datePath)).click();
    }
    public void setTerm (String termRent) {
        driver.findElement(termRentField).click();
        driver.findElement(By.xpath(".//div[text()='"+ termRent + "']")).click();
    }
    public void clickColourCheckbox(String colourId) {
        switch (colourId) {
            case "black":
                driver.findElement(blackColourCheckbox).click();
                break;
            case "grey":
                driver.findElement(greyColourCheckbox).click();
                break;
            default:
                break;
        }
    }
    public void setCommentField(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }
    public void checkOrderSuccess () {
        new WebDriverWait(driver, java.time.Duration.ofSeconds(5))
            .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(orderSuccess));
    }

    public void makeOrder (String newOrderButton, String fName, String lName, String address, String metroStation, String phone, String deliveryDate, String termRent, String colourId, String comment) {
        startNewOrder(newOrderButton);
        inputFirstName(fName);
        inputLastName(lName);
        inputAddress(address);
        inputMetroStation(metroStation);
        inputPhone(phone);
        nextButtonClick();
        setDeliveryDate(deliveryDate);
        setTerm(termRent);
        clickColourCheckbox(colourId);
        setCommentField(comment);
        clickOrderButton();
        clickYesButton();
        checkOrderSuccess();
    }
}
