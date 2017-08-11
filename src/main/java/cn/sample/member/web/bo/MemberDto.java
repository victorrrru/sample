package cn.sample.member.web.bo;

/**
 * Created by victorrrr on 2017/6/22.
 */
public class MemberDto {

    /**
     * 手机号
     */
    private String mobileno;
    /**
     * 验证码
     */
    private String verifyCode;
    /**
     * 登录密码
     */
    private String loginPwd;
    /**
     * 新密码
     */
    private String newLoginPwd;
    /**
     * 邀请码
     */
    private String inviteCode;
    /**
     * 修改密码类型（0：忘记密码；1：修改密码）
     */
    private Byte updateLoginPwdType;
    /**
     * 交易密码
     */
    private String transactionPwd;
    /**
     * 新交易密码
     */
    private String newTransactionPwd;
    /**
     * 忘记交易密码时下一步操作
     */
    private Byte nextStep;
    /**
     * 用户姓名
     */
    private String realName;
    /**
     * 用户身份证号码
     */
    private String idCard;

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getNewLoginPwd() {
        return newLoginPwd;
    }

    public void setNewLoginPwd(String newLoginPwd) {
        this.newLoginPwd = newLoginPwd;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public Byte getUpdateLoginPwdType() {
        return updateLoginPwdType;
    }

    public void setUpdateLoginPwdType(Byte updateLoginPwdType) {
        this.updateLoginPwdType = updateLoginPwdType;
    }

    public String getTransactionPwd() {
        return transactionPwd;
    }

    public void setTransactionPwd(String transactionPwd) {
        this.transactionPwd = transactionPwd;
    }

    public String getNewTransactionPwd() {
        return newTransactionPwd;
    }

    public void setNewTransactionPwd(String newTransactionPwd) {
        this.newTransactionPwd = newTransactionPwd;
    }

    public Byte getNextStep() {
        return nextStep;
    }

    public void setNextStep(Byte nextStep) {
        this.nextStep = nextStep;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
