<template>
  <div class="cardType-list main-container">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>商品管理</el-breadcrumb-item>
      <el-breadcrumb-item>会员卡分类</el-breadcrumb-item>
    </el-breadcrumb>

    <div class="member-container content-wrap">
      <div class="search-wrap">
        <div class="search-item">
          <el-input
            placeholder="请输入卡名称"
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
            prop="id"
            label="类型编号"
            width="100">
          </el-table-column>
          <el-table-column
            prop="name"
            label="类型名称"
            width="120">
          </el-table-column>
          <el-table-column
            prop="useCount"
            label="使用次数"
            width="100">
          </el-table-column>
          <el-table-column
            prop="useCount"
            label="使用天数"
            width="120">
          </el-table-column>
          <el-table-column
            prop="money"
            label="金额">
          </el-table-column>
          <el-table-column
            prop="discount"
            label="折扣">
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
        name: "good-list",
      data() {
        return {
          tableData: [{
            id: '01',
            name: '年卡',
            useCount: '1',
            useTime:30,
            money:'26',
            discount:1,
            createTime:'2016-05-02'
          }, {
            id: '01',
            name: '年卡',
            useCount: '1',
            useTime:30,
            money:'26',
            discount:1,
            createTime:'2016-05-02'
          }, {
            id: '01',
            name: '年卡',
            useCount: '1',
            useTime:30,
            money:'26',
            discount:1,
            createTime:'2016-05-02'
          }, {
            id: '01',
            name: '年卡',
            useCount: '1',
            useTime:30,
            money:'26',
            discount:1,
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
