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
import com.renhuas.school.domain.SchSchool;
import com.renhuas.school.service.ISchSchoolService;
import com.renhuas.common.utils.poi.ExcelUtil;
import com.renhuas.common.core.page.TableDataInfo;

/**
 * 学校信息Controller
 *
 * @author chenzr
 * @date 2021-11-04
 */
@RestController
@RequestMapping("/school/schschool")
public class SchSchoolController extends BaseController
{
    @Autowired
    private ISchSchoolService schSchoolService;

    /**
     * 查询学校信息列表
     */
    @PreAuthorize("@ss.hasPermi('school:schschool:list')")
    @GetMapping("/list")
    public TableDataInfo list(SchSchool schSchool)
    {
        startPage();
        List<SchSchool> list = schSchoolService.selectSchSchoolList(schSchool);
        return getDataTable(list);
    }

    /**
     * 导出学校信息列表
     */
    @PreAuthorize("@ss.hasPermi('school:schschool:export')")
    @Log(title = "学校信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SchSchool schSchool)
    {
        List<SchSchool> list = schSchoolService.selectSchSchoolList(schSchool);
        ExcelUtil<SchSchool> util = new ExcelUtil<SchSchool>(SchSchool.class);
        return util.exportExcel(list, "学校信息数据");
    }

    /**
     * 获取学校信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('school:schschool:query')")
    @GetMapping(value = "/{schId}")
    public AjaxResult getInfo(@PathVariable("schId") Long schId)
    {
        return AjaxResult.success(schSchoolService.selectSchSchoolBySchId(schId));
    }

    /**
     * 新增学校信息
     */
    @PreAuthorize("@ss.hasPermi('school:schschool:add')")
    @Log(title = "学校信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SchSchool schSchool)
    {
        return toAjax(schSchoolService.insertSchSchool(schSchool));
    }

    /**
     * 修改学校信息
     */
    @PreAuthorize("@ss.hasPermi('school:schschool:edit')")
    @Log(title = "学校信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SchSchool schSchool)
    {
        return toAjax(schSchoolService.updateSchSchool(schSchool));
    }

    /**
     * 删除学校信息
     */
    @PreAuthorize("@ss.hasPermi('school:schschool:remove')")
    @Log(title = "学校信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{schIds}")
    public AjaxResult remove(@PathVariable Long[] schIds)
    {
        return toAjax(schSchoolService.deleteSchSchoolBySchIds(schIds));
    }
}
