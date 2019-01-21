<template>
  <div class="view-container">
    <HeaderNav></HeaderNav>
    <div class="title-sec">
      <div class="title-wrap">
        <span class="title-item"><a href="#" class="active">全部标签</a></span>
        <span class="title-item"><a href="#">已关注标签</a></span>
      </div>
    </div>
    <div class="view-wrap awareTags">
      <div class="tagNav">
        <ul>
          <li><a href="#" class="active">热门标签</a></li>
          <li><a href="#">人文·社科</a></li>
          <li><a href="#">科学·技术</a></li>
          <li><a href="#">生活·娱乐</a></li>
          <li><a href="#">自然·生态</a></li>
        </ul>
        <div class="search">
          <el-input  size="small" placeholder="搜索标签">
            <el-button slot="append" icon="el-icon-search"></el-button>
          </el-input>

        </div>
      </div>
      <section class="main-container">
        <ul class="tags-list">
          <li v-for="item in 7" :key="item">
            <TagItem></TagItem>
          </li>
        </ul>
      </section>
    </div>
  </div>
</template>

<script>
  import HeaderNav from './common/header-nav'
  import TagItem from './aware/tag-item'

  export default {
    name: "aware-tags",
    components: {
      HeaderNav,
      TagItem
    }
  }
</script>

<style scoped>
  .title-sec {
    background: white;
    margin-top: 60px;
    width: 100%;
  }

  .title-wrap {
    width: 1000px;
    height: 45px;
    line-height: 45px;
    margin: auto;

  }

  .title-item {
    display: inline-block;
    height: 100%;
  }

  .title-item a {
    display: inline-block;
    height: 100%;
    padding: 0 10px;
    font-weight: bold;
    box-sizing: border-box;
  }

  .title-item a.active {
    color: #007fff;
    border-bottom: 2px solid #007fff;
  }

  .title-item a:hover {
    color: #007fff;
    border-bottom: 2px solid #007fff;
  }

  .main-container {
    background: white;
    width: 100%;
  }

  .awareTags {
    margin: 15px auto 15px;
    display: block;
    background: white;

  }

  .tagNav {
    display: flex;
    align-items: center;
  }

  .tagNav ul {
    display: flex;
    height: 60px;
    margin: 0 15px;
    align-items: center;
  }

  .tagNav li {
    margin-left: 15px;
  }

  .tagNav li a {
    color: #005db6;
  }

  .tagNav li a.active {
    color: #71777c;
  }

  .search {
    margin-left: 20px;
  }
  span.el-input__suffix{
    cursor: pointer;
    color:#007fff ;
    background: red;
  }
  .el-input__icon{
    color: red;
  }

    /**/
  .tags-list {
    padding: 15px;
    box-sizing: border-box;
    display: flex;
    flex-wrap: wrap;
    /*justify-content: space-between;*/
  }

  .tags-list li {
    margin-bottom: 15px;
    width: 50%;
    display: flex;
    justify-content: center;
    align-items: center;
  }
</style>
