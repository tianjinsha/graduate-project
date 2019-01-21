<#assign base=request.contextPath />
<!DOCTYPE html>
<html>

<head>
    <title>齐行社1.0.0-角色修改</title>
    <title>欢迎页面-X-admin2.0</title>
    <#include "${base}/common/head.ftl">
    <script type="text/javascript" src="${base}/js/user.js"></script>
    <script type="text/javascript" src="${base}/js/role.js"></script>
</head>

<body>
<div class="x-body layui-anim layui-anim-up">
    <form class="layui-form">
        <div class="layui-form-item">
            <label for="L_name" class="layui-form-label">
                <span class="x-red">*</span>名称
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_name" name="name" required="" lay-verify="role_name"
                       autocomplete="off" class="layui-input" value="">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_description" class="layui-form-label">
                <span class="x-red">*</span>描述
            </label>
            <div class="layui-input-block">
                 <textarea name="description" placeholder="请输入内容" id="L_description" lay-verify="role_description"
                           class="layui-textarea"></textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label">
            </label>
            <button class="layui-btn" lay-filter="role_add" lay-submit="">
                添加
            </button>
        </div>
    </form>
</div>
</body>

</html>