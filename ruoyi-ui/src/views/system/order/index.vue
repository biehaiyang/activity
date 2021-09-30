<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="活动标题" prop="orderTitle">
        <el-input
          v-model="queryParams.orderTitle"
          placeholder="请输入活动标题"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="参加活动时间" prop="takeTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.takeTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择参加活动时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="人数" prop="peopleNum">
        <el-input
          v-model="queryParams.peopleNum"
          placeholder="请输入人数"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单总金额" prop="orderMoney">
        <el-input
          v-model="queryParams.orderMoney"
          placeholder="请输入订单总金额"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="单价" prop="unitMoney">
        <el-input
          v-model="queryParams.unitMoney"
          placeholder="请输入单价"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单状态 0 待付款 1 待参加 2 待评价 3 已取消" prop="orderStatus">
        <el-select v-model="queryParams.orderStatus" placeholder="请选择订单状态 0 待付款 1 待参加 2 待评价 3 已取消" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="支付id" prop="payId">
        <el-input
          v-model="queryParams.payId"
          placeholder="请输入支付id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="支付时间" prop="payTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.payTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择支付时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="1 余额 2 微信 3 支付宝" prop="payType">
        <el-select v-model="queryParams.payType" placeholder="请选择1 余额 2 微信 3 支付宝" clearable size="small">
          <el-option label="请选择字典生成" value="" />
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
          v-hasPermi="['system:order:add']"
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
          v-hasPermi="['system:order:edit']"
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
          v-hasPermi="['system:order:remove']"
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
          v-hasPermi="['system:order:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="orderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="1 余额 2 微信 3 支付宝" align="center" prop="id" v-if="false"/>
      <el-table-column label="活动标题" align="center" prop="orderTitle" />
      <el-table-column label="参加活动时间" align="center" prop="takeTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.takeTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="规格" align="center" prop="orderSpec" />
      <el-table-column label="人数" align="center" prop="peopleNum" />
      <el-table-column label="订单总金额" align="center" prop="orderMoney" />
      <el-table-column label="活动地址" align="center" prop="address" />
      <el-table-column label="单价" align="center" prop="unitMoney" />
      <el-table-column label="订单状态 0 待付款 1 待参加 2 待评价 3 已取消" align="center" prop="orderStatus" />
      <el-table-column label="支付id" align="center" prop="payId" />
      <el-table-column label="支付时间" align="center" prop="payTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.payTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="1 余额 2 微信 3 支付宝" align="center" prop="payType" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:order:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:order:remove']"
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

    <!-- 添加或修改订单对话框 -->
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
        <el-form-item label="活动标题" prop="orderTitle">
          <el-input v-model="form.orderTitle" placeholder="请输入活动标题" />
        </el-form-item>
        <el-form-item label="参加活动时间" prop="takeTime">
          <el-date-picker clearable size="small"
            v-model="form.takeTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="选择参加活动时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="规格" prop="orderSpec">
          <el-input v-model="form.orderSpec" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="人数" prop="peopleNum">
          <el-input v-model="form.peopleNum" placeholder="请输入人数" />
        </el-form-item>
        <el-form-item label="订单总金额" prop="orderMoney">
          <el-input v-model="form.orderMoney" placeholder="请输入订单总金额" />
        </el-form-item>
        <el-form-item label="活动地址" prop="address">
          <el-input v-model="form.address" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="单价" prop="unitMoney">
          <el-input v-model="form.unitMoney" placeholder="请输入单价" />
        </el-form-item>
        <el-form-item label="订单状态 0 待付款 1 待参加 2 待评价 3 已取消">
          <el-radio-group v-model="form.orderStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="支付id" prop="payId">
          <el-input v-model="form.payId" placeholder="请输入支付id" />
        </el-form-item>
        <el-form-item label="支付时间" prop="payTime">
          <el-date-picker clearable size="small"
            v-model="form.payTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="选择支付时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="1 余额 2 微信 3 支付宝" prop="payType">
          <el-select v-model="form.payType" placeholder="请选择1 余额 2 微信 3 支付宝">
            <el-option label="请选择字典生成" value="" />
          </el-select>
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
import { listOrder, getOrder, delOrder, addOrder, updateOrder, exportOrder } from "@/api/system/order";

export default {
  name: "Order",
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
      // 订单表格数据
      orderList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        orderTitle: undefined,
        takeTime: undefined,
        orderSpec: undefined,
        peopleNum: undefined,
        orderMoney: undefined,
        address: undefined,
        unitMoney: undefined,
        orderStatus: undefined,
        payId: undefined,
        payTime: undefined,
        payType: undefined
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
    /** 查询订单列表 */
    getList() {
      this.loading = true;
      listOrder(this.queryParams).then(response => {
        this.orderList = response.rows;
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
        orderTitle: undefined,
        takeTime: undefined,
        orderSpec: undefined,
        peopleNum: undefined,
        orderMoney: undefined,
        address: undefined,
        unitMoney: undefined,
        orderStatus: "0",
        payId: undefined,
        payTime: undefined,
        payType: undefined
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
      this.title = "添加订单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.loading = true;
      this.reset();
      const id = row.id || this.ids
      getOrder(id).then(response => {
        this.loading = false;
        this.form = response.data;
        this.open = true;
        this.title = "修改订单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.buttonLoading = true;
          if (this.form.id != null) {
            updateOrder(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            }).finally(() => {
              this.buttonLoading = false;
            });
          } else {
            addOrder(this.form).then(response => {
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
      this.$confirm('是否确认删除订单编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.loading = true;
          return delOrder(ids);
        }).then(() => {
          this.loading = false;
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有订单数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.exportLoading = true;
          return exportOrder(queryParams);
        }).then(response => {
          this.download(response.msg);
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
