<#import "/util/page.ftl" as cast/>
<!DOCTYPE html>
<html>

<head>
    <title>会员管理-齐行社1.0.0</title>
    <#include "../common/head.ftl">
    <script type="text/javascript" src="/js/user.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
</head>

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">会员管理</a>
        <a>
          <cite>会员删除</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so">
            <input class="layui-input" placeholder="开始日" name="fDate" id="start" value="${fDate}" readonly>
            <input class="layui-input" placeholder="截止日" name="tDate" id="end" value="${tDate}" readonly>
            <input type="text" name="nickname" placeholder="请输入用户名" autocomplete="off" class="layui-input"
                   value="${nickname}">
            <button class="layui-btn" lay-filter="search" lay-submit><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="recoverAll()"><i class="layui-icon"></i>批量恢复</button>
        <span class="x-right" style="line-height:40px">共有数据：<span id="dataCount">${usersDel.total}</span> 条</span>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i
                        class="layui-icon">&#xe605;</i></div>
            </th>
            <th>ID</th>
            <th>账号</th>
            <th>手机</th>
            <th>邮箱</th>
            <th>类型</th>
            <th>修改时间</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <#list usersDel.records as user>
        <tr>
            <td>
                <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='${user.id}'><i
                        class="layui-icon">&#xe605;</i></div>
            </td>
            <td>${user.id}</td>
            <td>${user.nickname}</td>
            <td>${user.phoneNum}</td>
            <td>${user.email}</td>
            <td>普通会员</td>
            <td>${user.updateTime?string('yyyy-MM-dd hh:mm')}</td>
            <td class="td-status">
              <span class="layui-btn layui-btn-danger layui-btn-mini">
                                已删除
                            </span>
            <td class="td-manage">
                <a title="恢复" onclick="member_recover(this,${user.id})" href="javascript:;">
                    <i class="layui-icon">&#xe618;</i>
                </a>
                <a title="删除" onclick="member_del(this,${user.id})" href="javascript:;">
                    <i class="layui-icon">&#xe640;</i>
                </a>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>
     <@cast.page current=usersDel.current total=usersDel.total pages=usersDel.pages showPages=2 url=url/>

</div>

</body>

</html>