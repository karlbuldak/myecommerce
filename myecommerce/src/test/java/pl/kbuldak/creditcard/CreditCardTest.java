package pl.kbuldak.creditcard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class CreditCardTest {
    
    @Test
    void itAllowsToAssignCreditLimit(){
        //Arrange
        CreditCard card = new CreditCard("1234-5678");
        //Act
        card.assignCredit(BigDecimal.valueOf(1000));
        //Assert
        assertEquals(BigDecimal.valueOf(1000), card.getBalance());
    }

    @Test
    void itAllowsToAssignDifferentCreditLimit(){
        //Arrange
        CreditCard card1 = new CreditCard("1234-5678");
        CreditCard card2 = new CreditCard("1234-5678");

        //Act
        card1.assignCredit(BigDecimal.valueOf(1000));
        card2.assignCredit(BigDecimal.valueOf(1100));
        //Assert
        assertEquals(BigDecimal.valueOf(1000), card1.getBalance());
        assertEquals(BigDecimal.valueOf(1100), card2.getBalance());
    }

    @Test
    void checkDoublesAndFloats(){
        double x1=0.01;
        double x2=0.03;
        double xresult = x2-x1;
        float y1=0.01f;
        float y2=0.03f;
        float yresult = y2-y1;
    }

    @Test
    void itCanAssignBelowCertainThreshold(){
        CreditCard card = new CreditCard("1234-5678");

        try {
            card.assignCredit(BigDecimal.valueOf(10));
            fail("Should throw exception");
        } catch (CreditLimitBelowThresholdException e){
            assertTrue(true);
        }
        assertThrows(CreditLimitBelowThresholdException.class,
                () -> card.assignCredit(BigDecimal.valueOf(10)));
        assertThrows(CreditLimitBelowThresholdException.class,
                () -> card.assignCredit(BigDecimal.valueOf(99)));
        assertDoesNotThrow(
                () -> card.assignCredit(BigDecimal.valueOf(100)));
    }

    @Test
    void canNotAssignLimitTwice(){
        CreditCard card = new CreditCard("1234-5678");

        card.assignCredit(BigDecimal.valueOf(1000));

        assertThrows(
                CantAssignCreditTwiceException.class,
                () -> card.assignCredit(BigDecimal.valueOf(1100))
        );
        }

    @Test
    void canNotWithdrawOverTheLimit(){
        CreditCard card = new CreditCard("1234-5678");

        card.setLimit(BigDecimal.valueOf(1000));
        card.setBalance(BigDecimal.valueOf(1200));
        assertThrows(
                CantWithdrawOverTheLimitException.class,
                () -> card.withdraw(BigDecimal.valueOf(1100))
        );
    }
    @Test
    void canNotWithdrawWhenNotEnoughMoney(){
        CreditCard card = new CreditCard("1234-5678");

        card.assignCredit(BigDecimal.valueOf(1000));

        assertThrows(
                CantWithdrawWhenNotEnoughMoneyException.class,
                () -> card.withdraw(BigDecimal.valueOf(1100))
        );
    }
    }

