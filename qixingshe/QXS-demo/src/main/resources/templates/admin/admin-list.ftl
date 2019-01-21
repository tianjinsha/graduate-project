<#assign base=request.contextPath />
<#import "${base}/util/page.ftl" as cast/>
<!DOCTYPE html>
<html>

<head>
    <title>欢迎页面-X-admin2.0</title>
    <#include "../common/head.ftl">
    <script type="text/javascript" src="${base}/js/common.js"></script>
    <script type="text/javascript" src="${base}/js/manager.js"></script>
</head>

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">管理员管理</a>
        <a>
          <cite>管理员列表</cite></a>
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
            <input type="text" name="account" placeholder="请输入账号" autocomplete="off" class="layui-input"
                   value="${account}">
            <div class="layui-input-inline">
                <select name="status" lay-verify="" class="form-inline">
                    <option value="">请选择用户状态</option>
                    <option value="0" <#if status=='0'>selected</#if>>已停用</option>
                    <option value="1" <#if status=='1'>selected</#if>>已启用</option>
                </select>
            </div>
            <button class="layui-btn" lay-submit="" lay-filter="search"><i
                    class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量禁用</button>
        <button class="layui-btn" onclick="x_admin_show('添加管理员','/manager/add',600,600)"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px">共有数据：<span id="dataCount">${managers.total} </span>条</span>
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
            <th>用户名</th>
            <th>邮箱</th>
            <th>创建时间</th>
            <th>上次登录</th>
            <th>角色</th>
            <th>状态</th>
            <th>操作</th>
        </thead>
        <tbody>
        <#list managers.records as manager>
        <tr>
            <td>
                <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i>
                </div>
            </td>
            <td>${manager.id}</td>
            <td>${manager.account}</td>
            <td>${manager.username}</td>
            <td>${manager.email}</td>
            <td>${manager.createTime?string('yyyy-MM-dd hh:mm')}</td>
            <td><#if (manager.lastTime)??>${manager.lastTime?string('yyyy-MM-dd hh:mm')}</#if></td>
            <td>${manager.authorityId}</td>
            <td class="td-status">
              <#if manager.status='1'>
                  <span class="layui-btn layui-btn-normal layui-btn-mini">已启用</span>
              <#elseif manager.status='0'>
                <span class="layui-btn layui-btn-normal layui-btn-mini layui-btn-disabled">已停用</span>
              </#if>
            </td>
            <td class="td-manage">
               <#if manager.status='1'>
                <a onclick="manager_status_change(this,${manager.id})" href="javascript:;" title="停用">
                    <i class="layui-icon">&#xe601;</i>
                </a>
               <#elseif manager.status='0'>
                    <a onclick="manager_status_change(this,${manager.id})" href="javascript:;" title="启用">
                        <i class="layui-icon">&#xe62f;</i>
                    </a>
               </#if>
                <a title="编辑" onclick="x_admin_show('编辑','/manager/edit/${manager.id}',600,600)" href="javascript:;">
                    <i class="layui-icon">&#xe642;</i>
                </a>
                <a title="删除" onclick="manager_del(this,${manager.id})" href="javascript:;">
                    <i class="layui-icon">&#xe640;</i>
                </a>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>

     <@cast.page current=managers.current total=managers.total pages=managers.pages showPages=2 url=url/>

</div>
<script>
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });
</script>

</body>

</html>