import org.testng.Assert;
import org.testng.annotations.Test;
import views.Views;

public class FirstTest extends BaseTest {

    @Test
    public void checkTextAppearing() {

        Views.mainViewActions.tapAnswBtn();
        Assert.assertFalse(Views.mainViewActions.mainViewElements.getTextViewActive().getText().isEmpty());
    }

    @Test
    public void checkColor() throws Exception {

        Views.mainViewActions.tapBurgerBtn().tapRedColor();
        Assert.assertEquals(Views.helper.getColor(Views.mainViewActions.mainViewElements.getTextViewActive()),
                Views.mainViewActions.mainViewElements.RED);
    }
}
