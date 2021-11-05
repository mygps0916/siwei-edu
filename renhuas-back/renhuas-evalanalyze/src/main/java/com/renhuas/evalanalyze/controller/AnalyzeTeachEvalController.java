package com.renhuas.evalanalyze.controller;

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
import com.renhuas.evalanalyze.domain.AnalyzeTeachEval;
import com.renhuas.evalanalyze.service.IAnalyzeTeachEvalService;
import com.renhuas.common.utils.poi.ExcelUtil;
import com.renhuas.common.core.page.TableDataInfo;

/**
 * 老师测评分析Controller
 *
 * @author chenzr
 * @date 2021-11-04
 */
@RestController
@RequestMapping("/evalanalyze/teachevalanalyze")
public class AnalyzeTeachEvalController extends BaseController
{
    @Autowired
    private IAnalyzeTeachEvalService analyzeTeachEvalService;

    /**
     * 查询老师测评分析列表
     */
    @PreAuthorize("@ss.hasPermi('evalanalyze:teachevalanalyze:list')")
    @GetMapping("/list")
    public TableDataInfo list(AnalyzeTeachEval analyzeTeachEval)
    {
        startPage();
        List<AnalyzeTeachEval> list = analyzeTeachEvalService.selectAnalyzeTeachEvalList(analyzeTeachEval);
        return getDataTable(list);
    }

    /**
     * 导出老师测评分析列表
     */
    @PreAuthorize("@ss.hasPermi('evalanalyze:teachevalanalyze:export')")
    @Log(title = "老师测评分析", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AnalyzeTeachEval analyzeTeachEval)
    {
        List<AnalyzeTeachEval> list = analyzeTeachEvalService.selectAnalyzeTeachEvalList(analyzeTeachEval);
        ExcelUtil<AnalyzeTeachEval> util = new ExcelUtil<AnalyzeTeachEval>(AnalyzeTeachEval.class);
        return util.exportExcel(list, "老师测评分析数据");
    }

    /**
     * 获取老师测评分析详细信息
     */
    @PreAuthorize("@ss.hasPermi('evalanalyze:teachevalanalyze:query')")
    @GetMapping(value = "/{analyzeId}")
    public AjaxResult getInfo(@PathVariable("analyzeId") Long analyzeId)
    {
        return AjaxResult.success(analyzeTeachEvalService.selectAnalyzeTeachEvalByAnalyzeId(analyzeId));
    }

    /**
     * 新增老师测评分析
     */
    @PreAuthorize("@ss.hasPermi('evalanalyze:teachevalanalyze:add')")
    @Log(title = "老师测评分析", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AnalyzeTeachEval analyzeTeachEval)
    {
        return toAjax(analyzeTeachEvalService.insertAnalyzeTeachEval(analyzeTeachEval));
    }

    /**
     * 修改老师测评分析
     */
    @PreAuthorize("@ss.hasPermi('evalanalyze:teachevalanalyze:edit')")
    @Log(title = "老师测评分析", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AnalyzeTeachEval analyzeTeachEval)
    {
        return toAjax(analyzeTeachEvalService.updateAnalyzeTeachEval(analyzeTeachEval));
    }

    /**
     * 删除老师测评分析
     */
    @PreAuthorize("@ss.hasPermi('evalanalyze:teachevalanalyze:remove')")
    @Log(title = "老师测评分析", businessType = BusinessType.DELETE)
	@DeleteMapping("/{analyzeIds}")
    public AjaxResult remove(@PathVariable Long[] analyzeIds)
    {
        return toAjax(analyzeTeachEvalService.deleteAnalyzeTeachEvalByAnalyzeIds(analyzeIds));
    }
}
