package it.prova.model.Utility;

public class NumberUtility {
    public static Integer parseFromStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            return null;
        }
        catch (NullPointerException e1) {
            return null;
        }
    }
}
