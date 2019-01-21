<template>
  <div class="consumer-list main-container">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>会员管理</el-breadcrumb-item>
      <el-breadcrumb-item>消费列表</el-breadcrumb-item>
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
            placeholder="请输入会员名"
            v-model="account"
            clearable>
          </el-input>
        </div>
        <div class="search-item">
          <el-input
            placeholder="请输入教练名"
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
            label="消费日期"
            width="180">
          </el-table-column>
          <el-table-column
            prop="memberId"
            label="会员名">
          </el-table-column>
          <el-table-column
            prop="coachID"
            label="教练"
            width="180">
          </el-table-column>
          <el-table-column
            prop="money"
            label="消费金额"
            width="180">
          </el-table-column>
          <el-table-column
            prop="money"
            label="备注">
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
        name: "consumer-list",
      data() {
        return {
          tableData: [{
            createTime: '2016-05-02',
            memberId: '3323',
            coachID: '12345',
            money:123,
            comment:'备注'
          }, {
            createTime: '2016-05-02',
            memberId: '3232',
            coachID: '12345',
            money:123,
            comment:'备注'
          }, {
            createTime: '2016-05-02',
            memberId: '322',
            coachID: '12345',
            money:123,
            comment:'备注'
          }, {
            createTime: '2016-05-02',
            memberId: '2323',
            coachID: '12345',
            money:123,
            comment:'备注'
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
