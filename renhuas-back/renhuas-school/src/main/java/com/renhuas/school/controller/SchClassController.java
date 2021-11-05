package com.renhuas.school.controller;

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
import com.renhuas.school.domain.SchClass;
import com.renhuas.school.service.ISchClassService;
import com.renhuas.common.utils.poi.ExcelUtil;
import com.renhuas.common.core.page.TableDataInfo;

/**
 * 班级信息Controller
 *
 * @author chenzr
 * @date 2021-11-04
 */
@RestController
@RequestMapping("/school/schclass")
public class SchClassController extends BaseController
{
    @Autowired
    private ISchClassService schClassService;

    /**
     * 查询班级信息列表
     */
    @PreAuthorize("@ss.hasPermi('school:schclass:list')")
    @GetMapping("/list")
    public TableDataInfo list(SchClass schClass)
    {
        startPage();
        List<SchClass> list = schClassService.selectSchClassList(schClass);
        return getDataTable(list);
    }

    /**
     * 导出班级信息列表
     */
    @PreAuthorize("@ss.hasPermi('school:schclass:export')")
    @Log(title = "班级信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SchClass schClass)
    {
        List<SchClass> list = schClassService.selectSchClassList(schClass);
        ExcelUtil<SchClass> util = new ExcelUtil<SchClass>(SchClass.class);
        return util.exportExcel(list, "班级信息数据");
    }

    /**
     * 获取班级信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('school:schclass:query')")
    @GetMapping(value = "/{classId}")
    public AjaxResult getInfo(@PathVariable("classId") Long classId)
    {
        return AjaxResult.success(schClassService.selectSchClassByClassId(classId));
    }

    /**
     * 新增班级信息
     */
    @PreAuthorize("@ss.hasPermi('school:schclass:add')")
    @Log(title = "班级信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SchClass schClass)
    {
        return toAjax(schClassService.insertSchClass(schClass));
    }

    /**
     * 修改班级信息
     */
    @PreAuthorize("@ss.hasPermi('school:schclass:edit')")
    @Log(title = "班级信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SchClass schClass)
    {
        return toAjax(schClassService.updateSchClass(schClass));
    }

    /**
     * 删除班级信息
     */
    @PreAuthorize("@ss.hasPermi('school:schclass:remove')")
    @Log(title = "班级信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{classIds}")
    public AjaxResult remove(@PathVariable Long[] classIds)
    {
        return toAjax(schClassService.deleteSchClassByClassIds(classIds));
    }
}
