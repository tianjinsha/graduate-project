<template>
  <div class="app-wrap">
    <div class="view-wrap">
      <div class="view-container">
        <div class="img-wrap">
          <img src="../../assets/img/login.jpg"/>
        </div>
        <el-form ref="loginForm" :model="loginForm" label-width="80px" @submit.stop.prevent="login">
          <div class="login-title">
            <p>后台登录</p>
          </div>
          <el-form-item label="账号">
            <el-input v-model="loginForm.username"></el-input>
          </el-form-item>

          <el-form-item label="密码">
            <el-input v-model="loginForm.password" type="password"></el-input>
          </el-form-item>

          <el-form-item>
            <el-button type="primary" href="/login" size="small" @click.native.prevent="login" target="_blank" class="login-submit">登录</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
  import * as types from '../../store/type'
  export default {
    name: "admin-login",
    data() {
      return {
        loginForm: {
          username: 'admin',
          password: 'admin'
        },
        msg: '',
        token: ''
      }
    },
    mounted() {
      this.$store.commit(types.TITLE, 'Login');
    },
    methods: {
      login: function () {
        // console.log("to login"+JSON.stringify({username:this.loginForm.username,password:this.loginForm.password}))
        //
        // this.$axios.post("/login",{username:this.loginForm.username,password:this.loginForm.password},(response)=>{
        // console.log(response)
        // });
        this.$router.push({ path: `/` })

        if (this.token) {
          this.$store.commit(types.LOGIN, this.token)
          let redirect = decodeURIComponent(this.$route.query.redirect || '/');
          this.$router.push({
            path: redirect
          })
        }
      }
    }
  }
</script>

<style scoped>
  .app-wrap {
    position: absolute;
    top: 0;
    bottom: 0;
    width: 100%;
    background: linear-gradient(45deg, #C2FFD8, #1eb2fb);
  }

  .img-wrap {

    max-width: 400px;
    height: auto;
  }

  .img-wrap img {
    width: 100%;
    border-radius: 4px;
  }

  .el-form .el-form-item__label {
    color: #f3f3f3 !important;
  }

  .view-container {
    margin: 50px auto 0;
    display: flex;
    color: #f3f3f3;
    flex-wrap: wrap;
    padding: 0 15px;
  }

  .login-title {
    height: 40px;
    line-height: 40px;
    text-align: center;
    font-size: 18px;
    color: #f3f3f3;
  }
</style>
