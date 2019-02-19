<#--引入头部导入的css等内容-->
<#include "common/head.ftl">
<#--引入左侧导航栏-->
<#include "common/left.ftl">
<div id="page-wrapper" class="gray-bg dashbard-1">
<#--引入上方 -->
<#include "common/top.ftl">
<#if Session["manager"]?exists>
    <div class="row wrapper border-bottom white-bg page-heading">
        <div class="col-lg-10">
            <h2>个人资料</h2>
            <ol class="breadcrumb">
                <li>
                    <a href="index.html">主页</a>
                </li>
                <li>
                    <strong>个人资料</strong>
                </li>
            </ol>
        </div>
        <div class="col-lg-2">

        </div>
    </div>
    <div class="wrapper wrapper-content">
        <div class="row animated fadeInRight">
            <div class="col-md-6">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>个人资料</h5>
                    </div>
                    <div>
                        <div class="ibox-content profile-content ">
                            <input id="managerId" type="hidden" value="${Session.manager.id}">
                            <h4>管理员CODE：<strong> ${Session.manager.managerCode} </strong></h4>
                            <h4>管理员姓名：${Session.manager.managerName}</h4>
                            <h4>手机号码：${Session.manager.phone}</h4>
                            <div class="user-button">
                                <div class="row">
                                    <div class="col-md-8">
                                        <button type="button" id="btnUpdate" class="btn btn-primary btn-sm btn-block"
                                                data-toggle="modal" data-target="#updateManager">编辑信息
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--修改管理员信息的模态框-->
    <div class="modal inmodal" id="updateManager" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content animated fadeIn">
                <form id="formUpdate">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                                class="sr-only">关闭</span>
                        </button>
                        <h4 class="modal-title">修改信息</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <input id="id" name="id" value="" type="hidden" placeholder="id">
                            <label>管理员CODE：</label>
                            <div>
                                <input id="managerCode" class="form-control" name="managerCode" required=""
                                       aria-required="true" placeholder="管理员CODE" value="">
                                <span id="ts"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>管理员姓名：</label>
                            <div>
                                <input id="managerName" class="form-control" name="managerName" required=""
                                       aria-required="true" placeholder="管理员姓名" value="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label>手机号码：</label>
                            <div>
                                <input id="phone" name="phone" class="form-control" required="" aria-required="true"
                                       placeholder="管理员手机号码" value="">
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" id="btnSave">保存</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</#if>
<#--引入底部引入的内容-->
<#include "common/tail.ftl">
    <script>
        $(function () {
            var id = $("#managerId").val();
            //点击编辑信息按钮 ajax 将管理员信息附上
            $("#btnUpdate").click(function () {
                $.ajax({
                    type: "POST",
                    url: "/manager/toUpdateManager.html",
                    data: {"id": id},
                    success: function (data) {
                        //成功
                        if (data != null) {
                            $("#id").val(data.id);
                            $("#managerCode").val(data.managerCode);
                            $("#managerName").val(data.managerName);
                            $("#phone").val(data.phone);
                        }
                    },
                    dataType: "json"
                });
            });

            //点击保存ajax处理  保存修改后的管理员信息
            $("#btnSave").click(function () {
                //将表单序列化为json对象
                var formToJson = $("#formUpdate").getFormJSON();
                var fromUpdate = JSON.stringify(formToJson);
                $.ajax({
                    type: "POST",
                    url: "/manager/updateManager.html",
                    data: {"formUpdate": fromUpdate},
                    success: function (data) {
                        //成功
                        if (data.result == "success") {
                            alert(data.message);
                        } else {
                            alert(data.message);
                        }
                        location.href = "/index.html";
                    },
                    dataType: "json"
                });
            });

            $("#managerCode").blur(function () {
                var code = $("#managerCode").val();
                $.ajax({
                    type: "POST",
                    url: "/manager/checkCode.html",
                    data: {"code": code},
                    success: function (data) {
                        //成功
                        if (data.result == "success") {
                            $("#ts").html(data.message);
                        } else if (data.result == "null") {
                            $("#ts").html(data.message);
                        } else {
                            $("#ts").html(data.message);
                            $("#managerCode").val("");
                        }
                    },
                    dataType: "json"
                });
            });
        });
    </script>