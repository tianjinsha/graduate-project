<template>
  <div class="topic">
    <div class="title">
      <span>热门话题</span>
      <a href="#">
        <li class="icon el-icon-refresh"></li>
        换一批</a>
    </div>
    <div class="list">
      <ul>
        <li>
          <a href="#" class="avatar"><img src="../../assets/img/topic.jpg" alt=""></a>
          <a href="#" class="name">篮球</a>
          <a href="" class="follow"><i class="icon el-icon-plus"></i>关注</a>
        </li>
        <!---->
        <li>
          <a href="#" class="avatar"><img src="../../assets/img/topic2.jpg" alt=""></a>
          <a href="#" class="name">食品安全</a>
          <a href="" class="follow"><i class="icon el-icon-plus"></i>关注</a>
        </li>
        <!---->
        <li>
          <a href="#" class="avatar"><img src="../../assets/img/topic2.jpg" alt=""></a>
          <a href="#" class="name">食品安全</a>
          <a href="" class="follow"><i class="icon el-icon-plus"></i>关注</a>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
  export default {
    name: "hot-topic"
  }
</script>

<style scoped>
  .topic {
    width: 100%;
    background: white;
    padding: 15px 10px;
    box-sizing: border-box;
    font-size: 14px;
    margin-bottom: 15px;
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

  /*列表*/
  .list ul {
    padding: 10px 0;

  }

  .list ul li {
    display: flex;
    padding: 5px 0;
    align-items: center;
  }

  .list ul li:after {
    content: "";
    height: 0;
    line-height: 0;
    display: block;
    visibility: hidden;
    clear: both;
  }

  .list .avatar img{
    width: 48px;
    height: 48px;
    border-radius: 8px;
  }

  .list .name {
    /*margin-right:auto;//布局：最后一个元素靠右*/
    padding:0 10px;
    font-weight: bold;
    color:#0078b6;
  }
  .list .follow {
    color: #42c02e;
    flex: 1;
    text-align: right;
    color:#259;
  }
</style>
