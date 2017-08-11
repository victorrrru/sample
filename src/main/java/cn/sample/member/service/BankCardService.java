package cn.sample.member.service;

import cn.itht.dto.ResultDto;
import cn.itht.mybatis.criteria.Criteria;
import cn.itht.mybatis.criteria.ExpressionFactory;
import cn.sample.member.entity.BankCard;
import cn.sample.member.mapper.BankCardMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import cn.sample.member.web.bo.BankCardDto;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

/**
 * 业务实现层 - 表：bank_card
 * @since 2017-06-28 14:11:54
 */
@Service("bankCardService")
public class BankCardService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private BankCardMapper bankCardMapper;

	public ResultDto getBankCardListSer(BankCardDto data) {
		ResultDto result = new ResultDto();
		result.setMsg("查询银行卡列表");
		List<BankCard> bankCards = bankCardMapper.selectByCriteria(Criteria.create(BankCard.class)
				.add(ExpressionFactory.eq("memberId", data.getMemberId())));
		result.setData(bankCards);
		return result;
	}

	public ResultDto addBankCardSer(BankCardDto data) {
		ResultDto result = new ResultDto();
		result.setMsg("添加银行卡");
		List<BankCard> bankCards = bankCardMapper.selectByCriteria(Criteria.create(BankCard.class)
				.add(ExpressionFactory.eq("bankcardno", data.getBankCardno())));
		if (CollectionUtils.isNotEmpty(bankCards)) {
			result.setMsg("您要添加的银行卡已存在，请重新添加");
			result.setCode("1");
			return result;
		}
		BankCard bankCardExt = new BankCard();
		bankCardExt.setMemberId(data.getMemberId());
		bankCardExt.setCardholder(data.getCardholder());
		bankCardExt.setCollectingbank(data.getCollectionBank());
		bankCardExt.setReservedmobileno(data.getMobileno());
		bankCardExt.setBankcardno(data.getBankCardno());
		bankCardMapper.insertSelective(bankCardExt);
		result.setMsg("添加银行卡成功");
		return result;
	}


}