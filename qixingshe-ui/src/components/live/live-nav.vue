<template>
    <div class="nav-wrap live-nav">
      <nav class="welcome-nav">
        <ul class="nav-list">
          <li><router-link :to="{path:'/live'}" exact>推荐</router-link></li>
          <li><router-link :to="{path:'/live2'}">动态</router-link></li>
        </ul>
      </nav>
    </div>
</template>

<script>
    export default {
        name: "live-nav"
    }
</script>

<style scoped>
  /*导航*/
  .nav-wrap {
    height: 45px;
    border-bottom: 1px solid #eee;
    width:100%;
    background: rgb(255,255,255);
  }
  .welcome-nav{
    height: 100%;
    font-size:16px;
  }
  .nav-list {
    display: flex;
    padding:0 30px;
    align-items: center;
    justify-content: center;
    height:100%;
  }
  .nav-list li{
    width:200px;
    display: flex;
    align-items: center;
    justify-content: center;
    height:100%;
  }
  .nav-list li a{
    color:#909090;
    position: relative;
  }
  .active{
    color:#007fff !important;
  }
  .active:after{
    content: "";
    width:36px;
    height: 3px;
    border-radius: 2px;
    background-color: #007fff;
    position: absolute;
    top: 120%;
    left: -8%;
  }
</style>
