<template>
  <div class="tag-item item-content" v-on:mouseenter="changeEnter" @mouseleave="changeLeave">
    <div class="content-row thumb">
      <img src="../../assets/img/movie.jpg" alt="">
    </div>
    <div class="content-row title">
      电影
    </div>
    <div class="content-row introduce">
      <p>本专题收录电影相关文章。要求文内不得带有公众号信息等推广内容</p>
    </div>
    <div class="content-row meta">
      <span class="subscribe">15485&nbsp;关注</span>
      <span class="article">15457 &nbsp;文章</span>
    </div>
    <div class="content-row action">
      <a href="#" class="action-item look active">查看</a>
      <!--<a href="#" class="action-item attention">关注</a>-->
    </div>
  </div>
</template>

<script>
  export default {
    name: "tag-item",
    methods:{
      changeEnter:function (event) {
        var el=event.currentTarget;
        $(el).children(".action").css("display","block");
      },
      changeLeave:function () {
        var el=event.currentTarget;
        $(el).children(".action").css("display","none");
      }
    }
  }
</script>

<style scoped>

  .item-content{
    width:300px;
    border:1px solid #f2f2f2;
    text-align: center;
    padding:15px;
    box-sizing: border-box;
    position: relative;
  }
  .item-content:hover{
    background: rgba(225, 225, 225, 0.3);
  }
  .content-row{
    width:100%;
    padding:3px 20px;
    box-sizing: border-box;
  }
  .thumb img{
    display: inline-block;
    width:150px;
    height:150px;
  }
  .meta{
    color: #71777c;
    height:42px;
    line-height: 42px;
  }
  .title{
    font-size:20px;
    font-weight: bold;
    color:#333;
  }
  .introduce p{
    text-overflow: ellipsis;
    overflow: hidden;
    height:42px;
    color: #686e73;
    line-height:1.5;
    text-align: left;
  }
  .action{
    height:42px;
    width: inherit;
    line-height: 42px;
    position: absolute;
    bottom: 15px;
    left: 0;
    display: flex;
    align-items: center;
    justify-content: center;
    display: none;
  }
  .action-item{
    display: block;
    color:white;
    width: 100%;
    background: #66b1ff;
    border-radius: 10px;
  }
  .active{
    display: block;
  }
</style>
