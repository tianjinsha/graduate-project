<template>
  <div class="main-container card-list">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>会员管理</el-breadcrumb-item>
      <el-breadcrumb-item>办卡记录</el-breadcrumb-item>
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
            placeholder="请输入卡号"
            v-model="cardNumber"
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
          :data=cardListData.records
          border
          style="width: 100%">
          <el-table-column
            prop="createTime"
            label="开卡日期"
            width="180">
          </el-table-column>
          <el-table-column
            prop="disableTime"
            label="到期时间">
          </el-table-column>
          <el-table-column
            prop="cardNumber"
            label="卡号"
            width="180">
          </el-table-column>
          <el-table-column
            prop="cardId"
            label="类型"
            width="180">
          </el-table-column>
        </el-table>
      </div>
      <div class="page">
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page=cardListData.current
          :page-sizes="[cardListData.size*1, cardListData.size*2, cardListData.size*3, cardListData.size*4]"
          :page-size=cardListData.size
          layout="total, sizes, prev, pager, next, jumper"
          :total=cardListData.total>
        </el-pagination>
      </div>
      <div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "card-list",
    data() {
      return {
        cardListData:{
          current:1,
          pages:0,
          records:[],
          size:10,
          total:0
        },
        fdate:'',
        cardNumber:'',
        username:'',
      }
    },
    methods: {
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
      }
    },
    created:function () {
      this.$fetch("/cardHistory/list").then((response)=>{
        console.log(response);
        console.log(response.records)
        this.cardListData=response;
      })
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
