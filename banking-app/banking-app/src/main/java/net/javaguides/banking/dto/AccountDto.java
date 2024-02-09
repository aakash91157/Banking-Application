package net.javaguides.banking.dto;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import net.javaguides.banking.enums.ProfileStatus;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.Period;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
public class AccountDto {

    private Long id;

    private String accountHolderName;

    private Double balance;

    private Date updateAt;

    private String accountType;

    private Date accountOpened;

    private String email;

    private String phoneNumber;

    private String panCard;

    private String aadharCard;

    private int age;

    private ProfileStatus status;


    public AccountDto( Long id, String accountHolderName, double balance, String accountType, String email, String phoneNumber, String panCard, String aadharCard) {
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountType = accountType;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.panCard = panCard;

        this.aadharCard = aadharCard;
    }



    public String getAadharCard() {
        return aadharCard;
    }

    public void setAadharCard(String aadharCard) {
        this.aadharCard = aadharCard;
    }


    public String getPanCard() {
        return panCard;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Date getAccountOpened() {
        return accountOpened;
    }

    public void setAccountOpened(Date accountOpened) {
        this.accountOpened = accountOpened;
    }

    public ProfileStatus getStatus() {
        return status;
    }

    public void setStatus(ProfileStatus status) {
        this.status = status;
    }
}
