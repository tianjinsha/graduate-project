<template>
  <!--内容-->
  <div class="content-box new-item">
    <!---->
    <div class="info-box">
      <div class="info-row title-row">区块链汽车生态圈MVL于韩国交通研究院研讨会分享事例”</div>
      <div class="info-row meta-row">
        <span class="category">韩国/快讯</span>
        <span><strong>359</strong>次阅读</span>
        <span><time>2天前</time></span>
      </div>
      <div class="info-row summary-row">
        区块链汽车生态圈MVL于韩国交通研究院研讨会分享事例,区块链汽车生态圈MVL于韩国交通研究院研讨会分享事例区块链汽车生态圈MVL于韩国交通研究院研讨会分享事例区块链汽车生态圈MVL于韩国交通研究院研讨会分享事例
      </div>
      <div class="info-row action-row">
        <ul class="action-list">
          <li class="action-item like"><a title="喜欢"><i class="fa fa-heart"></i><span class="count">34</span></a></li>
          <li class="action-item comment"><a title="评论"><i class="fa fa-commenting"></i></a></li>

          <li class="action-item share"><a title="分享"><i class="fa fa-share-alt"></i></a></li>
          <li class="action-item collect"><a title="收藏"><i class="fa fa-leaf"></i></a></li>
        </ul>
      </div>
    </div>
    <!--图片-->
    <div class="thumb"><img src="../../assets/img/news-list1.jpg" alt=""></div>
  </div>
</template>

<script>
  export default {
    name: "news-item"
  }
</script>

<style scoped>
  /*内容列表*/
  .content-box {
    display: flex;
    align-items: center;
    justify-content: space-between;
    border-bottom: 1px solid #eee;
    padding: 15px;
    background: white;
  }

  .info-box {
    flex: 1 1 auto;
    justify-content: center;
    padding: 0 10px;
    min-height: 120px;
  }

  .info-row {
    margin: 10px 0;
  }

  .title-row {
    /*单行显示*/
    font-size: 16px;
    font-weight: bold;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }

  .meta-row {
    color: #90979c;
    font-size: 12px;
  }

  .meta-row > span {
    padding: 0 5px;
  }

  .summary-row {
    /*限制行数*/
    text-overflow: ellipsis;
    overflow: hidden;
    height:42px;
    color: #686e73;
    line-height:1.5;
  }

  .action-row .action-list {
    display: inline-flex;
    white-space: nowrap;
  }

  .action-list > .action-item {
    border-radius: 1px;
    border: 1px solid #edeeef;
    color: #b2bac2;
    height: 24px;
    display: flex;
    align-items: center;
    -webkit-box-pack: center;
    -moz-box-pack: center;
    padding: 0 10px;
  }

  .action-list > .action-item i {
    margin-right: 5px;
  }

  .action-list .share {
    margin-left: 15px;
  }

  .action-list > .action-item:nth-of-type(odd) {
    border-right: 0;
  }

  .thumb {
    /*align-self: flex-start;*/
  }

  .thumb img {
    display: block;
    height: 100px;
  }
</style>
