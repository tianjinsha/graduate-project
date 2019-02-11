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
          <a href="">新闻管理</a>
        <a>
          <cite>新闻标签列表</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so form-search">
            <input type="text" name="tname" placeholder="请输入名称" autocomplete="off" class="layui-input" value="${tname}">
            <div class="layui-input-inline">
                <select name="category" lay-verify="" class="form-inline">
                    <option value="">请选择新闻分类</option>
                    <#list newsCategory as c>
                    <option value="${c.id}" <#if c.id?string==category>selected</#if>>${c.cname}</option>
                    </#list>
                </select>
            </div>
            <button class="layui-btn" lay-submit="" lay-filter="search"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="newsTags_deleteAll()"><i class="layui-icon"></i>批量删除
        </button>
        <button class="layui-btn" onclick="x_admin_show('添加','/newsTags/add',600,400)"><i class="layui-icon"></i>添加
        </button>
        <span class="x-right" style="line-height:40px">共有数据：<span id="dataCount">${newsTagsList.total}</span> 条</span>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i
                        class="layui-icon">&#xe605;</i></div>
            </th>
            <th>ID</th>
            <th>名称</th>
            <th>描述</th>
            <th>创建时间</th>
            <td>分类</td>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <#list newsTagsList.records as newsTags>
        <tr>
            <td>
                <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='${newsTags.id}'><i
                        class="layui-icon">&#xe605;</i></div>
            </td>
            <td>${newsTags.id}</td>
            <td>${newsTags.tname}</td>
            <td>${newsTags.description}</td>
            <td>${newsTags.createTime?string('yyyy-MM-dd hh:mm')}</td>
            <td>${newsTags.newsCategory.cname}</td>
            <td class="td-manage">
                <a title="编辑" onclick="x_admin_show('编辑','/newsTags/edit/'+${newsTags.id},600,400)" href="javascript:;">
                    <i class="layui-icon">&#xe642;</i>
                </a>
                <a title="删除" onclick="newsTags_delete(this,${newsTags.id})" href="javascript:;">
                    <i class="layui-icon">&#xe640;</i>
                </a>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>
<@cast.page current=newsTagsList.current total=newsTagsList.total pages=newsTagsList.pages showPages=2 url=url/>

</div>
</body>
</html>