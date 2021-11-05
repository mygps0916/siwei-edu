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
import com.renhuas.school.domain.SchStudent;
import com.renhuas.school.service.ISchStudentService;
import com.renhuas.common.utils.poi.ExcelUtil;
import com.renhuas.common.core.page.TableDataInfo;

/**
 * 学生信息Controller
 *
 * @author chenzr
 * @date 2021-11-04
 */
@RestController
@RequestMapping("/school/schstudent")
public class SchStudentController extends BaseController
{
    @Autowired
    private ISchStudentService schStudentService;

    /**
     * 查询学生信息列表
     */
    @PreAuthorize("@ss.hasPermi('school:schstudent:list')")
    @GetMapping("/list")
    public TableDataInfo list(SchStudent schStudent)
    {
        startPage();
        List<SchStudent> list = schStudentService.selectSchStudentList(schStudent);
        return getDataTable(list);
    }

    /**
     * 导出学生信息列表
     */
    @PreAuthorize("@ss.hasPermi('school:schstudent:export')")
    @Log(title = "学生信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SchStudent schStudent)
    {
        List<SchStudent> list = schStudentService.selectSchStudentList(schStudent);
        ExcelUtil<SchStudent> util = new ExcelUtil<SchStudent>(SchStudent.class);
        return util.exportExcel(list, "学生信息数据");
    }

    /**
     * 获取学生信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('school:schstudent:query')")
    @GetMapping(value = "/{stuId}")
    public AjaxResult getInfo(@PathVariable("stuId") Long stuId)
    {
        return AjaxResult.success(schStudentService.selectSchStudentByStuId(stuId));
    }

    /**
     * 新增学生信息
     */
    @PreAuthorize("@ss.hasPermi('school:schstudent:add')")
    @Log(title = "学生信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SchStudent schStudent)
    {
        return toAjax(schStudentService.insertSchStudent(schStudent));
    }

    /**
     * 修改学生信息
     */
    @PreAuthorize("@ss.hasPermi('school:schstudent:edit')")
    @Log(title = "学生信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SchStudent schStudent)
    {
        return toAjax(schStudentService.updateSchStudent(schStudent));
    }

    /**
     * 删除学生信息
     */
    @PreAuthorize("@ss.hasPermi('school:schstudent:remove')")
    @Log(title = "学生信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{stuIds}")
    public AjaxResult remove(@PathVariable Long[] stuIds)
    {
        return toAjax(schStudentService.deleteSchStudentByStuIds(stuIds));
    }
}
