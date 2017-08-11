package cn.sample.loan.web.bo;

/**
 * Created by victorrrr
 * Date : 2017/7/4 13:51
 */
public class CreditApplyInfoDto {

    private Integer memberId;

    private Byte applyStep;

    private Byte applyState;

    private String front;

    private String back;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Byte getApplyStep() {
        return applyStep;
    }

    public void setApplyStep(Byte applyStep) {
        this.applyStep = applyStep;
    }

    public Byte getApplyState() {
        return applyState;
    }

    public void setApplyState(Byte applyState) {
        this.applyState = applyState;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }
}
