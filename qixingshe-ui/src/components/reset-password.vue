<template>
  <div class="view-container">
    <div class="view-wrap reset-password">
      <section class="wrap">
        <div class="title">重置密码</div>
        <div class="tags">
          <a href="javascript:void(0)" class="reset-item reset-email" :class="{active:isEmail}" @click="changeEmailShow">邮箱重置</a>
          <a href="javascript:void(0)" class="reset-item reset-phone" :class="{active:isPhone}" @click="changePhoneShow">手机重置</a>
        </div>
        <div class="content">
          <div class="email-box" v-show="isEmail">
            <ul>
              <li>
                <el-input placeholder="请输入邮箱地址" clearable></el-input>
              </li>
              <li>
                <el-button type="primary">发送邮件</el-button>
              </li>
            </ul>
          </div>
          <div class="phone-box" v-show="isPhone">
            <ul>
              <li>
                <el-input placeholder="请输入手机号码" clearable></el-input>
              </li>
              <li>
                <el-input placeholder="图片验证码" clearable></el-input>
                <img src="../assets/img/validate.png" class="validate-img" alt=""></li>
              <li>
                <el-input placeholder="请输入验证码" clearable></el-input>
                <el-button type="primary" class="message">获取验证码</el-button>
              </li>
              <li>
                <el-input placeholder="请输入新密码" clearable></el-input>
              </li>
              <li>
                <el-button type="primary">确定</el-button>
              </li>
            </ul>
          </div>
        </div>

        <el-button type="text" @click="goBack">返回首页</el-button>
      </section>
    </div>
  </div>
</template>

<script>
  export default {
    name: "reset-password",
    data() {
      return {
        isEmail: true,
        isPhone: false

      }
    },
    methods: {
      goBack() {
        this.$router.go(-1);
      },
      changeEmailShow(){
        this.isEmail=true;
        this.isPhone=false;
      },
      changePhoneShow(){
        this.isEmail=false
        this.isPhone=true;

      }
    }
  }
</script>

<style scoped>
  .wrap {
    background: white;
    width: 500px;
    margin: 0 auto;
    padding: 15px 20px;
    box-sizing: border-box;
  }

  .title {
    text-align: center;
    height: 80px;
    line-height: 80px;
    font-size: 24px;
    font-weight: bold;
    color: #333;
  }

  .tags {
    background: #eee;
    height: 42px;
    display: flex;
    align-items: center;
    text-align: center;
  }

  .tags a {
    display: block;
    width: 50%;
    color: #333;
    height: 42px;
    line-height: 42px;

  }

  .tags a:hover {
    color: #007fff;
  }

  .tags a.active {
    box-sizing: border-box;
    color: #007fff;
    border-bottom: 2px solid #007fff;
  }

  .content {
    padding: 15px 0;
  }

  .content ul li {
    display: flex;
    padding: 5px 0;
    justify-content: space-between;
    align-items: center;
  }

  .validate-img {
    display: flex;
    margin-left: 15px;
    cursor: pointer;
  }

  .el-button {
    width: 100%;
  }

  .message {
    width: inherit;
    margin-left: 15px;
  }

  /**/

</style>
