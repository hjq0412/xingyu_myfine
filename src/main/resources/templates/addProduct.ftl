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
                    <strong>录入商品</strong>
                </li>
            </ol>
        </div>
        <div class="col-lg-2">
        </div>
    </div>
    <div class="wrapper wrapper-content">
        <div class="row animated fadeInRight">
            <div class="col-sm-6">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>录入商品</h5>
                    </div>
                    <div class="ibox-content">
                        <form class="form-horizontal m-t" id="frm1" enctype="multipart/form-data"
                              action="/product/addProduct.html" method="post">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">商品名称：</label>
                                <div class="col-sm-8">
                                    <input id="cname" name="name" minlength="2" type="text" class="form-control"
                                           required="" aria-required="true" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">所属一级分类：</label>
                                <div class="col-sm-8">
                                    <select class="form-control m-b" name="level1Id" id="level1Id" required="">
                                        <option value="">请选择</option>
                                        <#list classifyList as list>
                                            <#if list.type==1>
                                                <option value="${list.id}" >${list.name}</option>
                                            </#if>
                                        </#list>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">所属二级分类：</label>
                                <div class="col-sm-8">
                                    <select class="form-control m-b" name="level2Id" id="level2Id">
                                        <option value="">请选择</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">商品规格：</label>
                                <div class="col-sm-8">
                                    <input id="size" class="form-control" name="size" required="" aria-required="true"
                                           >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">商品颜色：</label>
                                <div class="col-sm-8">
                                    <input id="color" class="form-control" name="color" required=""
                                           aria-required="true" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">商品数量：</label>
                                <div class="col-sm-8">
                                    <input id="count" class="form-control" name="count" required=""
                                           aria-required="true" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">商品价格：</label>
                                <div class="col-sm-8">
                                    <input id="price" class="form-control" name="price" required=""
                                           aria-required="true" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">商品描述：</label>
                                <div class="col-sm-8">
                                    <textarea id="description" name="description" class="form-control"
                                             ></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">商品图片：</label>
                                <div class="col-sm-8">
                                    <input type="file" name="file" title="选择商品图片" class="btn" required=""
                                           aria-required="true" >
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">
                                    <button class="btn btn-primary " type="submit">提交</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

<#--引入尾部导入-->
<#include "common/tail.ftl">
    <script>
        $(function () {
            //一级分类改变事件
            $("#level1Id").change(function () {
                var level1Id = $(this).val();
                $.ajax({
                    type: "POST",
                    url: "/classify/level1IdChange.html",
                    data: {"level1Id": level1Id},
                    success: function (data) {
                        $("#level2Id").html("");
                        var options = "";
                        options += '<option value="">请选择</option>';//拼接上分类
                        for (var i = 0; i < data.length; i++) {
                            options += '<option value="' + data[i].id + '">' + data[i].name + '</option>';//循环拼接内容
                        }
                        $("#level2Id").html(options);//填充到下拉框
                    },
                    dataType:
                            "json"
                });
            });
        })
    </script>