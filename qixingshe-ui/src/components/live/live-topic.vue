<template>
  <div class="live-topic">
    <div class="title">
      <span>更多话题</span>
      <router-link :to="{path:'/liveTags'}" class="more">
        全部<i class="el-icon-arrow-right"></i>
      </router-link>
    </div>
    <div class="list">
      <ul>
          <li  v-for="item in 4" :key="item">
            <a href="#" class="avatar"><img src="../../assets/img/author.jpg" alt=""></a>
            <a href="#" class="name">无限猴子</a>
            <p>390关注 · 45篇文章</p>
          </li>
          <!---->
      </ul>
    </div>
  </div>
</template>

<script>
  export default {
    name: "live-topic"
  }
</script>

<style scoped>
  .live-topic {
    width: 100%;
    background: white;
    padding: 0 10px 15px;
    box-sizing: border-box;
    font-size: 14px;
    margin-bottom: 15px;
  }

  .title {
    height: 45px;
    display: flex;
    align-items: center;
    justify-content: space-between;
    border-bottom: 1px solid #eee;
  }

  .title span {
    color: #333;
    font-weight: bold;
  }

  .title .more {
    color: #007fff;
    font-size: 12px;
  }

  /**/
  .list {
    margin:10px 0;
  }

  .list ul li {
    padding: 5px 0;
    border-bottom: 1px solid #eee;
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

</style>
