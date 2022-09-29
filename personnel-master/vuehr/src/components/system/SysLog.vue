<template>
  <div>
    <el-container>
      <el-header style="display: flex;justify-content: space-between;align-items: center;padding-left: 0px">
        <el-button size="mini" type="success" @click="loadSalaryCfg" icon="el-icon-refresh"></el-button>
      </el-header>
      <el-main style="padding-left: 0px;padding-top: 0px">
        <div>
          <el-table
            :data="log"
            stripe
            v-loading="tableLoading"
            size="mini"
            style="width: 100%">
            <el-table-column
              width="350"
              prop="eid"
              align="center"
              label="员工编号">
            </el-table-column>
            <el-table-column
              width="350"
              prop="admin"
              align="center"
              label="管理人员">
            </el-table-column>
            <el-table-column
              width="550"
              prop="date"
              align="center"
              label="上线时间">
              <template slot-scope="scope">{{getCurrentTime()}}</template>
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
      log: [{eid: '1000' ,admin: sessionStorage.getItem('username')}]
        }
      },
    methods: {
        getCurrentTime() {
            //获取当前时间并打印
        　　let yy = new Date().getFullYear();
        　　let mm = new Date().getMonth()+1;
        　　let dd = new Date().getDate();
        　　let hh = new Date().getHours();
        　　let mf = new Date().getMinutes()<10 ? '0'+new Date().getMinutes() : new Date().getMinutes();
        　　let ss = new Date().getSeconds()<10 ? '0'+new Date().getSeconds() : new Date().getSeconds();
        　　let time = yy+'/'+mm+'/'+dd+' '+hh+':'+mf+':'+ss;
            return time;
    }
       }
}
</script>
<style>
  .el-dialog__body {
    padding-bottom: 10px;
  }
</style>
