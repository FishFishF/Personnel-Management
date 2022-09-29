<template>
  <div>
    <el-container>
      <el-header style="display: flex;justify-content: space-between;align-items: center;padding-left: 0px">
      </el-header>
      <el-main style="padding-left: 0px;padding-top: 0px">
        <div>
          <el-table
            :data="system"
            stripe
            v-loading="tableLoading"
            size="mini"
            style="width: 100%">
            <el-table-column
              width="150"
              prop="time"
              align="center"
              label="发行时间">
            </el-table-column>
            <el-table-column
              width="100"
              prop="work"
              align="center"
              label="管理人员">
            </el-table-column>
            <el-table-column
              width="200"
              prop="version"
              align="center"
              label="版本号码">
            </el-table-column>
            <el-table-column
              width="500"
              prop="remark"
              align="center"
              label="备注内容">
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
      system: [
      {time: '2022-08-03',work: '蒋子涵',version: 'HRSYS(test)-V1_0',remark: '完成二次开发的主体框架'},
      {time: '2022-08-04',work: '谢浩科',version: 'HRSYS(release)-V1_1',remark: '数据库配置增加useSSL==false'},
      {time: '2022-08-10',work: '蒋子涵',version: 'HRSYS(test)-V2_1',remark: '数据库脚本变更'},
      {time: '2022-08-10',work: '蒋子涵',version: 'HRSYS(release)-V2_2',remark: '增添人事考评和人事积分的功能模块'},
      {time: '2022-08-16',work: '陈琴',version: 'HRSYS(release)-V2_3',remark: '增添导出员工数据库的功能模块'},
      {time: '2022-08-16',work: '蒋子涵',version: 'HRSYS(test)-V3_1',remark: '完善员工高级资料的信息查询'},
      {time: '2022-08-17',work: '谢浩科',version: 'HRSYS(test)-V3_2',remark: '完善人事信息统计的高级检索'},
      ]
        }
      },
    methods: {
       }
}
</script>
<style>
  .el-dialog__body {
    padding-bottom: 10px;
  }
</style>
