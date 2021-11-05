<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="教学质量报告" prop="techQualityName">
        <el-input
          v-model="queryParams.techQualityName"
          placeholder="请输入教学质量报告"
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
      <el-form-item label="客观评价" prop="evalObjective">
        <el-input
          v-model="queryParams.evalObjective"
          placeholder="请输入客观评价"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="主观评价" prop="evalSubjective">
        <el-input
          v-model="queryParams.evalSubjective"
          placeholder="请输入主观评价"
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
          v-hasPermi="['evaluation:eduqualityeval:add']"
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
          v-hasPermi="['evaluation:eduqualityeval:edit']"
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
          v-hasPermi="['evaluation:eduqualityeval:remove']"
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
          v-hasPermi="['evaluation:eduqualityeval:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="eduqualityevalList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="techQualityId" />
      <el-table-column label="教学质量报告" align="center" prop="techQualityName" />
      <el-table-column label="学业阶段" align="center" prop="academic" />
      <el-table-column label="所属学年学期" align="center" prop="schSemester" />
      <el-table-column label="客观评价" align="center" prop="evalObjective" />
      <el-table-column label="主观评价" align="center" prop="evalSubjective" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="创建人" align="center" prop="username" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['evaluation:eduqualityeval:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['evaluation:eduqualityeval:remove']"
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

    <!-- 添加或修改教学质量评测对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="教学质量报告" prop="techQualityName">
          <el-input v-model="form.techQualityName" placeholder="请输入教学质量报告" />
        </el-form-item>
        <el-form-item label="学业阶段" prop="academic">
          <el-input v-model="form.academic" placeholder="请输入学业阶段" />
        </el-form-item>
        <el-form-item label="所属学年学期" prop="schSemester">
          <el-input v-model="form.schSemester" placeholder="请输入所属学年学期" />
        </el-form-item>
        <el-form-item label="客观评价" prop="evalObjective">
          <el-input v-model="form.evalObjective" placeholder="请输入客观评价" />
        </el-form-item>
        <el-form-item label="主观评价" prop="evalSubjective">
          <el-input v-model="form.evalSubjective" placeholder="请输入主观评价" />
        </el-form-item>
        <el-form-item label="用户ID" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户ID" />
        </el-form-item>
        <el-form-item label="创建人" prop="username">
          <el-input v-model="form.username" placeholder="请输入创建人" />
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
import { listEduqualityeval, getEduqualityeval, delEduqualityeval, addEduqualityeval, updateEduqualityeval, exportEduqualityeval } from "@/api/evaluation/eduqualityeval";

export default {
  name: "Eduqualityeval",
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
      // 教学质量评测表格数据
      eduqualityevalList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        techQualityName: null,
        academic: null,
        schSemester: null,
        evalObjective: null,
        evalSubjective: null,
        createTime: null,
        username: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        techQualityName: [
          { required: true, message: "教学质量报告不能为空", trigger: "blur" }
        ],
        academic: [
          { required: true, message: "学业阶段不能为空", trigger: "blur" }
        ],
        schSemester: [
          { required: true, message: "所属学年学期不能为空", trigger: "blur" }
        ],
        evalObjective: [
          { required: true, message: "客观评价不能为空", trigger: "blur" }
        ],
        evalSubjective: [
          { required: true, message: "主观评价不能为空", trigger: "blur" }
        ],
        createTime: [
          { required: true, message: "创建时间不能为空", trigger: "blur" }
        ],
        userId: [
          { required: true, message: "用户ID不能为空", trigger: "blur" }
        ],
        username: [
          { required: true, message: "创建人不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询教学质量评测列表 */
    getList() {
      this.loading = true;
      listEduqualityeval(this.queryParams).then(response => {
        this.eduqualityevalList = response.rows;
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
        techQualityId: null,
        techQualityName: null,
        academic: null,
        schSemester: null,
        evalObjective: null,
        evalSubjective: null,
        createTime: null,
        userId: null,
        username: null
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
      this.ids = selection.map(item => item.techQualityId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加教学质量评测";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const techQualityId = row.techQualityId || this.ids
      getEduqualityeval(techQualityId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改教学质量评测";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.techQualityId != null) {
            updateEduqualityeval(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addEduqualityeval(this.form).then(response => {
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
      const techQualityIds = row.techQualityId || this.ids;
      this.$modal.confirm('是否确认删除教学质量评测编号为"' + techQualityIds + '"的数据项？').then(function() {
        return delEduqualityeval(techQualityIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$modal.confirm('是否确认导出所有教学质量评测数据项？').then(() => {
        this.exportLoading = true;
        return exportEduqualityeval(queryParams);
      }).then(response => {
        this.$download.name(response.msg);
        this.exportLoading = false;
      }).catch(() => {});
    }
  }
};
</script>
