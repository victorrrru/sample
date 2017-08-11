package cn.sample.config.mapper;

import cn.itht.mybatis.criteria.Criteria;
import cn.sample.config.entity.CommDataConfig;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MyBatis Mapper 接口 - 表：comm_data_config
 * @since 2017-06-29 15:30:53
 */
@Repository
public interface CommDataConfigMapper {
	/**
	 * 按主键删除
	 * @since 2017-06-29 15:30:53
	 */
	int deleteByPrimaryKey(Short menuId);

	/**
	 * 插入 - 全字段保存
	 * @since 2017-06-29 15:30:53
	 */
	int insert(CommDataConfig record);

	/**
	 * 插入 - 仅保存给定实体类中非null的字段
	 * @since 2017-06-29 15:30:53
	 */
	int insertSelective(CommDataConfig record);

	/**
	 * 按主键查询
	 * @since 2017-06-29 15:30:53
	 */
	CommDataConfig selectByPrimaryKey(Short menuId);

	/**
	 * 按主键更新 - 仅更新给定实体类中非null的字段
	 * @since 2017-06-29 15:30:53
	 */
	int updateByPrimaryKeySelective(CommDataConfig record);

	/**
	 * 按主键更新 - 全更新
	 * @since 2017-06-29 15:30:53
	 */
	int updateByPrimaryKey(CommDataConfig record);

	/**
	 * 按 Criteria 条件查询, 支持分页
	 * @since 2017-06-29 15:30:53
	 */
	List<CommDataConfig> selectByCriteria(Criteria<CommDataConfig> criteria);
}