layui.use(['form', 'layer'], function () {
    $ = layui.jquery;
    var form = layui.form
        , layer = layui.layer;

    //自定义验证规则
    form.verify({
        role_name: function (value) {
            if (value.length < 2) {
                return '角色名称至少得2个字符';
            }else if (value.length>10){
                return '角色名称最多得10个字符';
            }
        },
        role_description: function (value) {
            if (value.length > 200) {
                return '角色名称最多得200个字符';
            }
        }
    });

    //监听提交
    form.on('submit(role_edit)', function (data) {
        $.ajax({
            type: 'PUT',
            contentType: "application/json",
            url: '/role/edit',
            data:JSON.stringify(data.field),
            success: function () {
                layer.alert("修改成功", {icon: 6}, function () {
                    // 获得frame索引
                    var index = parent.layer.getFrameIndex(window.name);
                    //关闭当前frame
                    parent.layer.close(index);
                });
            },
            error: function () {
                layer.alert("修改失败", {icon: 5})
            }
        });
        return false;
    });

    //监听提交
    form.on('submit(role_add)', function (data) {
        $.ajax({
            type: 'POST',
            contentType: "application/json",
            url: '/role/add',
            data:JSON.stringify(data.field),
            success: function () {
                layer.alert("添加成功", {icon: 6}, function () {
                    // 获得frame索引
                    var index = parent.layer.getFrameIndex(window.name);
                    //关闭当前frame
                    parent.layer.close(index);
                });
            },
            error: function () {
                layer.alert("添加失败", {icon: 5})
            }
        });
        return false;
    });

});