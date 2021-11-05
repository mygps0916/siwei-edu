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
import com.renhuas.edutrace.domain.TraceEduSch;
import com.renhuas.edutrace.service.ITraceEduSchService;
import com.renhuas.common.utils.poi.ExcelUtil;
import com.renhuas.common.core.page.TableDataInfo;

/**
 * 学校教学追溯Controller
 *
 * @author chenzr
 * @date 2021-11-04
 */
@RestController
@RequestMapping("/edutrace/schedutrace")
public class TraceEduSchController extends BaseController
{
    @Autowired
    private ITraceEduSchService traceEduSchService;

    /**
     * 查询学校教学追溯列表
     */
    @PreAuthorize("@ss.hasPermi('edutrace:schedutrace:list')")
    @GetMapping("/list")
    public TableDataInfo list(TraceEduSch traceEduSch)
    {
        startPage();
        List<TraceEduSch> list = traceEduSchService.selectTraceEduSchList(traceEduSch);
        return getDataTable(list);
    }

    /**
     * 导出学校教学追溯列表
     */
    @PreAuthorize("@ss.hasPermi('edutrace:schedutrace:export')")
    @Log(title = "学校教学追溯", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TraceEduSch traceEduSch)
    {
        List<TraceEduSch> list = traceEduSchService.selectTraceEduSchList(traceEduSch);
        ExcelUtil<TraceEduSch> util = new ExcelUtil<TraceEduSch>(TraceEduSch.class);
        return util.exportExcel(list, "学校教学追溯数据");
    }

    /**
     * 获取学校教学追溯详细信息
     */
    @PreAuthorize("@ss.hasPermi('edutrace:schedutrace:query')")
    @GetMapping(value = "/{traceId}")
    public AjaxResult getInfo(@PathVariable("traceId") Long traceId)
    {
        return AjaxResult.success(traceEduSchService.selectTraceEduSchByTraceId(traceId));
    }

    /**
     * 新增学校教学追溯
     */
    @PreAuthorize("@ss.hasPermi('edutrace:schedutrace:add')")
    @Log(title = "学校教学追溯", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TraceEduSch traceEduSch)
    {
        return toAjax(traceEduSchService.insertTraceEduSch(traceEduSch));
    }

    /**
     * 修改学校教学追溯
     */
    @PreAuthorize("@ss.hasPermi('edutrace:schedutrace:edit')")
    @Log(title = "学校教学追溯", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TraceEduSch traceEduSch)
    {
        return toAjax(traceEduSchService.updateTraceEduSch(traceEduSch));
    }

    /**
     * 删除学校教学追溯
     */
    @PreAuthorize("@ss.hasPermi('edutrace:schedutrace:remove')")
    @Log(title = "学校教学追溯", businessType = BusinessType.DELETE)
	@DeleteMapping("/{traceIds}")
    public AjaxResult remove(@PathVariable Long[] traceIds)
    {
        return toAjax(traceEduSchService.deleteTraceEduSchByTraceIds(traceIds));
    }
}
