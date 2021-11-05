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
import com.renhuas.basicdata.domain.BasicdataSchType;
import com.renhuas.basicdata.service.IBasicdataSchTypeService;
import com.renhuas.common.utils.poi.ExcelUtil;
import com.renhuas.common.core.page.TableDataInfo;

/**
 * 学校类型Controller
 *
 * @author chenzr
 * @date 2021-11-04
 */
@RestController
@RequestMapping("/basicdata/schooltype")
public class BasicdataSchTypeController extends BaseController
{
    @Autowired
    private IBasicdataSchTypeService basicdataSchTypeService;

    /**
     * 查询学校类型列表
     */
    @PreAuthorize("@ss.hasPermi('basicdata:schooltype:list')")
    @GetMapping("/list")
    public TableDataInfo list(BasicdataSchType basicdataSchType)
    {
        startPage();
        List<BasicdataSchType> list = basicdataSchTypeService.selectBasicdataSchTypeList(basicdataSchType);
        return getDataTable(list);
    }

    /**
     * 导出学校类型列表
     */
    @PreAuthorize("@ss.hasPermi('basicdata:schooltype:export')")
    @Log(title = "学校类型", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BasicdataSchType basicdataSchType)
    {
        List<BasicdataSchType> list = basicdataSchTypeService.selectBasicdataSchTypeList(basicdataSchType);
        ExcelUtil<BasicdataSchType> util = new ExcelUtil<BasicdataSchType>(BasicdataSchType.class);
        return util.exportExcel(list, "学校类型数据");
    }

    /**
     * 获取学校类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('basicdata:schooltype:query')")
    @GetMapping(value = "/{schTypeId}")
    public AjaxResult getInfo(@PathVariable("schTypeId") Long schTypeId)
    {
        return AjaxResult.success(basicdataSchTypeService.selectBasicdataSchTypeBySchTypeId(schTypeId));
    }

    /**
     * 新增学校类型
     */
    @PreAuthorize("@ss.hasPermi('basicdata:schooltype:add')")
    @Log(title = "学校类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BasicdataSchType basicdataSchType)
    {
        return toAjax(basicdataSchTypeService.insertBasicdataSchType(basicdataSchType));
    }

    /**
     * 修改学校类型
     */
    @PreAuthorize("@ss.hasPermi('basicdata:schooltype:edit')")
    @Log(title = "学校类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BasicdataSchType basicdataSchType)
    {
        return toAjax(basicdataSchTypeService.updateBasicdataSchType(basicdataSchType));
    }

    /**
     * 删除学校类型
     */
    @PreAuthorize("@ss.hasPermi('basicdata:schooltype:remove')")
    @Log(title = "学校类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{schTypeIds}")
    public AjaxResult remove(@PathVariable Long[] schTypeIds)
    {
        return toAjax(basicdataSchTypeService.deleteBasicdataSchTypeBySchTypeIds(schTypeIds));
    }
}
