package Encrypter;

public class Encrypter {

    public Encrypter() {
        //
    }

    public char encrypt(String plainText) {
        char[] charArray = plainText.toCharArray();
        int[] intArray = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
             intArray[i] = (int) charArray[i];
        }
        double number = (double) intArray[0];
        double powered = Math.pow(number, 5);
        double remainder = (int) powered % 14;
        char r = (char) remainder;
        return r;
    }
}
