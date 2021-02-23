package com.leet.temp.Leet.jva;


import com.leet.temp.Leet.jva.model.CreditItem;
import com.leet.temp.Leet.jva.model.CreditItemParser;
import com.leet.temp.Leet.jva.model.CreditItemParserForCSV;
import com.leet.temp.Leet.jva.model.CreditItemParserForPrn;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Test {

public static void main(String args[])  throws IOException{
    String fileNamePrn = "C:\\workset\\FADE\\src\\External\\bay\\MartkplaatsCodingTest-master\\src\\main\\resources\\Workbook2.prn";
    String fileNameCsv = "C:\\workset\\FADE\\src\\External\\bay\\MartkplaatsCodingTest-master\\src\\main\\resources\\Workbook2.csv";
    CreditItemParser csvCreditItemParser = new CreditItemParserForCSV();
    CreditItemParser prnCreditItemParser = new CreditItemParserForPrn();

    
    List<CreditItem> csvLines = parseCsv(csvCreditItemParser, fileNameCsv);
    List<CreditItem> prnLines = parseCsv(prnCreditItemParser, fileNamePrn);
    printCreditItems(csvLines);
    System.out.println("===================");
    printCreditItems(prnLines);
}

    private static void printCreditItems(List<CreditItem> items) {
        for(CreditItem item: items){
            System.out.println(item);
        }
    }

    private static List<CreditItem> parseCsv(CreditItemParser creditItemParser, String fileName) throws IOException {
        List<CreditItem> csvLines = new ArrayList<>();
        //todo : fix this later
        //List<String> lines = FileUtils.readLines(new File(fileName), "ISO-8859-1");
        List<String> lines = new ArrayList<>();
        int i=0;
        for (String line: lines) {
            if(i==0){
                i++;
                continue;
            }
            //createLineItem(line);
            csvLines.add(creditItemParser.parseCreditLimitItem(line));
        }
        return csvLines;
    }

    private static void createLineItem(String line) {
            String name = line.substring(0, 16).trim();
            String address = line.substring(16, 38).trim();
            String postcode = line.substring(38, 47).trim();
            String phone = line.substring(47, 62).trim();
            System.out.println("Name : "+name +"address:"+address+"postcode : "+postcode+" phone:"+phone);
    }


}