<template>
    <div class="tag-item item-content">
      <div class="content-column thumb">
        <img src="../../assets/img/aware1.jpg" alt="">
      </div>
      <div class="content-column detail">
        <div class="content-row title">
          <span class="name">心理学</span>
          <span class="action"><a href="">随便看看</a></span>
        </div>
        <div class="content-row meta">
          25587个问题
        </div>
        <div class="content-row introduce">
          <p>
            心理学是一门研究人类及动物的心理现象、
            精神功能和行为的科学，涉及知觉、认知、情绪、人格、行为和人际关系等许多领域，
            也与日常生活的许多领域——家庭、教育、健康等发生关联。
          </p>
        </div>
      </div>
    </div>
</template>

<script>
    export default {
        name: "tag-item"
    }
</script>

<style scoped>
  .item-content{
    width:450px;
    border:1px solid #f2f2f2;
    padding:15px;
    box-sizing: border-box;
    display: flex;
  }

  .thumb img{
    width:48px;
    height:48px;
  }
  .detail{
    padding:0 5px;
  }
  .content-row{
    padding:5px 0;
  }
  .title{
    display: flex;
    justify-content: space-between;
    padding: 0;
  }
  .title .name{
    color: #005db6;
  }
  .title .action a{
    color: #71777c;
  }
  .meta{
    color: #71777c;

  }
  .introduce p{
    text-overflow: ellipsis;
    overflow: hidden;
    height:42px;
    color: #444;
    line-height:1.5;
    text-align: left;
    margin: 0;
  }
</style>
