<template>
  <div class="view-container">
    <HeaderNav></HeaderNav>
    <div class="view-wrap index">
      <section class="main-container">
        <!--新闻模块-->
        <div class="new-wrap">
          <!---->
          <div class="title news-title">
            <h2>热门新闻</h2>
          </div>
          <!---->
          <div class="new-content">
            <div class="carouser-box">
              <el-carousel trigger="click" height="280px">
                <el-carousel-item v-for="item in 4" :key="item">
                  <h3>{{ item }}</h3>
                </el-carousel-item>
              </el-carousel>
            </div>
            <div class="newsList-box">
              <ul class="newsList">
                <li><a href="#" title="">同样是蚊子，怎么就我反应最大声？</a></li>
                <li><a href="#" title="">不想带套？男性避孕的新花招期待一下</a></li>
                <li><a href="#" title="">你在网上勾搭的对象，比你自己好个几成？</a></li>
                <li><a href="#" title="">美甲会让指甲变薄吗？</a></li>
                <li><a href="#" title="">国王、女皇与数学大咖？</a></li>
                <li><a href="#" title="">真的别帮我，还人情比还钱压力还大？</a></li>
                <li><a href="#" title="">首个“年抛”避孕环，女性可自行放置阴道内</a></li>
                <li><a href="#" title="">同样是蚊子，怎么就我反应最大声？</a></li>
                <li><a href="#" title="">美甲会让指甲变薄吗？</a></li>
                <li><a href="#" title="">首个“年抛”避孕环，女性可自行放置阴道内</a></li>
              </ul>
            </div>
          </div>
        </div>
        <!--科技模块-->
        <div class="science">
          <div class="title science-title">
            <h2>精彩科技</h2>
          </div>
          <div class="scienceList-box">
            <ul class="scienceList">
              <!---->
              <li class="scienceList-item" v-for="item in 4" :key="item">
                <div class="sec-title">
                  <h3>人工智能</h3>
                </div>
                <ul class="article-list">
                  <li class="article-head">
                    <a href="#" class="img"><img src="../assets/img/qixingTest.jpg" alt=""></a>
                    <div class="count">
                      <h4><a href="">我哼着歌，开着车，等着红灯……怎么又浪费油了？</a></h4>
                      <p>这个夏天，又有哪些勇士冒着酷暑学车了呢？</p>
                    </div>
                  </li>
                  <li><a href="#">大数据 《一》数据挖掘 原理思路分析</a></li>
                  <li><a href="#">基础 | batchnorm原理及代码详解</a></li>
                  <li><a href="#">《机器学习》周志华-CH1 绪论</a></li>
                  <li><a href="#">GBDT原理与Sklearn源码分析-回归篇</a></li>
                </ul>
              </li>
              <!---->
            </ul>
          </div>
        </div>
        <!--感悟模块-->

        <!--娱乐模块-->
      </section>
      <!---->
      <!---->
      <aside class="aside-container">
        <auth></auth>
        <recommed-author></recommed-author>
        <hotTopic></hotTopic>
      </aside>
    </div>
  </div>

</template>

<script>
  import HeaderNav from './common/header-nav'
  import auth from './index/auth'
  import hotTopic from './index/hot-topic'
  import recommedAuthor from './index/recommend-author'
  export default {
    name: "index",
    components:{
      HeaderNav,
      auth,
      hotTopic,
      recommedAuthor
    }
  }
</script>

<style scoped>
  /*模块标题*/
  .main-container .title {
    height: 42px;
    border-bottom: 1px solid #e9e9e9;
    line-height: 42px;
    text-indent: 5px;
  }

  .title h2 {
    color: #4c4c4c;
    font-weight: normal;
    font-size: 18px;
  }
.science-title{
  border-bottom: 1px solid #c5ebf9;
}
.science-title h2{
  color: #0078b6;
}
  /*新闻*/
  .new-wrap {
    width: 100%;
    background: white;
    margin-bottom: 15px;
  }
  .new-content{
    padding:15px 5px;
    display: flex;
  }

  /*走马灯*/
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }

  .carouser-box {
    width: 330px;
  }
  .newsList-box{
    width:350px;
    padding:0 15px;
    font-size:16px;
  }
  .newsList li{
    height:28px;
    line-height:28px;
  }
  .newsList li a{
    display: block;
    height:28px;
    line-height:28px;
  }
  /*精彩科技*/
  .science{
    background: white;
  }
  .scienceList-box{
    margin:15px 0;
  }
  .scienceList{
    display:flex;
    font-size:14px;
    flex-wrap: wrap;

  }
  .scienceList-item{
    width:340px;
    display: block;
  }
  .sec-title h3{
    height:45px;
    width:340px;
    line-height:45px;
    font-size:16px;
    font-weight: normal;
    color:#333;
    text-indent: 5px;
  }

  .article-list{
    padding:0 0 0 20px;
    height:204px;
  }
  .article-list li{
    list-style-type: square;
    word-wrap: break-word;
    color: #666;
    height:25px;
  }
  .article-head{
    width:100%;
    height:100px !important;
    display: flex;
    align-items: center;
    margin-left:-15px;
  }
  .count{
    padding:5px 10px;
  }

</style>

