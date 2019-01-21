<template>
  <div class="main-container card-list">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>会员管理</el-breadcrumb-item>
      <el-breadcrumb-item>来访统计</el-breadcrumb-item>
    </el-breadcrumb>

    <div class="card-container content-wrap">
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
            placeholder="请输入账号"
            v-model="account"
            clearable>
          </el-input>
        </div>
        <div class="search-item">
          <el-input
            placeholder="请输入用户名"
            v-model="username" clearable>
          </el-input>
        </div>
        <div class="search-item">
          <el-button type="primary" icon="el-icon-search" size="small">搜索</el-button>
        </div>


      </div>
      <!--办卡记录-->
      <div class="card-wrap content-list">
        <el-table
          :data="tableData"
          border
          style="width: 100%">
          <el-table-column
            prop="createTime"
            label="到访日期"
            width="150">
          </el-table-column>
          <el-table-column
            prop="username"
            label="姓名"
            width="150">
          </el-table-column>
          <el-table-column
            prop="phone"
            label="预留电话"
            width="180">
          </el-table-column>
          <el-table-column
            prop="sex"
            label="性别"
            width="80">
          </el-table-column>
          <el-table-column
            prop="intention"
            label="意向"
            width="120">
          </el-table-column>
          <el-table-column
            prop="intention"
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
      <div>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
        name: "会员打卡",
      data() {
        return {
          tableData: [{
            createTime: '2016-05-02',
            username: '王小虎',
            phone: '1213131313',
            sex:'男',
            ageStage:'18-25',
            intention:3,
            comment:'乱起暴躁'
          }, {
            createTime: '2016-05-02',
            username: '王小虎',
            phone: '1213131313',
            sex:'男',
            ageStage:'18-25',
            intention:3,
            comment:'乱起暴躁'
          }, {
            createTime: '2016-05-02',
            username: '王小虎',
            phone: '1213131313',
            sex:'男',
            ageStage:'18-25',
            intention:3,
            comment:'乱起暴躁'
          }, {
            createTime: '2016-05-02',
            username: '王小虎',
            phone: '1213131313',
            sex:'男',
            ageStage:'18-25',
            intention:3,
            comment:'乱起暴躁'
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
