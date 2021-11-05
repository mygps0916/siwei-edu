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
import com.renhuas.school.domain.SchTeacher;
import com.renhuas.school.service.ISchTeacherService;
import com.renhuas.common.utils.poi.ExcelUtil;
import com.renhuas.common.core.page.TableDataInfo;

/**
 * 教师信息Controller
 *
 * @author chenzr
 * @date 2021-11-04
 */
@RestController
@RequestMapping("/school/schteacher")
public class SchTeacherController extends BaseController
{
    @Autowired
    private ISchTeacherService schTeacherService;

    /**
     * 查询教师信息列表
     */
    @PreAuthorize("@ss.hasPermi('school:schteacher:list')")
    @GetMapping("/list")
    public TableDataInfo list(SchTeacher schTeacher)
    {
        startPage();
        List<SchTeacher> list = schTeacherService.selectSchTeacherList(schTeacher);
        return getDataTable(list);
    }

    /**
     * 导出教师信息列表
     */
    @PreAuthorize("@ss.hasPermi('school:schteacher:export')")
    @Log(title = "教师信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SchTeacher schTeacher)
    {
        List<SchTeacher> list = schTeacherService.selectSchTeacherList(schTeacher);
        ExcelUtil<SchTeacher> util = new ExcelUtil<SchTeacher>(SchTeacher.class);
        return util.exportExcel(list, "教师信息数据");
    }

    /**
     * 获取教师信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('school:schteacher:query')")
    @GetMapping(value = "/{teachId}")
    public AjaxResult getInfo(@PathVariable("teachId") Long teachId)
    {
        return AjaxResult.success(schTeacherService.selectSchTeacherByTeachId(teachId));
    }

    /**
     * 新增教师信息
     */
    @PreAuthorize("@ss.hasPermi('school:schteacher:add')")
    @Log(title = "教师信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SchTeacher schTeacher)
    {
        return toAjax(schTeacherService.insertSchTeacher(schTeacher));
    }

    /**
     * 修改教师信息
     */
    @PreAuthorize("@ss.hasPermi('school:schteacher:edit')")
    @Log(title = "教师信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SchTeacher schTeacher)
    {
        return toAjax(schTeacherService.updateSchTeacher(schTeacher));
    }

    /**
     * 删除教师信息
     */
    @PreAuthorize("@ss.hasPermi('school:schteacher:remove')")
    @Log(title = "教师信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{teachIds}")
    public AjaxResult remove(@PathVariable Long[] teachIds)
    {
        return toAjax(schTeacherService.deleteSchTeacherByTeachIds(teachIds));
    }
}
