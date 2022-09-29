<template>
  <div>
    <el-container>
      <el-header style="display: flex;justify-content: space-between;align-items: center;padding-left: 0px">
        <el-button @click="dialogVisible = true" icon="el-icon-plus" type="primary" size="mini">添加考评</el-button>
        <el-button size="mini" type="success" @click="loadAppraiseList" icon="el-icon-refresh"></el-button>
      </el-header>
      <el-main style="padding-left: 0px;padding-top: 0px;">
        <div>
          <el-table
            :data="appraises"
            stripe
            v-loading="tableLoading"
            size="mini"
            @selection-change="handleSelectionChange"
            style="width: 100%">
            <el-table-column type="selection" width="30"></el-table-column>
            <el-table-column width="90" prop="eid" label="员工编号" align="center"></el-table-column>
            <el-table-column width="90" prop="name" label="员工姓名" align="center"></el-table-column>
            <!--<el-table-column width="90" prop="workID" label="工号" align="center"></el-table-column>-->
            <el-table-column width="120" label="考评日期" align="center">
              <template slot-scope="scope">{{scope.row.appDate | formatDate}}</template>
            </el-table-column>
            <el-table-column width="120" prop="appResult" label="考评结果" align="center"></el-table-column>
            <el-table-column width="300" prop="appContent" label="考评内容" align="center"></el-table-column>
            <el-table-column width="300" prop="remark" label="备注" align="center"></el-table-column>
            <el-table-column label="操作" align="center">

              <el-table-column label="删除" align="center">
                <template slot-scope="scope">
                  <el-button
                    size="mini"
                    type="danger"
                    @click="handleDelete(scope.$index, scope.row)">删除
                  </el-button>
                </template>
              </el-table-column>
            </el-table-column>
          </el-table>
        </div>

      </el-main>
    </el-container>
    <div style="text-align: left">
      <el-dialog
        title="添加员工考评信息"
        :visible.sync="dialogVisible"
        width="50%"
        @close="emptyAppraise"
        :close-on-click-modal="false">
        <div style="display: flex;justify-content: flex-start;">
          <el-steps :active="index" direction="vertical">
            <el-step title="员工编号" size="mini"></el-step>
            <!--<el-step title="员工号"></el-step>-->
            <el-step title="员工姓名"></el-step>
            <el-step title="考评日期"></el-step>
            <el-step title="考评结果"></el-step>
            <el-step title="考评内容"></el-step>
            <el-step title="备注"></el-step>
          </el-steps>
          <div style="margin-left: 30px;display: flex;justify-content: center;align-items: center;width: 80%;">
            <div v-show="index==0">
              员工编号：
              <el-input
                placeholder="请输入员工编号..."
                size="mini"
                style="width: 200px"
                @keyup.enter.native="next"
                v-model="empAppraise.eid">
              </el-input>
            </div>
            <div v-show="index==1">
              员工姓名：
              <el-input
                placeholder="请输入员工姓名..."
                size="mini"
                style="width: 200px"
                @keyup.enter.native="next"
                v-model="empAppraise.name">
              </el-input>
            </div>
            <!--<div v-show="index==1">
              员工号：
              <el-input
                placeholder="请输入员工号..."
                @keyup.enter.native="next"
                size="mini"
                style="width: 200px"
                v-model="empTrain.workID">
              </el-input>
            </div>-->
            <div v-show="index==2">
              考评日期：
              <el-date-picker
                v-model="empAppraise.appDate"
                type="date"
                size="mini"
                value-format="yyyy-MM-dd HH:mm:ss"
                style="width: 200px;"
                placeholder="选择日期">
              </el-date-picker>
            </div>
            <div v-show="index==3">
              考评结果:
              <el-input
                type="textarea"
                size="mini"
                style="width: 200px;"
                :autosize="{ minRows: 5, maxRows: 10}"
                placeholder="请输入考评结果..."
                v-model="empAppraise.appResult">
              </el-input>
            </div>
            <div v-show="index==4">
              考评内容:
              <el-input
                type="textarea"
                size="mini"
                style="width: 200px;"
                :autosize="{ minRows: 5, maxRows: 10}"
                placeholder="请输入考评内容..."
                v-model="empAppraise.appContent">
              </el-input>
            </div>
            <div v-show="index==5">
              备注:
              <el-input
                type="textarea"
                size="mini"
                style="width: 200px;"
                :autosize="{ minRows: 5, maxRows: 10}"
                placeholder="请输入备注内容..."
                v-model="empAppraise.remark">
              </el-input>
            </div>
          </div>
        </div>
        <div style="display: flex;align-items: center;justify-content: center;padding: 0px;margin: 0px;">
          <el-button round size="mini" v-if="index!=0" @click="index--">上一步</el-button>
          <el-button type="primary" round size="mini" @click="next" v-text="index==5?'完成':'下一步'"></el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>
<script>
    export default {
        data(){
            return {
                dialogVisible:false,
                appraises:[],
                index:0,
                tableLoading:false,
                multipleSelection:[],
                empAppraise:{
                    id:'',
                    eid:'',
                    name:'',
                    appDate:'',
                    appResult:'',
                    appContent:'',
                    remark:'',
                }
            };
        },
        methods:{
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
            loadAppraiseList(){
                this.tableLoading = true;
                var _this = this;
                this.getRequest("/personnel/appraise/listAppraises").then(resp=> {
                    _this.tableLoading = false;
                    if (resp && resp.status == 200) {
                        _this.appraises = resp.data;
                    }
                })
            },
            handleEdit(index, row) {
                this.dialogVisible = true;
                row.appDate = new Date(row.appDate);
                this.empAppraise = row;
            },
            handleDelete(index, row) {
                this.$confirm('删除[' + row.name + ']的本条考评信息, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.doDelete(row.id);
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            },
            doDelete(id){
                var _this = this;
                _this.tableLoading = true;
                this.deleteRequest("/personnel/appraise/deleteAppraise/" + id).then(resp=>{
                    _this.tableLoading = false;
                    if (resp && resp.status == 200) {
                        var data = resp.data;
                        _this.loadAppraiseList();
                    }
                });
            },
            emptyAppraise(){
                this.empAppraise={
                    id:'',
                    eid:'',
                    name:'',
                    appDate:'',
                    appResult:'',
                    appContent:'',
                    remark:''
                };
                this.index = 0;
            },
            next(){
                var _this = this;
                if (this.index == 5) {
                    if(this.empAppraise.eid&&this.empAppraise.name&&this.empAppraise.appDate&&this.empAppraise.appResult&&this.empAppraise.appContent&&this.empAppraise.remark){
                        if (this.empAppraise.id) {//更新
                            _this.tableLoading = true;
                            this.putRequest("/personnel/appraise/addappraise", this.empAppraise).then(resp=> {
                                _this.tableLoading = false;
                                if (resp && resp.status == 200) {
                                    var data = resp.data;
                                    _
                                    _this.dialogVisible = false;
                                    _this.index = 0;
                                    _this.loadAppraiseList();
                                }
                            });
                        } else {//添加
                            this.postRequest("/personnel/appraise/addappraise", this.empAppraise).then(resp=> {
                                if (resp && resp.status == 200) {
                                    var data = resp.data;

                                    _this.dialogVisible = false;
                                    _this.index = 0;
                                    _this.loadAppraiseList();
                                }
                            });
                        }
                    }else{
                        this.$message({type: 'error', message: '字段不能为空!'});
                    }
                } else {
                    this.index++;
                }
            }
        },
        created() {
            this.loadAppraiseList();
        }
    }
</script>
