<template>
  <div class="reg-box auth-box">
    <div class="content-list">
      <div class="content-row title">
        <h1>注册</h1>
        <i class="el-icon-close close" v-on:click="boxClose"></i>
      </div>
      <div class="content-row form">
        <form action="">
          <el-input v-model="username" placeholder="请输入用户名"></el-input>
          <el-input v-model="phone" placeholder="请输手机号"></el-input>
          <el-input v-model="password" placeholder="请输入密码（不少于6位）"></el-input>
          <el-button type="primary">注册</el-button>
        </form>
      </div>
      <div class="content-row account-reg account">
        <span><a class="login-skip" v-on:click.stop="loginSkip">已有账号登录</a></span>
      </div>
      <div class="content-row other">
        <span>第三方注册：</span>
        <img class="other-item" src="../../assets/img/qq-ico.png" alt="QQ">
        <img class="other-item" src="../../assets/img/weixin-ico.png" alt="微信">
        <img class="other-item" src="../../assets/img/sinaweibo-ico.png" alt="微博">
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "reg-box",
    data() {
      return {
        isLogin: true,
        username: '',
        phone: '',
        password: ''
      }
    },

    methods: {
      //弹出注册框
      boxShow: function () {
        if ($(".view-container").children(".reg-box").length == 0) {
          // $(".reg-box").appendTo($(".view-container"));
          $(".view-container").append($(".reg-box"));
        }
        $("body").lock();
        $(".reg-box").center();
      },
      //注册框居中
      boxCenter: function () {
        if ($(".view-container").children(".reg-box").length == 0) {
          $(".view-container").append($(".reg-box"));
        }

        $(".reg-box").center();
      },
      //跳转到登录框
      loginSkip: function () {
        $(".reg-box").hide();
        this.$emit("loginShow", this.isLogin);
      },
      boxClose: function () {
        $(".reg-box").fadeOut();
        $(".screen").unlock();
      }
    }
  }
</script>

<style scoped>
  .auth-box {
    padding: 15px;
    background: white;
    display: none;
    position: fixed;
    border-radius: 4px;
    z-index: 9999;
    box-sizing: border-box;
    color: #969696;
  }

  .content-list {
    width: 300px;

  }

  .content-row {
    padding: 5px 10px;
  }

  .title {
    display: flex;
    align-items: center;
    height: 45px;
    box-sizing: border-box;
    justify-content: space-between;
  }

  .title h1 {
    font-size: 18px;
    color: #333;
  }

  .title i {
    font-weight: bold;
    color: #969696;
    font-size: 16px;
    padding: 5px;
    cursor: pointer;
  }

  .form .el-input {
    margin-bottom: 10px;
  }

  .form .el-button {
    width: 100%;
  }

  .account-reg {
    display: flex;
    justify-content: center;
  }

  .account-reg a {
    color: #007fff;
    cursor: pointer;
  }

  .other {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
  }

  .other span {
    display: block;
    width: 100%;
    padding: 5px 0;
  }

  .other-item {
    width: 48px;
    height: 48px;
  }
</style>
