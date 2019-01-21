<template>
  <div class="view-container">
    <HeaderNav></HeaderNav>
    <div class="title-sec">
      <div class="title-wrap">
        <span class="title-item"><a href="#" class="active">全部标签</a></span>
        <span class="title-item"><a href="#">已关注标签</a></span>
      </div>
    </div>
    <div class="view-wrap ItTags">
      <section class="main-container">
        <ul class="tags-list">
          <li v-for="item in 7" :key="item"><TagItem></TagItem></li>
        </ul>
      </section>
    </div>
  </div>
</template>

<script>
  import HeaderNav from './common/header-nav'
  import TagItem from './it/tag-item'

  export default {
    name: "it-tags",
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
  .ItTags{
    margin: 15px auto 15px;
  }
  .tags-list{
    padding: 15px;
    box-sizing: border-box;
    display: flex;
    flex-wrap: wrap;
    /*justify-content: space-between;*/
  }
  .tags-list li{
    margin-bottom: 15px;
    width:25%;
    display: flex;
    justify-content: center;
    align-items: center;
  }
</style>
