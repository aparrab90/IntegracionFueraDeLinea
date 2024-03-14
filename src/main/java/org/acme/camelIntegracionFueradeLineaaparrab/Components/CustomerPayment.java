package org.apache.camel.learn.model;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import java.math.BigDecimal;

@CsvRecord(separator = ",", skipFirstLine = true)
public class CustomerPayment {

    public CustomerPayment() {}
    
    //////////////////////////////////////////////////////
    @DataField(pos = 1)
    private BigDecimal ID;

    public BigDecimal getID() {
        return ID;
    }

    public void setID(BigDecimal iD) {
        ID = iD;
    }
    //////////////////////////////////////////////////////
    @DataField(pos = 2)
    private BigDecimal LIMIT_BAL;

    public BigDecimal getLIMIT_BAL() {
        return LIMIT_BAL;
    }

    public void setLIMIT_BAL(BigDecimal lIMIT_BAL) {
        LIMIT_BAL = lIMIT_BAL;
    }
    //////////////////////////////////////////////////////
    @DataField(pos = 3)
    private BigDecimal SEX;

    public BigDecimal getSEX() {
        return SEX;
    }

    public void setSEX(BigDecimal sEX) {
        SEX = sEX;
    }
    //////////////////////////////////////////////////////
    @DataField(pos = 4)
    private BigDecimal EDUCATION;

    public BigDecimal getEDUCATION() {
        return EDUCATION;
    }

    public void setEDUCATION(BigDecimal eDUCATION) {
        EDUCATION = eDUCATION;
    }
    //////////////////////////////////////////////////////
    @DataField(pos = 5)
    private BigDecimal MARRIAGE;

    public BigDecimal getMARRIAGE() {
        return MARRIAGE;
    }

    public void setMARRIAGE(BigDecimal mARRIAGE) {
        MARRIAGE = mARRIAGE;
    }
    //////////////////////////////////////////////////////
    @DataField(pos = 6)
    private BigDecimal AGE;

    public BigDecimal getAGE() {
        return AGE;
    }

    public void setAGE(BigDecimal aGE) {
        AGE = aGE;
    }
    //////////////////////////////////////////////////////
    @DataField(pos = 7)
    private BigDecimal PAY_0_1;

    public BigDecimal getPAY_0_1() {
        return PAY_0_1;
    }

    public void setPAY_0_1(BigDecimal pAY_0_1) {
        PAY_0_1 = pAY_0_1;
    }
    //////////////////////////////////////////////////////
    @DataField(pos = 8)
    private BigDecimal PAY_2_1;

    public BigDecimal getPAY_2_1() {
        return PAY_2_1;
    }

    public void setPAY_2_1(BigDecimal pAY_2_1) {
        PAY_2_1 = pAY_2_1;
    }
    //////////////////////////////////////////////////////
    @DataField(pos = 9)
    private BigDecimal PAY_3_1;

    public BigDecimal getPAY_3_1() {
        return PAY_3_1;
    }

    public void setPAY_3_1(BigDecimal pAY_3_1) {
        PAY_3_1 = pAY_3_1;
    }
    //////////////////////////////////////////////////////
    @DataField(pos = 10)
    private BigDecimal PAY_4_1;

    public BigDecimal getPAY_4_1() {
        return PAY_4_1;
    }

    public void setPAY_4_1(BigDecimal pAY_4_1) {
        PAY_4_1 = pAY_4_1;
    }
    //////////////////////////////////////////////////////
    @DataField(pos = 11)
    private BigDecimal PAY_5_1;

    public BigDecimal getPAY_5_1() {
        return PAY_5_1;
    }

    public void setPAY_5_1(BigDecimal pAY_5_1) {
        PAY_5_1 = pAY_5_1;
    }
    //////////////////////////////////////////////////////
    @DataField(pos = 12)
    private BigDecimal PAY_6_1;

    public BigDecimal getPAY_6_1() {
        return PAY_6_1;
    }

    public void setPAY_6_1(BigDecimal pAY_6_1) {
        PAY_6_1 = pAY_6_1;
    }
    //////////////////////////////////////////////////////
    @DataField(pos = 13)
    private BigDecimal BILL_1;

    public BigDecimal getBILL_1() {
        return BILL_1;
    }

    public void setBILL_1(BigDecimal bILL_1) {
        BILL_1 = bILL_1;
    }
    //////////////////////////////////////////////////////
    @DataField(pos = 14)
    private BigDecimal BILL_2;

    public BigDecimal getBILL_2() {
        return BILL_2;
    }

    public void setBILL_2(BigDecimal bILL_2) {
        BILL_2 = bILL_2;
    }
    //////////////////////////////////////////////////////
    @DataField(pos = 15)
    private BigDecimal BILL_3;

    public BigDecimal getBILL_3() {
        return BILL_3;
    }

    public void setBILL_3(BigDecimal bILL_3) {
        BILL_3 = bILL_3;
    }
    //////////////////////////////////////////////////////
    @DataField(pos = 16)
    private BigDecimal BILL_4;

    public BigDecimal getBILL_4() {
        return BILL_4;
    }

    public void setBILL_4(BigDecimal bILL_4) {
        BILL_4 = bILL_4;
    }
    //////////////////////////////////////////////////////
    @DataField(pos = 17)
    private BigDecimal BILL_5;

    public BigDecimal getBILL_5() {
        return BILL_5;
    }

    public void setBILL_5(BigDecimal bILL_5) {
        BILL_5 = bILL_5;
    }
    //////////////////////////////////////////////////////
    @DataField(pos = 18)
    private BigDecimal BILL_6;

    public BigDecimal getBILL_6() {
        return BILL_6;
    }

    public void setBILL_6(BigDecimal bILL_6) {
        BILL_6 = bILL_6;
    }
    //////////////////////////////////////////////////////
    @DataField(pos = 19)
    private BigDecimal PAY_1_2;

    public BigDecimal getPAY_1_2() {
        return PAY_1_2;
    }

    public void setPAY_1_2(BigDecimal pAY_1_2) {
        PAY_1_2 = pAY_1_2;
    }
    //////////////////////////////////////////////////////
    @DataField(pos = 20)
    private BigDecimal PAY_2_2;

    public BigDecimal getPAY_2_2() {
        return PAY_2_2;
    }

    public void setPAY_2_2(BigDecimal pAY_2_2) {
        PAY_2_2 = pAY_2_2;
    }
    //////////////////////////////////////////////////////
    @DataField(pos = 21)
    private BigDecimal PAY_3_2;

    public BigDecimal getPAY_3_2() {
        return PAY_3_2;
    }

    public void setPAY_3_2(BigDecimal pAY_3_2) {
        PAY_3_2 = pAY_3_2;
    }
    //////////////////////////////////////////////////////
    @DataField(pos = 22)
    private BigDecimal PAY_4_2;

    public BigDecimal getPAY_4_2() {
        return PAY_4_2;
    }

    public void setPAY_4_2(BigDecimal pAY_4_2) {
        PAY_4_2 = pAY_4_2;
    }
    //////////////////////////////////////////////////////
    @DataField(pos = 23)
    private BigDecimal PAY_5_2;

    public BigDecimal getPAY_5_2() {
        return PAY_5_2;
    }

    public void setPAY_5_2(BigDecimal pAY_5_2) {
        PAY_5_2 = pAY_5_2;
    }
    //////////////////////////////////////////////////////
    @DataField(pos = 24)
    private BigDecimal PAY_6_2;

    public BigDecimal getPAY_6_2() {
        return PAY_6_2;
    }

    public void setPAY_6_2(BigDecimal pAY_6_2) {
        PAY_6_2 = pAY_6_2;
    }
    //////////////////////////////////////////////////////
    @DataField(pos = 25)
    private BigDecimal defaultPaymentNextMonth;

    public BigDecimal getDefaultPaymentNextMonth() {
        return defaultPaymentNextMonth;
    }

    public void setDefaultPaymentNextMonth(BigDecimal defaultPaymentNextMonth) {
        this.defaultPaymentNextMonth = defaultPaymentNextMonth;
    } 

}