<template>
  <div class="app-wrap">
    <header-nav></header-nav>
    <div class="view-wrap">
      <el-container>
        this is message
      </el-container>
    </div>
  </div>
</template>

<script>
  import HeaderNav from '../components/common/header-nav';
  export default {
    name: "message",
    components: {
      HeaderNav
    }
  }
</script>

<style scoped>

</style>
