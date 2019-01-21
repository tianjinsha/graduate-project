<template>
  <div class="nav-wrap aware-nav-sec">
    <nav class="welcome-nav">
      <ul class="nav-list">
        <li class="item"><a href="#">知问首页</a></li>
        <li class="item"><a href="#">发现问题</a></li>
        <li class="item"><a href="#">等待回答</a></li>
        <li class="item"><a href="#">标签广场</a></li>
      </ul>
      <div class="nav-action">
        <a href="#">提问</a>
        <a href="#">我要回答</a>
      </div>
    </nav>
  </div>
</template>

<script>
  export default {
    name: "aware-nav-sec"
  }
</script>

<style scoped>
  .welcome-nav{
    display: flex;
    background: white;
    justify-content: space-between;
    height:45px;
    align-items: center;
  }
  .nav-list{
    display: flex;
  }
  .nav-list .item{
    padding:0 12px;
  }
  .nav-action{
    display: flex;
  }
.nav-action a{
  background: #007fff;
  margin:0 10px;
  padding:4px 12px;
  color: white;
  border-radius: 2px;
}
</style>
