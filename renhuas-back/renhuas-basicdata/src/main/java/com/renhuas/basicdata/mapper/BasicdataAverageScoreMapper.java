package com.renhuas.basicdata.mapper;

import java.util.List;
import com.renhuas.basicdata.domain.BasicdataAverageScore;

/**
 * 平均分数Mapper接口
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public interface BasicdataAverageScoreMapper 
{
    /**
     * 查询平均分数
     * 
     * @param averageScoreId 平均分数主键
     * @return 平均分数
     */
    public BasicdataAverageScore selectBasicdataAverageScoreByAverageScoreId(Long averageScoreId);

    /**
     * 查询平均分数列表
     * 
     * @param basicdataAverageScore 平均分数
     * @return 平均分数集合
     */
    public List<BasicdataAverageScore> selectBasicdataAverageScoreList(BasicdataAverageScore basicdataAverageScore);

    /**
     * 新增平均分数
     * 
     * @param basicdataAverageScore 平均分数
     * @return 结果
     */
    public int insertBasicdataAverageScore(BasicdataAverageScore basicdataAverageScore);

    /**
     * 修改平均分数
     * 
     * @param basicdataAverageScore 平均分数
     * @return 结果
     */
    public int updateBasicdataAverageScore(BasicdataAverageScore basicdataAverageScore);

    /**
     * 删除平均分数
     * 
     * @param averageScoreId 平均分数主键
     * @return 结果
     */
    public int deleteBasicdataAverageScoreByAverageScoreId(Long averageScoreId);

    /**
     * 批量删除平均分数
     * 
     * @param averageScoreIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBasicdataAverageScoreByAverageScoreIds(Long[] averageScoreIds);
}
