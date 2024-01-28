package views.mainViews;

import views.Views;

public class MainViewActions {
    public MainViewElements mainViewElements = new MainViewElements();

    public MainViewActions tapAnswBtn() {
        mainViewElements.getAnswBtn().click();
        return Views.mainViewActions;
    }

    public MainViewActions tapBurgerBtn() {
        mainViewElements.getBurgerBtn().click();
        return Views.mainViewActions;
    }

    public MainViewActions tapRedColor() {

        mainViewElements.getRedColor().click();
        return Views.mainViewActions;
    }

    public MainViewActions tapGreenColor() {

        mainViewElements.getGreenColor().click();
        return Views.mainViewActions;
    }

    public MainViewActions tapBlueColor() {

        mainViewElements.getBlueColor().click();
        return Views.mainViewActions;
    }
}
