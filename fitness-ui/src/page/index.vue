<template>
  <div class="app-wrap">
    <header-nav></header-nav>
    <div class="view-wrap">

      <div class="view-container">
        <el-row :gutter="20">
          <el-col :span="5">
            <div class="grid-content nav">
              <LeftNav></LeftNav>

            </div>
          </el-col>
          <el-col :span="19">
            <div class="grid-content">
              <router-view></router-view>
            </div>
          </el-col>
        </el-row>
    </div>
  </div>
  </div>
</template>

<script>
  import LeftNav from '../components/common/left-nav';
  import HeaderNav from '../components/common/header-nav';


  export default {
    name: "index",
    components: {
      LeftNav,
      HeaderNav
    }
  }
</script>

<style scoped>
  .view-container {
    width: 100%;
  }

  .grid-content {
    display: flex;
  }
  .nav{
    justify-content: center;
  }
</style>
