<template>
  <div class="member-list main-container">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>会员管理</el-breadcrumb-item>
      <el-breadcrumb-item>会员列表</el-breadcrumb-item>
    </el-breadcrumb>

    <div class="member-container content-wrap">
      <div class="search-wrap">
        <div class="search-item">
          <el-date-picker
            v-model="fdate"
            type="date"
            placeholder="开始日期">
          </el-date-picker>
        </div>
        <div class="search-item">
          <el-input
            placeholder="请输入卡号"
            v-model="account"
            clearable>
          </el-input>
        </div>
        <div class="search-item">
          <el-input
            placeholder="请输入用户名"
            v-model="username" clearable>
          </el-input>
        </div>
        <div class="search-item">
          <el-button type="primary" icon="el-icon-search" size="small">搜索</el-button>
        </div>


      </div>
      <ul class="member-wrap  content-wrap">
        <template v-for="item in MemberData.records">
        <li class="member-wrap-item" @click="memberEdit($event)">
          <div class="number"><span>{{item.id}}</span></div>
          <img class="member-img" src="../../assets/img/member1.jpg">
          <div class="msg">
            <div class="msg-item"><span>姓名：</span>{{item.username}}</div>
            <div class="msg-item"><span>性别：</span>{{item.sex}}</div>
            <div class="msg-item"><span>年龄：</span>{{item.age}}</div>
            <div class="msg-item"><span>卡号：</span>232425</div>
            <div class="msg-item"><span>热度：</span>{{item.hot}}</div>
          </div>
          <div class="edit" v-bind:style="{display: displayActive}">
            <el-button-group>
              <el-button type="primary" icon="el-icon-edit"></el-button>
              <el-button type="primary" icon="el-icon-delete"></el-button>
            </el-button-group>
          </div>
        </li>
        </template>
      </ul>
      <div class="page">
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page=MemberData.current
          :page-sizes="[10, 20, 30, 40]"
          :page-size=MemberData.size
          layout="total, sizes, prev, pager, next, jumper"
          :total=MemberData.total>
        </el-pagination>
      </div>
    </div>
  </div>

</template>

<script>
  import LeftNav from '../../components/common/left-nav'

  $(function () {
    $(".member-wrap-item").on("mouseenter", function () {
      $(this).find(".edit").css("display", "flex");
    });
    $(".member-wrap-item").on("mouseleave", function () {
      $(this).find(".edit").css("display", "none");
    });
  });
  export default {
    name: "member-list",
    components: {
      LeftNav
    },
    data() {
      return {
        displayActive: 'none',
        account: '',
        username: '',
        fdate:'',
        MemberData: {
          current:1,
          pages:0,
          records:{},
          size:10,
          total:0
        }
      }
    },
    methods: {
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
      }
    },
    created:function () {
      this.$fetch("/member/list").then((response)=>{
        console.log(response);
        this.MemberData=response;
      })
    }
  }
</script>

<style scoped>
  /**
  搜索
  */
  .search-wrap {
    display: flex;
    align-items: center;
  }

  .search-item {
    margin-left: 10px;
  }

  .member-wrap {
    display: flex;
    flex-wrap: wrap;
    align-content: center;
    justify-content: flex-start;
  }

  .member-img {
    width: 120px;
    height: 120px;
    display: block;
    border-radius: 4px;
  }

  .member-wrap-item {
    position: relative;
    margin: 15px 20px 15px 0;
    display: flex;
    background: rgba(37, 100, 29, 0.3);
    width: 280px;
    border-radius: 4px;
    color: #444;
    height: 160px;
    justify-content: center;
    cursor: pointer;
    align-items: center;

  }

  /**
  编号
   */
  .number {
    position: absolute;
    top: 5px;
    left: 5px;
    background: linear-gradient(left, #8590fb, #4cc2d7);
    width: 60px;
    height: 30px;
    text-align: center;
    line-height: 30px;
    border-radius: 4px;
    color: #eee;
  }

  .edit {
    background: rgba(50, 50, 50, .5);
    width: 100%;
    position: absolute;
    bottom: 0;
    left: 0;
    display: none;
    align-items: center;
    justify-content: center;
    height: 50%;
    box-sizing: border-box;
    border-radius: 0 0 4px 4px;
  }

  .msg {
    padding: 10px 10px;
  }

  .msg-item {
    padding: 4px 0;
  }
</style>
