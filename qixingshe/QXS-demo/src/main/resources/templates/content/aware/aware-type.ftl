<#assign base=request.contextPath />
<#import "${base}/util/page.ftl" as cast/>
<!DOCTYPE html>
<html>
<head>
    <title>会员管理-齐行社1.0.0</title>
   <#include "${base}/common/head.ftl">
    <script type="text/javascript" src="${base}/js/common.js"></script>
    <script type="text/javascript" src="${base}/js/content.js"></script>
</head>

<body class="layui-anim layui-anim-up">
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">内容管理</a>
          <a href="">知问管理</a>
        <a>
          <cite>栏目管理</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so form-search">
            <input type="text" name="cname" placeholder="请输入名称" autocomplete="off" class="layui-input" value="${cname}">
            <button class="layui-btn" lay-submit="" lay-filter="search"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="awareType_deleteAll()"><i class="layui-icon"></i>批量删除
        </button>
        <button class="layui-btn" onclick="x_admin_show('添加','/awareType/add',600,400)"><i class="layui-icon"></i>添加
        </button>
        <span class="x-right" style="line-height:40px">共有数据：<span
                id="dataCount">${awareTypeList.total}</span> 条</span>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i
                        class="layui-icon">&#xe605;</i></div>
            </th>
            <th>ID</th>
            <th>标题</th>
            <th>描述</th>
            <th>排序</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <#list awareTypeList.records as awareType>
        <tr>
            <td>
                <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='${awareType.id}'><i
                        class="layui-icon">&#xe605;</i></div>
            </td>
            <td>${awareType.id}</td>
            <td>${awareType.cname}</td>
            <td>${awareType.description}</td>
            <td>${awareType.sort}</td>

            <td class="td-manage">
                <a title="编辑" onclick="x_admin_show('编辑','/awareType/edit/'+${awareType.id},600,400)"
                   href="javascript:;">
                    <i class="layui-icon">&#xe642;</i>
                </a>
                <a title="删除" onclick="awareType_delete(this,${awareType.id})" href="javascript:;">
                    <i class="layui-icon">&#xe640;</i>
                </a>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>
<@cast.page current=awareTypeList.current total=awareTypeList.total pages=awareTypeList.pages showPages=2 url=url/>

</div>
</body>
</html>