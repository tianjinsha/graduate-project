<template>
    <div class="main-container member-nav">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/' }">Home</el-breadcrumb-item>
        <el-breadcrumb-item>全局导航</el-breadcrumb-item>
      </el-breadcrumb>

    </div>
</template>

<script>
    export default {
        name: "member-nav"
    }
</script>

<style scoped>

</style>
