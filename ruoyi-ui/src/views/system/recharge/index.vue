<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="订单号" prop="orderNo">
        <el-input
          v-model="queryParams.orderNo"
          placeholder="请输入订单号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="流水号" prop="seqNoNo">
        <el-input
          v-model="queryParams.seqNoNo"
          placeholder="请输入流水号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="充值金额" prop="amt">
        <el-input
          v-model="queryParams.amt"
          placeholder="请输入充值金额"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="充值类型： 1-支付宝，2-银行卡" prop="payType">
        <el-select v-model="queryParams.payType" placeholder="请选择充值类型： 1-支付宝，2-银行卡" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="充值状态： 0-初始创建，1-待对账，2-对账失败，3-对账成功，99-充值成功" prop="done">
        <el-input
          v-model="queryParams.done"
          placeholder="请输入充值状态： 0-初始创建，1-待对账，2-对账失败，3-对账成功，99-充值成功"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注" prop="summary">
        <el-input
          v-model="queryParams.summary"
          placeholder="请输入备注"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="对账失败原因" prop="reason">
        <el-input
          v-model="queryParams.reason"
          placeholder="请输入对账失败原因"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="充值用户id" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入充值用户id"
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
          v-hasPermi="['system:recharge:add']"
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
          v-hasPermi="['system:recharge:edit']"
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
          v-hasPermi="['system:recharge:remove']"
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
          v-hasPermi="['system:recharge:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="rechargeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="充值用户id" align="center" prop="id" v-if="false"/>
      <el-table-column label="订单号" align="center" prop="orderNo" />
      <el-table-column label="流水号" align="center" prop="seqNoNo" />
      <el-table-column label="充值金额" align="center" prop="amt" />
      <el-table-column label="充值类型： 1-支付宝，2-银行卡" align="center" prop="payType" />
      <el-table-column label="充值状态： 0-初始创建，1-待对账，2-对账失败，3-对账成功，99-充值成功" align="center" prop="done" />
      <el-table-column label="备注" align="center" prop="summary" />
      <el-table-column label="对账失败原因" align="center" prop="reason" />
      <el-table-column label="充值用户id" align="center" prop="userId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:recharge:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:recharge:remove']"
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

    <!-- 添加或修改充值对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="订单号" prop="orderNo">
          <el-input v-model="form.orderNo" placeholder="请输入订单号" />
        </el-form-item>
        <el-form-item label="流水号" prop="seqNoNo">
          <el-input v-model="form.seqNoNo" placeholder="请输入流水号" />
        </el-form-item>
        <el-form-item label="创建时间" prop="createTime">
          <el-date-picker clearable size="small"
            v-model="form.createTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="选择创建时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="充值金额" prop="amt">
          <el-input v-model="form.amt" placeholder="请输入充值金额" />
        </el-form-item>
        <el-form-item label="充值类型： 1-支付宝，2-银行卡" prop="payType">
          <el-select v-model="form.payType" placeholder="请选择充值类型： 1-支付宝，2-银行卡">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="充值状态： 0-初始创建，1-待对账，2-对账失败，3-对账成功，99-充值成功" prop="done">
          <el-input v-model="form.done" placeholder="请输入充值状态： 0-初始创建，1-待对账，2-对账失败，3-对账成功，99-充值成功" />
        </el-form-item>
        <el-form-item label="备注" prop="summary">
          <el-input v-model="form.summary" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="对账失败原因" prop="reason">
          <el-input v-model="form.reason" placeholder="请输入对账失败原因" />
        </el-form-item>
        <el-form-item label="充值用户id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入充值用户id" />
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
import { listRecharge, getRecharge, delRecharge, addRecharge, updateRecharge, exportRecharge } from "@/api/system/recharge";

export default {
  name: "Recharge",
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
      // 充值表格数据
      rechargeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        orderNo: undefined,
        seqNoNo: undefined,
        amt: undefined,
        payType: undefined,
        done: undefined,
        summary: undefined,
        reason: undefined,
        userId: undefined
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userId: [
          { required: true, message: "充值用户id不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询充值列表 */
    getList() {
      this.loading = true;
      listRecharge(this.queryParams).then(response => {
        this.rechargeList = response.rows;
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
        orderNo: undefined,
        seqNoNo: undefined,
        createTime: undefined,
        amt: undefined,
        payType: undefined,
        done: undefined,
        summary: undefined,
        reason: undefined,
        userId: undefined
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
      this.title = "添加充值";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.loading = true;
      this.reset();
      const id = row.id || this.ids
      getRecharge(id).then(response => {
        this.loading = false;
        this.form = response.data;
        this.open = true;
        this.title = "修改充值";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.buttonLoading = true;
          if (this.form.id != null) {
            updateRecharge(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            }).finally(() => {
              this.buttonLoading = false;
            });
          } else {
            addRecharge(this.form).then(response => {
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
      this.$confirm('是否确认删除充值编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.loading = true;
          return delRecharge(ids);
        }).then(() => {
          this.loading = false;
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有充值数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.exportLoading = true;
          return exportRecharge(queryParams);
        }).then(response => {
          this.download(response.msg);
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
