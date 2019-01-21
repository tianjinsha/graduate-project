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
        <a href="">系统管理</a>
        <a>
          <cite>菜单管理</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>全部展开</button>
        <button class="layui-btn" onclick="x_admin_show('添加菜单','/menu/add',600,600)"><i class="layui-icon"></i>添加</button>
        <#--<span class="x-right" style="line-height:40px"></span>-->
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i
                        class="layui-icon">&#xe605;</i></div>
            </th>
            <th>父级节点</th>
            <th>ID</th>
            <th>标题</th>
            <th>图标</th>
            <th>权限标识</th>
            <th>资源路径</th>
            <th>请求方法</th>
            <th>类型</th>
            <th>排序</th>
            <th>状态</th>
            <th>操作</th>
        </thead>
        <tbody>
        <#list menuList as menu>
        <tr>
            <td>
                <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i>
                </div>
            </td>
            <td>${menu.parent}</td>
            <td>${menu.id}</td>
            <td>${menu.title}</td>
            <td><i class="iconfont">${menu.icon!}</i></td>
            <td>${menu.identity!}</td>
            <td>${menu.path!}</td>
            <td>${menu.method!}</td>
            <td><#if menu.type==1>菜单<#elseif menu.type==2>按钮</#if></td>
            <td>${menu.sort!}</td>
            <td class="td-status">
              <#if menu.status='1'>
                  <span class="layui-btn layui-btn-normal layui-btn-mini">已启用</span>
              <#elseif menu.status='0'>
                <span class="layui-btn layui-btn-normal layui-btn-mini layui-btn-disabled">已停用</span>
              </#if>
            </td>
            <td class="td-manage">
               <#if menu.status='1'>
                <a onclick="manager_status_change(this,${menu.id})" href="javascript:;" title="停用">
                    <i class="layui-icon">&#xe601;</i>
                </a>
               <#elseif menu.status='0'>
                    <a onclick="manager_status_change(this,${menu.id})" href="javascript:;" title="启用">
                        <i class="layui-icon">&#xe62f;</i>
                    </a>
               </#if>
                <a title="编辑" onclick="x_admin_show('编辑','/menu/edit/${menu.id}',600,600)" href="javascript:;">
                    <i class="layui-icon">&#xe642;</i>
                </a>
                <a title="删除" onclick="manager_del(this,${menu.id})" href="javascript:;">
                    <i class="layui-icon">&#xe640;</i>
                </a>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>

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