<#assign base=request.contextPath />
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <link rel="stylesheet" href="${base}/css/common.css">
   <#include "../common/head.ftl">
</head>

<body>
<div class="x-body">
    <form class="layui-form qxs-md-form">
        <div class="layui-form-item">
            <label for="L_id" class="layui-form-label qxs-input-label">
                <span class="x-red">*</span>ID
            </label>
            <div class="layui-input-inline ">
                <input type="text" id="L_id" name="id" required="" lay-verify="" value="${userinfo.id}"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_username" class="layui-form-label qxs-input-label"> 姓名 </label>
            <div class="layui-input-inline">
                <input type="text" id="L_username" name="username" required="" lay-verify="nikename"
                       autocomplete="off" class="layui-input" value="${userinfo.username}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_sex" class="layui-form-label qxs-input-label">
                性别
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_sex" name="pass" required="" lay-verify="pass"
                       autocomplete="off" class="layui-input" value="${userinfo.sex}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_birthday" class="layui-form-label qxs-input-label">
                生日
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_birthday" name="birthday" required="" lay-verify="repass"
                       autocomplete="off" class="layui-input" value="${userinfo.birthday?string('yyyy-MM-dd hh:mm')}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_createTime" class="layui-form-label qxs-input-label">创建时间 </label>
            <div class="layui-input-inline">
                <input type="text" id="L_createTime" name="birthday" required="" lay-verify="repass"
                       autocomplete="off" class="layui-input" value="${userinfo.createTime?string('yyyy-MM-dd hh:mm')}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_lastTime" class="layui-form-label qxs-input-label"> 上次登录时间 </label>
            <div class="layui-input-inline">
                <input type="text" id="L_lastTime" name="birthday" required="" lay-verify="repass"
                       autocomplete="off" class="layui-input" value="${userinfo.lastTime?string('yyyy-MM-dd hh:mm')}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_introduce" class="layui-form-label qxs-input-label">自我介绍</label>
            <div class="layui-input-block">
                    <textarea name="introduce" placeholder="请输入内容" id="L_introduce" class="layui-textarea"> ${userinfo.introduce}
                    </textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-filter="add" lay-submit="">
                    修改
                </button>
            </div>
        </div>
    </form>
</div>
<script>
    layui.use(['form', 'layer'], function () {
        $ = layui.jquery;
        var form = layui.form
                , layer = layui.layer;

        //自定义验证规则
        form.verify({
            nikename: function (value) {
                if (value.length < 5) {
                    return '昵称至少得5个字符啊';
                }
            }
            , pass: [/(.+){6,12}$/, '密码必须6到12位']
            , repass: function (value) {
                if ($('#L_pass').val() != $('#L_repass').val()) {
                    return '两次密码不一致';
                }
            }
        });

        //监听提交
        form.on('submit(add)', function (data) {
            console.log(data);
            //发异步，把数据提交给php
            layer.alert("增加成功", {icon: 6}, function () {
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
            });
            return false;
        });


    });
</script>

</body>

</html>