<template>
  <div class="cardType-list main-container">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>商品管理</el-breadcrumb-item>
      <el-breadcrumb-item>最新活动</el-breadcrumb-item>
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
            label="编号"
            width="150">
          </el-table-column>
          <el-table-column
            prop="cardId"
            label="卡号名称"
            width="150">
          </el-table-column>
          <el-table-column
            prop="discount"
            label="折扣率"
            width="120">
          </el-table-column>
          <el-table-column
            prop="fromTime"
            label="开始时间"
            width="150">
          </el-table-column>
          <el-table-column
            prop="toTime"
            label="结束时间"
            width="150">
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
        name: "discount",
      data() {
        return {
          tableData: [{
            id: '01',
            cardId: '32',
            discount: 1,
            fromTime:'2018-12-1',
            toTime:'2018-12-1',
            createTime:'2018-12-1',
          }, {
            id: '01',
            cardId: '32',
            discount: 1,
            fromTime:'2018-12-1',
            toTime:'2018-12-1',
            createTime:'2018-12-1',
          }, {
            id: '01',
            cardId: '32',
            discount: 1,
            fromTime:'2018-12-1',
            toTime:'2018-12-1',
            createTime:'2018-12-1',
          }, {
            id: '01',
            cardId: '32',
            discount: 1,
            fromTime:'2018-12-1',
            toTime:'2018-12-1',
            createTime:'2018-12-1',
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
