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
import com.renhuas.evaluation.domain.EvalTeacher;
import com.renhuas.evaluation.service.IEvalTeacherService;
import com.renhuas.common.utils.poi.ExcelUtil;
import com.renhuas.common.core.page.TableDataInfo;

/**
 * 老师教学测评Controller
 *
 * @author chenzr
 * @date 2021-11-04
 */
@RestController
@RequestMapping("/evaluation/teacheredueval")
public class EvalTeacherController extends BaseController
{
    @Autowired
    private IEvalTeacherService evalTeacherService;

    /**
     * 查询老师教学测评列表
     */
    @PreAuthorize("@ss.hasPermi('evaluation:teacheredueval:list')")
    @GetMapping("/list")
    public TableDataInfo list(EvalTeacher evalTeacher)
    {
        startPage();
        List<EvalTeacher> list = evalTeacherService.selectEvalTeacherList(evalTeacher);
        return getDataTable(list);
    }

    /**
     * 导出老师教学测评列表
     */
    @PreAuthorize("@ss.hasPermi('evaluation:teacheredueval:export')")
    @Log(title = "老师教学测评", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(EvalTeacher evalTeacher)
    {
        List<EvalTeacher> list = evalTeacherService.selectEvalTeacherList(evalTeacher);
        ExcelUtil<EvalTeacher> util = new ExcelUtil<EvalTeacher>(EvalTeacher.class);
        return util.exportExcel(list, "老师教学测评数据");
    }

    /**
     * 获取老师教学测评详细信息
     */
    @PreAuthorize("@ss.hasPermi('evaluation:teacheredueval:query')")
    @GetMapping(value = "/{evalId}")
    public AjaxResult getInfo(@PathVariable("evalId") Long evalId)
    {
        return AjaxResult.success(evalTeacherService.selectEvalTeacherByEvalId(evalId));
    }

    /**
     * 新增老师教学测评
     */
    @PreAuthorize("@ss.hasPermi('evaluation:teacheredueval:add')")
    @Log(title = "老师教学测评", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EvalTeacher evalTeacher)
    {
        return toAjax(evalTeacherService.insertEvalTeacher(evalTeacher));
    }

    /**
     * 修改老师教学测评
     */
    @PreAuthorize("@ss.hasPermi('evaluation:teacheredueval:edit')")
    @Log(title = "老师教学测评", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EvalTeacher evalTeacher)
    {
        return toAjax(evalTeacherService.updateEvalTeacher(evalTeacher));
    }

    /**
     * 删除老师教学测评
     */
    @PreAuthorize("@ss.hasPermi('evaluation:teacheredueval:remove')")
    @Log(title = "老师教学测评", businessType = BusinessType.DELETE)
	@DeleteMapping("/{evalIds}")
    public AjaxResult remove(@PathVariable Long[] evalIds)
    {
        return toAjax(evalTeacherService.deleteEvalTeacherByEvalIds(evalIds));
    }
}
