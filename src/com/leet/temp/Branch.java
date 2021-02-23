package nl.ing.api.cash.order.temp;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class Branch {
    String branchName;
    String telephoneNumber;
    String regionDirectorEmail;
    String regionManagerTel;
    String regionManagerEmail;
    String officeEmailAddress;
}