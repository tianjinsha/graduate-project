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
            <label for="L_id" class="layui-form-label">
                <span class="x-red">*</span>ID
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_id" name="id" required=""
                       autocomplete="off" class="layui-input" value="${awareType.id}" readonly>
            </div>

        </div>
        <div class="layui-form-item">
            <label for="L_name" class="layui-form-label">
                <span class="x-red">*</span>名称
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_name" name="cname" required="" lay-verify="Category_name"
                       autocomplete="off" class="layui-input" value="${awareType.cname}">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>必填
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_sort" class="layui-form-label">
                <span class="x-red">*</span>排序
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_sort" name="sort" required="" lay-verify="newsCategory_sort"
                       value="${awareType.sort}" }
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>必填
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_description" class="layui-form-label">
                <span class="x-red">*</span>描述
            </label>
            <div class="layui-input-block">
                 <textarea name="description" placeholder="请输入内容" id="L_description" lay-verify="Category_description"
                           class="layui-textarea">${awareType.description}</textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
            </label>
            <button class="layui-btn" lay-filter="awareType_edit" lay-submit>
                修改
            </button>
        </div>
    </form>
</div>

</body>

</html>