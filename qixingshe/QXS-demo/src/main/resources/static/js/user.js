$(document).ready(function () {
    layui.use(['form', 'layer', 'laydate'], function () {
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
        form.verify({
            nickname: function (value) {
                if (value.length < 2) {
                    return '昵称至少得2个字符啊';
                }
            }
            , password: [/(.+){6,12}$/, '密码必须6到12位']
            , repass: function (value) {
                if ($('#L_password').val() != $('#L_repass').val()) {
                    return '两次密码不一致';
                }
            }
        });

        //监听提交
        form.on('submit(member_add)', function (data) {
            //发异步，把数据提交给server
            var postData = data.field;
            delete postData.repass;
            if (postData.status == 'on') {
                postData.status = '1';
            } else {
                postData.status = '2';
            }

            form_submit({
                formType: 'POST',
                title: '添加',
                url: "/user/add"
            }, postData);
            return false;
        });
    });
});


/*用户-恢复*/

/*1成功，2叉叉，3问号，4锁，5 失败，6 成功*/
function member_recover(obj, id) {
    console.log("用户恢复")
    deleteRow(obj, {
        'title': '恢复',
        'formType': 'PUT',
        'url': 'http://localhost:8081/user/stop/' + id,
        'timeout': 5000,
    })
}

/*用户-删除-彻底删除*/
function member_del(obj, id) {
    console.log("用户彻底删除")
    deleteRow(obj, {
        'title': '删除',
        'formType': 'DELETE',
        'url': 'http://localhost:8081/user/del/' + id,
        'timeout': 5000,
    })
}

/**
 * 用户状态改变：启用1，停用2
 * @param obj
 * @param id
 */
function member_status_change(obj, id) {
    /*用户-启用-1*/
    if ($(obj).attr('title') == '启用') {
        changeStatus(obj, {
            'title': '启用',
            'callback': '停用',
            'formType': 'PUT',
            'url': 'http://localhost:8081/user/recover/' + id,
            'timeout': 5000,
            'icon': '&#xe601;'
        })
        /*用户-停用-2*/
    } else if ($(obj).attr('title') == '停用') {
        changeStatus(obj, {
            'title': '停用',
            'callback': '启用',
            'formType': 'PUT',
            'url': 'http://localhost:8081/user/stop/' + id,
            'timeout': 5000,
            'icon': '&#xe62f;'
        })
    }
}

/*用户-删除-失效 0*/
function member_disable(obj, id) {
    console.log("禁用用户")
    deleteRow(obj, {
        'title': '删除',
        'formType': 'PUT',
        'url': 'http://localhost:8081/user/disable/' + id,
        'timeout': 5000,
    })
}


/**
 * 批量删除-失效0
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
 * 批量恢复 2
 * @param
 */
function recoverAll() {
    var data = tableCheck.getData();
    deleteRowAll(data, {
        'title': '恢复',
        'formType': 'PUT',
        'url': 'http://localhost:8081/user/batchRecover',
        'timeout': 5000,
    })
}


/**
 * **************************************************************************************************************************************
 * role
 */

/*角色-删除-失效 0*/
function role_del(obj, id) {
    console.log("角色删除")
    deleteRow(obj, {
        'title': '删除',
        'formType': 'DELETE',
        'url': 'http://localhost:8081/role/delete/' + id,
        'timeout': 5000,
    })
}


function role_status_change(obj, id) {
    if ($(obj).attr('title') == '启用') {
        changeStatus(obj, {
            'title': '启用',
            'callback': '停用',
            'formType': 'PUT',
            'url': 'http://localhost:8081/role/enable/' + id,
            'timeout': 5000,
            'icon': '&#xe601;'
        })
    } else if ($(obj).attr('title') == '停用') {
        changeStatus(obj, {
            'title': '停用',
            'callback': '启用',
            'formType': 'PUT',
            'url': 'http://localhost:8081/role/disable/' + id,
            'timeout': 5000,
            'icon': '&#xe62f;'
        })
    }
}


function searchs(data) {
    var urls = {
        'realPath': $(location).prop('href').toLocaleString(),
        'host': $(location).prop('host').toLocaleString(),
        'path': $(location).prop('pathname').toLocaleString(),
        'protocol': $(location).attr('protocol').toLocaleString(),
        'port': $(location).prop('port').toLocaleString(),
        'args': $.param(delUndefined(data))

    };
    var url = urls.protocol + "//" + urls.host + urls.path + "?" + urls.args;
    $(location).attr("href", url);
    return false;
}

