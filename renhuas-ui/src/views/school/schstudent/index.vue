<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="学生姓名" prop="stuName">
        <el-input
          v-model="queryParams.stuName"
          placeholder="请输入学生姓名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="民族" prop="stuNation">
        <el-input
          v-model="queryParams.stuNation"
          placeholder="请输入民族"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="stuSex">
        <el-select v-model="queryParams.stuSex" placeholder="请选择性别" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
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
      <el-form-item label="学籍号" prop="schNum">
        <el-input
          v-model="queryParams.schNum"
          placeholder="请输入学籍号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="当前年级" prop="grade">
        <el-input
          v-model="queryParams.grade"
          placeholder="请输入当前年级"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="当前班级" prop="className">
        <el-input
          v-model="queryParams.className"
          placeholder="请输入当前班级"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="籍贯" prop="nativePlace">
        <el-input
          v-model="queryParams.nativePlace"
          placeholder="请输入籍贯"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="监护人姓名" prop="guardian">
        <el-input
          v-model="queryParams.guardian"
          placeholder="请输入监护人姓名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="监护人电话" prop="guardPhone">
        <el-input
          v-model="queryParams.guardPhone"
          placeholder="请输入监护人电话"
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
          v-hasPermi="['school:schstudent:add']"
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
          v-hasPermi="['school:schstudent:edit']"
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
          v-hasPermi="['school:schstudent:remove']"
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
          v-hasPermi="['school:schstudent:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="schstudentList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="stuId" />
      <el-table-column label="学生姓名" align="center" prop="stuName" />
      <el-table-column label="民族" align="center" prop="stuNation" />
      <el-table-column label="性别" align="center" prop="stuSex" />
      <el-table-column label="学校名称" align="center" prop="schName" />
      <el-table-column label="学籍号" align="center" prop="schNum" />
      <el-table-column label="当前年级" align="center" prop="grade" />
      <el-table-column label="当前班级" align="center" prop="className" />
      <el-table-column label="籍贯" align="center" prop="nativePlace" />
      <el-table-column label="常住地址" align="center" prop="address" />
      <el-table-column label="监护人姓名" align="center" prop="guardian" />
      <el-table-column label="监护人电话" align="center" prop="guardPhone" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['school:schstudent:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['school:schstudent:remove']"
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

    <!-- 添加或修改学生信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="学生姓名" prop="stuName">
          <el-input v-model="form.stuName" placeholder="请输入学生姓名" />
        </el-form-item>
        <el-form-item label="民族" prop="stuNation">
          <el-input v-model="form.stuNation" placeholder="请输入民族" />
        </el-form-item>
        <el-form-item label="性别" prop="stuSex">
          <el-select v-model="form.stuSex" placeholder="请选择性别">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="学校名称" prop="schName">
          <el-input v-model="form.schName" placeholder="请输入学校名称" />
        </el-form-item>
        <el-form-item label="学校ID" prop="schId">
          <el-input v-model="form.schId" placeholder="请输入学校ID" />
        </el-form-item>
        <el-form-item label="学籍号" prop="schNum">
          <el-input v-model="form.schNum" placeholder="请输入学籍号" />
        </el-form-item>
        <el-form-item label="当前年级" prop="grade">
          <el-input v-model="form.grade" placeholder="请输入当前年级" />
        </el-form-item>
        <el-form-item label="班级ID" prop="classId">
          <el-input v-model="form.classId" placeholder="请输入班级ID" />
        </el-form-item>
        <el-form-item label="当前班级" prop="className">
          <el-input v-model="form.className" placeholder="请输入当前班级" />
        </el-form-item>
        <el-form-item label="籍贯" prop="nativePlace">
          <el-input v-model="form.nativePlace" placeholder="请输入籍贯" />
        </el-form-item>
        <el-form-item label="常住地址" prop="address">
          <el-input v-model="form.address" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="监护人姓名" prop="guardian">
          <el-input v-model="form.guardian" placeholder="请输入监护人姓名" />
        </el-form-item>
        <el-form-item label="监护人电话" prop="guardPhone">
          <el-input v-model="form.guardPhone" placeholder="请输入监护人电话" />
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
import { listSchstudent, getSchstudent, delSchstudent, addSchstudent, updateSchstudent, exportSchstudent } from "@/api/school/schstudent";

export default {
  name: "Schstudent",
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
      // 学生信息表格数据
      schstudentList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        stuName: null,
        stuNation: null,
        stuSex: null,
        schName: null,
        schNum: null,
        grade: null,
        className: null,
        nativePlace: null,
        address: null,
        guardian: null,
        guardPhone: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        stuName: [
          { required: true, message: "学生姓名不能为空", trigger: "blur" }
        ],
        stuNation: [
          { required: true, message: "民族不能为空", trigger: "blur" }
        ],
        stuSex: [
          { required: true, message: "性别不能为空", trigger: "change" }
        ],
        schName: [
          { required: true, message: "学校名称不能为空", trigger: "blur" }
        ],
        schId: [
          { required: true, message: "学校ID不能为空", trigger: "blur" }
        ],
        schNum: [
          { required: true, message: "学籍号不能为空", trigger: "blur" }
        ],
        grade: [
          { required: true, message: "当前年级不能为空", trigger: "blur" }
        ],
        classId: [
          { required: true, message: "班级ID不能为空", trigger: "blur" }
        ],
        className: [
          { required: true, message: "当前班级不能为空", trigger: "blur" }
        ],
        nativePlace: [
          { required: true, message: "籍贯不能为空", trigger: "blur" }
        ],
        address: [
          { required: true, message: "常住地址不能为空", trigger: "blur" }
        ],
        guardian: [
          { required: true, message: "监护人姓名不能为空", trigger: "blur" }
        ],
        guardPhone: [
          { required: true, message: "监护人电话不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询学生信息列表 */
    getList() {
      this.loading = true;
      listSchstudent(this.queryParams).then(response => {
        this.schstudentList = response.rows;
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
        stuId: null,
        stuName: null,
        stuNation: null,
        stuSex: null,
        schName: null,
        schId: null,
        schNum: null,
        grade: null,
        classId: null,
        className: null,
        nativePlace: null,
        address: null,
        guardian: null,
        guardPhone: null
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
      this.ids = selection.map(item => item.stuId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加学生信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const stuId = row.stuId || this.ids
      getSchstudent(stuId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改学生信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.stuId != null) {
            updateSchstudent(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSchstudent(this.form).then(response => {
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
      const stuIds = row.stuId || this.ids;
      this.$modal.confirm('是否确认删除学生信息编号为"' + stuIds + '"的数据项？').then(function() {
        return delSchstudent(stuIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$modal.confirm('是否确认导出所有学生信息数据项？').then(() => {
        this.exportLoading = true;
        return exportSchstudent(queryParams);
      }).then(response => {
        this.$download.name(response.msg);
        this.exportLoading = false;
      }).catch(() => {});
    }
  }
};
</script>
