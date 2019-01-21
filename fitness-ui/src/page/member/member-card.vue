<template>
  <div class="member-register main-container">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>会员管理</el-breadcrumb-item>
      <el-breadcrumb-item>办卡</el-breadcrumb-item>
    </el-breadcrumb>

    <div class="memberReg-container content-wrap">
      <el-form ref="card" :model="card" label-width="80px"  >

        <el-form-item label="会员编号">
          <el-col :span="8">
          <el-input placeholder="请输入会员编号" v-model="card.memberId" clearable></el-input>
          </el-col>
        </el-form-item>
        <el-form-item label="会员卡号">
          <el-col :span="8">
          <el-input placeholder="请输入卡号" v-model="card.cardNumber" clearable></el-input>
          </el-col>
        </el-form-item>
        <el-form-item label="截至时间">
          <el-col :span="8">
          <el-date-picker v-model="card.disableTime"  type="date" style="width: 100%;"> placeholder="选择日期">
          </el-date-picker>
          </el-col>
        </el-form-item>
        <el-form-item label="种类">
          <el-col :span="8">
          <el-select v-model="card.cardId" style="width: 100%;" placeholder="请选择">
            <el-option
              v-for="item in cardType"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
          </el-col>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">立即办理</el-button>
          <el-button>取消</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  export default {
    name: "member-card",

    data(){
      return{
        card:{
          memberId:'',
          cardNumber:'',
          disableTime:'',
          cardId:'',
        },
        cardType:[
          {
            value: '1',
            label: '年卡'
          }, {
            value: '2',
            label: '半年卡'
          }, {
            value: '3',
            label: '月卡'
          }
        ]
      }
    },
    methods: {
      onSubmit() {

          this.$axios.post('/cardHistory/add', this.card, {
            headers: {
              'Content-Type': 'application/json;charset=UTF-8'
            }
          }).then(function(response) {

            if(response.data){
              console.log(response.data)
              this.$message('添加成功');
              alert("添加成功");
            }
            // const data = response.data;
          }, function(response) {});
      }
    }

  }
</script>

<style scoped>
</style>
