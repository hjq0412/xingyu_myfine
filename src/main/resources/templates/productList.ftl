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
                        <a href="#">
                            <i class="fa fa-plus"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th class="text-center">商品编号</th>
                        <th class="text-center">商品名称</th>
                        <th class="text-center">商品图片</th>
                        <th class="text-center">所属分类</th>
                        <th class="text-center">商品描述</th>
                        <th class="text-center">商品价格</th>
                        <th class="text-center">商品库存</th>
                        <th class="text-center">操作</th>
                    </tr>
                    </thead>
                        <#if pageInfo?exists>
                            <#list pageInfo.list as list>
                        <tbody>
                        <tr>
                            <td class="text-center">${list.id}</td>
                            <td class="text-center"><span class="line">${list.name}</span></td>
                            <td class="text-center"><img src="${list.fileAddress}" class="img-responsive"/></td>
                            <td class="text-center">
                                <#list classifyList as classifylist>
                                    <#if list.level2Id == classifylist.id>
                                        ${classifylist.name}
                                    </#if>
                                </#list>
                            </td>
                            <td class="text-center">${list.description}</td>
                            <td class="text-center">${list.count}</td>
                            <td class="text-center">${list.price}</td>
                            <td class="text-center"><a href="productUpdate.html">修改</a>|<a>删除</a></td>
                        </tr>
                        </tbody>
                            </#list>

                    </table>
                        </#if>
                </div>
            </div>
        </div>
    </div>
<#--引入尾部导入-->
<#include "common/tail.ftl">
