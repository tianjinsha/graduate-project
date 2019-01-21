<template>
  <div class="cardType-list main-container">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>商品管理</el-breadcrumb-item>
      <el-breadcrumb-item>器材列表</el-breadcrumb-item>
    </el-breadcrumb>

    <div class="member-container content-wrap">
      <div class="search-wrap">
        <div class="search-item">
          <el-input
            placeholder="请输入器材编号"
            v-model="username" clearable>
          </el-input>
        </div>
        <div class="search-item">
          <el-button type="primary" icon="el-icon-search" size="small">搜索</el-button>
        </div>


      </div>
      <!--消费列表-->
      <div class="card-wrap content-list">
        <el-table
          :data="tableData"
          border
          style="width: 100%">
          <el-table-column
            prop="number"
            label="器材编号"
            width="100">
          </el-table-column>
          <el-table-column
            prop="typeId"
            label="器材名称"
            width="120">
          </el-table-column>
          <el-table-column
            prop="thumb"
            label="图片"
            width="100">
          </el-table-column>
          <el-table-column
            prop="status"
            label="状态"
            width="120">
          </el-table-column>
          <el-table-column
            prop="createTime"
            label="创建时间">
          </el-table-column>
        </el-table>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
        name: "equipment-list",
      data() {
        return {
          tableData: [{
            number: '01',
            typeId: '拉铃',
            thumb: '1.png',
            status:'良好',
            money:'26',
            createTime:'2016-05-02'
          }, {
            number: '01',
            typeId: '拉铃',
            thumb: '1.png',
            status:'良好',
            money:'26',
            createTime:'2016-05-02'
          }, {
            number: '01',
            typeId: '拉铃',
            thumb: '1.png',
            status:'良好',
            money:'26',
            createTime:'2016-05-02'
          }, {
            number: '01',
            typeId: '拉铃',
            thumb: '1.png',
            status:'良好',
            money:'26',
            createTime:'2016-05-02'
          }]
        }
      }
    }
</script>

<style scoped>
  /**
    搜索
    */
  .search-wrap {
    display: flex;
    align-items: center;
  }

  .search-item {
    margin-right: 10px;
  }
  .content-list {
    margin: 15px 0;
  }
</style>
