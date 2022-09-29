<template>
  <div>
    <el-container>
      <el-header style="display: flex;justify-content: space-between;align-items: center;padding-left: 0px">
        <el-button size="mini" type="success" @click="loadScores" icon="el-icon-refresh"></el-button>
      </el-header>
      <el-main style="padding-left: 0px;padding-top: 0px">
        <div>
          <el-table
            :data="scores"
            stripe
            v-loading="tableLoading"
            size="mini"
            style="width: 100%">
            <el-table-column
              width="400"
              prop="eid"
              align="center"
              label="员工编号">
            </el-table-column>

            <el-table-column
              width="400"
              prop="name"
              align="center"
              label="员工姓名">
            </el-table-column>

            <el-table-column
              width="400"
              prop="points"
              align="center"
              label="员工积分">
            </el-table-column>

          </el-table>
        </div>
      </el-main>
    </el-container>
  </div>
</template>
<script>
    export default {
        data() {
            return {
                dialogVisible: false,
                tableLoading: false,
                index: 0,
                scores: [],
                multipleSelection: [],
            };
        },
        methods: {
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
            loadScores(){
                this.tableLoading = true;
                var _this = this;
                this.getRequest("/personnel/appraise/listPoint").then(resp=> {
                    _this.tableLoading = false;
                    if (resp && resp.status == 200) {
                        _this.scores = resp.data;
                    }
                })
            },
            emptySalary(){
                this.salary = {
                    id: '',
                    eid:'',
                    type:'',
                    tDate:'',
                    remark:''
                };
                this.index = 0;
            }
        },
        mounted: function () {
            this.loadScores();
        }
    };
</script>
<style>
  .el-dialog__body {
    padding-bottom: 10px;
  }
</style>
