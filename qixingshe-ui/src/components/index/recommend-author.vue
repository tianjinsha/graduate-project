<template>
  <div class="author">
    <div class="title">
      <span>推荐作者</span>
      <a href="#">
        <li class="icon el-icon-refresh"></li>
        换一批</a>
    </div>
    <div class="list">
      <ul>
        <li>
          <a href="#" class="avatar"><img src="../../assets/img/author.jpg" alt=""></a>
          <a href="" class="follow"><i class="icon el-icon-plus"></i>关注</a>
          <a href="#" class="name">无限猴子</a>
          <p>写了34篇文章 · 21k喜欢</p>
        </li>
        <!---->
        <li>
          <a href="#" class="avatar"><img src="../../assets/img/author2.jpg" alt=""></a>
          <a href="" class="follow"><i class="icon el-icon-plus"></i>关注</a>
          <a href="#" class="name">乔汉童</a>
          <p>写了67篇文章 · 3.1k喜欢</p>
        </li>
        <!---->
        <li>
          <a href="#" class="avatar"><img src="../../assets/img/author.jpg" alt=""></a>
          <a href="" class="follow"><i class="icon el-icon-plus"></i>关注</a>
          <a href="#" class="name">无限猴子</a>
          <p>写了34篇文章 · 21k喜欢</p>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
  export default {
    name: "recommend-author"
  }
</script>

<style scoped>
  .author {
    width: 100%;
    background: white;
    padding: 15px 10px;
    font-size: 14px;
    margin-bottom: 15px;
    box-sizing: border-box;
  }

  .title {
    padding: 5px 0;
    display: flex;
    justify-content: space-between;
  }

  .title span {
    color: #969696;
  }

.icon {
    margin: 0 3px;
  font-weight: bold;
  }

  /*作者列表*/
  .list ul {
    padding: 10px 0;
  }

  .list ul li {
    padding: 5px 0;
  }

  .list ul li:after {
    content: "";
    height: 0;
    line-height: 0;
    display: block;
    visibility: hidden;
    clear: both;
  }

  .list .name {
    display: block;
    margin-left: 60px;
    color: #2f2f2f;
  }

  .list p {
    margin: 8px 0 0 60px;
    color: #969696;
  }

  .list .avatar {
    float: left;
  }

  .list .avatar img {
    width: 48px;
    height: 48px;
    border-radius: 48px;
  }

  .list .follow {
    float: right;
    color:#42c02e;
  }
</style>
