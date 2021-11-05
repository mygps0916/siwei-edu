<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="总表名称" prop="evalName">
        <el-input
          v-model="queryParams.evalName"
          placeholder="请输入总表名称"
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
      <el-form-item label="所属学年学期" prop="schSemester">
        <el-input
          v-model="queryParams.schSemester"
          placeholder="请输入所属学年学期"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="测评方案名称" prop="evalPlanName">
        <el-input
          v-model="queryParams.evalPlanName"
          placeholder="请输入测评方案名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建时间" prop="createTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.createTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择创建时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="创建人" prop="username">
        <el-input
          v-model="queryParams.username"
          placeholder="请输入创建人"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="引用状态" prop="refState">
        <el-select v-model="queryParams.refState" placeholder="请选择引用状态" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_common_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
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
          v-hasPermi="['evaluation:schooledueval:add']"
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
          v-hasPermi="['evaluation:schooledueval:edit']"
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
          v-hasPermi="['evaluation:schooledueval:remove']"
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
          v-hasPermi="['evaluation:schooledueval:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="schooleduevalList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="evalId" />
      <el-table-column label="总表名称" align="center" prop="evalName" />
      <el-table-column label="学业阶段" align="center" prop="academic" />
      <el-table-column label="所属学年学期" align="center" prop="schSemester" />
      <el-table-column label="测评方案名称" align="center" prop="evalPlanName" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="创建人" align="center" prop="username" />
      <el-table-column label="引用状态" align="center" prop="refState">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_common_status" :value="scope.row.refState"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['evaluation:schooledueval:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['evaluation:schooledueval:remove']"
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

    <!-- 添加或修改学校测评对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="总表名称" prop="evalName">
          <el-input v-model="form.evalName" placeholder="请输入总表名称" />
        </el-form-item>
        <el-form-item label="学业阶段" prop="academic">
          <el-input v-model="form.academic" placeholder="请输入学业阶段" />
        </el-form-item>
        <el-form-item label="所属学年学期" prop="schSemester">
          <el-input v-model="form.schSemester" placeholder="请输入所属学年学期" />
        </el-form-item>
        <el-form-item label="测评方案名称" prop="evalPlanName">
          <el-input v-model="form.evalPlanName" placeholder="请输入测评方案名称" />
        </el-form-item>
        <el-form-item label="用户ID" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户ID" />
        </el-form-item>
        <el-form-item label="创建人" prop="username">
          <el-input v-model="form.username" placeholder="请输入创建人" />
        </el-form-item>
        <el-form-item label="引用状态" prop="refState">
          <el-select v-model="form.refState" placeholder="请选择引用状态">
            <el-option
              v-for="dict in dict.type.sys_common_status"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
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
import { listSchooledueval, getSchooledueval, delSchooledueval, addSchooledueval, updateSchooledueval, exportSchooledueval } from "@/api/evaluation/schooledueval";

export default {
  name: "Schooledueval",
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
      // 学校测评表格数据
      schooleduevalList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        evalName: null,
        academic: null,
        schSemester: null,
        evalPlanName: null,
        createTime: null,
        username: null,
        refState: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        evalName: [
          { required: true, message: "总表名称不能为空", trigger: "blur" }
        ],
        academic: [
          { required: true, message: "学业阶段不能为空", trigger: "blur" }
        ],
        schSemester: [
          { required: true, message: "所属学年学期不能为空", trigger: "blur" }
        ],
        evalPlanName: [
          { required: true, message: "测评方案名称不能为空", trigger: "blur" }
        ],
        createTime: [
          { required: true, message: "创建时间不能为空", trigger: "blur" }
        ],
        userId: [
          { required: true, message: "用户ID不能为空", trigger: "blur" }
        ],
        username: [
          { required: true, message: "创建人不能为空", trigger: "blur" }
        ],
        refState: [
          { required: true, message: "引用状态不能为空", trigger: "change" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询学校测评列表 */
    getList() {
      this.loading = true;
      listSchooledueval(this.queryParams).then(response => {
        this.schooleduevalList = response.rows;
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
        evalId: null,
        evalName: null,
        academic: null,
        schSemester: null,
        evalPlanName: null,
        createTime: null,
        userId: null,
        username: null,
        refState: null
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
      this.ids = selection.map(item => item.evalId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加学校测评";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const evalId = row.evalId || this.ids
      getSchooledueval(evalId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改学校测评";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.evalId != null) {
            updateSchooledueval(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSchooledueval(this.form).then(response => {
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
      const evalIds = row.evalId || this.ids;
      this.$modal.confirm('是否确认删除学校测评编号为"' + evalIds + '"的数据项？').then(function() {
        return delSchooledueval(evalIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$modal.confirm('是否确认导出所有学校测评数据项？').then(() => {
        this.exportLoading = true;
        return exportSchooledueval(queryParams);
      }).then(response => {
        this.$download.name(response.msg);
        this.exportLoading = false;
      }).catch(() => {});
    }
  }
};
</script>
