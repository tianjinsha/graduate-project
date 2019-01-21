<template>
  <div class="login-box auth-box" ref="authBox">
    <div class="content-list">
      <div class="content-row title">
        <h1 v-on:click="boxClose">登录</h1>
        <i class="el-icon-close close" v-on:click="boxClose"></i>
      </div>
      <div class="content-row form">
        <form action="">
          <el-input v-model="account" placeholder="请输入手机号或邮箱"></el-input>
          <el-input v-model="password" placeholder="请输入密码"></el-input>
          <el-button type="primary">登录</el-button>
        </form>
      </div>
      <div class="content-row account-login account">
        <span>没有账号？</span>
        <span><a class="reg-skip" v-on:click.stop-="regSkip">注册</a></span>
        <span><a href="/reset-password">忘记密码</a></span>
        <!--<span><router-link :to="{path:'/reset-password'}" class="reset-password">忘记密码</router-link></span>-->
      </div>
      <div class="content-row other">
        <span>第三方登录：</span>
        <img class="other-item" src="../../assets/img/qq-ico.png" alt="QQ">
        <img class="other-item" src="../../assets/img/weixin-ico.png" alt="微信">
        <img class="other-item" src="../../assets/img/sinaweibo-ico.png" alt="微博">
      </div>
    </div>
  </div>
</template>

<script>
  import './../../assets/js/basic'

  export default {
    name: "login-box",
    data() {
      return {
        isReg: true,
        account: '',
        password: ''
      }
    },
    mounted() {
    },
    methods: {
      //弹出登录框
      boxShow: function () {
        if ($(".view-container").children(".login-box").length == 0) {
          // $(".login-box").appendTo($(".view-container"));
          $(".view-container").append($(".login-box"));
        }
        $("body").lock();
        $(".login-box").center();
      },
      //登录框居中
      boxCenter: function () {
        if ($(".view-container").children(".login-box").length == 0) {
          $(".view-container").append($(".login-box"));
        }
        $(".login-box").center();
      },
      //关闭登录框
      boxClose: function () {
        $(".login-box").fadeOut();
        $(".screen").unlock();
      },
      resize: function () {
        $(window).resize(function () {
          $(".auth-box").center();
        });
      },
      //跳转到注册框
      regSkip: function () {
        $(".login-box").hide();
        this.$emit("regShow", this.isReg);
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

  .account {
    display: flex;
  }

  .account span:last-child {
    flex: 1;
    text-align: right;
  }

  .account a {
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
