<template>
  <div class="member-register main-container">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>会员管理</el-breadcrumb-item>
      <el-breadcrumb-item>来访登记</el-breadcrumb-item>
    </el-breadcrumb>

    <div class="memberReg-container content-wrap">
      <el-form ref="visitor" :model="visitor" label-width="80px"  >
        <el-form-item label="姓名">
          <el-col :span="8">
            <el-input placeholder="请输入姓名" v-model="visitor.username" clearable></el-input>
          </el-col>
        </el-form-item>
        <el-form-item label="电话">
          <el-col :span="8">
            <el-input placeholder="请输入电话" v-model="visitor.phone" clearable></el-input>
          </el-col>
        </el-form-item>
        <el-form-item label="性别">
          <span class="placeholder"></span>
          <el-radio-group v-model="visitor.age">
            <el-radio label="男" value="男" border></el-radio>
            <el-radio label="女" value="女" border></el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="年龄">
          <span class="placeholder"></span>
          <el-input-number v-model="visitor.age" :min="12" :max="80" label="年龄"></el-input-number>
        </el-form-item>
        <el-form-item label="意向">
          <el-col :span="8" class="intention">
          <el-rate  v-model="visitor.intention"  :colors="['#99A9BF', '#F7BA2A', '#FF9900']"  show-text>
          </el-rate>
          </el-col>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="onSubmit">立即办理</el-button>
        </el-form-item>

      </el-form>

    </div>
  </div>
</template>

<script>
    export default {
        name: "visitor-add",
      data(){
        return{
          visitor:{
            username:'',
            phone:'',
            sex:'',
            age:18,
            intention:3.0,
            comment:''
          }
        }
      },
      methods: {
        onSubmit() {
          console.log('submit!');
        }
      }
    }
</script>

<style scoped>
.intention{
  height: 40px;
 display: flex;
  align-items: center;
}
 .placeholder{
   display: inline-block;
   margin:0 3px;
 }
</style>
