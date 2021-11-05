package com.renhuas.basicdata.controller;

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
import com.renhuas.basicdata.domain.BasicdataCourse;
import com.renhuas.basicdata.service.IBasicdataCourseService;
import com.renhuas.common.utils.poi.ExcelUtil;
import com.renhuas.common.core.page.TableDataInfo;

/**
 * 科目信息Controller
 *
 * @author chenzr
 * @date 2021-11-04
 */
@RestController
@RequestMapping("/basicdata/courseinfo")
public class BasicdataCourseController extends BaseController
{
    @Autowired
    private IBasicdataCourseService basicdataCourseService;

    /**
     * 查询科目信息列表
     */
    @PreAuthorize("@ss.hasPermi('basicdata:courseinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(BasicdataCourse basicdataCourse)
    {
        startPage();
        List<BasicdataCourse> list = basicdataCourseService.selectBasicdataCourseList(basicdataCourse);
        return getDataTable(list);
    }

    /**
     * 导出科目信息列表
     */
    @PreAuthorize("@ss.hasPermi('basicdata:courseinfo:export')")
    @Log(title = "科目信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BasicdataCourse basicdataCourse)
    {
        List<BasicdataCourse> list = basicdataCourseService.selectBasicdataCourseList(basicdataCourse);
        ExcelUtil<BasicdataCourse> util = new ExcelUtil<BasicdataCourse>(BasicdataCourse.class);
        return util.exportExcel(list, "科目信息数据");
    }

    /**
     * 获取科目信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('basicdata:courseinfo:query')")
    @GetMapping(value = "/{courseId}")
    public AjaxResult getInfo(@PathVariable("courseId") Long courseId)
    {
        return AjaxResult.success(basicdataCourseService.selectBasicdataCourseByCourseId(courseId));
    }

    /**
     * 新增科目信息
     */
    @PreAuthorize("@ss.hasPermi('basicdata:courseinfo:add')")
    @Log(title = "科目信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BasicdataCourse basicdataCourse)
    {
        return toAjax(basicdataCourseService.insertBasicdataCourse(basicdataCourse));
    }

    /**
     * 修改科目信息
     */
    @PreAuthorize("@ss.hasPermi('basicdata:courseinfo:edit')")
    @Log(title = "科目信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BasicdataCourse basicdataCourse)
    {
        return toAjax(basicdataCourseService.updateBasicdataCourse(basicdataCourse));
    }

    /**
     * 删除科目信息
     */
    @PreAuthorize("@ss.hasPermi('basicdata:courseinfo:remove')")
    @Log(title = "科目信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{courseIds}")
    public AjaxResult remove(@PathVariable Long[] courseIds)
    {
        return toAjax(basicdataCourseService.deleteBasicdataCourseByCourseIds(courseIds));
    }
}
