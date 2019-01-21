<template>
  <div class="view-container">
    <HeaderNav></HeaderNav>
    <div class="title-sec">
      <div class="title-wrap">
        <span class="title-item"><a href="#" class="active">全部话题</a></span>
        <span class="title-item"><a href="#">已关注换题</a></span>
      </div>
    </div>
    <div class="view-wrap liveTags">
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
  import TagItem from './live/tag-item'

  export default {
    name: "live-tags",
    components: {
      HeaderNav,
      TagItem
    }
  }
</script>

<style scoped>
  .liveTags{
    margin: 15px auto 15px;
  }
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
  .tags-list{
    padding: 15px;
    box-sizing: border-box;
    display: flex;
    flex-wrap: wrap;
    /*justify-content: space-between;*/
  }
  .tags-list li{
    margin-bottom: 15px;
    width:33.33%;
    display: flex;
    justify-content: center;
    align-items: center;
  }
</style>
