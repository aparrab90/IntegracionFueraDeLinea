package org.acme.camelIntegracionFueradeLineaaparrab.Components;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import java.math.BigDecimal;

@CsvRecord(separator = ",", skipFirstLine = true)
public class ClientCreditProfile {

    public ClientCreditProfile() {}

    @DataField(pos = 1)
    private BigDecimal id;

    @DataField(pos = 2)
    private BigDecimal limitBal;

    @DataField(pos = 3)
    private BigDecimal sex;

    @DataField(pos = 4)
    private BigDecimal education;

    @DataField(pos = 5)
    private BigDecimal marriage;

    @DataField(pos = 6)
    private BigDecimal age;

    @DataField(pos = 7)
    private BigDecimal pay0;

    @DataField(pos = 8)
    private BigDecimal pay2;

    @DataField(pos = 9)
    private BigDecimal pay3;

    @DataField(pos = 10)
    private BigDecimal pay4;

    @DataField(pos = 11)
    private BigDecimal pay5;

    @DataField(pos = 12)
    private BigDecimal pay6;

    @DataField(pos = 13)
    private BigDecimal billAmt1;

    @DataField(pos = 14)
    private BigDecimal billAmt2;

    @DataField(pos = 15)
    private BigDecimal billAmt3;

    @DataField(pos = 16)
    private BigDecimal billAmt4;

    @DataField(pos = 17)
    private BigDecimal billAmt5;

    @DataField(pos = 18)
    private BigDecimal billAmt6;

    @DataField(pos = 19)
    private BigDecimal payAmt1;

    @DataField(pos = 20)
    private BigDecimal payAmt2;

    @DataField(pos = 21)
    private BigDecimal payAmt3;

    @DataField(pos = 22)
    private BigDecimal payAmt4;

    @DataField(pos = 23)
    private BigDecimal payAmt5;

    @DataField(pos = 24)
    private BigDecimal payAmt6;

    @DataField(pos = 25)
    private BigDecimal defaultPaymentNextMonth;

    // Getters and Setters

    public BigDecimal getId() {
        return id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }
    
    public BigDecimal getLimitBal() {
        return limitBal;
    }
    
    public void setLimitBal(BigDecimal limitBal) {
        this.limitBal = limitBal;
    }
    
    public BigDecimal getSex() {
        return sex;
    }
    
    public void setSex(BigDecimal sex) {
        this.sex = sex;
    }
    
    public BigDecimal getEducation() {
        return education;
    }
    
    public void setEducation(BigDecimal education) {
        this.education = education;
    }
    
    public BigDecimal getMarriage() {
        return marriage;
    }
    
    public void setMarriage(BigDecimal marriage) {
        this.marriage = marriage;
    }
    
    public BigDecimal getAge() {
        return age;
    }
    
    public void setAge(BigDecimal age) {
        this.age = age;
    }
    
    public BigDecimal getPay0() {
        return pay0;
    }
    
    public void setPay0(BigDecimal pay0) {
        this.pay0 = pay0;
    }
    
    public BigDecimal getPay2() {
        return pay2;
    }
    
    public void setPay2(BigDecimal pay2) {
        this.pay2 = pay2;
    }
    
    public BigDecimal getPay3() {
        return pay3;
    }
    
    public void setPay3(BigDecimal pay3) {
        this.pay3 = pay3;
    }
    
    public BigDecimal getPay4() {
        return pay4;
    }
    
    public void setPay4(BigDecimal pay4) {
        this.pay4 = pay4;
    }
    
    public BigDecimal getPay5() {
        return pay5;
    }
    
    public void setPay5(BigDecimal pay5) {
        this.pay5 = pay5;
    }
    
    public BigDecimal getPay6() {
        return pay6;
    }
    
    public void setPay6(BigDecimal pay6) {
        this.pay6 = pay6;
    }
    
    public BigDecimal getBillAmt1() {
        return billAmt1;
    }
    
    public void setBillAmt1(BigDecimal billAmt1) {
        this.billAmt1 = billAmt1;
    }
    
    public BigDecimal getBillAmt2() {
        return billAmt2;
    }
    
    public void setBillAmt2(BigDecimal billAmt2) {
        this.billAmt2 = billAmt2;
    }
    
    public BigDecimal getBillAmt3() {
        return billAmt3;
    }
    
    public void setBillAmt3(BigDecimal billAmt3) {
        this.billAmt3 = billAmt3;
    }
    
    public BigDecimal getBillAmt4() {
        return billAmt4;
    }
    
    public void setBillAmt4(BigDecimal billAmt4) {
        this.billAmt4 = billAmt4;
    }
    
    public BigDecimal getBillAmt5() {
        return billAmt5;
    }
    
    public void setBillAmt5(BigDecimal billAmt5) {
        this.billAmt5 = billAmt5;
    }
    
    public BigDecimal getBillAmt6() {
        return billAmt6;
    }
    
    public void setBillAmt6(BigDecimal billAmt6) {
        this.billAmt6 = billAmt6;
    }
    
    public BigDecimal getPayAmt1() {
        return payAmt1;
    }
    
    public void setPayAmt1(BigDecimal payAmt1) {
        this.payAmt1 = payAmt1;
    }
    
    public BigDecimal getPayAmt2() {
        return payAmt2;
    }
    
    public void setPayAmt2(BigDecimal payAmt2) {
        this.payAmt2 = payAmt2;
    }
    
    public BigDecimal getPayAmt3() {
        return payAmt3;
    }
    
    public void setPayAmt3(BigDecimal payAmt3) {
        this.payAmt3 = payAmt3;
    }
    
    public BigDecimal getPayAmt4() {
        return payAmt4;
    }
    
    public void setPayAmt4(BigDecimal payAmt4) {
        this.payAmt4 = payAmt4;
    }
    
    public BigDecimal getPayAmt5() {
        return payAmt5;
    }
    
    public void setPayAmt5(BigDecimal payAmt5) {
        this.payAmt5 = payAmt5;
    }
    
    public BigDecimal getPayAmt6() {
        return payAmt6;
    }
    
    public void setPayAmt6(BigDecimal payAmt6) {
        this.payAmt6 = payAmt6;
    }
    
    public BigDecimal getDefaultPaymentNextMonth() {
        return defaultPaymentNextMonth;
    }
    
    public void setDefaultPaymentNextMonth(BigDecimal defaultPaymentNextMonth) {
        this.defaultPaymentNextMonth = defaultPaymentNextMonth;
    }
    





}
