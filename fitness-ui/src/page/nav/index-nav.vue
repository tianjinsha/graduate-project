<template>
  <div class="main-container index-nav">
    <div class="breadcrumb">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/' }">Home</el-breadcrumb-item>
        <el-breadcrumb-item>快速导航</el-breadcrumb-item>
      </el-breadcrumb>
    </div>

    <div class="nav-container content-wrap">
      <nav class="quit-nav">
        <ul>
          <li class="quit-item quit-member">
              <img class="quit-img" src="../../assets/img/quit-member.png"/>
              <div class="leader">
                <h3>会员注册</h3>
                <h4>快来成为健身达人吧！</h4>
                <el-button type="primary" size="small" @click="routerToMemberReg" round>去注册<i class="el-icon-d-arrow-right el-icon--right"></i></el-button>
              </div>
          </li>
          <li class="quit-item quit-card">
            <img class="quit-img" src="../../assets/img/quit-card.png"/>
            <div class="leader">
              <h3>快速办卡</h3>
              <h4>一卡在手，天下我有！</h4>
              <el-button type="primary" size="small" @click="routerToAddCard" round>去办卡<i class="el-icon-d-arrow-right el-icon--right"></i></el-button>
            </div>
          </li>
          <li class="quit-item quit-visitor">
            <img class="quit-img" src="../../assets/img/quit-visitor.png"/>
            <div class="leader">
              <h3>游客登记</h3>
              <h4>悄悄给你说，你来了就不想走了的！</h4>
              <el-button type="primary" size="small" @click="routerToAddVisitor" round>去登记<i class="el-icon-d-arrow-right el-icon--right"></i></el-button>
            </div>
          </li>
        </ul>
      </nav>
      <nav class="nav-wrap">
        <h3 class="nav-title"><span class="dot"></span>会员管理</h3>
        <ul class="nav-list">
          <li class="nav-item">
            <div class="nav-detail">
              <img class="nav-img" src="../../assets/img/member.png"/>
              <div class="msg">会员列表</div>
            </div>
          </li>
          <li class="nav-item">
            <div class="nav-detail">
              <img class="nav-img" src="../../assets/img/member.png"/>
              <div class="msg">办卡记录</div>
            </div>
          </li>
          <li class="nav-item">
            <div class="nav-detail">
              <img class="nav-img" src="../../assets/img/member.png"/>
              <div class="msg">消费记录</div>
            </div>
          </li>
          <li class="nav-item">
            <div class="nav-detail">
              <img class="nav-img" src="../../assets/img/member.png"/>
              <div class="msg">来访统计</div>
            </div>
          </li>
          <li class="nav-item">
            <div class="nav-detail">
              <img class="nav-img" src="../../assets/img/member.png"/>
              <div class="msg">消息管理</div>
            </div>
          </li>
        </ul>
      </nav>
      <nav class="nav-wrap">
        <h3 class="nav-title"><span class="dot"></span>教练管理</h3>
        <ul class="nav-list">
          <li class="nav-item">
            <div class="nav-detail">
              <img class="nav-img" src="../../assets/img/member.png"/>
              <div class="msg">私教列表</div>
            </div>
          </li>
          <li class="nav-item">
            <div class="nav-detail">
              <img class="nav-img" src="../../assets/img/member.png"/>
              <div class="msg">打卡记录</div>
            </div>
          </li>
          <li class="nav-item">
            <div class="nav-detail">
              <img class="nav-img" src="../../assets/img/member.png"/>
              <div class="msg">业绩考核</div>
            </div>
          </li>
          <li class="nav-item">
            <div class="nav-detail">
              <img class="nav-img" src="../../assets/img/member.png"/>
              <div class="msg">工资统计</div>
            </div>
          </li>
        </ul>
      </nav>
    </div>
  </div>
</template>

<script>
  export default {
    name: "index-nav",
    data(){
      return{

      }
    },
    methods:{
      routerToMemberReg:function () {
        this.$router.push({ path: `/member/reg` })
      },
      routerToAddCard:function () {
        this.$router.push({ path: `/member/card-add` })
      },
      routerToAddVisitor:function () {
        this.$router.push({ path: `/member/visitor-add` })
      },
    }
  }
</script>

<style scoped>

  /**
  *快速导航
  */
  .quit-nav ul{
    display: flex;
    justify-content: space-around;
  }
.quit-item{
  display: flex;
  background: linear-gradient(45deg , #C2FFD8, #465EFB);
  margin:5px 10px;
  width: 300px;
  height: 150px;
  align-items: center;
  -webkit-border-radius: 4px;
  -moz-border-radius: 4px;
  border-radius: 4px;
}
.quit-img{
  width: 120px;
  height: 120px;
}
.leader{
  height: 120px;
  box-sizing: border-box;
  padding:5px 10px;
  overflow: hidden;
  text-overflow: ellipsis;
  position: relative;
}
.leader h3{
  color:#444;
  font-size: 16px;
  font-weight: normal;

}
  .leader h4{
    color:#777;
    font-weight: normal;
    font-size: 12px;
    padding:5px 0;
  }
 .leader .el-button{
  position: absolute;
   bottom: 5px;
  }
  /**
  *导航列表
  */
  .nav-list {
    display: flex;
    width: 100%;
  }

  .nav-title {
    display: flex;
    align-items: center;
    padding: 5px 0;
    font-size: 16px;
    font-weight: normal;
  }

  .nav-title .dot {
    background: #545c64;
    display: inline-block;
    width: 5px;
    height: 18px;
    margin-right: 5px;
  }

  /**
  导航内容
   */
  .nav-detail {
    background: #e9e9e3;
    padding: 10px;
    margin: 10px 20px;
    border: 1px solid #f1f1f1;
    width: 120px;
    height: 120px;
    border-radius: 4px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }

  .nav-list {
    display: flex;
    flex-wrap: wrap;
  }

  .nav-img {
    width: 80px;
    height: 80px;
  }

  .msg {
    margin: 15px;
    color: #666;
  }
</style>
