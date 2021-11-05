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
import com.renhuas.evaluation.domain.EvalSchool;
import com.renhuas.evaluation.service.IEvalSchoolService;
import com.renhuas.common.utils.poi.ExcelUtil;
import com.renhuas.common.core.page.TableDataInfo;

/**
 * 学校测评Controller
 *
 * @author chenzr
 * @date 2021-11-04
 */
@RestController
@RequestMapping("/evaluation/schooledueval")
public class EvalSchoolController extends BaseController
{
    @Autowired
    private IEvalSchoolService evalSchoolService;

    /**
     * 查询学校测评列表
     */
    @PreAuthorize("@ss.hasPermi('evaluation:schooledueval:list')")
    @GetMapping("/list")
    public TableDataInfo list(EvalSchool evalSchool)
    {
        startPage();
        List<EvalSchool> list = evalSchoolService.selectEvalSchoolList(evalSchool);
        return getDataTable(list);
    }

    /**
     * 导出学校测评列表
     */
    @PreAuthorize("@ss.hasPermi('evaluation:schooledueval:export')")
    @Log(title = "学校测评", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(EvalSchool evalSchool)
    {
        List<EvalSchool> list = evalSchoolService.selectEvalSchoolList(evalSchool);
        ExcelUtil<EvalSchool> util = new ExcelUtil<EvalSchool>(EvalSchool.class);
        return util.exportExcel(list, "学校测评数据");
    }

    /**
     * 获取学校测评详细信息
     */
    @PreAuthorize("@ss.hasPermi('evaluation:schooledueval:query')")
    @GetMapping(value = "/{evalId}")
    public AjaxResult getInfo(@PathVariable("evalId") Long evalId)
    {
        return AjaxResult.success(evalSchoolService.selectEvalSchoolByEvalId(evalId));
    }

    /**
     * 新增学校测评
     */
    @PreAuthorize("@ss.hasPermi('evaluation:schooledueval:add')")
    @Log(title = "学校测评", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EvalSchool evalSchool)
    {
        return toAjax(evalSchoolService.insertEvalSchool(evalSchool));
    }

    /**
     * 修改学校测评
     */
    @PreAuthorize("@ss.hasPermi('evaluation:schooledueval:edit')")
    @Log(title = "学校测评", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EvalSchool evalSchool)
    {
        return toAjax(evalSchoolService.updateEvalSchool(evalSchool));
    }

    /**
     * 删除学校测评
     */
    @PreAuthorize("@ss.hasPermi('evaluation:schooledueval:remove')")
    @Log(title = "学校测评", businessType = BusinessType.DELETE)
	@DeleteMapping("/{evalIds}")
    public AjaxResult remove(@PathVariable Long[] evalIds)
    {
        return toAjax(evalSchoolService.deleteEvalSchoolByEvalIds(evalIds));
    }
}
