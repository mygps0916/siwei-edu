<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="文件名称" prop="inforName">
        <el-input
          v-model="queryParams.inforName"
          placeholder="请输入文件名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学年学期" prop="schSemester">
        <el-input
          v-model="queryParams.schSemester"
          placeholder="请输入学年学期"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学业阶段" prop="academic">
        <el-input
          v-model="queryParams.academic"
          placeholder="请输入学业阶段"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="文件类型" prop="inforType">
        <el-select v-model="queryParams.inforType" placeholder="请选择文件类型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="上传时间" prop="uploadTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.uploadTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择上传时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="上传状态" prop="uploadState">
        <el-select v-model="queryParams.uploadState" placeholder="请选择上传状态" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_common_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="锁定状态" prop="lockState">
        <el-input
          v-model="queryParams.lockState"
          placeholder="请输入锁定状态"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['datainform:datainform:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['datainform:datainform:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['datainform:datainform:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          :loading="exportLoading"
          @click="handleExport"
          v-hasPermi="['datainform:datainform:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="datainformList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="inforId" />
      <el-table-column label="文件名称" align="center" prop="inforName" />
      <el-table-column label="学年学期" align="center" prop="schSemester" />
      <el-table-column label="学业阶段" align="center" prop="academic" />
      <el-table-column label="文件类型" align="center" prop="inforType" />
      <el-table-column label="上传时间" align="center" prop="uploadTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.uploadTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="创建人" align="center" prop="username" />
      <el-table-column label="上传状态" align="center" prop="uploadState">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_common_status" :value="scope.row.uploadState"/>
        </template>
      </el-table-column>
      <el-table-column label="锁定状态" align="center" prop="lockState">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_job_status" :value="scope.row.lockState"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['datainform:datainform:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['datainform:datainform:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改数据管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="文件名称" prop="inforName">
          <el-input v-model="form.inforName" placeholder="请输入文件名称" />
        </el-form-item>
        <el-form-item label="学年学期" prop="schSemester">
          <el-input v-model="form.schSemester" placeholder="请输入学年学期" />
        </el-form-item>
        <el-form-item label="学业阶段" prop="academic">
          <el-input v-model="form.academic" placeholder="请输入学业阶段" />
        </el-form-item>
        <el-form-item label="文件类型" prop="inforType">
          <el-select v-model="form.inforType" placeholder="请选择文件类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="上传时间" prop="uploadTime">
          <el-date-picker clearable size="small"
            v-model="form.uploadTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择上传时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="上传状态" prop="uploadState">
          <el-select v-model="form.uploadState" placeholder="请选择上传状态">
            <el-option
              v-for="dict in dict.type.sys_common_status"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="锁定状态" prop="lockState">
          <el-input v-model="form.lockState" placeholder="请输入锁定状态" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listDatainform, getDatainform, delDatainform, addDatainform, updateDatainform, exportDatainform } from "@/api/datainform/datainform";

export default {
  name: "Datainform",
  dicts: ['sys_common_status'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 导出遮罩层
      exportLoading: false,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 数据管理表格数据
      datainformList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        inforName: null,
        schSemester: null,
        academic: null,
        inforType: null,
        uploadTime: null,
        uploadState: null,
        lockState: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        inforName: [
          { required: true, message: "文件名称不能为空", trigger: "blur" }
        ],
        schSemester: [
          { required: true, message: "学年学期不能为空", trigger: "blur" }
        ],
        academic: [
          { required: true, message: "学业阶段不能为空", trigger: "blur" }
        ],
        inforType: [
          { required: true, message: "文件类型不能为空", trigger: "change" }
        ],
        uploadTime: [
          { required: true, message: "上传时间不能为空", trigger: "blur" }
        ],
        uploadState: [
          { required: true, message: "上传状态不能为空", trigger: "change" }
        ],
        lockState: [
          { required: true, message: "锁定状态不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询数据管理列表 */
    getList() {
      this.loading = true;
      listDatainform(this.queryParams).then(response => {
        this.datainformList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        inforId: null,
        inforName: null,
        schSemester: null,
        academic: null,
        inforType: null,
        uploadTime: null,
        userId: null,
        username: null,
        uploadState: null,
        lockState: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.inforId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加数据管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const inforId = row.inforId || this.ids
      getDatainform(inforId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改数据管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.inforId != null) {
            updateDatainform(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDatainform(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const inforIds = row.inforId || this.ids;
      this.$modal.confirm('是否确认删除数据管理编号为"' + inforIds + '"的数据项？').then(function() {
        return delDatainform(inforIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$modal.confirm('是否确认导出所有数据管理数据项？').then(() => {
        this.exportLoading = true;
        return exportDatainform(queryParams);
      }).then(response => {
        this.$download.name(response.msg);
        this.exportLoading = false;
      }).catch(() => {});
    }
  }
};
</script>
