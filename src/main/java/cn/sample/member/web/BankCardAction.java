package cn.sample.member.web;


import cn.itht.dto.RequestDto;
import cn.itht.dto.ResultDto;
import cn.sample.member.service.BankCardService;
import cn.sample.member.web.bo.BankCardDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Spring MVC Controler - 表：bank_card
 * @since 2017-06-28 14:11:54
 */
@Controller
@RequestMapping(value = "/noauthor/member")
public class BankCardAction {
	private static final Logger logger = LoggerFactory.getLogger(BankCardAction.class);

	@Autowired
	private BankCardService bankCardService;

	/**
	 * 获得银行卡列表
	 * param: memberId
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/getBankCardList",method = RequestMethod.POST,produces = "application/json")
	public ResponseEntity<ResultDto> getBankCardList(@RequestBody BankCardDto param) {
		return new ResponseEntity<>(bankCardService.getBankCardListSer(param), HttpStatus.OK);
	}

	/**
	 * 添加银行卡
	 * param: memberId
	 * 		cardholder
	 * 		mobileno
	 * 		bankCardno
	 * 		collectionBank
	 * code :	0 :添加银行卡成功
	 * 			1 :您要添加的银行卡已存在，请重新添加
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/addBankCard",method = RequestMethod.POST,produces = "application/json")
	public ResponseEntity<ResultDto> addBankCard(@RequestBody RequestDto<BankCardDto> param) {
		return new ResponseEntity<>(bankCardService.addBankCardSer(param.getData()), HttpStatus.OK);
	}

}