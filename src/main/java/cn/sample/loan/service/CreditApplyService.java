package cn.sample.loan.service;


import cn.itht.exception.ServiceOperationException;
import cn.itht.mybatis.criteria.Criteria;
import cn.itht.mybatis.criteria.ExpressionFactory;
import cn.sample.common.ApplyStateEnum;
import cn.sample.common.CreditApplyStep;
import cn.sample.common.FacePPUtil;
import cn.sample.common.IDCardUtil;
import cn.sample.loan.entity.CreditApply;
import cn.sample.loan.mapper.CreditApplyMapper;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import cn.sample.loan.web.CreditApplyAction;
import cn.sample.loan.web.bo.CreditApplyIdCardDto;
import cn.sample.loan.web.bo.CreditApplyDrivingDto;
import cn.sample.loan.web.bo.CreditApplyPersonalDto;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 业务实现层 - 表：credit_apply
 * @since 2017-06-23 10:44:54
 */
@Service("creditApplyService")
public class CreditApplyService implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(CreditApplyAction.class);
	@Resource
	private CreditApplyMapper creditApplyMapper;
	private FacePPUtil.FacePPIDCardInfo idCardInfo;

	/**
	 * 将身份证上的个人信息存入数据库
	 * @param data
	 * @return
	 */
	public CreditApply insertIdCardInfo(CreditApplyIdCardDto data) {
		try {
			idCardInfo = FacePPUtil.getIDCard(data.getFront());
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new ServiceOperationException("身份证识别失败");
		}
		if (StringUtils.isEmpty(idCardInfo.getName())) {
			throw new ServiceOperationException("身份证识别信息不全");
		}
		List<CreditApply> creditApplies = creditApplyMapper.selectByCriteria(Criteria.create(CreditApply.class)
				.add(ExpressionFactory.eq("memberId", data.getMemId())));
		if (CollectionUtils.isNotEmpty(creditApplies)) {
			throw new ServiceOperationException("该身份证已授信");
		}
		CreditApply creditApply = new CreditApply();
		creditApply.setApplyState((byte)ApplyStateEnum.APPLYING.getIndex());
		creditApply.setApplyStep((byte)CreditApplyStep.FACE.getStep());
		creditApply.setApplyTime(new Date());
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.parseInt(idCardInfo.getBirthday().get("year").asText()),
				Integer.parseInt(idCardInfo.getBirthday().get("month").asText())-1,
				Integer.parseInt(idCardInfo.getBirthday().get("day").asText()));
		creditApply.setBirthday(calendar.getTime());
		creditApply.setIdCard(idCardInfo.getId_card_number());
		creditApply.setName(idCardInfo.getName());
		creditApply.setAddress(idCardInfo.getAddress());
		creditApply.setSex((byte)("男".equals(idCardInfo.getGender()) ? 0 : 1));
		creditApply.setNation(idCardInfo.getRace());
		creditApply.setMemberId(data.getMemId());
		creditApply.setNativePlace(IDCardUtil.nativePlace(idCardInfo.getId_card_number()));
		creditApplyMapper.insertSelective(creditApply);
		return creditApply;
	}

	/**
	 * 将车辆信息存入数据库
	 * @param data
	 * @return
	 */
	public void updateDrivingInfo(CreditApplyDrivingDto data) {
		List<CreditApply> creditApplies = creditApplyMapper.selectByCriteria(Criteria.create(CreditApply.class)
				.add(ExpressionFactory.eq("memberId", data.getMemId())));
		if (CollectionUtils.isEmpty(creditApplies)) {
			throw new ServiceOperationException("请先上传身份证");
		}
		CreditApply creditApply = creditApplies.get(0);
		if (creditApply.getApplyStep() != CreditApplyStep.CAR.getStep()) {
			throw new ServiceOperationException("当前不在上传驾驶证步骤");
		}
		BeanUtils.copyProperties(data, creditApply);
		creditApply.setApplyStep((byte)CreditApplyStep.PERSONAL_INFO.getStep());
		creditApplyMapper.updateByPrimaryKeySelective(creditApply);
	}

	/**
	 * 将个人信息存入数据库
	 * @param data
	 * @return
	 */
	public void updatePersonalInfo(CreditApplyPersonalDto data) {
		List<CreditApply> creditApplies = creditApplyMapper.selectByCriteria(Criteria.create(CreditApply.class)
				.add(ExpressionFactory.eq("memberId", data.getMemberId())));
		if (CollectionUtils.isEmpty(creditApplies)) {
			throw new ServiceOperationException("请先上传身份证");
		}
		CreditApply creditApply = creditApplies.get(0);
		if (creditApply.getApplyStep() != CreditApplyStep.PERSONAL_INFO.getStep()) {
			throw new ServiceOperationException("当前不在填写个人信息步骤");
		}
		BeanUtils.copyProperties(data, creditApply);
		creditApply.setApplyStep((byte)CreditApplyStep.AUTHORISE.getStep());
		creditApplyMapper.updateByPrimaryKeySelective(creditApply);
	}

	public List<CreditApply> findAll(Integer memberId) {
		return creditApplyMapper.selectByCriteria(Criteria.create(CreditApply.class)
				.add(ExpressionFactory.eq("memberId", memberId)));
	}


}