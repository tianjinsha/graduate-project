<template>
  <div class="content-box live-item">
    <!---->
    <div class="title-row">
      <div class="title-face-box">
        <img src="../../assets/img/author.jpg" alt="">
      </div>
      <div class="title-content-box">
        <div class="user">Choerodon猪齿鱼</div>
        <div class="info"><span class="community">社区名</span><span class="time">3小时前</span></div>
      </div>
      <div class="title-more-box">
        <el-dropdown trigger="click" placement="bottom">
          <span class="el-dropdown-link">
            ...
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item><i class="fa fa-hand-paper-o"></i>&nbsp;举报</el-dropdown-item>
            <el-dropdown-item><i class="fa fa-thumbs-o-up"></i>&nbsp;顶</el-dropdown-item>
            <el-dropdown-item><i class="fa fa-thumbs-o-down"></i>&nbsp;踩</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </div>
    <!---->
    <div class="info-row">
      有人说，男人难，要在外打拼，养家糊口。

      其实女人更难，留守女人难上加难。

      社会的现实，生活的压力，使不少女人成了一个新的群体——留守女人。
    </div>
    <!---->
    <div class="action-row">
      <ul class="action-list">
        <li class="action-item comment"><a title="评论"><i class="fa fa-commenting"></i>&nbsp;留言</a></li>
        <li class="action-item collect"><a title="收藏"><i class="fa fa-leaf"></i>&nbsp;收藏</a></li>
        <li class="action-item share"><a title="分享"><i class="fa fa-share-alt"></i>&nbsp;分享</a></li>
      </ul>
    </div>
  </div>
</template>

<script>
  export default {
    name: "live-item"
  }
</script>

<style scoped>
  /*内容列表*/
  .content-box {
    background: rgb(255,255,255);
  }

  .title-row {
    display: flex;
    align-items: center;
    padding: 15px 20px;
  }

  .title-face-box {
    width: 45px;
    height: 45px;
    border-radius: 50%;
  }

  .title-face-box img {
    width: 100%;
    height: 100%;
    border-radius: 50%;
  }

  .title-content-box {
    margin-left: 15px;
    flex: 1 0 auto;
  }

  .title-content-box .user {
    color: #333;
    font-weight: bold;
  }

  .title-content-box .info {
    color: #8a9aa9;
  }

  .title-content-box .info span {
    margin-right: 5px;
  }
  .el-dropdown-link{
    color:#8a9aa9;
    font-weight: bold;
    font-size:20px;
    cursor: pointer;
  }

  /**/
  .info-row {
    padding: 15px 20px;
  }
  /**/
  .action-list{
    display:flex;
    justify-content: space-between;
    align-items: center;
  }
  .action-list .action-item{
    display: block;
    width:100%;
    height:100%;
    text-align: center;
    border:1px solid #eee;
    box-sizing: border-box;
    border-left:none;
    padding:10px 0;
  }
  .action-list .action-item:last-child{
    border-right:none;
  }
</style>
