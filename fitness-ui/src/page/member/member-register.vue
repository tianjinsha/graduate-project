<template>
  <div class="member-register main-container">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>会员管理</el-breadcrumb-item>
      <el-breadcrumb-item>会员注册</el-breadcrumb-item>
    </el-breadcrumb>

    <div class="memberReg-container content-wrap">
      <form>
        <div class="form-list">
          <div class="input-item">
          <label>姓名：</label>
          <el-input placeholder="请输入姓名" v-model="formdata.username" clearable></el-input>
        </div>
          <div class="input-item">
            <label>电话：</label>
            <el-input placeholder="请输入电话" v-model="formdata.phone" clearable></el-input>
          </div>
          <div class="input-item">
            <label>年龄：</label>
            <el-input-number v-model="formdata.age" :step="1" :min="12" :max="80"></el-input-number>
          </div>
          <div class="input-item">
            <label>性别：</label>
            <el-radio v-model="formdata.sex" label="1" border>男</el-radio>
            <el-radio v-model="formdata.sex" label="2" border>女</el-radio>
          </div>
          <div  class="input-item">
            <el-upload
              action="https://jsonplaceholder.typicode.com/posts/"
              list-type="picture-card"
              :on-preview="handlePictureCardPreview"
              :on-remove="handleRemove"
              :on-success="handleAvatarSuccess"
              :before-upload="beforeAvatarUpload"
              :auto-upload=false
              >
              <i class="el-icon-plus"></i>
            </el-upload>
            <el-dialog :visible.sync="dialogVisible">
              <img width="100%" :src="formdata.dialogImageUrl" alt="">
            </el-dialog>
            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过2M</div>
          </div>
          <div class="input-item">
            <el-button type="primary" @click="login">注册</el-button>
          </div>
        </div>
      </form>
    </div>

  </div>
</template>

<script>
  export default {
    name: "member-register",
    data() {
      return {
        formdata:{
          username: '',
          phone:'',
          age: 18,
          sex: 1,
          thumb: '',
          dialogImageUrl: '',
        },
        dialogVisible: false
      }
    },
    methods: {
      handleAvatarSuccess(res, file) {
        console.log("file:"+file.url)
        this.imageUrl = URL.createObjectURL(file.raw);
        console.log("this.imageUrl:"+this.imageUrl)
      },
      beforeAvatarUpload(file) {
        console.log(file.size/1024/1024)
        const isJPG = file.type === 'image/png';
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG 格式!');
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
        }
        return isJPG && isLt2M;
      },

      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePictureCardPreview(file) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
      },
      login(){

        this.$axios.post('/member/add', this.formdata, {
          headers: {
            'Content-Type': 'application/json;charset=UTF-8'
          }
        }).then(function(response) {

          if(response.data){
            console.log(response.data)
            this.$message('添加成功');
            alert("添加成功");
          }
          // const data = response.data;
        }, function(response) {});
        console.log("login"+this.formdata.username);
      }
    }
  }
</script>

<style scoped>
  .form-list {
    display: flex;
    flex-direction: column;
  }
  .input-item{
    margin:10px 0;
  }
  .el-input{
    width: auto;
  }


  /**
  图片上传
   */
  .avatar-uploader .el-upload {
    border: 1px dashed red;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>
