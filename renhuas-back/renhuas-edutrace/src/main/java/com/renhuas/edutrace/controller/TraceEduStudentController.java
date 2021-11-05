package com.renhuas.edutrace.controller;

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
import com.renhuas.edutrace.domain.TraceEduStudent;
import com.renhuas.edutrace.service.ITraceEduStudentService;
import com.renhuas.common.utils.poi.ExcelUtil;
import com.renhuas.common.core.page.TableDataInfo;

/**
 * 学生教学质量追溯Controller
 *
 * @author chenzr
 * @date 2021-11-04
 */
@RestController
@RequestMapping("/edutrace/stuedutrace")
public class TraceEduStudentController extends BaseController
{
    @Autowired
    private ITraceEduStudentService traceEduStudentService;

    /**
     * 查询学生教学质量追溯列表
     */
    @PreAuthorize("@ss.hasPermi('edutrace:stuedutrace:list')")
    @GetMapping("/list")
    public TableDataInfo list(TraceEduStudent traceEduStudent)
    {
        startPage();
        List<TraceEduStudent> list = traceEduStudentService.selectTraceEduStudentList(traceEduStudent);
        return getDataTable(list);
    }

    /**
     * 导出学生教学质量追溯列表
     */
    @PreAuthorize("@ss.hasPermi('edutrace:stuedutrace:export')")
    @Log(title = "学生教学质量追溯", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TraceEduStudent traceEduStudent)
    {
        List<TraceEduStudent> list = traceEduStudentService.selectTraceEduStudentList(traceEduStudent);
        ExcelUtil<TraceEduStudent> util = new ExcelUtil<TraceEduStudent>(TraceEduStudent.class);
        return util.exportExcel(list, "学生教学质量追溯数据");
    }

    /**
     * 获取学生教学质量追溯详细信息
     */
    @PreAuthorize("@ss.hasPermi('edutrace:stuedutrace:query')")
    @GetMapping(value = "/{traceId}")
    public AjaxResult getInfo(@PathVariable("traceId") Long traceId)
    {
        return AjaxResult.success(traceEduStudentService.selectTraceEduStudentByTraceId(traceId));
    }

    /**
     * 新增学生教学质量追溯
     */
    @PreAuthorize("@ss.hasPermi('edutrace:stuedutrace:add')")
    @Log(title = "学生教学质量追溯", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TraceEduStudent traceEduStudent)
    {
        return toAjax(traceEduStudentService.insertTraceEduStudent(traceEduStudent));
    }

    /**
     * 修改学生教学质量追溯
     */
    @PreAuthorize("@ss.hasPermi('edutrace:stuedutrace:edit')")
    @Log(title = "学生教学质量追溯", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TraceEduStudent traceEduStudent)
    {
        return toAjax(traceEduStudentService.updateTraceEduStudent(traceEduStudent));
    }

    /**
     * 删除学生教学质量追溯
     */
    @PreAuthorize("@ss.hasPermi('edutrace:stuedutrace:remove')")
    @Log(title = "学生教学质量追溯", businessType = BusinessType.DELETE)
	@DeleteMapping("/{traceIds}")
    public AjaxResult remove(@PathVariable Long[] traceIds)
    {
        return toAjax(traceEduStudentService.deleteTraceEduStudentByTraceIds(traceIds));
    }
}
