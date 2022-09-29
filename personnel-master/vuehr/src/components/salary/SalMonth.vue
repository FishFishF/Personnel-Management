<template>
  <div>
    <el-container>
      <el-header style="display: flex;justify-content: space-between;align-items: center;padding-left: 0px">
        <el-button @click="resetDanger" icon="el-icon-plus" type="primary" size="mini">重置月末处理</el-button>
        <el-button size="mini" type="success" @click="loadPointList" icon="el-icon-refresh"></el-button>
      </el-header>
      <el-main style="padding-left: 0px;padding-top: 0px;">
        <div>
          <el-table
            :data="emppoints"
            stripe
            v-loading="tableLoading"
            size="mini"
            @selection-change="handleSelectionChange"
            style="width: 100%">
            <el-table-column type="selection" width="30"></el-table-column>
            <el-table-column width="300" prop="eid" label="员工编号" align="center"></el-table-column>
            <el-table-column width="300" prop="name" label="员工姓名" align="center"></el-table-column>
            <el-table-column width="300" prop="points" label="积分" align="center"></el-table-column>
            <el-table-column label="操作" align="center">

              <el-table-column label="惩罚减薪" align="center">
                <template slot-scope="scope">
                  <el-button
                    size="mini"
                    type="danger"
                    @click="handleinsert(scope.$index, scope.row)">减薪
                  </el-button>
                </template>
              </el-table-column>
            </el-table-column>
          </el-table>
        </div>

      </el-main>
    </el-container>

  </div>
</template>
<script>
    export default {
        data(){
            return {
                emppoints:[],
                index:0,
                tableLoading:false,
                multipleSelection:[],
                empPoint:{
                    id:'',
                    eid:'',
                    name:'',
                    points:''
                }
            };
        },
        methods:{
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
            loadPointList(){
                this.tableLoading = true;
                var _this = this;
                this.getRequest("/personnel/appraise/listPointDanger").then(resp=> {
                    _this.tableLoading = false;
                    if (resp && resp.status == 200) {
                        _this.emppoints = resp.data;
                    }
                })
            },
            handleEdit(index, row) {
                this.empPoint = row;
            },
            handleinsert(index, row) {
                this.$confirm('要对[' + row.name + ']减少本月薪水吗?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.insertDanger(row.eid);
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            },
            insertDanger(eid){
                console.log(eid);
                this.postRequest("/personnel/appraise/addDanger/" +eid).then(resp=> {
                    if (resp && resp.status == 200) {
                        var data = resp.data;
                        console.log(data);
                    }
                });
            },
            resetDanger(){
                this.getRequest("/system/init/resetDanger").then(resp=> {
                    if (resp && resp.status == 200) {
                        var data = resp.data;
                        console.log(data);
                    }
                });
            }

    },
        created() {
            this.loadPointList();
        }
    }
</script>
