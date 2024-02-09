package net.javaguides.banking.entity;

import jakarta.persistence.*;
import lombok.*;
import net.javaguides.banking.enums.ProfileStatus;

import java.util.Date;

@Getter
@Setter
@Data
@Entity
@Table (name="accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="account_holder_name")
    private String accountHolderName;

    private Double balance;

    @Column(name = "account_type", columnDefinition = "Saving")
    private String accountType;

    private Date accountOpened;

    private String email;

    private  String phoneNumber;

    private String panCard;

    private ProfileStatus status;

    private String aadharCard;


    public Account(Long id, String accountHolderName, double balance, String accountType, String email, String phoneNumber, String panCard,  String aadharCard) {
        this.id = this.id;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountType = accountType;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.panCard = panCard;
        this.aadharCard = aadharCard;
    }



    public Account() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPanCard() {
        return panCard;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }



    public String getAadharCard() {
        return aadharCard;
    }

    public void setAadharCard(String aadharCard) {
        this.aadharCard = aadharCard;
    }

    public ProfileStatus getStatus() {
        return status;
    }

    public void setStatus(ProfileStatus status) {
        this.status = status;
    }
}

