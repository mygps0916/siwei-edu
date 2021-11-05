<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="学校名称" prop="schName">
        <el-input
          v-model="queryParams.schName"
          placeholder="请输入学校名称"
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
      <el-form-item label="学校代码" prop="schCode">
        <el-input
          v-model="queryParams.schCode"
          placeholder="请输入学校代码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属区域" prop="region">
        <el-input
          v-model="queryParams.region"
          placeholder="请输入所属区域"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系人" prop="linkName">
        <el-input
          v-model="queryParams.linkName"
          placeholder="请输入联系人"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系电话" prop="linkPhone">
        <el-input
          v-model="queryParams.linkPhone"
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
          v-hasPermi="['school:schschool:add']"
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
          v-hasPermi="['school:schschool:edit']"
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
          v-hasPermi="['school:schschool:remove']"
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
          v-hasPermi="['school:schschool:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="schschoolList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="schId" />
      <el-table-column label="学校名称" align="center" prop="schName" />
      <el-table-column label="学校类型" align="center" prop="schType" />
      <el-table-column label="学校代码" align="center" prop="schCode" />
      <el-table-column label="所属区域" align="center" prop="region" />
      <el-table-column label="地址" align="center" prop="address" />
      <el-table-column label="联系人" align="center" prop="linkName" />
      <el-table-column label="联系电话" align="center" prop="linkPhone" />
      <el-table-column label="学校简介" align="center" prop="schProfile" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['school:schschool:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['school:schschool:remove']"
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

    <!-- 添加或修改学校信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="学校名称" prop="schName">
          <el-input v-model="form.schName" placeholder="请输入学校名称" />
        </el-form-item>
        <el-form-item label="学校类型" prop="schType">
          <el-select v-model="form.schType" placeholder="请选择学校类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="学校代码" prop="schCode">
          <el-input v-model="form.schCode" placeholder="请输入学校代码" />
        </el-form-item>
        <el-form-item label="所属区域" prop="region">
          <el-input v-model="form.region" placeholder="请输入所属区域" />
        </el-form-item>
        <el-form-item label="地址" prop="address">
          <el-input v-model="form.address" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="联系人" prop="linkName">
          <el-input v-model="form.linkName" placeholder="请输入联系人" />
        </el-form-item>
        <el-form-item label="联系电话" prop="linkPhone">
          <el-input v-model="form.linkPhone" placeholder="请输入联系电话" />
        </el-form-item>
        <el-form-item label="学校简介">
          <fileUpload v-model="form.schProfile"/>
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
import { listSchschool, getSchschool, delSchschool, addSchschool, updateSchschool, exportSchschool } from "@/api/school/schschool";

export default {
  name: "Schschool",
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
      // 学校信息表格数据
      schschoolList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        schName: null,
        schType: null,
        schCode: null,
        region: null,
        address: null,
        linkName: null,
        linkPhone: null,
        schProfile: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        schName: [
          { required: true, message: "学校名称不能为空", trigger: "blur" }
        ],
        schType: [
          { required: true, message: "学校类型不能为空", trigger: "change" }
        ],
        schCode: [
          { required: true, message: "学校代码不能为空", trigger: "blur" }
        ],
        region: [
          { required: true, message: "所属区域不能为空", trigger: "blur" }
        ],
        address: [
          { required: true, message: "地址不能为空", trigger: "blur" }
        ],
        linkName: [
          { required: true, message: "联系人不能为空", trigger: "blur" }
        ],
        linkPhone: [
          { required: true, message: "联系电话不能为空", trigger: "blur" }
        ],
        schProfile: [
          { required: true, message: "学校简介不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询学校信息列表 */
    getList() {
      this.loading = true;
      listSchschool(this.queryParams).then(response => {
        this.schschoolList = response.rows;
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
        schId: null,
        schName: null,
        schType: null,
        schCode: null,
        region: null,
        address: null,
        linkName: null,
        linkPhone: null,
        schProfile: null
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
      this.ids = selection.map(item => item.schId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加学校信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const schId = row.schId || this.ids
      getSchschool(schId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改学校信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.schId != null) {
            updateSchschool(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSchschool(this.form).then(response => {
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
      const schIds = row.schId || this.ids;
      this.$modal.confirm('是否确认删除学校信息编号为"' + schIds + '"的数据项？').then(function() {
        return delSchschool(schIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$modal.confirm('是否确认导出所有学校信息数据项？').then(() => {
        this.exportLoading = true;
        return exportSchschool(queryParams);
      }).then(response => {
        this.$download.name(response.msg);
        this.exportLoading = false;
      }).catch(() => {});
    }
  }
};
</script>
