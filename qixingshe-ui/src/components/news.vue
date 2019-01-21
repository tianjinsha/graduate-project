<template>
  <div class="view-container">
    <HeaderNav></HeaderNav>
    <div class="view-wrap news">
      <section class="main-container">
        <!---->
        <NavSec></NavSec>
        <!---->
        <div class="content-wrap">
          <ul class="content-list">
            <li class="item" v-for="item in 4" :key="item">
              <news-item></news-item>
            </li>
          </ul>
        </div>
      </section>
      <!---->
      <!---->
      <aside class="aside-container">
        <NewsTimely></NewsTimely>
      </aside>
    </div>
  </div>
</template>

<script>
  import HeaderNav from './common/header-nav'
  import NavSec from './tool/nav-sec'
  import NewsItem from './news/news-item'
  import NewsTimely from './news/news-timely'

  export default {
    name: "news",
    components: {
      HeaderNav,
      NewsItem,
      NavSec,
      NewsTimely
    }
  }
</script>

<style scoped>


</style>

