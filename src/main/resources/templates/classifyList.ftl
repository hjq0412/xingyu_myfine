<#--导入头部引入文件-->
<#include "common/head.ftl">
<#--导入左侧导航栏-->
<#include "common/left.ftl">
<div id="page-wrapper" class="gray-bg dashbard-1">
<#--引入上方 -->
<#include "common/top.ftl">

    <div class="row wrapper border-bottom white-bg page-heading">
        <div class="col-lg-10">
            <h2>商品分类</h2>
            <ol class="breadcrumb">
                <li>
                    <a href="/index.html">主页</a>
                </li>
                <li>
                    <a>商品分类</a>
                </li>
                <li>
                    <strong>分类管理</strong>
                </li>
            </ol>
        </div>
        <div class="col-lg-2">
        </div>
    </div>
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row ">
            <div class="col-lg-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>分类</h5>
                        <div class="ibox-tools">
                            <button data-toggle="modal" data-target="#addModal">
                                <i class="fa fa-plus"></i>
                            </button>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <form action="/classify/classifyList.html" method="post">
                            <input type="hidden" name="pageIndex" value="1" id="pageIndex"/>
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th class="text-center">分类编号</th>
                                    <th class="text-center">分类名称</th>
                                    <th class="text-center">分类级别</th>
                                    <th class="text-center">父级分类</th>
                                    <th class="text-center">操作</th>
                                </tr>
                                </thead>
                        <#if page.list?exists>
                            <#list page.list as list >
                                <tbody>
                                <tr class="gradeA">
                                    <td class="text-center">${list.id}</td>
                                    <td class="text-center"><span class="line">${list.name}</span></td>
                                    <td class="text-center">
                                        <#if list.type==1 >
                                            一级分类
                                        <#else >
                                            二级分类
                                        </#if>
                                    </td>
                                    <td class="text-center">
                                        <#if list.type==1 >
                                            无父级分类
                                        <#elseif list.type==2>
                                            <#switch list.parentId>
                                                <#case 1>
                                                    上衣
                                                    <#break >
                                                <#case 2>
                                                    裤子
                                                    <#break >
                                                <#case 3>
                                                    潮鞋
                                                    <#break >
                                                <#case 4>
                                                    T恤
                                                    <#break >
                                                <#case 5>
                                                    配饰
                                                    <#break >
                                            </#switch>
                                        </#if>
                                    </td>
                                    <td class="text-center"><input type="hidden" class="classifyId" name="id"
                                                                   value="${list.id}"><a
                                            href="/classify/toUpdate.html?id=${list.id}">修改</a>|<a class="delClassify"
                                                                                                   classifyId="${list.id}"
                                                                                                   typeList="${list.type}">删除</a>
                                    </td>
                                </tr>
                                </tbody>
                            </#list>
                        </#if>
                            </table>
                        </form>
                        <#include "common/page.ftl">
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!--新增分类的模态框&ndash;&gt;-->
    <div class="modal inmodal" id="addModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content animated bounceInRight">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span
                            class="sr-only">关闭</span>
                    </button>
                    <h4 class="modal-title">新增分类</h4>
                </div>
                <div class="modal-body">
                    <form id="classifyAddForm">
                        <div class="form-group" id="classifyType">
                            <label>分类等级：</label><!--如果选择一级分类就隐藏掉父级分类-->
                            <div>
                                <select class="form-control m-b" name="type">
                                    <option value="1">一级分类</option>
                                    <option value="2">二级分类</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group" id="parentClassifyDiv">
                            <label>父级分类：</label><!--如果选择一级分类就隐藏掉二级分类-->
                            <div>
                                <select class="form-control m-b" name="parentId">
                                    <option value="0">请选择</option>
                             <#list classifyList as list>
                                 <#if list.type==1>
                                     <option value="${list.id}">${list.name}</option>
                                 </#if>
                             </#list>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>分类名称：</label>
                            <div>
                                <input id="name" name="name" class="form-control" placeholder="分类名称" required=""
                                       aria-required="true">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="classifyAdd">保存</button>
                </div>
            </div>
        </div>
    </div>

<#--引入尾部导入-->
<#include "common/tail.ftl">
    <script>
        $(function () {
            //新增时下拉框改变事件
            $("#parentClassifyDiv").hide();
            $("#classifyType").change(function () {
                if ($(this).val() == 1) {
                    $("#parentClassifyDiv").hide();
                } else {
                    $("#parentClassifyDiv").show();
                }
            });
            //ajax新增
            $("#classifyAdd").click(function () {
                //表单序列化json
                var formAddJson = $("#classifyAddForm").getFormJSON();
                var formAdd = JSON.stringify(formAddJson);
                alert(formAdd);
                $.ajax({
                    type: "POST",
                    url: "/classify/addClassify.html",
                    data: {"formAdd": formAdd},
                    success: function (data) {
                        //成功
                        if (data.result == "success") {
                            alert(data.message);
                        } else {
                            alert(data.message);
                        }
                        //跳转至分类列表
                        location.href = "/classify/classifyList.html";
                    },
                    dataType: "json"
                });
            });
            //ajax删除
            $(".delClassify").click(function () {
                if (confirm("确定要删除吗？")) {
                    var obj = $(this);
                    var id = obj.attr("classifyId");
                    var type = obj.attr("typeList");
                    $.ajax({
                        type: "POST",
                        url: "/classify/delClassify.html",
                        data: {"id": id, "type": type},
                        success: function (data) {
                            //成功
                            if (data.result == "success") {
                                alert(data.message);
                            } else {
                                alert(data.message);
                            }
                            //跳转至分类列表
                            location.href = "/classify/classifyList.html";
                        },
                        dataType: "json"
                    });
                }
            });
        });
    </script>