<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户名" prop="userName">
        <el-input
          v-model="queryParams.userName"
          placeholder="请输入用户名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机号" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入手机号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户头像" prop="headPhoto">
        <el-input
          v-model="queryParams.headPhoto"
          placeholder="请输入用户头像"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="背景图" prop="backgroundPhoto">
        <el-input
          v-model="queryParams.backgroundPhoto"
          placeholder="请输入背景图"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="生日" prop="birthday">
        <el-date-picker clearable size="small"
          v-model="queryParams.birthday"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择生日">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="用户级别  0 普通会员 1 个人用户 2 商家" prop="userLevel">
        <el-input
          v-model="queryParams.userLevel"
          placeholder="请输入用户级别  0 普通会员 1 个人用户 2 商家"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="总金额" prop="sumMoney">
        <el-input
          v-model="queryParams.sumMoney"
          placeholder="请输入总金额"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="冻结金额" prop="lockMoney">
        <el-input
          v-model="queryParams.lockMoney"
          placeholder="请输入冻结金额"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="可提现金额" prop="allowMoney">
        <el-input
          v-model="queryParams.allowMoney"
          placeholder="请输入可提现金额"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="0 正常 1 封禁" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择0 正常 1 封禁" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="信誉分" prop="creditNum">
        <el-input
          v-model="queryParams.creditNum"
          placeholder="请输入信誉分"
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
          v-hasPermi="['system:webuser:add']"
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
          v-hasPermi="['system:webuser:edit']"
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
          v-hasPermi="['system:webuser:remove']"
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
          v-hasPermi="['system:webuser:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="webuserList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="信誉分" align="center" prop="id" v-if="false"/>
      <el-table-column label="用户名" align="center" prop="userName" />
      <el-table-column label="手机号" align="center" prop="phone" />
      <el-table-column label="个性签名" align="center" prop="userSignature" />
      <el-table-column label="用户头像" align="center" prop="headPhoto" />
      <el-table-column label="背景图" align="center" prop="backgroundPhoto" />
      <el-table-column label="生日" align="center" prop="birthday" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.birthday, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="地址" align="center" prop="address" />
      <el-table-column label="用户级别  0 普通会员 1 个人用户 2 商家" align="center" prop="userLevel" />
      <el-table-column label="总金额" align="center" prop="sumMoney" />
      <el-table-column label="冻结金额" align="center" prop="lockMoney" />
      <el-table-column label="可提现金额" align="center" prop="allowMoney" />
      <el-table-column label="0 正常 1 封禁" align="center" prop="status" />
      <el-table-column label="信誉分" align="center" prop="creditNum" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:webuser:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:webuser:remove']"
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

    <!-- 添加或修改用户对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="创建时间" prop="createTime">
          <el-date-picker clearable size="small"
            v-model="form.createTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="选择创建时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="修改时间" prop="updateTime">
          <el-date-picker clearable size="small"
            v-model="form.updateTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="选择修改时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="用户名" prop="userName">
          <el-input v-model="form.userName" placeholder="请输入用户名" />
        </el-form-item>
        <el-form-item label="手机号" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入手机号" />
        </el-form-item>
        <el-form-item label="个性签名" prop="userSignature">
          <el-input v-model="form.userSignature" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="用户头像" prop="headPhoto">
          <el-input v-model="form.headPhoto" placeholder="请输入用户头像" />
        </el-form-item>
        <el-form-item label="背景图" prop="backgroundPhoto">
          <el-input v-model="form.backgroundPhoto" placeholder="请输入背景图" />
        </el-form-item>
        <el-form-item label="生日" prop="birthday">
          <el-date-picker clearable size="small"
            v-model="form.birthday"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="选择生日">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="地址" prop="address">
          <el-input v-model="form.address" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="用户级别  0 普通会员 1 个人用户 2 商家" prop="userLevel">
          <el-input v-model="form.userLevel" placeholder="请输入用户级别  0 普通会员 1 个人用户 2 商家" />
        </el-form-item>
        <el-form-item label="总金额" prop="sumMoney">
          <el-input v-model="form.sumMoney" placeholder="请输入总金额" />
        </el-form-item>
        <el-form-item label="冻结金额" prop="lockMoney">
          <el-input v-model="form.lockMoney" placeholder="请输入冻结金额" />
        </el-form-item>
        <el-form-item label="可提现金额" prop="allowMoney">
          <el-input v-model="form.allowMoney" placeholder="请输入可提现金额" />
        </el-form-item>
        <el-form-item label="0 正常 1 封禁">
          <el-radio-group v-model="form.status">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="信誉分" prop="creditNum">
          <el-input v-model="form.creditNum" placeholder="请输入信誉分" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listWebuser, getWebuser, delWebuser, addWebuser, updateWebuser, exportWebuser } from "@/api/system/webuser";

export default {
  name: "Webuser",
  data() {
    return {
      // 按钮loading
      buttonLoading: false,
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
      // 用户表格数据
      webuserList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userName: undefined,
        phone: undefined,
        userSignature: undefined,
        headPhoto: undefined,
        backgroundPhoto: undefined,
        birthday: undefined,
        address: undefined,
        userLevel: undefined,
        sumMoney: undefined,
        lockMoney: undefined,
        allowMoney: undefined,
        status: undefined,
        creditNum: undefined
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询用户列表 */
    getList() {
      this.loading = true;
      listWebuser(this.queryParams).then(response => {
        this.webuserList = response.rows;
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
        id: undefined,
        createTime: undefined,
        updateTime: undefined,
        userName: undefined,
        phone: undefined,
        userSignature: undefined,
        headPhoto: undefined,
        backgroundPhoto: undefined,
        birthday: undefined,
        address: undefined,
        userLevel: undefined,
        sumMoney: undefined,
        lockMoney: undefined,
        allowMoney: undefined,
        status: "0",
        creditNum: undefined
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加用户";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.loading = true;
      this.reset();
      const id = row.id || this.ids
      getWebuser(id).then(response => {
        this.loading = false;
        this.form = response.data;
        this.open = true;
        this.title = "修改用户";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.buttonLoading = true;
          if (this.form.id != null) {
            updateWebuser(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            }).finally(() => {
              this.buttonLoading = false;
            });
          } else {
            addWebuser(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            }).finally(() => {
              this.buttonLoading = false;
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除用户编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.loading = true;
          return delWebuser(ids);
        }).then(() => {
          this.loading = false;
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有用户数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.exportLoading = true;
          return exportWebuser(queryParams);
        }).then(response => {
          this.download(response.msg);
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
