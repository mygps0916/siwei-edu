package com.renhuas.datainform.controller;

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
import com.renhuas.datainform.domain.DataInform;
import com.renhuas.datainform.service.IDataInformService;
import com.renhuas.common.utils.poi.ExcelUtil;
import com.renhuas.common.core.page.TableDataInfo;

/**
 * 数据管理Controller
 * 
 * @author chenzr
 * @date 2021-11-04
 */
@RestController
@RequestMapping("/datainform/datainform")
public class DataInformController extends BaseController
{
    @Autowired
    private IDataInformService dataInformService;

    /**
     * 查询数据管理列表
     */
    @PreAuthorize("@ss.hasPermi('datainform:datainform:list')")
    @GetMapping("/list")
    public TableDataInfo list(DataInform dataInform)
    {
        startPage();
        List<DataInform> list = dataInformService.selectDataInformList(dataInform);
        return getDataTable(list);
    }

    /**
     * 导出数据管理列表
     */
    @PreAuthorize("@ss.hasPermi('datainform:datainform:export')")
    @Log(title = "数据管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DataInform dataInform)
    {
        List<DataInform> list = dataInformService.selectDataInformList(dataInform);
        ExcelUtil<DataInform> util = new ExcelUtil<DataInform>(DataInform.class);
        return util.exportExcel(list, "数据管理数据");
    }

    /**
     * 获取数据管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('datainform:datainform:query')")
    @GetMapping(value = "/{inforId}")
    public AjaxResult getInfo(@PathVariable("inforId") Long inforId)
    {
        return AjaxResult.success(dataInformService.selectDataInformByInforId(inforId));
    }

    /**
     * 新增数据管理
     */
    @PreAuthorize("@ss.hasPermi('datainform:datainform:add')")
    @Log(title = "数据管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DataInform dataInform)
    {
        return toAjax(dataInformService.insertDataInform(dataInform));
    }

    /**
     * 修改数据管理
     */
    @PreAuthorize("@ss.hasPermi('datainform:datainform:edit')")
    @Log(title = "数据管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DataInform dataInform)
    {
        return toAjax(dataInformService.updateDataInform(dataInform));
    }

    /**
     * 删除数据管理
     */
    @PreAuthorize("@ss.hasPermi('datainform:datainform:remove')")
    @Log(title = "数据管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{inforIds}")
    public AjaxResult remove(@PathVariable Long[] inforIds)
    {
        return toAjax(dataInformService.deleteDataInformByInforIds(inforIds));
    }
}
