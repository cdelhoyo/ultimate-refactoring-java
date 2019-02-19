package moveResponsibility;

import java.math.BigDecimal;

public class Invoice {

    public static String calculateNetAmount(String amount, String tax){
        BigDecimal grossAmount = new BigDecimal(amount);
        BigDecimal taxPercentage = new BigDecimal(tax);
        return grossAmount.subtract(
                grossAmount.multiply(
                        taxPercentage.divide(
                                new BigDecimal("100")
                        )))
                .toString();
    }
}
