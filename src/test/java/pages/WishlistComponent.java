package pages;

import com.codeborne.selenide.SelenideElement;

public class WishlistComponent {
    SelenideElement name;
    SelenideElement quantity;
    SelenideElement created;
    SelenideElement direct_link;
    SelenideElement delete;

    public WishlistComponent(SelenideElement name, SelenideElement quantity, SelenideElement created,
                         SelenideElement direct_link, SelenideElement delete) {
        this.name = name;
        this.quantity = quantity;
        this.created = created;
        this.direct_link = direct_link;
        this.delete = delete;
    }
}