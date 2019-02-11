layui.use(['form', 'layer', 'laydate'], function () {
    $ = layui.jquery;
    var laydate = layui.laydate,
        form = layui.form,
        layer = layui.layer;

    //执行一个laydate实例
    laydate.render({
        elem: '#start' //指定元素
    });

    //执行一个laydate实例
    laydate.render({
        elem: '#end' //指定元素
    });

    //自定义验证规则
    // form.verify({
    //     accout: function (value) {
    //         if (value.length < 2) {
    //             return '账号至少得2个字符啊';
    //         }
    //     }
    //     , password: [/(.+){6,12}$/, '密码必须6到12位']
    //     , repass: function (value) {
    //         if ($('#L_password').val() != $('#L_repass').val()) {
    //             return '两次密码不一致';
    //         }
    //     }
    // });

    //监听提交
    form.on('submit(manager-add)', function (data) {
        //发异步，把数据提交给server
        var postData = data.field;
        delete postData.repass;
        if (postData.status == 'on') {
            postData.status = '1';
        } else {
            postData.status = '0';
        }
        console.log(postData);
        form_submit({
            formType: 'POST',
            title: '添加',
            url: "/manager/add"

        }, postData);
        return false;
    });
    //监听提交
    form.on('submit(manager-edit)', function (data) {
        //发异步，把数据提交给server
        var postData = data.field;
        delete postData.repass;
        if (postData.status == 'on') {
            postData.status = '1';
        } else {
            postData.status = '0';
        }
        console.log(postData);
        form_submit({
            formType: 'PUT',
            title: '修改',
            url: "/manager/edit"

        }, postData);
        return false;
    });

    //监听提交
    form.on('submit(managerRole-add)', function (data) {
        console.log(data);
        //发异步，把数据提交给server
        var postData = data.field;
        delete postData.repass;
        if (postData.status == 'on') {
            postData.status = '1';
        } else {
            postData.status = '0';
        }
        form_submit({
            formType: 'POST',
            title: '添加',
            url: "/managerRole/add"

        }, postData);

    });
    //监听提交
    form.on('submit(managerRole-add)', function (data) {
        console.log(data);
        //发异步，把数据提交给server
        var postData = data.field;
        delete postData.repass;
        if (postData.status == 'on') {
            postData.status = '1';
        } else {
            postData.status = '0';
        }
        form_submit({
            formType: 'PUT',
            title: '修改',
            url: "/managerRole/edit"

        }, postData);

    });
});


/*管理员-删除*/
function manager_del(obj, id) {
    console.log("管理员删除")
    deleteRow(obj, {
        'title': '删除',
        'formType': 'DELETE',
        'url': 'http://localhost:8081/manager/delete/' + id,
        'timeout': 5000,
    })
}

/**
 * 管理员状态改变：启用1，停用0
 * @param obj
 * @param id
 */
function manager_status_change(obj, id) {
    /*用户-启用-1*/
    if ($(obj).attr('title') == '启用') {
        console.log("启用：" + id);
        changeStatus(obj, {
            'title': '启用',
            'callback': '停用',
            'formType': 'PUT',
            'url': 'http://localhost:8081/manager/enable/' + id,
            'timeout': 5000,
            'icon': '&#xe601;'
        })
        /*管理员-停用-0*/
    } else if ($(obj).attr('title') == '停用') {
        console.log("停用：：" + id);
        changeStatus(obj, {
            'title': '停用',
            'callback': '启用',
            'formType': 'PUT',
            'url': 'http://localhost:8081/manager/disable/' + id,
            'timeout': 5000,
            'icon': '&#xe62f;'
        })
    }
}

/**
 * 批量禁用失效0
 * @param
 */
function disableAll() {
    var data = tableCheck.getData();
    deleteRowAll(data, {
        'title': '删除',
        'formType': 'PUT',
        'url': 'http://localhost:8081/user/batchDisable',
        'timeout': 5000,
    })
}


/**
 * **************************************************************************************************************************************
 *
 */

/**
 * 管理员状态改变：启用1，停用0
 * @param obj
 * @param id
 */
function managerRole_status_change(obj, id) {

    /*角色-启用-1*/
    if ($(obj).attr('title') == '启用') {
        console.log("启用：" + id);
        changeStatus(obj, {
            'title': '启用',
            'callback': '停用',
            'formType': 'PUT',
            'url': 'http://localhost:8081/managerRole/enable/' + id,
            'timeout': 5000,
            'icon': '&#xe601;'
        })
        /*角色-停用-0*/
    } else if ($(obj).attr('title') == '停用') {
        console.log("停用：：" + id);
        changeStatus(obj, {
            'title': '停用',
            'callback': '启用',
            'formType': 'PUT',
            'url': 'http://localhost:8081/managerRole/disable/' + id,
            'timeout': 5000,
            'icon': '&#xe62f;'
        })
    }
}

/*管理员角色-删除*/
function role_del(obj, id) {
    console.log("角色删除")
    deleteRow(obj, {
        'title': '删除',
        'formType': 'DELETE',
        'url': 'http://localhost:8081/managerRole/delete/' + id,
        'timeout': 5000,
    })
}

