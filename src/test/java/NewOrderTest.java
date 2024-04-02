import PageObject.OrderPage;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class NewOrderTest {
    private final String newOrderButton;
    private final String fName;
    private final String lName;
    private final String address;
    private final String metroStation;
    private final String phone;
    private final String deliveryDate;
    private final String termRent;
    private final String colourId;
    private final String comment;


    public NewOrderTest(
            String newOrderButton,
            String fName,
            String lName,
            String address,
            String metroStation,
            String phone,
            String deliveryDate,
            String termRent,
            String colourId,
            String comment) {
        this.newOrderButton = newOrderButton;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.deliveryDate = deliveryDate;
        this.termRent = termRent;
        this.colourId = colourId;
        this.comment = comment;
    }
    @Parameterized.Parameters
    public static Object[][] info() {
        return new Object[][] {
            {"up", "Клиент", "Тестовов", "г. Москва ул. Омская д.3", "4", "88005553535", "19", "трое суток", "grey", "Не звонить, стучать"},
            {"down", "Клинт", "Тесовов", "г. Омск ул. Московская д.8", "8", "88005553535", "10", "сутки", "black", "Звонить, не стучать"},
        };
    }
    @Rule
    public DriverRules driverRules = new DriverRules();

    @Test
    public void newOrderTest() {
        OrderPage objOrderPage = new OrderPage(driverRules.getDriver());
        objOrderPage.makeOrder(
                newOrderButton,
                fName,
                lName,
                address,
                metroStation,
                phone,
                deliveryDate,
                termRent,
                colourId,
                comment);
    }
}


