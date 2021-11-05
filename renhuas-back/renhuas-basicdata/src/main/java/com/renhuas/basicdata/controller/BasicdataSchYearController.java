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
import com.renhuas.basicdata.domain.BasicdataSchYear;
import com.renhuas.basicdata.service.IBasicdataSchYearService;
import com.renhuas.common.utils.poi.ExcelUtil;
import com.renhuas.common.core.page.TableDataInfo;

/**
 * 学年信息Controller
 *
 * @author chenzr
 * @date 2021-11-04
 */
@RestController
@RequestMapping("/basicdata/schoolyear")
public class BasicdataSchYearController extends BaseController
{
    @Autowired
    private IBasicdataSchYearService basicdataSchYearService;

    /**
     * 查询学年信息列表
     */
    @PreAuthorize("@ss.hasPermi('basicdata:schoolyear:list')")
    @GetMapping("/list")
    public TableDataInfo list(BasicdataSchYear basicdataSchYear)
    {
        startPage();
        List<BasicdataSchYear> list = basicdataSchYearService.selectBasicdataSchYearList(basicdataSchYear);
        return getDataTable(list);
    }

    /**
     * 导出学年信息列表
     */
    @PreAuthorize("@ss.hasPermi('basicdata:schoolyear:export')")
    @Log(title = "学年信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BasicdataSchYear basicdataSchYear)
    {
        List<BasicdataSchYear> list = basicdataSchYearService.selectBasicdataSchYearList(basicdataSchYear);
        ExcelUtil<BasicdataSchYear> util = new ExcelUtil<BasicdataSchYear>(BasicdataSchYear.class);
        return util.exportExcel(list, "学年信息数据");
    }

    /**
     * 获取学年信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('basicdata:schoolyear:query')")
    @GetMapping(value = "/{schYearId}")
    public AjaxResult getInfo(@PathVariable("schYearId") Long schYearId)
    {
        return AjaxResult.success(basicdataSchYearService.selectBasicdataSchYearBySchYearId(schYearId));
    }

    /**
     * 新增学年信息
     */
    @PreAuthorize("@ss.hasPermi('basicdata:schoolyear:add')")
    @Log(title = "学年信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BasicdataSchYear basicdataSchYear)
    {
        return toAjax(basicdataSchYearService.insertBasicdataSchYear(basicdataSchYear));
    }

    /**
     * 修改学年信息
     */
    @PreAuthorize("@ss.hasPermi('basicdata:schoolyear:edit')")
    @Log(title = "学年信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BasicdataSchYear basicdataSchYear)
    {
        return toAjax(basicdataSchYearService.updateBasicdataSchYear(basicdataSchYear));
    }

    /**
     * 删除学年信息
     */
    @PreAuthorize("@ss.hasPermi('basicdata:schoolyear:remove')")
    @Log(title = "学年信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{schYearIds}")
    public AjaxResult remove(@PathVariable Long[] schYearIds)
    {
        return toAjax(basicdataSchYearService.deleteBasicdataSchYearBySchYearIds(schYearIds));
    }
}
