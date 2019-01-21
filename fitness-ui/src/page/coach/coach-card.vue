<template>
  <div class="coachCard-list main-container">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>私教管理</el-breadcrumb-item>
      <el-breadcrumb-item>打卡记录</el-breadcrumb-item>
    </el-breadcrumb>

    <div class="member-container content-wrap">
      <div class="search-wrap">
        <div class="search-item">
          <el-date-picker
            v-model="fdate"
            type="date"
            placeholder="开始日期">
          </el-date-picker>
        </div>
        <div class="search-item">
          <el-input
            placeholder="请输入私教名"
            v-model="account"
            clearable>
          </el-input>
        </div>
        <div class="search-item">
          <el-input
            placeholder="请输入私教编号"
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
            prop="createTime"
            label="开始日期"
            width="180">
          </el-table-column>
          <el-table-column
            prop="endTime"
            label="结束时间">
          </el-table-column>
          <el-table-column
            prop="coachName"
            label="教练名称"
            width="180">
          </el-table-column>
          <el-table-column
            prop="coachID"
            label="教练编号"
            width="180">
          </el-table-column>
        </el-table>
      </div>
      <div class="page">
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage4"
          :page-sizes="[10, 20, 30, 40]"
          :page-size="10"
          layout="total, sizes, prev, pager, next, jumper"
          :total="40">
        </el-pagination>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
        name: "coach-card",
      data() {
        return {
          tableData: [{
            createTime: '2016-05-02',
            endTime: '2016-05-02',
            coachName: '张三',
            coachID:123
          }, {
            createTime: '2016-05-02',
            endTime: '2016-05-02',
            coachName: '张三',
            coachID:123
          }, {
            createTime: '2016-05-02',
            endTime: '2016-05-02',
            coachName: '张三',
            coachID:123
          }, {
            createTime: '2016-05-02',
            endTime: '2016-05-02',
            coachName: '张三',
            coachID:123
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
