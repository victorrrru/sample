package cn.sample.member.web.bo;

/**
 * Created by victorrrr on 2017/6/28.
 */
public class BankCardDto {

    /**
     * 用户id
     */
    private Integer memberId;
    /**
     * 持卡人
     */
    private String cardholder;
    /**
     * 收款银行
     */
    private String collectionBank;
    /**
     * 银行预留手机号
     */
    private String mobileno;
    /**
     * 银行卡号
     */
    private String bankCardno;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getCardholder() {
        return cardholder;
    }

    public void setCardholder(String cardholder) {
        this.cardholder = cardholder;
    }

    public String getCollectionBank() {
        return collectionBank;
    }

    public void setCollectionBank(String collectionBank) {
        this.collectionBank = collectionBank;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getBankCardno() {
        return bankCardno;
    }

    public void setBankCardno(String bankCardno) {
        this.bankCardno = bankCardno;
    }
}
