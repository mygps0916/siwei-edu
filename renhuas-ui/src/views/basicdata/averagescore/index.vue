<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="科目" prop="course">
        <el-input
          v-model="queryParams.course"
          placeholder="请输入科目"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="平均分数" prop="averageScore">
        <el-input
          v-model="queryParams.averageScore"
          placeholder="请输入平均分数"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="类型" prop="averType">
        <el-select v-model="queryParams.averType" placeholder="请选择类型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
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
      <el-form-item label="学年" prop="schYear">
        <el-input
          v-model="queryParams.schYear"
          placeholder="请输入学年"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学期" prop="semester">
        <el-input
          v-model="queryParams.semester"
          placeholder="请输入学期"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="年级" prop="grade">
        <el-input
          v-model="queryParams.grade"
          placeholder="请输入年级"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="年级ID" prop="gradeId">
        <el-input
          v-model="queryParams.gradeId"
          placeholder="请输入年级ID"
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
          v-hasPermi="['basicdata:averagescore:add']"
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
          v-hasPermi="['basicdata:averagescore:edit']"
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
          v-hasPermi="['basicdata:averagescore:remove']"
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
          v-hasPermi="['basicdata:averagescore:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="averagescoreList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="averageScoreId" />
      <el-table-column label="科目" align="center" prop="course" />
      <el-table-column label="平均分数" align="center" prop="averageScore" />
      <el-table-column label="类型" align="center" prop="averType" />
      <el-table-column label="学业阶段" align="center" prop="academic" />
      <el-table-column label="学年" align="center" prop="schYear" />
      <el-table-column label="学期" align="center" prop="semester" />
      <el-table-column label="年级" align="center" prop="grade" />
      <el-table-column label="年级ID" align="center" prop="gradeId" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['basicdata:averagescore:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['basicdata:averagescore:remove']"
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

    <!-- 添加或修改平均分数对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="科目" prop="course">
          <el-input v-model="form.course" placeholder="请输入科目" />
        </el-form-item>
        <el-form-item label="科目ID" prop="courseId">
          <el-input v-model="form.courseId" placeholder="请输入科目ID" />
        </el-form-item>
        <el-form-item label="平均分数" prop="averageScore">
          <el-input v-model="form.averageScore" placeholder="请输入平均分数" />
        </el-form-item>
        <el-form-item label="类型" prop="averType">
          <el-select v-model="form.averType" placeholder="请选择类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="学业阶段" prop="academic">
          <el-input v-model="form.academic" placeholder="请输入学业阶段" />
        </el-form-item>
        <el-form-item label="学年" prop="schYear">
          <el-input v-model="form.schYear" placeholder="请输入学年" />
        </el-form-item>
        <el-form-item label="学年ID" prop="schYearId">
          <el-input v-model="form.schYearId" placeholder="请输入学年ID" />
        </el-form-item>
        <el-form-item label="学期" prop="semester">
          <el-input v-model="form.semester" placeholder="请输入学期" />
        </el-form-item>
        <el-form-item label="学期ID" prop="semesterId">
          <el-input v-model="form.semesterId" placeholder="请输入学期ID" />
        </el-form-item>
        <el-form-item label="年级" prop="grade">
          <el-input v-model="form.grade" placeholder="请输入年级" />
        </el-form-item>
        <el-form-item label="年级ID" prop="gradeId">
          <el-input v-model="form.gradeId" placeholder="请输入年级ID" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
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
import { listAveragescore, getAveragescore, delAveragescore, addAveragescore, updateAveragescore, exportAveragescore } from "@/api/basicdata/averagescore";

export default {
  name: "Averagescore",
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
      // 平均分数表格数据
      averagescoreList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        course: null,
        averageScore: null,
        averType: null,
        academic: null,
        schYear: null,
        semester: null,
        grade: null,
        gradeId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        course: [
          { required: true, message: "科目不能为空", trigger: "blur" }
        ],
        courseId: [
          { required: true, message: "科目ID不能为空", trigger: "blur" }
        ],
        averageScore: [
          { required: true, message: "平均分数不能为空", trigger: "blur" }
        ],
        averType: [
          { required: true, message: "类型不能为空", trigger: "change" }
        ],
        academic: [
          { required: true, message: "学业阶段不能为空", trigger: "blur" }
        ],
        schYear: [
          { required: true, message: "学年不能为空", trigger: "blur" }
        ],
        schYearId: [
          { required: true, message: "学年ID不能为空", trigger: "blur" }
        ],
        semester: [
          { required: true, message: "学期不能为空", trigger: "blur" }
        ],
        semesterId: [
          { required: true, message: "学期ID不能为空", trigger: "blur" }
        ],
        grade: [
          { required: true, message: "年级不能为空", trigger: "blur" }
        ],
        gradeId: [
          { required: true, message: "年级ID不能为空", trigger: "blur" }
        ],
        remark: [
          { required: true, message: "备注不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询平均分数列表 */
    getList() {
      this.loading = true;
      listAveragescore(this.queryParams).then(response => {
        this.averagescoreList = response.rows;
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
        averageScoreId: null,
        course: null,
        courseId: null,
        averageScore: null,
        averType: null,
        academic: null,
        schYear: null,
        schYearId: null,
        semester: null,
        semesterId: null,
        grade: null,
        gradeId: null,
        remark: null
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
      this.ids = selection.map(item => item.averageScoreId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加平均分数";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const averageScoreId = row.averageScoreId || this.ids
      getAveragescore(averageScoreId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改平均分数";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.averageScoreId != null) {
            updateAveragescore(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAveragescore(this.form).then(response => {
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
      const averageScoreIds = row.averageScoreId || this.ids;
      this.$modal.confirm('是否确认删除平均分数编号为"' + averageScoreIds + '"的数据项？').then(function() {
        return delAveragescore(averageScoreIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$modal.confirm('是否确认导出所有平均分数数据项？').then(() => {
        this.exportLoading = true;
        return exportAveragescore(queryParams);
      }).then(response => {
        this.$download.name(response.msg);
        this.exportLoading = false;
      }).catch(() => {});
    }
  }
};
</script>
