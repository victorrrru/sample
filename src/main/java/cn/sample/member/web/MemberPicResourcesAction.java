package cn.sample.member.web;

import cn.sample.member.service.MemberPicResourcesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Spring MVC Controler - 表：member_pic_resources
 * @since 2017-06-26 16:05:50
 */
@Controller
@RequestMapping(value = "/noauthor/credit")
public class MemberPicResourcesAction {
	private static final Logger logger = LoggerFactory.getLogger(MemberPicResourcesAction.class);

	@Autowired
	private MemberPicResourcesService memberPicResourcesService;


}