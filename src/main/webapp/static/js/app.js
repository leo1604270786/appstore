var App = function () {
    //用于存放id的数组
    var idArray;
    //默认的Dropzone参数
    var defaultDropzoneOpts = {
        url: "", // 文件提交地址
        method: "post",  // 也可用put
        paramName: "dropFile", // 默认为file
        maxFiles: 1,// 一次性上传的文件数量上限
        maxFilesize: 2, // 文件大小，单位：MB
        acceptedFiles: ".jpg,.gif,.png,.jpeg", // 上传的类型
        addRemoveLinks: true,
        parallelUploads: 1,// 一次上传的文件数量
        dictDefaultMessage: '拖动文件至此或者点击上传',
        dictMaxFilesExceeded: "您最多只能上传"+this.maxFiles+"个文件！",
        dictResponseError: '文件上传失败!',
        dictInvalidFileType: "文件类型只能是*.jpg,*.gif,*.png,*.jpeg",
        dictFallbackMessage: "浏览器不受支持",
        dictFileTooBig: "文件过大上传文件最大支持.",
        dictRemoveLinks: "删除",
        dictCancelUpload: "取消"
    };

    /*
    * 初始化DataTables
    * */
    var handlerInitDataTables = function (url, columns) {
        var dataTable = $("#dataTable").DataTable({
            "ordering": false,
            "lengthChange": false,
            "stateSave": true,
            "processing": true,
            "searching": false,
            "deferRender": true,
            "serverSide": true,
            "ajax": {
                "url": url
            },
            "columns": columns,
            "drawCallback":function ( settings) {
            },
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            }
        });
        return dataTable;
    };
    /*
    * 初始化Dropzone
    * */
    var handlerInitDropzone = function (opts) {
        //关闭Dropzone自动发现功能
        Dropzone.autoDiscover = false;
        //继承
        $.extend(defaultDropzoneOpts,opts);
        new Dropzone(defaultDropzoneOpts.id, defaultDropzoneOpts);
    };
    var handlerGetCategory = function (level,parent) {
        var url = "/appstore/app/category?level="+level;
        if (parent !== ''){
            url += ("&parent="+parent);
        }
        var categoryList;
        $.ajax({
            type: "GET",
            url: url,
            dataType: 'json',
            async: false,
            success: function(msg){
                categoryList = JSON.stringify(msg);
                //alert(JSON.stringify(msg));
            }
        });
        return categoryList;
    };


    return{
        //初始化DataTables
        initDataTables:function (url, columns) {
            return handlerInitDataTables(url,columns);
        },
        //初始化Dropzone
        initDropzone:function (opts) {
            handlerInitDropzone(opts);
        },
        //获取分类列表
        getCategory: function (level,parent) {
            return handlerGetCategory(level,parent);
        }
    }
}();
