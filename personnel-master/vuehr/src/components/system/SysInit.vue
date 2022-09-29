<template>
  <el-header style="display: flex;justify-content: space-between;align-items: center;padding-left: 0px">
    <el-button @click="handleReset" icon="el-icon-pie-chart" type="primary" size="mini">初始化数据库</el-button>
  </el-header>
</template>

<script>
    export default {
        data() {
            return {
                dialogVisible: false,
                trains: [],
                index: 0,
                tableLoading: false,
                multipleSelection: [],
                empTrain: {
                    id: '',
                    eid: '',
                    trainDate: '',
                    trainContent: '',
                    remark: ''
                }
            };
        },
        methods: {
            reset(){
                var _this=this;
                this.getRequest("/system/init/reset").then(resp=> {
                    if(resp){
                        console.log(resp.data);
                    }
                })
            },
            handleReset(){
                this.$confirm('初始化数据库, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                   this.reset();
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            }
        }
    }

</script>

<style scoped>

</style>
