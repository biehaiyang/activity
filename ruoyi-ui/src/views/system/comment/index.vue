<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="满意度星级:1~5,发帖评论为0" prop="starLv">
        <el-input
          v-model="queryParams.starLv"
          placeholder="请输入满意度星级:1~5,发帖评论为0"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="根评论id，第一条评论id的根为0" prop="rId">
        <el-input
          v-model="queryParams.rId"
          placeholder="请输入根评论id，第一条评论id的根为0
"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="目评论的id，第一条评论的目的评论为0" prop="pId">
        <el-input
          v-model="queryParams.pId"
          placeholder="请输入目评论的id，第一条评论的目的评论为0"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户id" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入用户id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="活动id， 发帖评论填0" prop="activityId">
        <el-input
          v-model="queryParams.activityId"
          placeholder="请输入活动id， 发帖评论填0"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否允许展示， 默认可以" prop="showFlag">
        <el-input
          v-model="queryParams.showFlag"
          placeholder="请输入是否允许展示， 默认可以"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="被回复用户id，" prop="repliedId">
        <el-input
          v-model="queryParams.repliedId"
          placeholder="请输入被回复用户id，"
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
          v-hasPermi="['system:comment:add']"
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
          v-hasPermi="['system:comment:edit']"
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
          v-hasPermi="['system:comment:remove']"
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
          v-hasPermi="['system:comment:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="commentList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键id" align="center" prop="id" v-if="false"/>
      <el-table-column label="评论内容" align="center" prop="comment" />
      <el-table-column label="满意度星级:1~5,发帖评论为0" align="center" prop="starLv" />
      <el-table-column label="根评论id，第一条评论id的根为0" align="center" prop="rId" />
      <el-table-column label="目评论的id，第一条评论的目的评论为0" align="center" prop="pId" />
      <el-table-column label="用户id" align="center" prop="userId" />
      <el-table-column label="活动id， 发帖评论填0" align="center" prop="activityId" />
      <el-table-column label="是否允许展示， 默认可以" align="center" prop="showFlag" />
      <el-table-column label="被回复用户id，" align="center" prop="repliedId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:comment:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:comment:remove']"
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

    <!-- 添加或修改活动评论对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="评论内容" prop="comment">
          <el-input v-model="form.comment" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="满意度星级:1~5,发帖评论为0" prop="starLv">
          <el-input v-model="form.starLv" placeholder="请输入满意度星级:1~5,发帖评论为0" />
        </el-form-item>
        <el-form-item label="根评论id，第一条评论id的根为0
" prop="rId">
          <el-input v-model="form.rId" placeholder="请输入根评论id，第一条评论id的根为0
" />
        </el-form-item>
        <el-form-item label="目评论的id，第一条评论的目的评论为0
" prop="pId">
          <el-input v-model="form.pId" placeholder="请输入目评论的id，第一条评论的目的评论为0
" />
        </el-form-item>
        <el-form-item label="评论时间" prop="createTime">
          <el-date-picker clearable size="small"
            v-model="form.createTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="选择评论时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="用户id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户id" />
        </el-form-item>
        <el-form-item label="活动id， 发帖评论填0" prop="activityId">
          <el-input v-model="form.activityId" placeholder="请输入活动id， 发帖评论填0" />
        </el-form-item>
        <el-form-item label="是否允许展示， 默认可以" prop="showFlag">
          <el-input v-model="form.showFlag" placeholder="请输入是否允许展示， 默认可以" />
        </el-form-item>
        <el-form-item label="被回复用户id，" prop="repliedId">
          <el-input v-model="form.repliedId" placeholder="请输入被回复用户id，" />
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
import { listComment, getComment, delComment, addComment, updateComment, exportComment } from "@/api/system/comment";

export default {
  name: "Comment",
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
      // 活动评论表格数据
      commentList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        comment: undefined,
        starLv: undefined,
        rId: undefined,
        pId: undefined,
        userId: undefined,
        activityId: undefined,
        showFlag: undefined,
        repliedId: undefined
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        comment: [
          { required: true, message: "评论内容不能为空", trigger: "blur" }
        ],
        starLv: [
          { required: true, message: "满意度星级:1~5,发帖评论为0不能为空", trigger: "blur" }
        ],
        rId: [
          { required: true, message: "根评论id，第一条评论id的根为0不能为空", trigger: "blur" }
        ],
        pId: [
          { required: true, message: "目评论的id，第一条评论的目的评论为0不能为空", trigger: "blur" }
        ],
        createTime: [
          { required: true, message: "评论时间不能为空", trigger: "blur" }
        ],
        userId: [
          { required: true, message: "用户id不能为空", trigger: "blur" }
        ],
        activityId: [
          { required: true, message: "活动id， 发帖评论填0不能为空", trigger: "blur" }
        ],
        showFlag: [
          { required: true, message: "是否允许展示， 默认可以不能为空", trigger: "blur" }
        ],
        repliedId: [
          { required: true, message: "被回复用户id，不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询活动评论列表 */
    getList() {
      this.loading = true;
      listComment(this.queryParams).then(response => {
        this.commentList = response.rows;
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
        comment: undefined,
        starLv: undefined,
        rId: undefined,
        pId: undefined,
        createTime: undefined,
        userId: undefined,
        activityId: undefined,
        showFlag: undefined,
        repliedId: undefined
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
      this.title = "添加活动评论";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.loading = true;
      this.reset();
      const id = row.id || this.ids
      getComment(id).then(response => {
        this.loading = false;
        this.form = response.data;
        this.open = true;
        this.title = "修改活动评论";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.buttonLoading = true;
          if (this.form.id != null) {
            updateComment(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            }).finally(() => {
              this.buttonLoading = false;
            });
          } else {
            addComment(this.form).then(response => {
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
      this.$confirm('是否确认删除活动评论编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.loading = true;
          return delComment(ids);
        }).then(() => {
          this.loading = false;
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有活动评论数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.exportLoading = true;
          return exportComment(queryParams);
        }).then(response => {
          this.download(response.msg);
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
