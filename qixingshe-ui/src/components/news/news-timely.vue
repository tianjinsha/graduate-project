<template>
  <div class="news-timely">
    <div class="title">
      <h5><i class="el-icon-tickets"></i>&nbsp;快讯</h5>
      <div class="action"><i class="el-icon-caret-left"></i><span>全部</span> <i class="el-icon-caret-right"></i></div>
    </div>
    <!---->
    <!---->
    <div class="content-wrap">
      <ul class="list">
        <!---->
        <li class="list-item" v-for="item in 8" :key="item">
          <div class="news-box">
            <div class="dot"></div>
            <div class="line"></div>
            <div class="info" >
              <a href="#">如何让教育精准触达目标人群 看阿里文娱智能营销平台智教育心</a>
            </div>
            <div class="topic">
              互联网
            </div>
          </div>
        </li>
        <!---->
      </ul>
    </div>
  </div>
</template>

<script>
  import '../../assets/js/index'
  export default {
    name: "news-timely",
    methods:{
    }
  }
</script>

<style scoped>
  .news-timely {
    width: 100%;
    background: white;
    padding: 0 10px 15px;
    box-sizing: border-box;
    font-size: 14px;
    margin-bottom: 15px;
  }

  .title {
    display: flex;
    align-items: center;
    justify-content: space-between;
    height: 45px;
    border-bottom: 1px solid #eee;
  }

  .title h5 {
    font-size: 14px;
    color: #007fff;
  }

  .title .action {
    color: #969696;
  }

  .title .action i {
    cursor: pointer;
  }

  /**/
  .content-wrap{
    height:555px;
    overflow-y: scroll;
    margin:15px 0;
  }
  .list {
    padding: 15px 0;
    box-sizing: border-box;
  }

  .news-box {
    height: 80px;
    position: relative;
  }

  .line {
    height: 100%;
    width: 30px;
    border-right: 1px solid #ccc;
    float:left;
    box-sizing: border-box;
  }
  .dot{
    width:8px;
    height:8px;
    display: inline-block;
    background:#ddd;
    border-radius: 10px;
    position: absolute;
    left:26px;
    top:15px;
    cursor: pointer;
  }
  .info{
    float:right;
    width:217px;
    margin:10px ;
    box-sizing: border-box;
    text-overflow: ellipsis;
    overflow: hidden;
    height:40px;

  }
  .topic{
    float:right;
    width:217px;
    color:#ccc;
    padding:0 10px;
    box-sizing: border-box;
    font-size:12px;
  }
</style>
