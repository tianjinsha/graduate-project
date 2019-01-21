<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
  import HeaderNav from './components/common/header-nav'
  import Index from './components/index'
  import LoginBox from './components/common/login-box'
  import RegBox from './components/common/reg-box'

  export default {
    name: 'App',
    components: {
      HeaderNav,
      Index,
      LoginBox,
      RegBox
    }
  }
</script>

<style>


</style>
