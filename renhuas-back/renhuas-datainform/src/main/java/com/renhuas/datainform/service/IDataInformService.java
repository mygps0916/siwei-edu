package com.renhuas.datainform.service;

import java.util.List;
import com.renhuas.datainform.domain.DataInform;

/**
 * 数据管理Service接口
 * 
 * @author chenzr
 * @date 2021-11-04
 */
public interface IDataInformService 
{
    /**
     * 查询数据管理
     * 
     * @param inforId 数据管理主键
     * @return 数据管理
     */
    public DataInform selectDataInformByInforId(Long inforId);

    /**
     * 查询数据管理列表
     * 
     * @param dataInform 数据管理
     * @return 数据管理集合
     */
    public List<DataInform> selectDataInformList(DataInform dataInform);

    /**
     * 新增数据管理
     * 
     * @param dataInform 数据管理
     * @return 结果
     */
    public int insertDataInform(DataInform dataInform);

    /**
     * 修改数据管理
     * 
     * @param dataInform 数据管理
     * @return 结果
     */
    public int updateDataInform(DataInform dataInform);

    /**
     * 批量删除数据管理
     * 
     * @param inforIds 需要删除的数据管理主键集合
     * @return 结果
     */
    public int deleteDataInformByInforIds(Long[] inforIds);

    /**
     * 删除数据管理信息
     * 
     * @param inforId 数据管理主键
     * @return 结果
     */
    public int deleteDataInformByInforId(Long inforId);
}
