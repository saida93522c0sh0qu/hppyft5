package sample;

public class JogadaUtils {

    public static int[] IntegerToInt(Integer[] IntegerArray) {
        int[] intArray = new int[IntegerArray.length];
        for (int i = 0; i < intArray.length; i++) {
            Integer integerNumber = IntegerArray[i];
            if (integerNumber != null) {
                intArray[i] = integerNumber;
            } else {
                intArray[i] = -99;
            }
        }
        return intArray;
    }

    public static Integer[] IntToInteger(int[] intArray) {
        Integer[] integerArray = new Integer[intArray.length];
        for (int i = 0; i < integerArray.length; i++) {
            int intNumber = intArray[i];
            if (intNumber != -99) {
                integerArray[i] = intNumber;
            } else {
                integerArray[i] = null;
            }
        }
        return integerArray;
    }
}
