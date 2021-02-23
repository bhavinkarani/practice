package com.leet.temp.Leet.jva.model;

public class CreditItemParserForCSV implements CreditItemParser{
    @Override
    public CreditItem parseCreditLimitItem(String line){
        String[] tokens = line.split(",");
        CreditItem creditItem = new CreditItem();
        creditItem.setName(tokens[0]+ ","+tokens[1]);
        creditItem.setAddress(tokens[2].trim());
        creditItem.setPostcode(tokens[3].trim());
        creditItem.setPhone(tokens[4]);
        creditItem.setCredit_limit(Double.parseDouble(tokens[5].trim()));
        creditItem.setBirthday(Birthday.createBirthdayFromString(tokens[6], BirthdayFormat.DDsMMsYY));
        return creditItem;
    }
}
