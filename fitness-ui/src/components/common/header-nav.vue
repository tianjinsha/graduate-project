<template>
  <div class="header-wrap">
    <header class="view-wrap">
      <el-menu
        :default-active="activeIndex2"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b">
        <el-menu-item index="1">
          <router-link :to="{path:'/'}" exact>Home</router-link>
        </el-menu-item>
        <el-menu-item index="3">
          <router-link :to="{path:'/message'}">消息中心</router-link>
        </el-menu-item>
        <el-menu-item index="4">订单管理</el-menu-item>

      </el-menu>
    </header>
  </div>
</template>

<script>
  export default {
    name: "header-nav",
    data() {
      return {
        activeIndex: '1',
        activeIndex2: '1'
      };
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      }
    }
  }
</script>

<style scoped>
  .header-wrap {
    width: 100%;
    background: #545c64;

  }

  .el-menu {
    border: none;
  }
</style>
