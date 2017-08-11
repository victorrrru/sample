package cn.sample.member.service;

import cn.itht.exception.ServiceOperationException;
import cn.itht.mybatis.criteria.Criteria;
import cn.itht.mybatis.criteria.ExpressionFactory;
import cn.itht.mybatis.criteria.Sort;
import cn.sample.loan.web.bo.CreditApplyDrivingDto;
import cn.sample.loan.web.bo.CreditApplyIdCardDto;
import cn.sample.member.entity.MemberPicResources;
import cn.sample.member.mapper.MemberPicResourcesMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

/**
 * 业务实现层 - 表：member_pic_resources
 * @since 2017-06-26 16:05:50
 */
@Service("memberPicResourcesService")
public class MemberPicResourcesService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private MemberPicResourcesMapper memberPicResourcesMapper;

	/**
	 * 将身份证图片url存入数据库
	 * @param data
	 * @param creditId
	 */
	public void insertIdCard(CreditApplyIdCardDto data, Integer creditId) {
		insertMemberPic(data.getMemId(), (byte)1, creditId, (byte)2, data.getFront());
		insertMemberPic(data.getMemId(), (byte)2, creditId, (byte)2, data.getBack());
	}

	/**
	 * 将驾驶证图片url存入数据库
	 * @param data
	 */
	public void insertDrivingLisence(CreditApplyDrivingDto data) {
		insertMemberPic(data.getMemId(), (byte)5, data.getCreditApplyId(), (byte)2, data.getDfront());
		insertMemberPic(data.getMemId(), (byte)6, data.getCreditApplyId(), (byte)2, data.getCfront());
		insertMemberPic(data.getMemId(), (byte)7, data.getCreditApplyId(), (byte)2, data.getDback());
		insertMemberPic(data.getMemId(), (byte)8, data.getCreditApplyId(), (byte)2, data.getCback());
	}

	/**
	 * 获取身份证图片
	 * @param memberId
	 */
	public void getIdCardPic(Integer memberId) {
		List<MemberPicResources> pic = selectPic(memberId, 1,2);
		if (CollectionUtils.isEmpty(pic)) {
			throw new ServiceOperationException("未找到身份证图片");
		}
		//todo 返回数据
	}

	/**
	 * 获得行驶证图片
	 * @param memberId
	 */
	public void getDrivingLisencePic(Integer memberId) {
		List<MemberPicResources> pic = selectPic(memberId, 6, 7);
		if (CollectionUtils.isEmpty(pic)) {
			throw new ServiceOperationException("未找到行驶证图片");
		}
		//todo 返回数据
	}

	/**
	 * 获得人脸图片
	 * @param memberId
	 */
	public void getFacePic(Integer memberId) {
		List<MemberPicResources> pic = selectPic(memberId, 3);
		if (CollectionUtils.isEmpty(pic)) {
			throw new ServiceOperationException("未找到人脸图片");
		}
		//todo 返回数据
	}

	private void insertMemberPic(Integer memberId, byte pictype, Integer objectId, byte objectType,String url) {
		MemberPicResources memberPicResources = new MemberPicResources();
		memberPicResources.setMemberId(memberId);
		memberPicResources.setPictype(pictype);
		memberPicResources.setObjectId(objectId);
		memberPicResources.setObjectType(objectType);
		memberPicResources.setUrl(url);
		memberPicResourcesMapper.insertSelective(memberPicResources);
	}

	private List<MemberPicResources> selectPic(Integer memberId, Object... values) {
		return memberPicResourcesMapper.selectByCriteria(Criteria.create(MemberPicResources.class)
				.add(ExpressionFactory.eq("memberId", memberId))
				.add(ExpressionFactory.in("pictype", values))
				.add(ExpressionFactory.eq("objectType", 2))
				.sort(Sort.asc("memberId")));
	}
}