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
          <a href="">IT管理</a>
        <a>
          <cite>IT列表</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so form-search">
            <input class="layui-input" placeholder="开始日" name="fDate" id="start" value="${fDate}" readonly>
            <input class="layui-input" placeholder="截止日" name="tDate" id="end" value="${tDate}" readonly>
            <input type="text" name="title" placeholder="请输入标题" autocomplete="off" class="layui-input" value="${title}">
            <div class="layui-input-inline">
                <select name="category" lay-verify="" class="form-inline">
                    <option value="">请选择新闻分类</option>
                    <#list itCategory as c>
                    <option value="${c.id}" <#if c.id?string==category>selected</#if>>${c.cname}</option>
                    </#list>
                </select>
            </div>
            <div class="layui-input-inline">
                <select name="status" lay-verify="" class="form-inline">
                    <option value="">请选择文章状态</option>
                    <option value="0" <#if status=='0'>selected</#if>>已停用</option>
                    <option value="1" <#if status=='1'>selected</#if>>已启用</option>
                </select>
            </div>
            <button class="layui-btn" lay-submit="" lay-filter="search"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="it_deleteAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加','/it/add')"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px">共有数据：<span id="dataCount">${itList.total}</span> 条</span>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i
                        class="layui-icon">&#xe605;</i></div>
            </th>
            <th>ID</th>
            <th>分类</th>
            <th>标题</th>
            <th>作者</th>
            <th>创建时间</th>
            <th>阅读数</th>
            <th>用户</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <#list itList.records as it>
        <tr>
            <td>
                <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='${it.id}'><i
                        class="layui-icon">&#xe605;</i></div>
            </td>
            <td>${it.id}</td>
            <td>${it.itCategory.cname}</td>
            <td>${it.title}</td>
            <td>${it.author}</td>
            <td>${it.createTime?string('yyyy-MM-dd hh:mm')}</td>
            <td>${it.readingCount}</td>
            <td>${it.user.nickname}</td>
        <td class="td-status">
               <#if it.status='1'>
                   <span class="layui-btn layui-btn-normal layui-btn-mini">已启用</span></td>
               <#elseif it.status='0'>
                <span class="layui-btn layui-btn-normal layui-btn-mini layui-btn-disabled">已停用</span>
               </#if>
            </td>
            <td class="td-manage">
               <#if it.status='1'>
                <a onclick="it_status_change(this,${it.id})" href="javascript:;" title="停用">
                    <i class="layui-icon">&#xe601;</i>
                </a>
               <#elseif it.status='0'>
                    <a onclick="it_status_change(this,${it.id})" href="javascript:;" title="启用">
                        <i class="layui-icon">&#xe62f;</i>
                    </a>
               </#if>

                <a title="编辑" onclick="x_admin_show('编辑','/it/edit/'+${it.id})" href="javascript:;">
                    <i class="layui-icon">&#xe642;</i>
                </a>
                <a title="删除" onclick="it_delete(this,${it.id})" href="javascript:;">
                    <i class="layui-icon">&#xe640;</i>
                </a>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>
<@cast.page current=itList.current total=itList.total pages=itList.pages showPages=2 url=url/>

</div>
</body>
</html>