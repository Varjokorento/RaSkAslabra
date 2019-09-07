package Decryptor;

import java.math.BigDecimal;

public class Decrypter {

    public char decrypt(char a) {
        Double number = Math.pow((double) a, 11);
        Double doubleNumber = number % 14;
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(doubleNumber));
        int intValue = bigDecimal.intValue();
        System.out.println("Double Number: " + bigDecimal.toPlainString());
        System.out.println("Integer Part: " + intValue);
        System.out.println("Decimal Part: " + bigDecimal.subtract(
                new BigDecimal(intValue)).toPlainString());
        return 'a';
    }
}
