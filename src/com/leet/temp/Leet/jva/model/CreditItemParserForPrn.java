package com.leet.temp.Leet.jva.model;
public class CreditItemParserForPrn implements CreditItemParser{

    @Override
    public CreditItem parseCreditLimitItem(String line){
        CreditItem creditItem = new CreditItem();
        creditItem.setName(line.substring(0, 16).trim());
        creditItem.setAddress(line.substring(16, 38).trim());
        creditItem.setPostcode(line.substring(38, 47).trim());
        creditItem.setPhone(line.substring(47, 62).trim());
        creditItem.setCredit_limit(Double.parseDouble(line.substring(62, 74).trim()));
        creditItem.setBirthday(Birthday.createBirthdayFromString(line.substring(74).trim(), BirthdayFormat.YYYYMMDD));

        return creditItem;
    }
}
