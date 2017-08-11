package cn.sample.loan.web.bo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by victorrrr on 2017/6/29.
 */
public class CreditApplyDrivingDto {

    @NotNull(message = "正面照不能为空")
    private String dfront = null;

    private String dback = null;

    @NotNull(message = "行驶证正面照不能为空")
    private String cfront = null;


    @NotNull(message = "行驶证背面照不能为空")
    private String cback = null;

    @NotNull(message = "会员id不能为空")
    private Integer memId = null;

    @NotNull(message = "授信id不能为空")
    private Integer creditApplyId;

    /** car_number -- 车牌号 */
    private String carNumber;

    /** car_brand -- 车辆品牌 */
    private String carBrand;

    /** car_lisence -- 驾照登记地址 */
    private String carLisence;

    /** car_property -- 车辆性质（非运营0运营1） */
    private Byte carProperty;

    /** car_driven -- 驾龄 */
    private Byte carDriven;

    /** car_owner -- 车辆所有人 */
    private String carOwner;

    /** car_code -- 车辆识别代码 */
    private String carCode;

    /** buy_date -- 购买日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date buyDate;

    /** counts -- 第几辆车（0第一辆，1第二辆，2第三辆，3第四辆及以上） */
    private Short counts;

    /** price -- 购买价格 */
    private BigDecimal price;

    /** car_insurance_amount -- 保费金额 */
    private BigDecimal carInsuranceAmount;

    public String getDfront() {
        return dfront;
    }

    public void setDfront(String dfront) {
        this.dfront = dfront;
    }

    public String getDback() {
        return dback;
    }

    public void setDback(String dback) {
        this.dback = dback;
    }

    public String getCfront() {
        return cfront;
    }

    public void setCfront(String cfront) {
        this.cfront = cfront;
    }

    public String getCback() {
        return cback;
    }

    public void setCback(String cback) {
        this.cback = cback;
    }

    public Integer getMemId() {
        return memId;
    }

    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    public Integer getCreditApplyId() {
        return creditApplyId;
    }

    public void setCreditApplyId(Integer creditApplyId) {
        this.creditApplyId = creditApplyId;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarLisence() {
        return carLisence;
    }

    public void setCarLisence(String carLisence) {
        this.carLisence = carLisence;
    }

    public Byte getCarProperty() {
        return carProperty;
    }

    public void setCarProperty(Byte carProperty) {
        this.carProperty = carProperty;
    }

    public Byte getCarDriven() {
        return carDriven;
    }

    public void setCarDriven(Byte carDriven) {
        this.carDriven = carDriven;
    }

    public String getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(String carOwner) {
        this.carOwner = carOwner;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Short getCounts() {
        return counts;
    }

    public void setCounts(Short counts) {
        this.counts = counts;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCarInsuranceAmount() {
        return carInsuranceAmount;
    }

    public void setCarInsuranceAmount(BigDecimal carInsuranceAmount) {
        this.carInsuranceAmount = carInsuranceAmount;
    }
}
