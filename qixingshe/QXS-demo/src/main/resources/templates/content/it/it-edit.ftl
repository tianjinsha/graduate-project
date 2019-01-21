<#assign base=request.contextPath />
<!DOCTYPE html>
<html>

<head>
    <title>会员管理-齐行社1.0.0</title>
        <#include "${base}/common/head.ftl">
    <script type="text/javascript" src="${base}/js/common.js"></script>
    <script type="text/javascript" src="${base}/js/content.js"></script>
</head>
</head>

<body>
<div class="x-body layui-anim layui-anim-up">
    <form class="layui-form">
        <div class="layui-form-item">
            <label for="L_title" class="layui-form-label">
                <span class="x-red">*</span>标题
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_title" name="title" required="" lay-verify="it_title"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>必填
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_author" class="layui-form-label">
                <span class="x-red">*</span>作者
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_author" name="author" required="" lay-verify="it_title"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>必填
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_name" class="layui-form-label">
                <span class="x-red">*</span>分类
            </label>
            <div class="layui-input-inline">
                <select name="itCategoryId" lay-verify="" class="form-inline">
                    <option value="">请选择it分类</option>
                    <#list itCategory as c>
                    <option value="${c.id}">${c.cname}</option>
                    </#list>
                </select>
            </div>
            <div class="layui-form-item">
                <label for="L_description" class="layui-form-label">
                    <span class="x-red">*</span>内容
                </label>
                <div class="layui-input-block">
                 <textarea name="content" placeholder="请输入内容" id="L_content" lay-verify="it_content"
                           class="layui-textarea"></textarea>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">状态</label>
                <div class="layui-input-block">
                    <input type="checkbox" name="status" lay-skin="switch" lay-text="启用|停用" checked>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">
                </label>
                <button class="layui-btn" lay-filter="it_add" lay-submit>
                    增加
                </button>
            </div>
    </form>
</div>
<script>
    layui.use('layedit', function () {
        var layedit = layui.layedit;
        var it_content=layedit.build('L_content'); //建立编辑器
    });
</script>

</body>

</html>