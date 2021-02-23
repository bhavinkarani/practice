package nl.ing.api.cash.order.temp;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormater {
    public static void main(String args[]){
        String s = "-400000";
        double d = Double.valueOf(s);
        String amount = String.format("%,.2f", Double.valueOf(400000));
        System.out.println(amount);
        //Using numberFormater
        Double number = 150000D;
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CANADA);
        String currency = format.format(d);
        System.out.println("Currency in Canada : " + currency);
        format = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        currency = format.format(d);
        System.out.println("Currency in Germany: " + currency);

        //using decimalFormat
        s = "450000";
        double euros = Double.parseDouble(s);
        DecimalFormat df = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setCurrencySymbol("");
        dfs.setMonetaryDecimalSeparator(',');
        dfs.setGroupingSeparator('.');
        df.setDecimalFormatSymbols(dfs);
        String k = df.format(d);

        System.out.println("specific Currency :" + k);

        System.out.println("specific Currency :" + df.format(euros));
    }
}
