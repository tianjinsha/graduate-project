<template>
  <div class="view-container">
    <HeaderNav></HeaderNav>
    <div class="view-wrap aware">
      <section class="main-container">
        <AwareNavSec></AwareNavSec>
        <!---->
        <!---->
        <div class="ask">
          <!---->
          <div class="ask-item ask-hot">
            <div class="title">
              <h5>热门回答</h5>
              <span class="more">[全部]</span>
            </div>
            <ul class="list">
              <li class="list-item"><a href="#">谁能详细的解释下二进制及其算法？ </a></li>
              <li class="list-item"><a href="#">昏倒了应该掐人中吗? 还是心肺复苏？</a></li>
              <li class="list-item"><a href="#">为什么人类混血的好看，其他动物都是纯血的好看</a></li>
              <li class="list-item"><a href="#">数学专业的大学课程该怎么学呢？哪些课更重要？ </a></li>
              <li class="list-item"><a href="#">如何看待果壳终于选择放弃自己的网站，而依附于其他平台？</a></li>
              <li class="list-item"><a href="#">数学专业的大学课程该怎么学呢？哪些课更重要？</a></li>
              <li class="list-item"><a href="#">为什么现在果壳帖子不能空格了？</a></li>
              <li class="list-item"><a href="#">根据西瓜的形状、颜色和纹路来挑西瓜有科学依据吗？</a></li>
              <li class="list-item"><a href="#">果壳网的式微很大程度上因为果壳手机客户端功能少吗？</a></li>
              <li class="list-item"><a href="#">五年后的果壳会是什么样子？</a></li>
            </ul>
          </div>
          <!---->
          <div class="ask-item ask-good">
            <div class="title">
              <h5>精彩回答</h5>
              <span class="more">[全部]</span>
            </div>
            <ul class="list">
              <li class="list-item"><a href="#">谁能详细的解释下二进制及其算法？ </a></li>
              <li class="list-item"><a href="#">昏倒了应该掐人中吗? 还是心肺复苏？</a></li>
              <li class="list-item"><a href="#">为什么人类混血的好看，其他动物都是纯血的好看</a></li>
              <li class="list-item"><a href="#">数学专业的大学课程该怎么学呢？哪些课更重要？ </a></li>
              <li class="list-item"><a href="#">如何看待果壳终于选择放弃自己的网站，而依附于其他平台？</a></li>
              <li class="list-item"><a href="#">数学专业的大学课程该怎么学呢？哪些课更重要？</a></li>
              <li class="list-item"><a href="#">为什么现在果壳帖子不能空格了？</a></li>
              <li class="list-item"><a href="#">根据西瓜的形状、颜色和纹路来挑西瓜有科学依据吗？</a></li>
              <li class="list-item"><a href="#">果壳网的式微很大程度上因为果壳手机客户端功能少吗？</a></li>
              <li class="list-item"><a href="#">五年后的果壳会是什么样子？</a></li>
            </ul>
          </div>
          <!---->
        </div>
        <!---->
        <div class="ask-new">
          <div class="title">
            <h5>最新问题</h5>
            <span class="more">[全部]</span>
          </div>
          <ul class="list">
            <li class="list-item"><a href="#">谁能详细的解释下二进制及其算法？ </a>
              <time>2018-08-03 20:53</time>
            </li>
            <li class="list-item"><a href="#">昏倒了应该掐人中吗? 还是心肺复苏？</a>
              <time>2018-08-03 20:53</time>
            </li>
            <li class="list-item"><a href="#">为什么人类混血的好看，其他动物都是纯血的好看</a>
              <time>2018-08-03 20:53</time>
            </li>
            <li class="list-item"><a href="#">数学专业的大学课程该怎么学呢？哪些课更重要？ </a>
              <time>2018-08-03 20:53</time>
            </li>
            <li class="list-item"><a href="#">如何看待果壳终于选择放弃自己的网站，而依附于其他平台？</a>
              <time>2018-08-03 20:53</time>
            </li>
            <li class="list-item"><a href="#">数学专业的大学课程该怎么学呢？哪些课更重要？</a>
              <time>2018-08-03 20:53</time>
            </li>
            <li class="list-item"><a href="#">为什么现在果壳帖子不能空格了？</a>
              <time>2018-08-03 20:53</time>
            </li>
            <li class="list-item"><a href="#">根据西瓜的形状、颜色和纹路来挑西瓜有科学依据吗？</a>
              <time>2018-08-03 20:53</time>
            </li>
            <li class="list-item"><a href="#">果壳网的式微很大程度上因为果壳手机客户端功能少吗？</a>
              <time>2018-08-03 20:53</time>
            </li>
            <li class="list-item"><a href="#">五年后的果壳会是什么样子？</a>
              <time>2018-08-03 20:53</time>
            </li>
          </ul>
        </div>
        <!---->
      </section>
      <!---->
      <!---->
      <aside class="aside-container">
        <AwareHotTag></AwareHotTag>
        <AwareBest></AwareBest>
      </aside>
    </div>
  </div>
</template>

<script>
  import HeaderNav from './common/header-nav'
  import AwareNavSec from './aware/aware-nav-sec'
  import AwareBest from './aware/aware-best'
  import AwareHotTag from './aware/aware-hot-tag'

  export default {
    name: "aware",
    components: {
      HeaderNav,
      AwareNavSec,
      AwareBest,
      AwareHotTag
    }
  }
</script>

<style scoped>
  .ask {
    display: flex;
    background: white;
    border-bottom: 1px solid #eee;
  }

  .ask-item {
    width: 50%;
    padding: 10px;
    box-sizing: border-box;
  }

  .title {
    display: flex;
    padding: 10px 0;
    align-items: center;
  }

  .title h5 {
    font-size: 16px;
    font-weight: normal;
    color: #007fff;
    margin-right: 15px;
  }

  .title .more {
    font-size: 12px;
    color: #909090;
  }

  /**/
  .list {
  }

  .list .list-item {
    padding: 3px 0;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }

  .ask-new {
    background: white;
    padding: 10px;
  }

  .ask-new .list-item {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }

  .ask-new time {
    font-size: 12px;
    color: #909090;
  }
</style>
