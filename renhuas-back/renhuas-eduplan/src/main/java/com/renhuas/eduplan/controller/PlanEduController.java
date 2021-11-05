package com.renhuas.eduplan.controller;

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
import com.renhuas.eduplan.domain.PlanEdu;
import com.renhuas.eduplan.service.IPlanEduService;
import com.renhuas.common.utils.poi.ExcelUtil;
import com.renhuas.common.core.page.TableDataInfo;

/**
 * 方案管理Controller
 *
 * @author chenzr
 * @date 2021-11-05
 */
@RestController
@RequestMapping("/eduplan/eduplan")
public class PlanEduController extends BaseController
{
    @Autowired
    private IPlanEduService planEduService;

    /**
     * 查询方案管理列表
     */
    @PreAuthorize("@ss.hasPermi('eduplan:eduplan:list')")
    @GetMapping("/list")
    public TableDataInfo list(PlanEdu planEdu)
    {
        startPage();
        List<PlanEdu> list = planEduService.selectPlanEduList(planEdu);
        return getDataTable(list);
    }

    /**
     * 导出方案管理列表
     */
    @PreAuthorize("@ss.hasPermi('eduplan:eduplan:export')")
    @Log(title = "方案管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PlanEdu planEdu)
    {
        List<PlanEdu> list = planEduService.selectPlanEduList(planEdu);
        ExcelUtil<PlanEdu> util = new ExcelUtil<PlanEdu>(PlanEdu.class);
        return util.exportExcel(list, "方案管理数据");
    }

    /**
     * 获取方案管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('eduplan:eduplan:query')")
    @GetMapping(value = "/{planId}")
    public AjaxResult getInfo(@PathVariable("planId") Long planId)
    {
        return AjaxResult.success(planEduService.selectPlanEduByPlanId(planId));
    }

    /**
     * 新增方案管理
     */
    @PreAuthorize("@ss.hasPermi('eduplan:eduplan:add')")
    @Log(title = "方案管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PlanEdu planEdu)
    {
        return toAjax(planEduService.insertPlanEdu(planEdu));
    }

    /**
     * 修改方案管理
     */
    @PreAuthorize("@ss.hasPermi('eduplan:eduplan:edit')")
    @Log(title = "方案管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PlanEdu planEdu)
    {
        return toAjax(planEduService.updatePlanEdu(planEdu));
    }

    /**
     * 删除方案管理
     */
    @PreAuthorize("@ss.hasPermi('eduplan:eduplan:remove')")
    @Log(title = "方案管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{planIds}")
    public AjaxResult remove(@PathVariable Long[] planIds)
    {
        return toAjax(planEduService.deletePlanEduByPlanIds(planIds));
    }
}
