package com.renhuas.basicdata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.renhuas.basicdata.mapper.BasicdataAverageScoreMapper;
import com.renhuas.basicdata.domain.BasicdataAverageScore;
import com.renhuas.basicdata.service.IBasicdataAverageScoreService;

/**
 * 平均分数Service业务层处理
 * 
 * @author chenzr
 * @date 2021-11-04
 */
@Service
public class BasicdataAverageScoreServiceImpl implements IBasicdataAverageScoreService 
{
    @Autowired
    private BasicdataAverageScoreMapper basicdataAverageScoreMapper;

    /**
     * 查询平均分数
     * 
     * @param averageScoreId 平均分数主键
     * @return 平均分数
     */
    @Override
    public BasicdataAverageScore selectBasicdataAverageScoreByAverageScoreId(Long averageScoreId)
    {
        return basicdataAverageScoreMapper.selectBasicdataAverageScoreByAverageScoreId(averageScoreId);
    }

    /**
     * 查询平均分数列表
     * 
     * @param basicdataAverageScore 平均分数
     * @return 平均分数
     */
    @Override
    public List<BasicdataAverageScore> selectBasicdataAverageScoreList(BasicdataAverageScore basicdataAverageScore)
    {
        return basicdataAverageScoreMapper.selectBasicdataAverageScoreList(basicdataAverageScore);
    }

    /**
     * 新增平均分数
     * 
     * @param basicdataAverageScore 平均分数
     * @return 结果
     */
    @Override
    public int insertBasicdataAverageScore(BasicdataAverageScore basicdataAverageScore)
    {
        return basicdataAverageScoreMapper.insertBasicdataAverageScore(basicdataAverageScore);
    }

    /**
     * 修改平均分数
     * 
     * @param basicdataAverageScore 平均分数
     * @return 结果
     */
    @Override
    public int updateBasicdataAverageScore(BasicdataAverageScore basicdataAverageScore)
    {
        return basicdataAverageScoreMapper.updateBasicdataAverageScore(basicdataAverageScore);
    }

    /**
     * 批量删除平均分数
     * 
     * @param averageScoreIds 需要删除的平均分数主键
     * @return 结果
     */
    @Override
    public int deleteBasicdataAverageScoreByAverageScoreIds(Long[] averageScoreIds)
    {
        return basicdataAverageScoreMapper.deleteBasicdataAverageScoreByAverageScoreIds(averageScoreIds);
    }

    /**
     * 删除平均分数信息
     * 
     * @param averageScoreId 平均分数主键
     * @return 结果
     */
    @Override
    public int deleteBasicdataAverageScoreByAverageScoreId(Long averageScoreId)
    {
        return basicdataAverageScoreMapper.deleteBasicdataAverageScoreByAverageScoreId(averageScoreId);
    }
}
