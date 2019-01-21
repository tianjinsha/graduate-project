<template>
  <div class="view-container">
    <HeaderNav></HeaderNav>
    <div class="view-wrap it">
      <section class="main-container">
        <!---->
        <NavSec></NavSec>
        <!---->
        <div class="content-wrap">
          <ul class="content-list">
            <li class="item" v-for="item in 4" :key="item">
              <ItItem></ItItem>
            </li>
          </ul>
        </div>
      </section>
      <!---->
      <!---->
      <aside class="aside-container">
        <hot-topic2></hot-topic2>
      </aside>
    </div>
  </div>
</template>

<script>
  import HeaderNav from './common/header-nav'
  import NavSec from './tool/nav-sec'
  import ItItem from './it/it-item'
  import HotTopic2 from './it/hot-tag'

  export default {
    name: "i-t",
    components: {
      HeaderNav,
      NavSec,
      ItItem,
      HotTopic2
    }
  }
</script>

<style scoped>

</style>
