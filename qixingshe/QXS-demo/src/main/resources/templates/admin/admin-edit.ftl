<!DOCTYPE html>
<html>

<head>
    <title>管理员角色添加</title>
    <#include "../common/head.ftl">
    <script type="text/javascript" src="${base}/js/common.js"></script>
    <script type="text/javascript" src="${base}/js/manager.js"></script>
</head>

<body>
<div class="x-body">
    <form class="layui-form">
        <div class="layui-form-item">
            <label for="L_id" class="layui-form-label">
                <span class="x-red">*</span>ID
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_id" name="id" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${manager.id}" readonly>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="username" class="layui-form-label">
                <span class="x-red">*</span>账号
            </label>
            <div class="layui-input-inline">
                <input type="text" id="account" name="account" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${manager.account}" readonly>
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>将会成为您唯一的登入名
            </div>
        </div>
        <div class="layui-form-item">
            <label for="usernmae" class="layui-form-label">
                <span class="x-red">*</span>用户名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="username" name="username" required="" lay-verify="username"
                       autocomplete="off" class="layui-input" value="${manager.username}">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_email" class="layui-form-label">
                <span class="x-red">*</span>邮箱
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_email" name="email" required="" lay-verify="email"
                       autocomplete="off" class="layui-input" value="${manager.email}">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">角色</label>
            <div class="layui-input-inline">
                <select name="authorityId" lay-verify="" lay-search>
                    <option value="">请选择管理员角色</option>
                    <option value="1">超级管理员</option>
                    <option value="2">后台管理员</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label">
            </label>
            <button class="layui-btn" lay-filter="manager-edit" lay-submit="">
                修改
            </button>
        </div>
    </form>
</div>
</body>

</html>