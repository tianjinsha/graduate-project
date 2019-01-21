<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>

  import Index from './page/index'
  import HeaderNav from './components/common/header-nav'

  export default {
    name: 'App',
    components: {
      Index,
      HeaderNav
    }
  }
</script>

<style>
  @import "assets/css/basic.css";
</style>
