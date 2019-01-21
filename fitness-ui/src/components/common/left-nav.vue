<template>
  <el-header>
    <div class="left-nav ">
      <el-menu default-active="1-4-1"
               class="el-menu-vertical-demo"
               @open="handleOpen"
               @close="handleClose"
               background-color="#545c64"
               text-color="#fff"
               active-text-color="#ffd04b"

               :collapse="isCollapse">
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-location"></i>
            <span slot="title">会员管理</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="1-1" router=""><router-link :to="{path:'/member/list'}" exact>会员列表</router-link></el-menu-item>
            <el-menu-item index="1-2"><router-link :to="{path:'/member/card'}" exact>办卡记录</router-link></el-menu-item>
            <el-menu-item index="1-3"><router-link :to="{path:'/member/consumer'}" exact>消费记录</router-link></el-menu-item>
            <el-menu-item index="1-4"><router-link :to="{path:'/member/visitor'}" exact>来访统计</router-link></el-menu-item>
          </el-menu-item-group>
        </el-submenu>

        <el-submenu index="2">
          <template slot="title">
            <i class="el-icon-menu"></i>
            <span slot="title">私教管理</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="2-1" router=""><router-link :to="{path:'/coach/list'}" exact>私教列表</router-link></el-menu-item>
            <el-menu-item index="2-2"><router-link :to="{path:'/coach/student'}" exact>学员列表</router-link></el-menu-item>
            <el-menu-item index="2-3"><router-link :to="{path:'/coach/card'}" exact>打卡记录</router-link></el-menu-item>
          </el-menu-item-group>
        </el-submenu>

        <el-submenu index="3">
          <template slot="title">
            <i class="el-icon-menu"></i>
            <span slot="title">商品管理</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="3-1"><router-link :to="{path:'/goods/card'}" exact>办卡分类</router-link></el-menu-item>
            <el-menu-item index="3-2"><router-link :to="{path:'/goods/discount'}" exact>最新活动</router-link></el-menu-item>
            <el-menu-item index="3-3"><router-link :to="{path:'/goods/equipment'}" exact>器材统计</router-link></el-menu-item>
          </el-menu-item-group>
        </el-submenu>

        <el-submenu index="4">
          <template slot="title">
            <i class="el-icon-setting"></i>
            <span slot="title">系统管理</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="4-1">系统日志</el-menu-item>
            <el-menu-item index="4-2">密码重置</el-menu-item>
            <el-menu-item index="4-3">收益分析</el-menu-item>
          </el-menu-item-group>
        </el-submenu>

        <el-menu-item index="4">
          <i class="el-icon-setting"></i>
          <span slot="title">系统设置</span>
        </el-menu-item>

      </el-menu>
    </div>
  </el-header>
</template>

<script>
  export default {
    name: "left-nav",
    data() {
      return {
        isCollapse: false
      };
    },
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
    }
  }
</script>

<style scoped>
  .el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    min-height: 400px;
  }
</style>
