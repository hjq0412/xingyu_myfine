<#--导入头部引入文件-->
<#include "common/head.ftl">
<#--导入左侧导航栏-->
<#include "common/left.ftl">
<div id="page-wrapper" class="gray-bg dashbard-1">
<#--引入上方 -->
<#include "common/top.ftl">
    <div class="row wrapper border-bottom white-bg page-heading">
        <div class="col-lg-10">
            <h2>商品管理</h2>
            <ol class="breadcrumb">
                <li>
                    <a href="index.html">主页</a>
                </li>
                <li>
                    <a>商品管理</a>
                </li>
                <li>
                    <strong>商品信息</strong>
                </li>
            </ol>
        </div>
        <div class="col-lg-2">
        </div>
    </div>
    <div class="wrapper wrapper-content">
        <div class="row animated fadeInRight">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>商品列表</h5>
                    <div class="ibox-tools">
                        <a href="/product/toAddProduct.html">
                            <i class="fa fa-plus"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                <form action="/product/getProductAll.html" method="post">
                    <input type="hidden" name="pageIndex" value="1" id="pageIndex"/>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th class="text-center col-md-1 col-xs-3">商品编号</th>
                        <th class="text-center col-md-1 col-xs-3">商品名称</th>
                        <th class="text-center col-md-1 col-xs-3">商品图片</th>
                        <th class="text-center col-md-1 col-xs-3">所属分类</th>
                        <th class="text-center col-md-1 col-xs-3">商品描述</th>
                        <th class="text-center col-md-1 col-xs-3">商品价格</th>
                        <th class="text-center col-md-1 col-xs-3">商品库存</th>
                        <th class="text-center col-md-1 col-xs-3">操作</th>
                    </tr>
                    </thead>
                        <#if page?exists>
                            <#list page.list as list>
                                 <tbody>
                                 <tr>
                                     <td class="text-center">${list.id}</td>
                                     <td class="text-center"><span class="line">${list.name}</span></td>
                                     <td class="text-center"><a href="${list.fileAddress}"><img
                                             src="${list.fileAddress}"
                                             class="col-md-6 col-md-push-3 img-responsive"/></a></td>
                                     <td class="text-center">
                                <#list classifyList as classifylist>
                                    <#if list.level2Id == classifylist.id>
                                        ${classifylist.name}
                                    </#if>
                                </#list>
                                     </td>
                                     <td class="text-center">${list.description!""}</td>
                                     <td class="text-center">${list.count!""}</td>
                                     <td class="text-center">${list.price!""}</td>
                                     <td class="text-center"><a
                                             href="/product/toUpdateProduct.html?id=${list.id}">修改</a>|
                                    <#if list.isDel==2>
                                         <a class="delPro" proId="${list.id}">下架</a>
                                    <#else >
                                         <a class="upPro" proId="${list.id}">上架</a>
                                    </#if>
                                     </td>
                                 </tr>
                                 </tbody>
                             </#list>
                    </table>
                        </form>
                            <#include "common/page.ftl">
                        </#if>
                </div>
            </div>
        </div>
    </div>
<#--引入尾部导入-->
<#include "common/tail.ftl">
    <script>
        $(function () {
            $(".delPro").click(function () {
                if (confirm("确定要删除吗？")) {
                    var obj = $(this);
                    var id = obj.attr("proId");
                    $.ajax({
                        type: "POST",
                        url: "/product/delPro.html",
                        data: {"id": id},
                        success: function (data) {
                            //成功
                            if (data.result == "success") {
                                alert(data.message);
                            } else {
                                alert(data.message);
                            }
                            //跳转至分类列表
                            location.href = "/product/getProductAll.html";
                        },
                        dataType: "json"
                    });
                }
            });
            //上架商品
            $(".upPro").click(function () {
                if (confirm("确定要上架吗？")) {
                    var obj = $(this);
                    var id = obj.attr("proId");
                    $.ajax({
                        type: "POST",
                        url: "/product/upPro.html",
                        data: {"id": id},
                        success: function (data) {
                            //成功
                            if (data.result == "success") {
                                alert(data.message);
                            } else {
                                alert(data.message);
                            }
                            //跳转至分类列表
                            location.href = "/product/getProductAll.html";
                        },
                        dataType: "json"
                    });
                }
            });
        });
    </script>