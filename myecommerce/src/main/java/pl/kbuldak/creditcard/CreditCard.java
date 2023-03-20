package pl.kbuldak.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal balance;
    private BigDecimal credit;
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    private BigDecimal limit;

    public CreditCard(String number) {
    }

    public void assignCredit(BigDecimal creditAmount) {
        if (isAlreadyAssigned()){
            throw new CantAssignCreditTwiceException();
        }
        if (isBelowThreshold(creditAmount)) {
            throw new CreditLimitBelowThresholdException();
        }
        this.balance = creditAmount;
        this.credit = creditAmount;
    }

    private boolean isAlreadyAssigned() {
        return credit != null;
    }

    private boolean isBelowThreshold(BigDecimal creditAmount) {
        return creditAmount.compareTo(BigDecimal.valueOf(100)) < 0;
    }


    public BigDecimal getBalance() {
        return balance;
    }

    public void withdraw(BigDecimal value) {
        if (isOverBalance(value)){
            throw new canNotWithdrawWhenNotEnoughMoney();
        }
        if (value.compareTo(limit) < 0){
            throw new CantWithdrawOverTheLimitException();
        }
        this.balance.subtract(value);
    }

    private boolean isOverBalance(BigDecimal value) {
        return value.compareTo(balance) < 0;
    }




}
