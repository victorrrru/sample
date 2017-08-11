package cn.sample.config.service;

import cn.itht.mybatis.criteria.Criteria;
import cn.itht.mybatis.criteria.ExpressionFactory;
import cn.sample.config.entity.CommDataConfig;
import cn.sample.config.mapper.CommDataConfigMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 业务实现层 - 表：comm_data_config
 * @since 2017-06-29 15:30:53
 */
@Service("commDataConfigService")
public class CommDataConfigService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Resource
	private CommDataConfigMapper commDataConfigMapper;

	public String getEduType(Integer data) {
		List<CommDataConfig> menuTypes = commDataConfigMapper.selectByCriteria(Criteria.create(CommDataConfig.class)
				.add(ExpressionFactory.eq("value", data)));
		return menuTypes.get(0).getMenuItem();
	}

}