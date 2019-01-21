<template>
  <div class="nav-wrap">
    <h5>热点新闻</h5>
    <nav class="welcome-nav">
      <ul class="nav-list">
        <li>
          <router-link :to="{path:'/news'}">推荐</router-link>
        </li>
        <li>
          <router-link :to="{path:'/news'}">军事</router-link>
        </li>
        <li>
          <router-link :to="{path:'/news'}">财经</router-link>
        </li>
        <li>
          <router-link :to="{path:'/news'}">娱乐</router-link>
        </li>
        <li>
          <router-link :to="{path:'/news'}">体育</router-link>
        </li>
        <li>
          <router-link :to="{path:'/news'}">互联网</router-link>
        </li>
        <li>
          <router-link :to="{path:'/news'}">科技</router-link>
        </li>
        <li>
          <router-link :to="{path:'/news'}">女人</router-link>
        </li>
        <li>
          <router-link :to="{path:'/news'}">汽车</router-link>
        </li>
      </ul>
    </nav>
  </div>
</template>

<script>
  export default {
    name: "nav-sec"
  }
</script>

<style scoped>
  /*导航*/
  .nav-wrap {
    display: flex;
    align-items: center;
    justify-content: space-between;
    height: 45px;
    padding: 0 10px;
    border-bottom: 1px solid #eee;
    background: white;
  }

  .nav-wrap h5 {
    font-size: 16px;
    color: #555;
    font-weight: normal;
  }

  .nav-list {
    display: flex;

  }

  .nav-list li {
    padding: 3px 10px;
  }

  .nav-list li a {
    color: #90979c;
  }
</style>
