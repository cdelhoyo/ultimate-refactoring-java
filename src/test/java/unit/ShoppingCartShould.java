package unit;

import implementationChange.Price;
import implementationChange.ShoppingCart;
import org.junit.Assert;
import org.junit.Test;

public class ShoppingCartShould {
    @Test
    public void count_number_of_products() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new Price(10));

        Assert.assertEquals(1, shoppingCart.numberOfProducts());
    }

    @Test
    public void calculate_total_price() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new Price(10));

        Assert.assertEquals(10, shoppingCart.calculateTotalPrice().getPrice());
    }

    @Test
    public void know_when_is_discount_applicable() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new Price(100));

        Assert.assertTrue(shoppingCart.hasDiscount());
    }

    @Test
    public void know_when_is_not_possible_to_apply_discount() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new Price(99));

        Assert.assertFalse(shoppingCart.hasDiscount());
    }

}
