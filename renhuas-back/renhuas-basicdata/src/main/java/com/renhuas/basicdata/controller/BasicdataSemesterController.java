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
import com.renhuas.basicdata.domain.BasicdataSemester;
import com.renhuas.basicdata.service.IBasicdataSemesterService;
import com.renhuas.common.utils.poi.ExcelUtil;
import com.renhuas.common.core.page.TableDataInfo;

/**
 * 学期信息Controller
 *
 * @author chenzr
 * @date 2021-11-04
 */
@RestController
@RequestMapping("/basicdata/semester")
public class BasicdataSemesterController extends BaseController
{
    @Autowired
    private IBasicdataSemesterService basicdataSemesterService;

    /**
     * 查询学期信息列表
     */
    @PreAuthorize("@ss.hasPermi('basicdata:semester:list')")
    @GetMapping("/list")
    public TableDataInfo list(BasicdataSemester basicdataSemester)
    {
        startPage();
        List<BasicdataSemester> list = basicdataSemesterService.selectBasicdataSemesterList(basicdataSemester);
        return getDataTable(list);
    }

    /**
     * 导出学期信息列表
     */
    @PreAuthorize("@ss.hasPermi('basicdata:semester:export')")
    @Log(title = "学期信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BasicdataSemester basicdataSemester)
    {
        List<BasicdataSemester> list = basicdataSemesterService.selectBasicdataSemesterList(basicdataSemester);
        ExcelUtil<BasicdataSemester> util = new ExcelUtil<BasicdataSemester>(BasicdataSemester.class);
        return util.exportExcel(list, "学期信息数据");
    }

    /**
     * 获取学期信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('basicdata:semester:query')")
    @GetMapping(value = "/{semesterId}")
    public AjaxResult getInfo(@PathVariable("semesterId") Long semesterId)
    {
        return AjaxResult.success(basicdataSemesterService.selectBasicdataSemesterBySemesterId(semesterId));
    }

    /**
     * 新增学期信息
     */
    @PreAuthorize("@ss.hasPermi('basicdata:semester:add')")
    @Log(title = "学期信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BasicdataSemester basicdataSemester)
    {
        return toAjax(basicdataSemesterService.insertBasicdataSemester(basicdataSemester));
    }

    /**
     * 修改学期信息
     */
    @PreAuthorize("@ss.hasPermi('basicdata:semester:edit')")
    @Log(title = "学期信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BasicdataSemester basicdataSemester)
    {
        return toAjax(basicdataSemesterService.updateBasicdataSemester(basicdataSemester));
    }

    /**
     * 删除学期信息
     */
    @PreAuthorize("@ss.hasPermi('basicdata:semester:remove')")
    @Log(title = "学期信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{semesterIds}")
    public AjaxResult remove(@PathVariable Long[] semesterIds)
    {
        return toAjax(basicdataSemesterService.deleteBasicdataSemesterBySemesterIds(semesterIds));
    }
}
