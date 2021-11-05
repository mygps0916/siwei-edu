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
import com.renhuas.evaluation.domain.EvalTeachPersion;
import com.renhuas.evaluation.service.IEvalTeachPersionService;
import com.renhuas.common.utils.poi.ExcelUtil;
import com.renhuas.common.core.page.TableDataInfo;

/**
 * 老师个人测评Controller
 *
 * @author chenzr
 * @date 2021-11-04
 */
@RestController
@RequestMapping("/evaluation/teachpersioneval")
public class EvalTeachPersionController extends BaseController
{
    @Autowired
    private IEvalTeachPersionService evalTeachPersionService;

    /**
     * 查询老师个人测评列表
     */
    @PreAuthorize("@ss.hasPermi('evaluation:teachpersioneval:list')")
    @GetMapping("/list")
    public TableDataInfo list(EvalTeachPersion evalTeachPersion)
    {
        startPage();
        List<EvalTeachPersion> list = evalTeachPersionService.selectEvalTeachPersionList(evalTeachPersion);
        return getDataTable(list);
    }

    /**
     * 导出老师个人测评列表
     */
    @PreAuthorize("@ss.hasPermi('evaluation:teachpersioneval:export')")
    @Log(title = "老师个人测评", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(EvalTeachPersion evalTeachPersion)
    {
        List<EvalTeachPersion> list = evalTeachPersionService.selectEvalTeachPersionList(evalTeachPersion);
        ExcelUtil<EvalTeachPersion> util = new ExcelUtil<EvalTeachPersion>(EvalTeachPersion.class);
        return util.exportExcel(list, "老师个人测评数据");
    }

    /**
     * 获取老师个人测评详细信息
     */
    @PreAuthorize("@ss.hasPermi('evaluation:teachpersioneval:query')")
    @GetMapping(value = "/{evalId}")
    public AjaxResult getInfo(@PathVariable("evalId") Long evalId)
    {
        return AjaxResult.success(evalTeachPersionService.selectEvalTeachPersionByEvalId(evalId));
    }

    /**
     * 新增老师个人测评
     */
    @PreAuthorize("@ss.hasPermi('evaluation:teachpersioneval:add')")
    @Log(title = "老师个人测评", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EvalTeachPersion evalTeachPersion)
    {
        return toAjax(evalTeachPersionService.insertEvalTeachPersion(evalTeachPersion));
    }

    /**
     * 修改老师个人测评
     */
    @PreAuthorize("@ss.hasPermi('evaluation:teachpersioneval:edit')")
    @Log(title = "老师个人测评", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EvalTeachPersion evalTeachPersion)
    {
        return toAjax(evalTeachPersionService.updateEvalTeachPersion(evalTeachPersion));
    }

    /**
     * 删除老师个人测评
     */
    @PreAuthorize("@ss.hasPermi('evaluation:teachpersioneval:remove')")
    @Log(title = "老师个人测评", businessType = BusinessType.DELETE)
	@DeleteMapping("/{evalIds}")
    public AjaxResult remove(@PathVariable Long[] evalIds)
    {
        return toAjax(evalTeachPersionService.deleteEvalTeachPersionByEvalIds(evalIds));
    }
}
