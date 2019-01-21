<template>
  <div class="topic">
    <div class="title">
      <span>热门标签</span>
      <a href="#" class="more">
        <router-link :to="{path:'/itTags'}">
          全部<i class="el-icon-arrow-right"></i>
        </router-link>
      </a>
    </div>
    <div class="list">
      <ul class="tag-list">
        <li class="tag-item"><a href="#">架构</a></li>
        <li class="tag-item"><a href="#">开源</a></li>
        <li class="tag-item"><a href="#">算法</a></li>
        <li class="tag-item"><a href="#">GitHub</a></li>
        <li class="tag-item"><a href="#">面试</a></li>
        <li class="tag-item"><a href="#">代码规范</a></li>
        <li class="tag-item"><a href="#">产品</a></li>
        <li class="tag-item"><a href="#">翻译</a></li>
        <li class="tag-item"><a href="#">区块链</a></li>
        <li class="tag-item"><a href="#">大数据</a></li>
      </ul>
    </div>
  </div>
</template>

<script>
  export default {
    name: "hot-topic-2"
  }
</script>

<style scoped>
  .topic {
    width: 100%;
    background: white;
    padding: 0 10px 15px;
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

  .title .more a{
    color: #007fff;
    font-size: 12px;
  }

  /**/
  .list {
    margin:10px 0;
  }

  .tag-list {
    display: flex;
    flex-wrap:wrap;

  }

  .tag-list .tag-item{
    padding:4px 22px;
    background-color: #f3f6f3;
    border-radius: 30px;
    margin-right: 15px;
    margin-bottom: 15px;
  }
</style>
