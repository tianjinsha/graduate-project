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
                <span class="x-red">*</span>ID
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_id" name="id" required="" readonly value="${live.id}"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_title" class="layui-form-label">
                <span class="x-red">*</span>标题
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_title" name="title" required="" lay-verify="it_title"
                       autocomplete="off" class="layui-input" value="${live.title}">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>必填
            </div>
        </div>

        <div class="layui-form-item">
            <label for="L_topic" class="layui-form-label">
                <span class="x-red">*</span>话题
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_topic" name="topicId" required="" value="${live.topicId}"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>必填
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_description" class="layui-form-label">
                <span class="x-red">*</span>内容
            </label>
            <div class="layui-input-block">
                 <textarea name="content" placeholder="请输入内容" id="L_content" lay-verify="live_content"
                           class="layui-textarea">${live.content}</textarea>
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
            <button class="layui-btn" lay-filter="live_edit" lay-submit>
                修改
            </button>
        </div>
    </form>
</div>
<script>
    layui.use('layedit', function () {
        var layedit = layui.layedit;
        var it_content = layedit.build('L_content'); //建立编辑器
    });
</script>

</body>

</html>