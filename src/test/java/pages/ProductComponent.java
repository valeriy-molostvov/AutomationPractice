package pages;

import com.codeborne.selenide.SelenideElement;

public class ProductComponent {
    SelenideElement name;
    SelenideElement price;
    SelenideElement addToCart;
    SelenideElement more;
    SelenideElement addToWishlist;

    public ProductComponent(SelenideElement name, SelenideElement price, SelenideElement addToCart,
                            SelenideElement more, SelenideElement addToWishlist) {
        this.name = name;
        this.price = price;
        this.addToCart = addToCart;
        this.more = more;
        this.addToWishlist = addToWishlist;
    }
}
