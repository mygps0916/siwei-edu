package com.renhuas.basicdata.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.renhuas.common.annotation.Log;
import com.renhuas.common.core.controller.BaseController;
import com.renhuas.common.core.domain.AjaxResult;
import com.renhuas.common.enums.BusinessType;
import com.renhuas.basicdata.domain.BasicdataAverageScore;
import com.renhuas.basicdata.service.IBasicdataAverageScoreService;
import com.renhuas.common.utils.poi.ExcelUtil;
import com.renhuas.common.core.page.TableDataInfo;

/**
 * 平均分数Controller
 *
 * @author chenzr
 * @date 2021-11-04
 */
@RestController
@RequestMapping("/basicdata/averagescore")
public class BasicdataAverageScoreController extends BaseController
{
    @Autowired
    private IBasicdataAverageScoreService basicdataAverageScoreService;

    /**
     * 查询平均分数列表
     */
    @PreAuthorize("@ss.hasPermi('basicdata:averagescore:list')")
    @GetMapping("/list")
    public TableDataInfo list(BasicdataAverageScore basicdataAverageScore)
    {
        startPage();
        List<BasicdataAverageScore> list = basicdataAverageScoreService.selectBasicdataAverageScoreList(basicdataAverageScore);
        return getDataTable(list);
    }

    /**
     * 导出平均分数列表
     */
    @PreAuthorize("@ss.hasPermi('basicdata:averagescore:export')")
    @Log(title = "平均分数", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BasicdataAverageScore basicdataAverageScore)
    {
        List<BasicdataAverageScore> list = basicdataAverageScoreService.selectBasicdataAverageScoreList(basicdataAverageScore);
        ExcelUtil<BasicdataAverageScore> util = new ExcelUtil<BasicdataAverageScore>(BasicdataAverageScore.class);
        return util.exportExcel(list, "平均分数数据");
    }

    /**
     * 获取平均分数详细信息
     */
    @PreAuthorize("@ss.hasPermi('basicdata:averagescore:query')")
    @GetMapping(value = "/{averageScoreId}")
    public AjaxResult getInfo(@PathVariable("averageScoreId") Long averageScoreId)
    {
        return AjaxResult.success(basicdataAverageScoreService.selectBasicdataAverageScoreByAverageScoreId(averageScoreId));
    }

    /**
     * 新增平均分数
     */
    @PreAuthorize("@ss.hasPermi('basicdata:averagescore:add')")
    @Log(title = "平均分数", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BasicdataAverageScore basicdataAverageScore)
    {
        return toAjax(basicdataAverageScoreService.insertBasicdataAverageScore(basicdataAverageScore));
    }

    /**
     * 修改平均分数
     */
    @PreAuthorize("@ss.hasPermi('basicdata:averagescore:edit')")
    @Log(title = "平均分数", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BasicdataAverageScore basicdataAverageScore)
    {
        return toAjax(basicdataAverageScoreService.updateBasicdataAverageScore(basicdataAverageScore));
    }

    /**
     * 删除平均分数
     */
    @PreAuthorize("@ss.hasPermi('basicdata:averagescore:remove')")
    @Log(title = "平均分数", businessType = BusinessType.DELETE)
	@DeleteMapping("/{averageScoreIds}")
    public AjaxResult remove(@PathVariable Long[] averageScoreIds)
    {
        return toAjax(basicdataAverageScoreService.deleteBasicdataAverageScoreByAverageScoreIds(averageScoreIds));
    }
}
