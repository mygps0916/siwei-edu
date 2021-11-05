<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="教师姓名" prop="teachName">
        <el-input
          v-model="queryParams.teachName"
          placeholder="请输入教师姓名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="老师性别" prop="teachSex">
        <el-select v-model="queryParams.teachSex" placeholder="请选择老师性别" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="出生日期" prop="birthDate">
        <el-input
          v-model="queryParams.birthDate"
          placeholder="请输入出生日期"
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
      <el-form-item label="职称" prop="jobTitle">
        <el-input
          v-model="queryParams.jobTitle"
          placeholder="请输入职称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任教学校" prop="schName">
        <el-input
          v-model="queryParams.schName"
          placeholder="请输入任教学校"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学校类型" prop="schType">
        <el-select v-model="queryParams.schType" placeholder="请选择学校类型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="任教科目" prop="course">
        <el-input
          v-model="queryParams.course"
          placeholder="请输入任教科目"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系电话" prop="telephone">
        <el-input
          v-model="queryParams.telephone"
          placeholder="请输入联系电话"
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
          v-hasPermi="['school:schteacher:add']"
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
          v-hasPermi="['school:schteacher:edit']"
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
          v-hasPermi="['school:schteacher:remove']"
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
          v-hasPermi="['school:schteacher:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="schteacherList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="teachId" />
      <el-table-column label="教师姓名" align="center" prop="teachName" />
      <el-table-column label="老师性别" align="center" prop="teachSex" />
      <el-table-column label="出生日期" align="center" prop="birthDate" />
      <el-table-column label="身份证号" align="center" prop="cartId" />
      <el-table-column label="职称" align="center" prop="jobTitle" />
      <el-table-column label="任教学校" align="center" prop="schName" />
      <el-table-column label="学校类型" align="center" prop="schType" />
      <el-table-column label="任教科目" align="center" prop="course" />
      <el-table-column label="联系电话" align="center" prop="telephone" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['school:schteacher:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['school:schteacher:remove']"
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

    <!-- 添加或修改教师信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="教师姓名" prop="teachName">
          <el-input v-model="form.teachName" placeholder="请输入教师姓名" />
        </el-form-item>
        <el-form-item label="老师性别" prop="teachSex">
          <el-select v-model="form.teachSex" placeholder="请选择老师性别">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="出生日期" prop="birthDate">
          <el-input v-model="form.birthDate" placeholder="请输入出生日期" />
        </el-form-item>
        <el-form-item label="身份证号" prop="cartId">
          <el-input v-model="form.cartId" placeholder="请输入身份证号" />
        </el-form-item>
        <el-form-item label="职称" prop="jobTitle">
          <el-input v-model="form.jobTitle" placeholder="请输入职称" />
        </el-form-item>
        <el-form-item label="任教学校" prop="schName">
          <el-input v-model="form.schName" placeholder="请输入任教学校" />
        </el-form-item>
        <el-form-item label="学校ID" prop="schId">
          <el-input v-model="form.schId" placeholder="请输入学校ID" />
        </el-form-item>
        <el-form-item label="学校类型" prop="schType">
          <el-select v-model="form.schType" placeholder="请选择学校类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="任教科目" prop="course">
          <el-input v-model="form.course" placeholder="请输入任教科目" />
        </el-form-item>
        <el-form-item label="联系电话" prop="telephone">
          <el-input v-model="form.telephone" placeholder="请输入联系电话" />
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
import { listSchteacher, getSchteacher, delSchteacher, addSchteacher, updateSchteacher, exportSchteacher } from "@/api/school/schteacher";

export default {
  name: "Schteacher",
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
      // 教师信息表格数据
      schteacherList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        teachName: null,
        teachSex: null,
        birthDate: null,
        cartId: null,
        jobTitle: null,
        schName: null,
        schType: null,
        course: null,
        telephone: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        teachName: [
          { required: true, message: "教师姓名不能为空", trigger: "blur" }
        ],
        teachSex: [
          { required: true, message: "老师性别不能为空", trigger: "change" }
        ],
        birthDate: [
          { required: true, message: "出生日期不能为空", trigger: "blur" }
        ],
        cartId: [
          { required: true, message: "身份证号不能为空", trigger: "blur" }
        ],
        jobTitle: [
          { required: true, message: "职称不能为空", trigger: "blur" }
        ],
        schName: [
          { required: true, message: "任教学校不能为空", trigger: "blur" }
        ],
        schId: [
          { required: true, message: "学校ID不能为空", trigger: "blur" }
        ],
        schType: [
          { required: true, message: "学校类型不能为空", trigger: "change" }
        ],
        course: [
          { required: true, message: "任教科目不能为空", trigger: "blur" }
        ],
        telephone: [
          { required: true, message: "联系电话不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询教师信息列表 */
    getList() {
      this.loading = true;
      listSchteacher(this.queryParams).then(response => {
        this.schteacherList = response.rows;
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
        teachId: null,
        teachName: null,
        teachSex: null,
        birthDate: null,
        cartId: null,
        jobTitle: null,
        schName: null,
        schId: null,
        schType: null,
        course: null,
        telephone: null
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
      this.ids = selection.map(item => item.teachId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加教师信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const teachId = row.teachId || this.ids
      getSchteacher(teachId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改教师信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.teachId != null) {
            updateSchteacher(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSchteacher(this.form).then(response => {
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
      const teachIds = row.teachId || this.ids;
      this.$modal.confirm('是否确认删除教师信息编号为"' + teachIds + '"的数据项？').then(function() {
        return delSchteacher(teachIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$modal.confirm('是否确认导出所有教师信息数据项？').then(() => {
        this.exportLoading = true;
        return exportSchteacher(queryParams);
      }).then(response => {
        this.$download.name(response.msg);
        this.exportLoading = false;
      }).catch(() => {});
    }
  }
};
</script>
