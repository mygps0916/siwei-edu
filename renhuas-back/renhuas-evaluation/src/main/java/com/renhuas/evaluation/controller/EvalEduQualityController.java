package com.renhuas.evaluation.controller;

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
import com.renhuas.evaluation.domain.EvalEduQuality;
import com.renhuas.evaluation.service.IEvalEduQualityService;
import com.renhuas.common.utils.poi.ExcelUtil;
import com.renhuas.common.core.page.TableDataInfo;

/**
 * 教学质量评测Controller
 *
 * @author chenzr
 * @date 2021-11-04
 */
@RestController
@RequestMapping("/evaluation/eduqualityeval")
public class EvalEduQualityController extends BaseController
{
    @Autowired
    private IEvalEduQualityService evalEduQualityService;

    /**
     * 查询教学质量评测列表
     */
    @PreAuthorize("@ss.hasPermi('evaluation:eduqualityeval:list')")
    @GetMapping("/list")
    public TableDataInfo list(EvalEduQuality evalEduQuality)
    {
        startPage();
        List<EvalEduQuality> list = evalEduQualityService.selectEvalEduQualityList(evalEduQuality);
        return getDataTable(list);
    }

    /**
     * 导出教学质量评测列表
     */
    @PreAuthorize("@ss.hasPermi('evaluation:eduqualityeval:export')")
    @Log(title = "教学质量评测", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(EvalEduQuality evalEduQuality)
    {
        List<EvalEduQuality> list = evalEduQualityService.selectEvalEduQualityList(evalEduQuality);
        ExcelUtil<EvalEduQuality> util = new ExcelUtil<EvalEduQuality>(EvalEduQuality.class);
        return util.exportExcel(list, "教学质量评测数据");
    }

    /**
     * 获取教学质量评测详细信息
     */
    @PreAuthorize("@ss.hasPermi('evaluation:eduqualityeval:query')")
    @GetMapping(value = "/{techQualityId}")
    public AjaxResult getInfo(@PathVariable("techQualityId") Long techQualityId)
    {
        return AjaxResult.success(evalEduQualityService.selectEvalEduQualityByTechQualityId(techQualityId));
    }

    /**
     * 新增教学质量评测
     */
    @PreAuthorize("@ss.hasPermi('evaluation:eduqualityeval:add')")
    @Log(title = "教学质量评测", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EvalEduQuality evalEduQuality)
    {
        return toAjax(evalEduQualityService.insertEvalEduQuality(evalEduQuality));
    }

    /**
     * 修改教学质量评测
     */
    @PreAuthorize("@ss.hasPermi('evaluation:eduqualityeval:edit')")
    @Log(title = "教学质量评测", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EvalEduQuality evalEduQuality)
    {
        return toAjax(evalEduQualityService.updateEvalEduQuality(evalEduQuality));
    }

    /**
     * 删除教学质量评测
     */
    @PreAuthorize("@ss.hasPermi('evaluation:eduqualityeval:remove')")
    @Log(title = "教学质量评测", businessType = BusinessType.DELETE)
	@DeleteMapping("/{techQualityIds}")
    public AjaxResult remove(@PathVariable Long[] techQualityIds)
    {
        return toAjax(evalEduQualityService.deleteEvalEduQualityByTechQualityIds(techQualityIds));
    }
}
