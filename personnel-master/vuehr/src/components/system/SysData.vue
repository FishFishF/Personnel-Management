<template>
<div>
  <div>
  <el-button type="success"><a href="/system/init/downEmpFile">导出员工数据</a></el-button>
  </div>
  <br>
          <el-upload
            :show-file-list="false"
            accept="application/vnd.ms-excel"
            action="/system/init/importEmp"
            :on-success="fileUploadSuccess"
            :on-error="fileUploadError" :disabled="fileUploadBtnText=='正在导入'"
            :before-upload="beforeFileUpload" style="display: inline">
            <el-button size="medium " type="primary" :loading="fileUploadBtnText=='正在导入'">
              {{fileUploadBtnText}}
            </el-button>
          </el-upload>
</div>
</template>
<script>
  export default{
    data(){
      return {
        keywords: '',
        fullloading: false,
        hrs: [],
        cardLoading: [],
        eploading: [],
         fileList: [{name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}, {name: 'food2.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}]
  , fileUploadBtnText: '恢复员工数据',
        allRoles: [],
        moreBtnState:false,
        selRoles: [],
        selRolesBak: []
      }
    },
    mounted: function () {

    },
    methods: {
      getAllEmp(){
        this.getRequest("/system/init/downEmpFile").then(resp=> {
          
          if (resp && resp.status == 200) {
          }
        });
      },
      fileUploadSuccess(response, file, fileList){
        if (response) {
          this.$message({type: response.status, message: response.msg});
        }
        // this.loadEmps();
        this.fileUploadBtnText = '恢复员工数据';
      },
      fileUploadError(err, file, fileList){
        this.$message({type: 'error', message: "导入失败!"});
        this.fileUploadBtnText = '恢复员工数据';
      },
      beforeFileUpload(file){
        this.fileUploadBtnText = '正在导入';
      },
    }
  }
</script>
<style>
  .user-info {
    font-size: 12px;
    color: #09c0f6;
  }
</style>