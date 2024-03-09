package net.javaguides.banking.app.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class AccountDto {
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    private long id;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private String accountHolderName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private double balance;

}
