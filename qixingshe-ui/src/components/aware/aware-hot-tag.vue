<template>
  <div class="aware-hot-tag">
    <div class="title">
      <span>热门标签</span>
      <router-link :to="{path:'/awareTags'}" class="more">
        全部<i class="icon el-icon-arrow-right"></i>
      </router-link>
    </div>
    <div class="hot-tags">
      <!---->
      <div class="tag-item" v-for="item in 4" :key="item">
        <div class="tag-title"><a href="#">人文 ▪ 社科</a></div>
        <ul class="tag-list">
          <li class="tag-list-item">
            <img src="../../assets/img/aware1.jpg" alt="">
            <span><a href="#">心理学</a></span>
          </li>
          <li class="tag-list-item">
            <img src="../../assets/img/aware1.jpg" alt="">
            <span><a href="#">人文</a></span>
          </li>
          <li class="tag-list-item">
            <img src="../../assets/img/aware1.jpg" alt="">
            <span><a href="#">社会科学</a></span>
          </li>
          <li class="tag-list-item">
            <img src="../../assets/img/aware1.jpg" alt="">
            <span><a href="#">历史</a></span>
          </li>
          <li class="tag-list-item">
            <img src="../../assets/img/aware1.jpg" alt="">
            <span><a href="#">大学</a></span>
          </li>
          <li class="tag-list-item">
            <img src="../../assets/img/aware1.jpg" alt="">
            <span><a href="#">法律</a></span>
          </li>


          <!---->
        </ul>
      </div>
      <!---->
    </div>
  </div>
</template>

<script>
  export default {
    name: "aware-hot-tag"
  }
</script>

<style scoped>
  .aware-hot-tag {
    width: 100%;
    background: white;
    padding: 0px 10px 15px;
    box-sizing: border-box;
    font-size: 14px;
    margin-bottom: 15px;
  }

  .title {
    height: 45px;
    display: flex;
    align-items: center;
    justify-content: space-between;
    border-bottom: 1px solid #eee;
  }
  .title span {
    color: #333;
    font-weight: bold;
  }
  .more{
    color: #007fff;
    font-size: 12px;
  }
  /**/
  .hot-tags{
    font-size:12px;
    padding:10px 0 0;
  }
  .tag-title a{
    padding:2px 0;
    color:#969696;
  }
  .tag-title a:hover{
    text-decoration: underline;
  }
  .tag-list{
    display: flex;
    flex-wrap: wrap;
    padding:15px 0 0;
    /*justify-content: space-around;*/
  }

  .tag-list-item{
    display: flex;
    align-items: center;
    margin-bottom: 15px;
    width:33.33%;
  }
  .tag-list-item img{
    width:24px;
    height:24px;
  }
  .tag-list-item span a{
    color:#005dba;
    margin-left:5px;
  }
  .tag-list-item span a:hover{
    text-decoration: underline;
  }
</style>
