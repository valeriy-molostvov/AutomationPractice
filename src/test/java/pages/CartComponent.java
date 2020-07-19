package pages;

import com.codeborne.selenide.SelenideElement;

public class CartComponent {
    SelenideElement name;
    SelenideElement price;
    SelenideElement description;
    SelenideElement quantity;
    SelenideElement delete;

    public CartComponent(SelenideElement name, SelenideElement price, SelenideElement description,
                         SelenideElement quantity, SelenideElement delete) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.delete = delete;
    }
}
