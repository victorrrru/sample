package cn.sample.loan.web.bo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by victorrrr on 2017/6/29.
 */
public class CreditApplyPersonalDto {

    private String domicileProvince;
    /**
     * domicile_detail -- 详细地址
     */
    private String domicileDetail;

    /** domicile_time -- 居住时间 */
    private Byte domicileTime;

    /**
     * education -- 文化程度(0高中及以下1中专2大专3本科4硕士5博士)
     */
    private Integer education;

    /**
     * company_name -- 单位名称
     */
    private String companyName;

    /** is_company_fivehun -- 是否是500强0否1是 */
    private Byte isCompanyFivehun;

    /**
     * job -- 职务
     */
    private Byte job;

    /**
     * marriage -- 婚姻状态(0单身，1丧偶，2离异,3已婚)
     */
    private Integer marriage;

    /** couple_card -- 配偶身份证号码 */
    private String coupleCard;

    /** couple_mobile -- 配偶手机号码 */
    private String coupleMobile;

    /** couple_name -- 配偶姓名 */
    private String coupleName;

    /** couple_education -- 配偶文化程度(0高中及以下1中专2大专3本科4硕士5博士) */
    private Byte coupleEducation;

    /** couple_job -- 配偶职业(在家、工作) */
    private Byte coupleJob;

    /** family_amount -- 家庭人口(0：2人，1：3人，2：4人，3：5人，4：5人以上) */
    private Byte familyAmount;

    /** member_id -- 用户id */
    private Integer memberId;
    /** buy_type -- 买房类型0按揭1全款 */
    private Byte buyType;

    /** house_type -- 0商品房1自建房2亲属主住房3租房4其他 */
    private Byte houseType;

    /** origin_type -- 0城镇户口1农村户口 */
    private Byte originType;

    /** house_caty -- 住宅类型（0普通住宅，1别墅） */
    private Byte houseCaty;

    /** house_big -- 房子面积 */
    private Short houseBig;

    /** loan_amount -- 每月按揭金额 */
    private BigDecimal loanAmount;

    /** city -- 所在城市 */
    private String city;

    /** area -- 所在小区 */
    private String area;

    /** income --  */
    @Min(value = 0,message = "月收入不能为0")
    private BigDecimal income;

    /** social_security -- 社保缴纳基数0：5000以下，1：5000-10000，2：10000以上 */
    private Byte socialSecurity;

    /** accumulation_fund -- 公积金缴纳基数0：5000以下，1：5000-10000，2：10000以上 */
    private Byte accumulationFund;

    /** jingdong_quto -- 京东白条额度 */
    private BigDecimal jingdongQuto;

    /** mayijieb_quto -- 蚂蚁借呗额度 */
    private BigDecimal mayijiebQuto;

    /** huabei_quto -- 蚂蚁花呗额度 */
    private BigDecimal huabeiQuto;

    /** debit -- 负债 */
    private BigDecimal debit;

    /** qq -- QQ号 */
    private String qq;

    /** qq_age -- qq年龄 */
    private Short qqAge;

    /** wx_age -- 微信年龄 */
    private Short wxAge;

    /** wx -- 微信号 */
    private String wx;

    /** high_edu_starttime -- 最高教育开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date highEduStarttime;

    /** high_edu_endtime -- 最高教育结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date highEduEndtime;

    /** year_pay -- 保险年缴纳费 */
    private BigDecimal yearPay;

    /** com_bus_time_length -- 公司经营时长（年） */
    private Short comBusTimeLength;

    /** work_experience -- 工作经验 */
    private String workExperience;

    /** work_place -- 单位地址 */
    private String workPlace;

    /** wanted_limit -- 期望额度 */
    private Integer wantedLimit;

    /** wanted_period -- 期望还款期限 */
    private Byte wantedPeriod;

    /** wanted_repay_day -- 期望还款日期 */
    private Byte wantedRepayDay;

    public String getDomicileProvince() {
        return domicileProvince;
    }

    public void setDomicileProvince(String domicileProvince) {
        this.domicileProvince = domicileProvince;
    }

    public String getDomicileDetail() {
        return domicileDetail;
    }

    public void setDomicileDetail(String domicileDetail) {
        this.domicileDetail = domicileDetail;
    }

    public Byte getDomicileTime() {
        return domicileTime;
    }

    public void setDomicileTime(Byte domicileTime) {
        this.domicileTime = domicileTime;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Byte getIsCompanyFivehun() {
        return isCompanyFivehun;
    }

    public void setIsCompanyFivehun(Byte isCompanyFivehun) {
        this.isCompanyFivehun = isCompanyFivehun;
    }

    public Byte getJob() {
        return job;
    }

    public void setJob(Byte job) {
        this.job = job;
    }

    public Integer getMarriage() {
        return marriage;
    }

    public void setMarriage(Integer marriage) {
        this.marriage = marriage;
    }

    public String getCoupleCard() {
        return coupleCard;
    }

    public void setCoupleCard(String coupleCard) {
        this.coupleCard = coupleCard;
    }

    public String getCoupleMobile() {
        return coupleMobile;
    }

    public void setCoupleMobile(String coupleMobile) {
        this.coupleMobile = coupleMobile;
    }

    public String getCoupleName() {
        return coupleName;
    }

    public void setCoupleName(String coupleName) {
        this.coupleName = coupleName;
    }

    public Byte getCoupleEducation() {
        return coupleEducation;
    }

    public void setCoupleEducation(Byte coupleEducation) {
        this.coupleEducation = coupleEducation;
    }

    public Byte getCoupleJob() {
        return coupleJob;
    }

    public void setCoupleJob(Byte coupleJob) {
        this.coupleJob = coupleJob;
    }

    public Byte getFamilyAmount() {
        return familyAmount;
    }

    public void setFamilyAmount(Byte familyAmount) {
        this.familyAmount = familyAmount;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Byte getBuyType() {
        return buyType;
    }

    public void setBuyType(Byte buyType) {
        this.buyType = buyType;
    }

    public Byte getHouseType() {
        return houseType;
    }

    public void setHouseType(Byte houseType) {
        this.houseType = houseType;
    }

    public Byte getOriginType() {
        return originType;
    }

    public void setOriginType(Byte originType) {
        this.originType = originType;
    }

    public Byte getHouseCaty() {
        return houseCaty;
    }

    public void setHouseCaty(Byte houseCaty) {
        this.houseCaty = houseCaty;
    }

    public Short getHouseBig() {
        return houseBig;
    }

    public void setHouseBig(Short houseBig) {
        this.houseBig = houseBig;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public Byte getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(Byte socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public Byte getAccumulationFund() {
        return accumulationFund;
    }

    public void setAccumulationFund(Byte accumulationFund) {
        this.accumulationFund = accumulationFund;
    }

    public BigDecimal getJingdongQuto() {
        return jingdongQuto;
    }

    public void setJingdongQuto(BigDecimal jingdongQuto) {
        this.jingdongQuto = jingdongQuto;
    }

    public BigDecimal getMayijiebQuto() {
        return mayijiebQuto;
    }

    public void setMayijiebQuto(BigDecimal mayijiebQuto) {
        this.mayijiebQuto = mayijiebQuto;
    }

    public BigDecimal getHuabeiQuto() {
        return huabeiQuto;
    }

    public void setHuabeiQuto(BigDecimal huabeiQuto) {
        this.huabeiQuto = huabeiQuto;
    }

    public BigDecimal getDebit() {
        return debit;
    }

    public void setDebit(BigDecimal debit) {
        this.debit = debit;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Short getQqAge() {
        return qqAge;
    }

    public void setQqAge(Short qqAge) {
        this.qqAge = qqAge;
    }

    public Short getWxAge() {
        return wxAge;
    }

    public void setWxAge(Short wxAge) {
        this.wxAge = wxAge;
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public Date getHighEduStarttime() {
        return highEduStarttime;
    }

    public void setHighEduStarttime(Date highEduStarttime) {
        this.highEduStarttime = highEduStarttime;
    }

    public Date getHighEduEndtime() {
        return highEduEndtime;
    }

    public void setHighEduEndtime(Date highEduEndtime) {
        this.highEduEndtime = highEduEndtime;
    }

    public BigDecimal getYearPay() {
        return yearPay;
    }

    public void setYearPay(BigDecimal yearPay) {
        this.yearPay = yearPay;
    }

    public Short getComBusTimeLength() {
        return comBusTimeLength;
    }

    public void setComBusTimeLength(Short comBusTimeLength) {
        this.comBusTimeLength = comBusTimeLength;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public Integer getWantedLimit() {
        return wantedLimit;
    }

    public void setWantedLimit(Integer wantedLimit) {
        this.wantedLimit = wantedLimit;
    }

    public Byte getWantedPeriod() {
        return wantedPeriod;
    }

    public void setWantedPeriod(Byte wantedPeriod) {
        this.wantedPeriod = wantedPeriod;
    }

    public Byte getWantedRepayDay() {
        return wantedRepayDay;
    }

    public void setWantedRepayDay(Byte wantedRepayDay) {
        this.wantedRepayDay = wantedRepayDay;
    }
}
