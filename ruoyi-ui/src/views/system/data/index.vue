<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="标题" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入标题"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="分类id" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择分类id" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="开始时间" prop="startTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.startTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择开始时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="结束时间" prop="endTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.endTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择结束时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="活动费用 / 人" prop="money">
        <el-input
          v-model="queryParams.money"
          placeholder="请输入活动费用 / 人"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="活动最大限制人数" prop="maxPeople">
        <el-input
          v-model="queryParams.maxPeople"
          placeholder="请输入活动最大限制人数"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="主办方手机号" prop="sponsorPhone">
        <el-input
          v-model="queryParams.sponsorPhone"
          placeholder="请输入主办方手机号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发布人id" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入发布人id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发布人名字" prop="userName">
        <el-input
          v-model="queryParams.userName"
          placeholder="请输入发布人名字"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否启用规格 0 启用 1 否" prop="specFlag">
        <el-input
          v-model="queryParams.specFlag"
          placeholder="请输入是否启用规格 0 启用 1 否"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否启用活动时间 0 启用 1 否" prop="dateFlag">
        <el-input
          v-model="queryParams.dateFlag"
          placeholder="请输入是否启用活动时间 0 启用 1 否"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="浏览数量" prop="browseNum">
        <el-input
          v-model="queryParams.browseNum"
          placeholder="请输入浏览数量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="已报名人数" prop="alreadyPeople">
        <el-input
          v-model="queryParams.alreadyPeople"
          placeholder="请输入已报名人数"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否推荐 0 否 1 是" prop="isRecommend">
        <el-input
          v-model="queryParams.isRecommend"
          placeholder="请输入是否推荐 0 否 1 是"
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
          v-hasPermi="['system:data:add']"
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
          v-hasPermi="['system:data:edit']"
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
          v-hasPermi="['system:data:remove']"
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
          v-hasPermi="['system:data:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="dataList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="详细地址" align="center" prop="id" v-if="false"/>
      <el-table-column label="标题" align="center" prop="title" />
      <el-table-column label="分类id" align="center" prop="type" />
      <el-table-column label="开始时间" align="center" prop="startTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.startTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="结束时间" align="center" prop="endTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.endTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="活动费用 / 人" align="center" prop="money" />
      <el-table-column label="活动最大限制人数" align="center" prop="maxPeople" />
      <el-table-column label="主办方手机号" align="center" prop="sponsorPhone" />
      <el-table-column label="发布人id" align="center" prop="userId" />
      <el-table-column label="发布人名字" align="center" prop="userName" />
      <el-table-column label="是否启用规格 0 启用 1 否" align="center" prop="specFlag" />
      <el-table-column label="是否启用活动时间 0 启用 1 否" align="center" prop="dateFlag" />
      <el-table-column label="浏览数量" align="center" prop="browseNum" />
      <el-table-column label="已报名人数" align="center" prop="alreadyPeople" />
      <el-table-column label="是否推荐 0 否 1 是" align="center" prop="isRecommend" />
      <el-table-column label="活动地址" align="center" prop="province" />
      <el-table-column label="市" align="center" prop="city" />
      <el-table-column label="详细地址" align="center" prop="address" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:data:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:data:remove']"
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

    <!-- 添加或修改活动数据对话框 -->
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
        <el-form-item label="标题" prop="title">
          <el-input v-model="form.title" placeholder="请输入标题" />
        </el-form-item>
        <el-form-item label="分类id" prop="type">
          <el-select v-model="form.type" placeholder="请选择分类id">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="开始时间" prop="startTime">
          <el-date-picker clearable size="small"
            v-model="form.startTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="选择开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="结束时间" prop="endTime">
          <el-date-picker clearable size="small"
            v-model="form.endTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="选择结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="活动费用 / 人" prop="money">
          <el-input v-model="form.money" placeholder="请输入活动费用 / 人" />
        </el-form-item>
        <el-form-item label="活动最大限制人数" prop="maxPeople">
          <el-input v-model="form.maxPeople" placeholder="请输入活动最大限制人数" />
        </el-form-item>
        <el-form-item label="主办方手机号" prop="sponsorPhone">
          <el-input v-model="form.sponsorPhone" placeholder="请输入主办方手机号" />
        </el-form-item>
        <el-form-item label="发布人id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入发布人id" />
        </el-form-item>
        <el-form-item label="发布人名字" prop="userName">
          <el-input v-model="form.userName" placeholder="请输入发布人名字" />
        </el-form-item>
        <el-form-item label="是否启用规格 0 启用 1 否" prop="specFlag">
          <el-input v-model="form.specFlag" placeholder="请输入是否启用规格 0 启用 1 否" />
        </el-form-item>
        <el-form-item label="是否启用活动时间 0 启用 1 否" prop="dateFlag">
          <el-input v-model="form.dateFlag" placeholder="请输入是否启用活动时间 0 启用 1 否" />
        </el-form-item>
        <el-form-item label="浏览数量" prop="browseNum">
          <el-input v-model="form.browseNum" placeholder="请输入浏览数量" />
        </el-form-item>
        <el-form-item label="已报名人数" prop="alreadyPeople">
          <el-input v-model="form.alreadyPeople" placeholder="请输入已报名人数" />
        </el-form-item>
        <el-form-item label="是否推荐 0 否 1 是" prop="isRecommend">
          <el-input v-model="form.isRecommend" placeholder="请输入是否推荐 0 否 1 是" />
        </el-form-item>
        <el-form-item label="活动地址" prop="province">
          <el-input v-model="form.province" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="市" prop="city">
          <el-input v-model="form.city" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="详细地址" prop="address">
          <el-input v-model="form.address" type="textarea" placeholder="请输入内容" />
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
import { listData, getData, delData, addData, updateData, exportData } from "@/api/system/data";

export default {
  name: "Data",
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
      // 活动数据表格数据
      dataList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        title: undefined,
        type: undefined,
        startTime: undefined,
        endTime: undefined,
        money: undefined,
        maxPeople: undefined,
        sponsorPhone: undefined,
        userId: undefined,
        userName: undefined,
        specFlag: undefined,
        dateFlag: undefined,
        browseNum: undefined,
        alreadyPeople: undefined,
        isRecommend: undefined,
        province: undefined,
        city: undefined,
        address: undefined
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
    /** 查询活动数据列表 */
    getList() {
      this.loading = true;
      listData(this.queryParams).then(response => {
        this.dataList = response.rows;
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
        title: undefined,
        type: undefined,
        startTime: undefined,
        endTime: undefined,
        money: undefined,
        maxPeople: undefined,
        sponsorPhone: undefined,
        userId: undefined,
        userName: undefined,
        specFlag: undefined,
        dateFlag: undefined,
        browseNum: undefined,
        alreadyPeople: undefined,
        isRecommend: undefined,
        province: undefined,
        city: undefined,
        address: undefined
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
      this.title = "添加活动数据";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.loading = true;
      this.reset();
      const id = row.id || this.ids
      getData(id).then(response => {
        this.loading = false;
        this.form = response.data;
        this.open = true;
        this.title = "修改活动数据";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.buttonLoading = true;
          if (this.form.id != null) {
            updateData(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            }).finally(() => {
              this.buttonLoading = false;
            });
          } else {
            addData(this.form).then(response => {
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
      this.$confirm('是否确认删除活动数据编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.loading = true;
          return delData(ids);
        }).then(() => {
          this.loading = false;
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有活动数据数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.exportLoading = true;
          return exportData(queryParams);
        }).then(response => {
          this.download(response.msg);
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
