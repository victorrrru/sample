package cn.sample.member.web;

import cn.itht.dto.RequestDto;
import cn.itht.dto.ResultDto;
import cn.sample.member.service.MemberService;
import cn.sample.member.web.bo.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Spring MVC Controler - 表：member
 * @since 2017-06-14 14:34:10
 */
@RestController
@RequestMapping(value = "/noauthor/member")
public class MemberAction {

	@Resource
	private MemberService memberService;

	/**
	 * 检查用户是否注册接口
	 * param：mobileno
	 * code: 0 :用户未注册
	 * 		1:用户已注册
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/isRegister",method = RequestMethod.POST,produces = "application/json")
	public ResponseEntity<ResultDto> isRegister(@RequestBody RequestDto<MemberDto> param) {
		return new ResponseEntity<>(memberService.isRegisterSer(param.getData()), HttpStatus.OK);
	}

	/**
	 * 发送短信验证码
	 * 场景：注册，忘记密码发送短信
	 * param:	mobile
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/sendVerifyCode",method = RequestMethod.POST,produces = "application/json")
	public ResponseEntity<ResultDto> sendVerifyCode(@RequestBody RequestDto<MemberDto> param) {
		return new ResponseEntity<>(memberService.sendVerifyCodeSer(param.getData()), HttpStatus.OK);
	}

	/**
	 *用户注册接口
	 * param：mobileno
	 * 		loginPwd
	 * 		verifyCode
	 * 		inviteCode （选填）
	 * code: 0 :注册成功
	 * 		1:用户已注册
	 * 		2:验证码错误，请重新输入
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/userRegister",method = RequestMethod.POST,produces = "application/json")
	public ResponseEntity<ResultDto> userRegister(@RequestBody RequestDto<MemberDto> param) {
		return new ResponseEntity<>(memberService.userRegisterSer(param.getData()), HttpStatus.OK);
	}

	/**
	 * 用户登录接口
	 * param：mobileno
	 * 		loginPwd
	 * code: 0 :登录成功
	 * 		1:密码错误
	 * 		2:用户不存在
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/userLogin",method = RequestMethod.POST,produces = "application/json")
	public ResponseEntity<ResultDto> userLogin(@RequestBody RequestDto<MemberDto> param) {
		return new ResponseEntity<>(memberService.userLoginSer(param.getData()), HttpStatus.OK);
	}

	/**
	 * 修改密码接口
	 * 场景：忘记密码；修改密码
	 * param：mobileno
	 * 		verifyCode （updateLoginPwdType=0时传入）
	 * 		loginPwd   （updateLoginPwdType=1时传入）
	 * 		newLoginPwd
	 * 		updateLoginPwdType（0和1）
	 * code: 0 :忘记密码修改成功/密码修改成功
	 * 		1:用户不存在
	 * 		2:新的登录密码不能与交易密码相同
	 * 		3:验证码错误，请重新输入
	 * 		4:原密码输入错误
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/updateLoginPwd",method = RequestMethod.POST,produces = "application/json")
	public ResponseEntity<ResultDto> updateLoginPwd(@RequestBody RequestDto<MemberDto> param) {
		return new ResponseEntity<>(memberService.updateLoginPwdSer(param.getData()), HttpStatus.OK);
	}

	/**
	 * 设置交易密码
	 * param: mobile
	 * 		loginPwd
	 * 		transactionPwd
	 * code: 0 :交易密码设置成功
	 * 		1:用户不存在
	 * 		2:交易密码不能与登录密码相同
	 * 		3:登录密码错误
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/setTransactionPwd",method = RequestMethod.POST,produces = "application/json")
	public ResponseEntity<ResultDto> setTransactionPwd(@RequestBody RequestDto<MemberDto> param) {
		return new ResponseEntity<>(memberService.setTransactionPwdSer(param.getData()), HttpStatus.OK);
	}
	/**
	 * 修改交易密码
	 * param: mobile
	 * 		transactionPwd
	 * 		newTransactionPwd
	 * code: 0 :交易密码修改成功
	 * 		1:用户不存在
	 * 		2:新的交易密码不能与登录密码相同
	 * 		3:原交易密码错误
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/updateTransactionPwd",method = RequestMethod.POST,produces = "application/json")
	public ResponseEntity<ResultDto> updateTransactionPwd(@RequestBody RequestDto<MemberDto> param) {
		return new ResponseEntity<>(memberService.updateTransactionPwdSer(param.getData()), HttpStatus.OK);
	}
	/**
	 * 忘记交易密码(验证身份 + 修改交易密码)
	 * param: mobile
	 * 		realName
	 * 		idCard
	 * 		loginPwd
	 * 		newTransactionPwd
	 * code: 0 :交易密码修改成功
	 * 		1:用户不存在
	 * 		2:用户验证信息有误
	 * 		3:新的交易密码不能与登录密码相同
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/forgetTransactionPwd",method = RequestMethod.POST,produces = "application/json")
	public ResponseEntity<ResultDto> forgetTransactionPwd(@RequestBody RequestDto<MemberDto> param) {
		return new ResponseEntity<>(memberService.forgetTransactionPwdSer(param.getData()), HttpStatus.OK);
	}

}