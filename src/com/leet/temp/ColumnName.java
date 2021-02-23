package nl.ing.api.cash.order.temp;

public class ColumnName {
    public static void main(String args[]){
        System.out.println(getColumnName(25));
        System.out.println(getColumnName(28));
        System.out.println(getColumnName(52));
        System.out.println(getColumnName(53));
        System.out.println(getColumnName(78));
        System.out.println(getColumnName(79));
        System.out.println(getColumnName(520));
        System.out.println(getColumnName(2600));
        System.out.println(getColumnName(10000));
        System.out.println(getColumnName(676));
        System.out.println(getColumnName(702));
        System.out.println(getColumnName(705));
    }

    private static String getColumnName(int col) {
        String colName="";
        while(col > 26){
            int rem = col%26;
            if(rem == 0){
                colName = 'Z' + colName;
                col= (col / 26)-1;
            }else {
                colName = (char) (rem + 64) + colName;
                col= col / 26;
            }

        }
        colName = (char)(col+64) + colName ;

        return colName;
    }
}
