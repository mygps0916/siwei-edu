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
import com.renhuas.edutrace.domain.TraceEduTeach;
import com.renhuas.edutrace.service.ITraceEduTeachService;
import com.renhuas.common.utils.poi.ExcelUtil;
import com.renhuas.common.core.page.TableDataInfo;

/**
 * 老师教学追溯Controller
 *
 * @author chenzr
 * @date 2021-11-04
 */
@RestController
@RequestMapping("/edutrace/teachedutrace")
public class TraceEduTeachController extends BaseController
{
    @Autowired
    private ITraceEduTeachService traceEduTeachService;

    /**
     * 查询老师教学追溯列表
     */
    @PreAuthorize("@ss.hasPermi('edutrace:teachedutrace:list')")
    @GetMapping("/list")
    public TableDataInfo list(TraceEduTeach traceEduTeach)
    {
        startPage();
        List<TraceEduTeach> list = traceEduTeachService.selectTraceEduTeachList(traceEduTeach);
        return getDataTable(list);
    }

    /**
     * 导出老师教学追溯列表
     */
    @PreAuthorize("@ss.hasPermi('edutrace:teachedutrace:export')")
    @Log(title = "老师教学追溯", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TraceEduTeach traceEduTeach)
    {
        List<TraceEduTeach> list = traceEduTeachService.selectTraceEduTeachList(traceEduTeach);
        ExcelUtil<TraceEduTeach> util = new ExcelUtil<TraceEduTeach>(TraceEduTeach.class);
        return util.exportExcel(list, "老师教学追溯数据");
    }

    /**
     * 获取老师教学追溯详细信息
     */
    @PreAuthorize("@ss.hasPermi('edutrace:teachedutrace:query')")
    @GetMapping(value = "/{traceId}")
    public AjaxResult getInfo(@PathVariable("traceId") Long traceId)
    {
        return AjaxResult.success(traceEduTeachService.selectTraceEduTeachByTraceId(traceId));
    }

    /**
     * 新增老师教学追溯
     */
    @PreAuthorize("@ss.hasPermi('edutrace:teachedutrace:add')")
    @Log(title = "老师教学追溯", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TraceEduTeach traceEduTeach)
    {
        return toAjax(traceEduTeachService.insertTraceEduTeach(traceEduTeach));
    }

    /**
     * 修改老师教学追溯
     */
    @PreAuthorize("@ss.hasPermi('edutrace:teachedutrace:edit')")
    @Log(title = "老师教学追溯", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TraceEduTeach traceEduTeach)
    {
        return toAjax(traceEduTeachService.updateTraceEduTeach(traceEduTeach));
    }

    /**
     * 删除老师教学追溯
     */
    @PreAuthorize("@ss.hasPermi('edutrace:teachedutrace:remove')")
    @Log(title = "老师教学追溯", businessType = BusinessType.DELETE)
	@DeleteMapping("/{traceIds}")
    public AjaxResult remove(@PathVariable Long[] traceIds)
    {
        return toAjax(traceEduTeachService.deleteTraceEduTeachByTraceIds(traceIds));
    }
}
