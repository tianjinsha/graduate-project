layui.use(['form','layedit'], function () {
    var form = layui.form,
        layedit = layui.layedit;
    var it_content=layedit.build('L_content'); //建立编辑器
    var live_content=layedit.build('L_content'); //建立编辑器

    //自定义验证规则
    form.verify({
        newsCategory_name: function (value) {
            if (value.length < 2) {
                return '新闻分类至少得2个字符啊';
            }
            if (value.length > 10) {
                return '新闻分类最多得10个字符啊';
            }
        }
        ,
        newsCategory_description: function (value) {
            if (value.length < 5) {
                return '新闻描述至少得5个字符啊';
            }
            if (value.length > 100) {
                return '新闻分类最多得100个字符啊';
            }
        },
        newsTags_name: function (value) {
            if (value.length < 2) {
                return '新闻标签至少得2个字符啊';
            }
            if (value.length > 10) {
                return '新闻标签最多得10个字符啊';
            }
        }
        ,
        newsTags_description: function (value) {
            if (value.length < 5) {
                return '新闻标签描述至少得5个字符啊';
            }
            if (value.length > 100) {
                return '新闻标签描述最多得100个字符啊';
            }
        },
        itCategory_name: function (value) {
            if (value.length < 2) {
                return '分类至少得2个字符啊';
            }
            if (value.length > 10) {
                return '分类最多得10个字符啊';
            }
        }
        ,
        itCategory_description: function (value) {
            if (value.length < 5) {
                return '描述至少得5个字符啊';
            }
            if (value.length > 100) {
                return '描述最多得100个字符啊';
            }
        },
    });

    //添加新闻分类
    form.on('submit(newsCategory_add)', function (data) {
        //发异步，把数据提交给server
        var postData = data.field;
        form_submit({
            formType: 'POST',
            title: '添加',
            url: "/newsCategory/add"
        }, postData);
        return false;
    });
    //修改新闻分类
    form.on('submit(newsCategory_edit)', function (data) {
        //发异步，把数据提交给server
        var postData = data.field;
        form_submit({
            formType: 'PUT',
            title: '修改',
            url: "/newsCategory/edit"
        }, postData);
        return false;
    });
    //添加新闻标签
    form.on('submit(newsTags_add)', function (data) {
        //发异步，把数据提交给server
        var postData = data.field;
        form_submit({
            formType: 'POST',
            title: '添加',
            url: "/newsTags/add"
        }, postData);
        return false;
    });
    //修改新闻标签
    form.on('submit(newsTags_edit)', function (data) {
        //发异步，把数据提交给server
        var postData = data.field;
        form_submit({
            formType: 'PUT',
            title: '修改',
            url: "/newsTags/edit"
        }, postData);
        return false;
    });

    //添加it分类
    form.on('submit(itCategory_add)', function (data) {
        //发异步，把数据提交给server
        var postData = data.field;
        form_submit({
            formType: 'POST',
            title: '添加',
            url: "/itCategory/add"
        }, postData);
        return false;
    });

    //修改it分类
    form.on('submit(itCategory_edit)', function (data) {
        //发异步，把数据提交给server
        var postData = data.field;
        form_submit({
            formType: 'PUT',
            title: '修改',
            url: "/itCategory/edit"
        }, postData);
        return false;
    });

    //添加it分类
    form.on('submit(itTags_add)', function (data) {
        //发异步，把数据提交给server
        var postData = data.field;
        form_submit({
            formType: 'POST',
            title: '添加',
            url: "/itTags/add"
        }, postData);
        return false;
    });

    //修改it标签
    form.on('submit(itTags_edit)', function (data) {
        //发异步，把数据提交给server
        var postData = data.field;
        form_submit({
            formType: 'PUT',
            title: '修改',
            url: "/itTags/edit"
        }, postData);
        return false;
    });

    //添加it
    form.on('submit(it_add)', function (data) {
        //发异步，把数据提交给server
        var postData=data.field;

        if (postData.status=='on'){
            postData.status='1';
        }else{
            postData.status='0';
        }
        postData.content=layedit.getContent(it_content);
        console.log(postData);
        form_submit({
            formType: 'POST',
            title: '添加',
            url: "/it/add"
        }, postData);
        return false;
    });

    //添加aware分类
    form.on('submit(awareType_add)', function (data) {
        //发异步，把数据提交给server
        var postData=data.field;
        form_submit({
            formType: 'POST',
            title: '添加',
            url: "/awareType/add"
        }, postData);
        return false;
    });

    //修改aware分类
    form.on('submit(awareType_edit)', function (data) {
        //发异步，把数据提交给server
        var postData=data.field;
        form_submit({
            formType: 'PUT',
            title: '修改',
            url: "/awareType/edit"
        }, postData);
        return false;
    });

    //添加aware标签
    form.on('submit(awareTags_add)', function (data) {
        //发异步，把数据提交给server
        var postData=data.field;
        form_submit({
            formType: 'POST',
            title: '添加',
            url: "/awareTags/add"
        }, postData);
        return false;
    });

    //修改aware标签
    form.on('submit(awareTags_edit)', function (data) {
        //发异步，把数据提交给server
        var postData=data.field;
        form_submit({
            formType: 'PUT',
            title: '修改',
            url: "/awareTags/edit"
        }, postData);
        return false;
    });

    //添加aware标签
    form.on('submit(aware_add)', function (data) {
        //发异步，把数据提交给server
        var postData=data.field;
        form_submit({
            formType: 'POST',
            title: '添加',
            url: "/aware/add"
        }, postData);
        return false;
    });

    //修改aware标签
    form.on('submit(aware_edit)', function (data) {
        //发异步，把数据提交给server
        var postData=data.field;
        form_submit({
            formType: 'PUT',
            title: '修改',
            url: "/aware/edit"
        }, postData);
        return false;
    });

    //添加liveTopic
    form.on('submit(liveTopic_add)', function (data) {
        //发异步，把数据提交给server
        var postData=data.field;
        form_submit({
            formType: 'POST',
            title: '添加',
            url: "/liveTopic/add"
        }, postData);
        return false;
    });

    //修改aware标签
    form.on('submit(liveTopic_edit)', function (data) {
        //发异步，把数据提交给server
        var postData=data.field;
        form_submit({
            formType: 'PUT',
            title: '修改',
            url: "/liveTopic/edit"
        }, postData);
        return false;
    });

    //添加live
    form.on('submit(live_add)', function (data) {
        //发异步，把数据提交给server
        var postData=data.field;

        if (postData.status=='on'){
            postData.status='1';
        }else{
            postData.status='0';
        }
        postData.content=layedit.getContent(live_content);
        console.log(postData);
        form_submit({
            formType: 'POST',
            title: '添加',
            url: "/live/add"
        }, postData);
        return false;
    });

    //修改live
    form.on('submit(live_edit)', function (data) {
        //发异步，把数据提交给server
        var postData=data.field;

        if (postData.status=='on'){
            postData.status='1';
        }else{
            postData.status='0';
        }
        postData.content=layedit.getContent(live_content);
        form_submit({
            formType: 'PUT',
            title: '修改',
            url: "/live/edit"
        }, postData);
        return false;
    });
});




/**
 * 用户状态改变：启用1，停用0
 * @param obj
 * @param id
 */
function news_status_change(obj, id) {
    console.log(RequestUrl + '/news/disable/' + id);
    /*新闻-启用-1*/
    if ($(obj).attr('title') == '启用') {
        console.log("1:启用：" + $(obj).attr('title'));
        changeStatus(obj, {
            'title': '启用',
            'callback': '停用',
            'formType': 'PUT',
            'url': RequestUrl + '/news/enable/' + id,
            'timeout': 5000,
            'icon': '&#xe601;'
        })
        /*新闻-停用-0*/
    } else if ($(obj).attr('title') == '停用') {
        console.log("1:停用：" + $(obj).attr('title'));
        changeStatus(obj, {
            'title': '停用',
            'callback': '启用',
            'formType': 'PUT',
            'url': RequestUrl + '/news/disable/' + id,
            'timeout': 5000,
            'icon': '&#xe62f;'
        })
    }
}

/**
 * 新闻-删除
 * @param obj
 * @param id
 */
function news_delete(obj, id) {
    deleteRow(obj, {
        'title': '删除',
        'formType': 'DELETE',
        'url': RequestUrl + '/news/delete/' + id,
        'timeout': 5000,
    })
}

/**
 * 新闻-批量删除
 * @param
 */
function news_deleteAll() {
    var data = tableCheck.getData();
    deleteRowAll(data, {
        'title': '删除',
        'formType': 'DELETE',
        'url': RequestUrl + '/news/batchDelete',
        'timeout': 5000,
    })
}

/**
 * 新闻分类-批量删除
 */
function newsCategory_deleteAll() {
    var data = tableCheck.getData();
    deleteRowAll(data, {
        'title': '删除',
        'formType': 'DELETE',
        'url': RequestUrl + '/newsCategory/batchDelete',
        'timeout': 5000,
    })
}

/**
 * 新闻分类-删除
 * @param obj
 * @param id
 */
function newsCategory_delete(obj, id) {
    deleteRow(obj, {
        'title': '删除',
        'formType': 'DELETE',
        'url': RequestUrl + '/newsCategory/delete/' + id,
        'timeout': 5000,
    })
}
/**
 * ==========================================================================
 */

/**
 * 新闻分类-批量删除
 */
function newsTags_deleteAll() {
    var data = tableCheck.getData();
    deleteRowAll(data, {
        'title': '删除',
        'formType': 'DELETE',
        'url': RequestUrl + '/newsTags/batchDelete',
        'timeout': 5000,
    })
}

/**
 * 新闻分类-删除
 * @param obj
 * @param id
 */
function newsTags_delete(obj, id) {
    deleteRow(obj, {
        'title': '删除',
        'formType': 'DELETE',
        'url': RequestUrl + '/newsTags/delete/' + id,
        'timeout': 5000,
    })
}

/**
 * ==========================================================================
 */

/**
 * it分类-批量删除
 */
function itCategory_deleteAll() {
    var data = tableCheck.getData();
    deleteRowAll(data, {
        'title': '删除',
        'formType': 'DELETE',
        'url': RequestUrl + '/itCategory/batchDelete',
        'timeout': 5000,
    })
}
/**
 * it分类-删除
 * @param obj
 * @param id
 */
function itCategory_delete(obj, id) {
    deleteRow(obj, {
        'title': '删除',
        'formType': 'DELETE',
        'url': RequestUrl + '/itCategory/delete/' + id,
        'timeout': 5000,
    })
}
/**
 * ==========================================================================
 */

/**
 * it分类-批量删除
 */
function itTags_deleteAll() {
    var data = tableCheck.getData();
    deleteRowAll(data, {
        'title': '删除',
        'formType': 'DELETE',
        'url': RequestUrl + '/itTags/batchDelete',
        'timeout': 5000,
    })
}
/**
 * it分类-删除
 * @param obj
 * @param id
 */
function itTags_delete(obj, id) {
    deleteRow(obj, {
        'title': '删除',
        'formType': 'DELETE',
        'url': RequestUrl + '/itTags/delete/' + id,
        'timeout': 5000,
    })
}

/**
 * ==========================================================================
 */

/**
 * 用户状态改变：启用1，停用2
 * @param obj
 * @param id
 */
function it_status_change(obj, id) {
    console.log(RequestUrl + '/it/disable/' + id);
    /*新闻-启用-1*/
    if ($(obj).attr('title') == '启用') {
        console.log("1:启用：" + $(obj).attr('title'));
        changeStatus(obj, {
            'title': '启用',
            'callback': '停用',
            'formType': 'PUT',
            'url': RequestUrl + '/it/enable/' + id,
            'timeout': 5000,
            'icon': '&#xe601;'
        })
        /*新闻-停用-0*/
    } else if ($(obj).attr('title') == '停用') {
        console.log("1:停用：" + $(obj).attr('title'));
        changeStatus(obj, {
            'title': '停用',
            'callback': '启用',
            'formType': 'PUT',
            'url': RequestUrl + '/it/disable/' + id,
            'timeout': 5000,
            'icon': '&#xe62f;'
        })
    }
}

/**
 * it-删除
 * @param obj
 * @param id
 */
function it_delete(obj, id) {
    deleteRow(obj, {
        'title': '删除',
        'formType': 'DELETE',
        'url': RequestUrl + '/it/delete/' + id,
        'timeout': 5000,
    })
}

/**
 * it分类-批量删除
 */
function it_deleteAll() {
    var data = tableCheck.getData();
    deleteRowAll(data, {
        'title': '删除',
        'formType': 'DELETE',
        'url': RequestUrl + '/it/batchDelete',
        'timeout': 5000,
    })
}
/**
 * ==========================================================================
 */
/**
 * it-删除
 * @param obj
 * @param id
 */
function awareType_delete(obj, id) {
    deleteRow(obj, {
        'title': '删除',
        'formType': 'DELETE',
        'url': RequestUrl + '/awareType/delete/' + id,
        'timeout': 5000,
    })
}

/**
 * it分类-批量删除
 */
function awareType_deleteAll() {
    var data = tableCheck.getData();
    deleteRowAll(data, {
        'title': '删除',
        'formType': 'DELETE',
        'url': RequestUrl + '/awareType/batchDelete',
        'timeout': 5000,
    })
}

/**
 * it-删除
 * @param obj
 * @param id
 */
function awareTags_delete(obj, id) {
    deleteRow(obj, {
        'title': '删除',
        'formType': 'DELETE',
        'url': RequestUrl + '/awareTags/delete/' + id,
        'timeout': 5000,
    })
}

/**
 * it分类-批量删除
 */
function awareTags_deleteAll() {
    var data = tableCheck.getData();
    deleteRowAll(data, {
        'title': '删除',
        'formType': 'DELETE',
        'url': RequestUrl + '/awareTags/batchDelete',
        'timeout': 5000,
    })
}
/**
 * ==========================================================================
 */
/**
 * it-删除
 * @param obj
 * @param id
 */
function aware_delete(obj, id) {
    deleteRow(obj, {
        'title': '删除',
        'formType': 'DELETE',
        'url': RequestUrl + '/aware/delete/' + id,
        'timeout': 5000,
    })
}

/**
 * it分类-批量删除
 */
function aware_deleteAll() {
    var data = tableCheck.getData();
    deleteRowAll(data, {
        'title': '删除',
        'formType': 'DELETE',
        'url': RequestUrl + '/aware/batchDelete',
        'timeout': 5000,
    })
}
/**
 * 用户状态改变：启用1，停用0
 * @param obj
 * @param id
 */
function aware_status_change(obj, id) {
    console.log(RequestUrl + '/aware/disable/' + id);
    /*新闻-启用-1*/
    if ($(obj).attr('title') == '启用') {
        console.log("1:启用：" + $(obj).attr('title'));
        changeStatus(obj, {
            'title': '启用',
            'callback': '停用',
            'formType': 'PUT',
            'url': RequestUrl + '/aware/enable/' + id,
            'timeout': 5000,
            'icon': '&#xe601;'
        })
        /*新闻-停用-0*/
    } else if ($(obj).attr('title') == '停用') {
        console.log("1:停用：" + $(obj).attr('title'));
        changeStatus(obj, {
            'title': '停用',
            'callback': '启用',
            'formType': 'PUT',
            'url': RequestUrl + '/aware/disable/' + id,
            'timeout': 5000,
            'icon': '&#xe62f;'
        })
    }
}

/**
 * ==========================================================================
 */
/**
 * 生活娱乐-删除
 * @param obj
 * @param id
 */
function liveTopic_delete(obj, id) {
    deleteRow(obj, {
        'title': '删除',
        'formType': 'DELETE',
        'url': RequestUrl + '/liveTopic/delete/' + id,
        'timeout': 5000,
    })
}
/**
 * liveTopic 话题-批量删除
 */
function liveTopic_deleteAll() {
    var data = tableCheck.getData();
    deleteRowAll(data, {
        'title': '删除',
        'formType': 'DELETE',
        'url': RequestUrl + '/liveTopic/batchDelete',
        'timeout': 5000,
    })
}

/**
 * ==========================================================================
 */
/**
 * 生活娱乐-删除
 * @param obj
 * @param id
 */
function live_delete(obj, id) {
    deleteRow(obj, {
        'title': '删除',
        'formType': 'DELETE',
        'url': RequestUrl + '/live/delete/' + id,
        'timeout': 5000,
    })
}
/**
 * liveTopic 话题-批量删除
 */
function live_deleteAll() {
    var data = tableCheck.getData();
    deleteRowAll(data, {
        'title': '删除',
        'formType': 'DELETE',
        'url': RequestUrl + '/live/batchDelete',
        'timeout': 5000,
    })
}

/**
 * live状态改变：启用1，停用0
 * @param obj
 * @param id
 */
function live_status_change(obj, id) {
    console.log(RequestUrl + '/live/disable/' + id);
    /*新闻-启用-1*/
    if ($(obj).attr('title') == '启用') {
        console.log("1:启用：" + $(obj).attr('title'));
        changeStatus(obj, {
            'title': '启用',
            'callback': '停用',
            'formType': 'PUT',
            'url': RequestUrl + '/live/enable/' + id,
            'timeout': 5000,
            'icon': '&#xe601;'
        })
        /*新闻-停用-0*/
    } else if ($(obj).attr('title') == '停用') {
        console.log("1:停用：" + $(obj).attr('title'));
        changeStatus(obj, {
            'title': '停用',
            'callback': '启用',
            'formType': 'PUT',
            'url': RequestUrl + '/live/disable/' + id,
            'timeout': 5000,
            'icon': '&#xe62f;'
        })
    }
}