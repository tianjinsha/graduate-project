<template>
  <div class="aware-best">
    <div class="title">
      <h4>最佳回答者</h4>
      <div class="action"><a href="#" class="active">最近</a><a href="#">一周</a></div>
    </div>
    <ul class="list">
      <li class="list-item" v-for="item in 4" :key="item">
        <div class="thumb"><img src="../../assets/img/author2.jpg" alt=""></div>
        <div class="name">喀秋莎</div>
        <div class="support"><i class="fa fa-thumbs-o-up"></i>&nbsp;3</div>
      </li>
    </ul>
  </div>
</template>

<script>
  export default {
    name: "aware-best"
  }
</script>

<style scoped>
  .aware-best {
    width: 100%;
    background: white;
    padding: 15px 10px;
    box-sizing: border-box;
    font-size: 14px;
    margin-bottom: 15px;
  }

  .title {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }

  .title h4 {
    color: #333;
    font-size: 14px;
  }

  .action a {
    display: inline-block;
    border: 1px solid #eee;
    padding: 3px 10px;
  }

  .action a:first-child {
    border-right: none;
  }

  .action a.active {
    color: #007fff;
  }

  /**/
  .list {
    padding:10px 0;
  }
  .list-item{
    display: flex;
    align-items: center;
    margin-bottom: 10px;
  }
  .thumb img{
    width:48px;
    height:48px;
  }
  .name{
    padding:0 8px;
    color: #005dba;
  }
  .support{
    flex:1 0 auto;
    text-align: right;
    padding-right:10px;
    color:#909090;
  }
</style>
