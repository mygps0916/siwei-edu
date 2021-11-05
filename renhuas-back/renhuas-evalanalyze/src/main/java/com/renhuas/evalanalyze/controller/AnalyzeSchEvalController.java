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
import com.renhuas.evalanalyze.domain.AnalyzeSchEval;
import com.renhuas.evalanalyze.service.IAnalyzeSchEvalService;
import com.renhuas.common.utils.poi.ExcelUtil;
import com.renhuas.common.core.page.TableDataInfo;

/**
 * 学校测评分析Controller
 *
 * @author chenzr
 * @date 2021-11-04
 */
@RestController
@RequestMapping("/evalanalyze/schevalanalyze")
public class AnalyzeSchEvalController extends BaseController
{
    @Autowired
    private IAnalyzeSchEvalService analyzeSchEvalService;

    /**
     * 查询学校测评分析列表
     */
    @PreAuthorize("@ss.hasPermi('evalanalyze:schevalanalyze:list')")
    @GetMapping("/list")
    public TableDataInfo list(AnalyzeSchEval analyzeSchEval)
    {
        startPage();
        List<AnalyzeSchEval> list = analyzeSchEvalService.selectAnalyzeSchEvalList(analyzeSchEval);
        return getDataTable(list);
    }

    /**
     * 导出学校测评分析列表
     */
    @PreAuthorize("@ss.hasPermi('evalanalyze:schevalanalyze:export')")
    @Log(title = "学校测评分析", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AnalyzeSchEval analyzeSchEval)
    {
        List<AnalyzeSchEval> list = analyzeSchEvalService.selectAnalyzeSchEvalList(analyzeSchEval);
        ExcelUtil<AnalyzeSchEval> util = new ExcelUtil<AnalyzeSchEval>(AnalyzeSchEval.class);
        return util.exportExcel(list, "学校测评分析数据");
    }

    /**
     * 获取学校测评分析详细信息
     */
    @PreAuthorize("@ss.hasPermi('evalanalyze:schevalanalyze:query')")
    @GetMapping(value = "/{analyzeId}")
    public AjaxResult getInfo(@PathVariable("analyzeId") Long analyzeId)
    {
        return AjaxResult.success(analyzeSchEvalService.selectAnalyzeSchEvalByAnalyzeId(analyzeId));
    }

    /**
     * 新增学校测评分析
     */
    @PreAuthorize("@ss.hasPermi('evalanalyze:schevalanalyze:add')")
    @Log(title = "学校测评分析", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AnalyzeSchEval analyzeSchEval)
    {
        return toAjax(analyzeSchEvalService.insertAnalyzeSchEval(analyzeSchEval));
    }

    /**
     * 修改学校测评分析
     */
    @PreAuthorize("@ss.hasPermi('evalanalyze:schevalanalyze:edit')")
    @Log(title = "学校测评分析", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AnalyzeSchEval analyzeSchEval)
    {
        return toAjax(analyzeSchEvalService.updateAnalyzeSchEval(analyzeSchEval));
    }

    /**
     * 删除学校测评分析
     */
    @PreAuthorize("@ss.hasPermi('evalanalyze:schevalanalyze:remove')")
    @Log(title = "学校测评分析", businessType = BusinessType.DELETE)
	@DeleteMapping("/{analyzeIds}")
    public AjaxResult remove(@PathVariable Long[] analyzeIds)
    {
        return toAjax(analyzeSchEvalService.deleteAnalyzeSchEvalByAnalyzeIds(analyzeIds));
    }
}
