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
          <cite>问题管理</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so form-search">
            <input class="layui-input" placeholder="开始日" name="fDate" id="start" value="${fDate}" readonly>
            <input class="layui-input" placeholder="截止日" name="tDate" id="end" value="${tDate}" readonly >
            <input type="text" name="title" placeholder="请输入标题" autocomplete="off" class="layui-input" value="${title}">
           <div class="layui-input-inline">
                <select name="status" lay-verify="" class="form-inline">
                    <option value="">请选择文章状态</option>
                    <option value="0" <#if status=='0'>selected</#if>>已停用</option>
                    <option value="1" <#if status=='1'>selected</#if>>已启用</option>
                </select>
            </div>
            <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="aware_deleteAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加用户','/user/add',600,600)"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px" >共有数据：<span id="dataCount">${awareList.total}</span> 条</span>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>ID</th>
            <th>标题</th>
            <th>图片</th>
            <th>关注数</th>
            <th>标签</th>
            <th>回答数</th>
            <th>创建时间</th>
            <th>用户id</th>
            <th>状态</th>
            <th>操作</th></tr>
        </thead>
        <tbody>
        <#list awareList.records as aware>
        <tr>
            <td>
                <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='${aware.id}'><i class="layui-icon">&#xe605;</i></div>
            </td>
            <td>${aware.id}</td>
            <td>${aware.title}</td>
            <td>${(aware.thumb)!''}</td>
            <td>${(aware.attentionCount)!''}</td>
            <td>${aware.tags}</td>
            <td>${(aware.answerCount)!''}</td>
            <td>${aware.createTime?string('yyyy-MM-dd hh:mm')}</td>
            <td>${aware.userId}</td>
        <td class="td-status">
               <#if aware.status='1'>
                    <span class="layui-btn layui-btn-normal layui-btn-mini">已启用</span></td>
                <#elseif aware.status='0'>
                <span class="layui-btn layui-btn-normal layui-btn-mini layui-btn-disabled">已停用</span>
                </#if>
            </td>
            <td class="td-manage">
               <#if aware.status='1'>
                <a onclick="aware_status_change(this,${aware.id})" href="javascript:;"  title="停用">
                    <i class="layui-icon">&#xe601;</i>
                </a>
                <#elseif aware.status='0'>
                    <a onclick="aware_status_change(this,${aware.id})" href="javascript:;"  title="启用">
                        <i class="layui-icon">&#xe62f;</i>
                    </a>
                </#if>

                <a title="编辑"  onclick="x_admin_show('编辑','/aware/edit/'+${aware.id},600,600)" href="javascript:;">
                    <i class="layui-icon">&#xe642;</i>
                </a>
                <a title="删除" onclick="aware_delete(this,${aware.id})" href="javascript:;">
                    <i class="layui-icon">&#xe640;</i>
                </a>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>
<@cast.page current=awareList.current total=awareList.total pages=awareList.pages showPages=2 url=url/>

</div>
</body>
</html>