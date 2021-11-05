<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="老师名称" prop="teachName">
        <el-input
          v-model="queryParams.teachName"
          placeholder="请输入老师名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身份证号" prop="cartId">
        <el-input
          v-model="queryParams.cartId"
          placeholder="请输入身份证号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学校名称" prop="schName">
        <el-input
          v-model="queryParams.schName"
          placeholder="请输入学校名称"
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
      <el-form-item label="学期" prop="academic">
        <el-input
          v-model="queryParams.academic"
          placeholder="请输入学期"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="测评得分" prop="evalScore">
        <el-input
          v-model="queryParams.evalScore"
          placeholder="请输入测评得分"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="排名" prop="ranking">
        <el-input
          v-model="queryParams.ranking"
          placeholder="请输入排名"
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
          v-hasPermi="['evalanalyze:teachevalanalyze:add']"
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
          v-hasPermi="['evalanalyze:teachevalanalyze:edit']"
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
          v-hasPermi="['evalanalyze:teachevalanalyze:remove']"
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
          v-hasPermi="['evalanalyze:teachevalanalyze:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="teachevalanalyzeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="analyzeId" />
      <el-table-column label="老师名称" align="center" prop="teachName" />
      <el-table-column label="身份证号" align="center" prop="cartId" />
      <el-table-column label="学校名称" align="center" prop="schName" />
      <el-table-column label="学年" align="center" prop="schYear" />
      <el-table-column label="学期" align="center" prop="academic" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="测评得分" align="center" prop="evalScore" />
      <el-table-column label="排名" align="center" prop="ranking" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['evalanalyze:teachevalanalyze:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['evalanalyze:teachevalanalyze:remove']"
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

    <!-- 添加或修改老师测评分析对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="老师名称" prop="teachName">
          <el-input v-model="form.teachName" placeholder="请输入老师名称" />
        </el-form-item>
        <el-form-item label="老师ID" prop="teachId">
          <el-input v-model="form.teachId" placeholder="请输入老师ID" />
        </el-form-item>
        <el-form-item label="身份证号" prop="cartId">
          <el-input v-model="form.cartId" placeholder="请输入身份证号" />
        </el-form-item>
        <el-form-item label="学校名称" prop="schName">
          <el-input v-model="form.schName" placeholder="请输入学校名称" />
        </el-form-item>
        <el-form-item label="学校ID" prop="schId">
          <el-input v-model="form.schId" placeholder="请输入学校ID" />
        </el-form-item>
        <el-form-item label="学年" prop="schYear">
          <el-input v-model="form.schYear" placeholder="请输入学年" />
        </el-form-item>
        <el-form-item label="学期" prop="academic">
          <el-input v-model="form.academic" placeholder="请输入学期" />
        </el-form-item>
        <el-form-item label="测评得分" prop="evalScore">
          <el-input v-model="form.evalScore" placeholder="请输入测评得分" />
        </el-form-item>
        <el-form-item label="排名" prop="ranking">
          <el-input v-model="form.ranking" placeholder="请输入排名" />
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
import { listTeachevalanalyze, getTeachevalanalyze, delTeachevalanalyze, addTeachevalanalyze, updateTeachevalanalyze, exportTeachevalanalyze } from "@/api/evalanalyze/teachevalanalyze";

export default {
  name: "Teachevalanalyze",
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
      // 老师测评分析表格数据
      teachevalanalyzeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        teachName: null,
        cartId: null,
        schName: null,
        schYear: null,
        academic: null,
        evalScore: null,
        ranking: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        teachName: [
          { required: true, message: "老师名称不能为空", trigger: "blur" }
        ],
        teachId: [
          { required: true, message: "老师ID不能为空", trigger: "blur" }
        ],
        cartId: [
          { required: true, message: "身份证号不能为空", trigger: "blur" }
        ],
        schName: [
          { required: true, message: "学校名称不能为空", trigger: "blur" }
        ],
        schId: [
          { required: true, message: "学校ID不能为空", trigger: "blur" }
        ],
        schYear: [
          { required: true, message: "学年不能为空", trigger: "blur" }
        ],
        academic: [
          { required: true, message: "学期不能为空", trigger: "blur" }
        ],
        createTime: [
          { required: true, message: "创建时间不能为空", trigger: "blur" }
        ],
        evalScore: [
          { required: true, message: "测评得分不能为空", trigger: "blur" }
        ],
        ranking: [
          { required: true, message: "排名不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询老师测评分析列表 */
    getList() {
      this.loading = true;
      listTeachevalanalyze(this.queryParams).then(response => {
        this.teachevalanalyzeList = response.rows;
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
        analyzeId: null,
        teachName: null,
        teachId: null,
        cartId: null,
        schName: null,
        schId: null,
        schYear: null,
        academic: null,
        createTime: null,
        evalScore: null,
        ranking: null
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
      this.ids = selection.map(item => item.analyzeId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加老师测评分析";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const analyzeId = row.analyzeId || this.ids
      getTeachevalanalyze(analyzeId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改老师测评分析";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.analyzeId != null) {
            updateTeachevalanalyze(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTeachevalanalyze(this.form).then(response => {
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
      const analyzeIds = row.analyzeId || this.ids;
      this.$modal.confirm('是否确认删除老师测评分析编号为"' + analyzeIds + '"的数据项？').then(function() {
        return delTeachevalanalyze(analyzeIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$modal.confirm('是否确认导出所有老师测评分析数据项？').then(() => {
        this.exportLoading = true;
        return exportTeachevalanalyze(queryParams);
      }).then(response => {
        this.$download.name(response.msg);
        this.exportLoading = false;
      }).catch(() => {});
    }
  }
};
</script>
