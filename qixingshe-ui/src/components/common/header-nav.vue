<template>
  <div class="main-header-box">
    <header class="main-header visible">
      <div class="container">
        <h1 class="logo"><a href="/"><img src="../../assets/logo.png" alt=""><span>齐行社</span></a>
        </h1>
        <nav class="main-nav">
          <!--导航列表-->
          <ul class="nav-list">
            <!---->
            <li class="nav-item main-nav-list">
              <ul class="q-nav">
                <li class="nav-item link-item"><router-link :to="{path:'/'}" exact>首页</router-link></li>
                <li class="nav-item link-item"><router-link :to="{path:'/news'}">新闻</router-link></li>
                <li class="nav-item link-item"><router-link :to="{path:'/it'}">IT·互联网</router-link></li>
                <li class="nav-item link-item"><router-link :to="{path:'/live'}">生活&娱乐</router-link></li>
                <li class="nav-item link-item"><router-link :to="{path:'/aware'}">知问</router-link></li>
              </ul>
            </li>
            <!---->
            <li class="nav-item search">
              <el-input suffix-icon="el-icon-search" placeholder="请输入内容"></el-input>
            </li>
            <li class="nav-item write">
              <div class="write-wrap">
                <el-button type="primary" icon="el-icon-edit" size="medium" round>写文章</el-button>
              </div>
            </li>
            <li class="nav-item auth">
              <span class="login"><a v-on:click.stop="loginShow()">登录</a></span>
              <span class="register"><a v-on:click.stop="regShow()">注册</a></span>
            </li>
          </ul>
          <!---->
        </nav>
      </div>
    </header>
    <LoginBox ref="LoginBox"  @regShow="regSkipShow"></LoginBox>
    <RegBox ref="RegBox" @loginShow="loginSkipShow"></RegBox>
  </div>
</template>

<script>
  // import '../../assets/js/index'
  import LoginBox from './login-box'
  import RegBox from './reg-box'
  export default {
    name: "header-nav",
    data() {
      return{
        isReg:false,
        isLogin:false,
        searchText:'  '
      }
    },
    components:{
      LoginBox,
      RegBox
    },
    methods:{
      //弹出登录框
      loginShow:function () {
       this.$refs.LoginBox.boxShow();
      },
      //弹出注册框
      regShow:function () {
        this.$refs.RegBox.boxShow();
      },
      //跳转到注册框
      regSkipShow:function(data){
        this.isReg=data;
        this.$refs.RegBox.boxCenter();
      },
      //条状到登录框
      loginSkipShow:function (data) {
        this.isLogin=data;
        this.$refs.LoginBox.boxCenter();
      }
    }
  }
</script>

<style scoped>
  /*头部容器*/
  .main-header-box {
    width: 100%;
    height: 60px;
    background: rgb(255,255,255);
    position: fixed;
    top:0;
    z-index: 250;
  }

  .main-header {
    height: 60px;
    border-bottom: 1px solid #eee;
    box-sizing: border-box;
  }

  .container {
    max-width: 1000px;
    height: 100%;
    margin: 0 auto;
    display: flex;
    align-items: center;
  }

  /*logo*/
  .logo{
    display: flex;
    align-items: center;
    justify-content: center;
    flex:1 0 auto;
    height:100%;
  }

  .logo a {
    color: #007fff;
    font-size: 18px;
    display: inline-flex;
    height:100%;
  }
  .logo a span{
    display:-webkit-box;
    -webkit-box-pack:center;
    -webkit-box-align:center;
  }
  /*导航栏*/
  .main-nav {
    height: 100%;
    /*flex:1 0 auto;*/
    box-sizing: border-box;
  }

  /*头部导航列表（导航列，搜索框，注册登陆）*/
  .nav-list {
    display: flex;
    height: 100%;
    align-items: flex-end;
    justify-content: flex-end;
  }

  .nav-item {
    padding: 0 15px;
    display: flex;
    height: 100%;
    box-sizing: border-box;
    align-items: center;
    justify-content: space-between;
  }

  /*导航列表*/
  .active {
    color:#007fff;
  }
  .main-nav-list {
    height: 100%;
    font-size: 16px;
  }

  .q-nav {
    display: flex;
    align-items: center;
    padding: 0 10px;
    height: 100%;
  }

  .q-nav .link-item {
    display: flex;
    height: 100%;
    align-items: center;
    padding: 0 15px;
    white-space: nowrap;
  }

  /*搜索框*/
  .write:after {
    content: "|";
    position: relative;
    /*top: 20px;*/
    left: 10px;
    font-size: 20px;
    color: hsla(0, 0%, 59%, .4);
  }

  /*注册登录*/
  .auth {
    white-space: nowrap;
  }

  .auth .login:after {
    content: '·';
  }
  .auth a{
    color:#007fff;
    cursor: pointer;
  }

  @media only screen and (max-width: 992px) {
    .main-nav-list, .search {
      display: none;
    }
  }
</style>
