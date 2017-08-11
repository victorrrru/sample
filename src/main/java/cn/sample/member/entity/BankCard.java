package cn.sample.member.entity;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

/**
 * 实体类 - 表：bank_card
 * @since 2017-06-28 14:11:54
 */
@Alias("BankCardDto")
public class BankCard implements Serializable {
	/** bcid -- 主键id */
	private Integer bcid;

	/** member_id -- 会员id */
	private Integer memberId;

	/** cardholder -- 持卡人 */
	@Length(max=50,message="noauthor/memmber.BankCard.cardholder.Length")
	private String cardholder;

	/** bankcardno -- 银行卡号 */
	@Length(max=50,message="noauthor/memmber.BankCard.bankcardno.Length")
	private String bankcardno;

	/** collectingbank -- 收款银行 */
	@Length(max=50,message="noauthor/memmber.BankCard.collectingbank.Length")
	private String collectingbank;

	/** reservedmobileno -- 银行预留手机号 */
	@Length(max=50,message="noauthor/memmber.BankCard.reservedmobileno.Length")
	private String reservedmobileno;

	/** defaultcollectingbank -- 是否设为默认收款银行账户（0：否；1：是） */
	@NotNull(message="noauthor/memmber.BankCard.defaultcollectingbank.NotNull")
	private Byte defaultcollectingbank;

	/** remark -- 备注 */
	@Length(max=30,message="noauthor/memmber.BankCard.remark.Length")
	private String remark;

	/** defaultrefundbank -- 是否设为首选还款银行账户（0：否；1：是） */
	@NotNull(message="noauthor/memmber.BankCard.defaultrefundbank.NotNull")
	private Byte defaultrefundbank;

	/** defaultbank -- 是否是默认收/还款银行（0：否，1是） */
	@NotNull(message="noauthor/memmber.BankCard.defaultbank.NotNull")
	private Byte defaultbank;

	/** createdon -- 创建（注册）时间 */
	private Date createdon;

	private static final long serialVersionUID = 1L;

	/** 获取主键id */
	public Integer getBcid() {
		return bcid;
	}

	/** 设置主键id */
	public void setBcid(Integer bcid) {
		this.bcid = bcid;
	}

	/** 获取会员id */
	public Integer getMemberId() {
		return memberId;
	}

	/** 设置会员id */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/** 获取持卡人 */
	public String getCardholder() {
		return cardholder;
	}

	/** 设置持卡人 */
	public void setCardholder(String cardholder) {
		this.cardholder = cardholder == null ? null : cardholder.trim();
	}

	/** 获取银行卡号 */
	public String getBankcardno() {
		return bankcardno;
	}

	/** 设置银行卡号 */
	public void setBankcardno(String bankcardno) {
		this.bankcardno = bankcardno == null ? null : bankcardno.trim();
	}

	/** 获取收款银行 */
	public String getCollectingbank() {
		return collectingbank;
	}

	/** 设置收款银行 */
	public void setCollectingbank(String collectingbank) {
		this.collectingbank = collectingbank == null ? null : collectingbank.trim();
	}

	/** 获取银行预留手机号 */
	public String getReservedmobileno() {
		return reservedmobileno;
	}

	/** 设置银行预留手机号 */
	public void setReservedmobileno(String reservedmobileno) {
		this.reservedmobileno = reservedmobileno == null ? null : reservedmobileno.trim();
	}

	/** 获取是否设为默认收款银行账户（0：否；1：是） */
	public Byte getDefaultcollectingbank() {
		return defaultcollectingbank;
	}

	/** 设置是否设为默认收款银行账户（0：否；1：是） */
	public void setDefaultcollectingbank(Byte defaultcollectingbank) {
		this.defaultcollectingbank = defaultcollectingbank;
	}

	/** 获取备注 */
	public String getRemark() {
		return remark;
	}

	/** 设置备注 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/** 获取是否设为首选还款银行账户（0：否；1：是） */
	public Byte getDefaultrefundbank() {
		return defaultrefundbank;
	}

	/** 设置是否设为首选还款银行账户（0：否；1：是） */
	public void setDefaultrefundbank(Byte defaultrefundbank) {
		this.defaultrefundbank = defaultrefundbank;
	}

	/** 获取是否是默认收/还款银行（0：否，1是） */
	public Byte getDefaultbank() {
		return defaultbank;
	}

	/** 设置是否是默认收/还款银行（0：否，1是） */
	public void setDefaultbank(Byte defaultbank) {
		this.defaultbank = defaultbank;
	}

	/** 获取创建（注册）时间 */
	public Date getCreatedon() {
		return createdon;
	}

	/** 设置创建（注册）时间 */
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	/**
	
	 * @since 2017-06-28 14:11:54
	 */
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		BankCard other = (BankCard) that;
		return (this.getBcid() == null ? other.getBcid() == null : this.getBcid().equals(other.getBcid()))
			&& (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
			&& (this.getCardholder() == null ? other.getCardholder() == null : this.getCardholder().equals(other.getCardholder()))
			&& (this.getBankcardno() == null ? other.getBankcardno() == null : this.getBankcardno().equals(other.getBankcardno()))
			&& (this.getCollectingbank() == null ? other.getCollectingbank() == null : this.getCollectingbank().equals(other.getCollectingbank()))
			&& (this.getReservedmobileno() == null ? other.getReservedmobileno() == null : this.getReservedmobileno().equals(other.getReservedmobileno()))
			&& (this.getDefaultcollectingbank() == null ? other.getDefaultcollectingbank() == null : this.getDefaultcollectingbank().equals(other.getDefaultcollectingbank()))
			&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
			&& (this.getDefaultrefundbank() == null ? other.getDefaultrefundbank() == null : this.getDefaultrefundbank().equals(other.getDefaultrefundbank()))
			&& (this.getDefaultbank() == null ? other.getDefaultbank() == null : this.getDefaultbank().equals(other.getDefaultbank()))
			&& (this.getCreatedon() == null ? other.getCreatedon() == null : this.getCreatedon().equals(other.getCreatedon()));
	}

	/**
	
	 * @since 2017-06-28 14:11:54
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getBcid() == null) ? 0 : getBcid().hashCode());
		result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
		result = prime * result + ((getCardholder() == null) ? 0 : getCardholder().hashCode());
		result = prime * result + ((getBankcardno() == null) ? 0 : getBankcardno().hashCode());
		result = prime * result + ((getCollectingbank() == null) ? 0 : getCollectingbank().hashCode());
		result = prime * result + ((getReservedmobileno() == null) ? 0 : getReservedmobileno().hashCode());
		result = prime * result + ((getDefaultcollectingbank() == null) ? 0 : getDefaultcollectingbank().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		result = prime * result + ((getDefaultrefundbank() == null) ? 0 : getDefaultrefundbank().hashCode());
		result = prime * result + ((getDefaultbank() == null) ? 0 : getDefaultbank().hashCode());
		result = prime * result + ((getCreatedon() == null) ? 0 : getCreatedon().hashCode());
		return result;
	}
}