<#assign base=request.contextPath />
<#import "${base}/util/page.ftl" as cast/>
<!DOCTYPE html>
<html>
<head>
    <title>会员管理-齐行社1.0.0</title>
   <#include "${base}/common/head.ftl">
    <script type="text/javascript" src="${base}/js/user.js"></script>
    <script type="text/javascript" src="${base}/js/common.js"></script>
</head>

<body class="layui-anim layui-anim-up">
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">会员管理</a>
        <a>
          <cite>会员列表</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so form-search" method="get">
            <input class="layui-input" placeholder="开始日" name="fDate" id="start" value="${fDate}" readonly>
            <input class="layui-input" placeholder="截止日" name="tDate" id="end" value="${tDate}" readonly >
            <input type="text" name="nickname" placeholder="请输入用户名" autocomplete="off" class="layui-input" value="${nickname}">
            <div class="layui-input-inline">
            <select name="status" lay-verify="" class="form-inline">
                <option value="">请选择用户状态</option>
                <option value="2" <#if status=='2'>selected</#if>>已停用</option>
                <option value="1" <#if status=='1'>selected</#if>>已启用</option>
            </select>
            </div>
            <button class="layui-btn"  lay-filter="search" lay-submit><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="disableAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加用户','/user/add',600,400)"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px" >共有数据：<span id="dataCount">${users.total}</span> 条</span>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>ID</th>
            <th>账号</th>
            <th>手机</th>
            <th>邮箱</th>
            <td>类型</td>
            <th>创建时间</th>
            <th>状态</th>
            <th>操作</th></tr>
        </thead>
        <tbody>
        <#list users.records as user>
        <tr>
            <td>
                <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='${user.id}'><i class="layui-icon">&#xe605;</i></div>
            </td>
            <td>${user.id}</td>
            <td>${user.nickname}</td>
            <td>${user.phoneNum}</td>
            <td>${user.email}</td>
            <td>普通会员</td>
            <td>${user.createTime?string('yyyy-MM-dd hh:mm')}</td>
            <td class="td-status">
                <#if user.status='1'>
                <span class="layui-btn layui-btn-normal layui-btn-mini">已启用</span></td>
                <#elseif user.status='2'>
                <span class="layui-btn layui-btn-normal layui-btn-mini layui-btn-disabled">已停用</span>
                </#if>
            </td>
            <td class="td-manage">
                <#if user.status='1'>
                <a onclick="member_status_change(this,${user.id})" href="javascript:;"  title="停用">
                    <i class="layui-icon">&#xe601;</i>
                </a>
                <#elseif user.status='2'>
                    <a onclick="member_status_change(this,${user.id})" href="javascript:;"  title="启用">
                        <i class="layui-icon">&#xe62f;</i>
                    </a>
                </#if>

                <a title="编辑"  onclick="x_admin_show('编辑','/userinfo/info/'+${user.id},600,400)" href="javascript:;">
                    <i class="layui-icon">&#xe642;</i>
                </a>
                <a onclick="x_admin_show('修改密码','/user/userPass/'+${user.id},600,400)" title="修改密码" href="javascript:;">
                    <i class="layui-icon">&#xe631;</i>
                </a>
                <a title="删除" onclick="member_disable(this,${user.id})" href="javascript:;">
                    <i class="layui-icon">&#xe640;</i>
                </a>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>
<@cast.page current=users.current total=users.total pages=users.pages showPages=2 url=url/>

</div>
</body>
</html>