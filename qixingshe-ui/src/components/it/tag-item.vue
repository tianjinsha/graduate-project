<template>
    <div class="tag-item item-content">
      <div class="content-row thumb">
        <img src="../../assets/img/net.jpg" alt="">
      </div>
      <div class="content-row title">
        网络
      </div>
      <div class="content-row meta">
        <span class="subscribe">15485&nbsp;关注</span>
        <span class="article">15457 &nbsp;文章</span>
      </div>
      <div class="action">
        <a href="#" class="action-item look active">查看</a>
        <a href="#" class="action-item attention">关注</a>
      </div>
    </div>
</template>

<script>
    export default {
        name: "tag-item"
    }
</script>

<style scoped>

  .item-content{
    width:220px;
    border:1px solid #f2f2f2;
    text-align: center;
    padding:10px;
    box-sizing: border-box;
  }
  .content-row{
    padding:3px 0;
  }
  .thumb{
    display: inline-block;
    width:48px;
    height:48px;
  }
  .meta{
    color: #71777c;

  }
  .title{
    font-size:16px;
    font-weight: bold;
    color:#333;
  }
  .action{
    padding:10px 0;
  }
  .action-item{
    display: none;
    border:1px solid #007fff;
    padding:3px 10px;
    color:#007fff;
  }
  .active{
    display: inline;
  }
</style>
