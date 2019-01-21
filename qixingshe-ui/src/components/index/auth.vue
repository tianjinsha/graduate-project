<template>
  <div class="auth">
    <div class="title">齐行社 - qixing.com</div>
    <div class="introduction">一站式智能推荐社区</div>
    <el-form ref="form" :model="form">
      <el-form-item>
        <el-input v-model="form.name" placeholder="用户名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-input v-model="form.phone" placeholder="电话号码" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-input v-model="form.password" placeholder="密码" type="password" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary">立即注册</el-button>
      </el-form-item>
    </el-form>
    <div class="other-auth">
      <span>第三方登录：</span>
      <img class="auth-btn" src="../../assets/img/qq-ico.png" alt="QQ">
      <img class="auth-btn" src="../../assets/img/weixin-ico.png" alt="微信">
      <img class="auth-btn" src="../../assets/img/sinaweibo-ico.png" alt="微博">
    </div>
  </div>
</template>

<script>
  export default {
    name: "auth",
    data() {
      return {
        form: {
          name: '',
          phone: '',
          password: ''
        }
      }
    }
  }
</script>

<style scoped>
  .auth {
    width: 100%;
    background: white;
    padding: 15px 10px;
    box-sizing: border-box;
    font-size: 14px;
    margin-bottom: 15px;
  }

  .title {
    font-weight: bold;
    color: #333;
    padding: 3px 30px;
  }

  .introduction {
    padding: 3px 30px;
    letter-spacing: 1px;
    color: #777;
  }
  /*表单*/
  .el-form{
    margin:10px 30px;
  }
  .el-form .el-button{
    width:100%;
  }
  .el-form-item{
    margin-bottom: 15px;
  }
  .other-auth{
    display: flex;
    height:32px;
    padding: 3px 30px 0;
  }
  .other-auth span{
    height:100%;
    display:-webkit-box;
    -webkit-box-pack:center;
    -webkit-box-align:center;
  }
  .auth-btn{
    width:30px;
    margin-left:5px;
    cursor: pointer;
  }
</style>
