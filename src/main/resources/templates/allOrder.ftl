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
                    <a>订单管理</a>
                </li>
                <li>
                    <strong>全部订单</strong>
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
                    <h5>全部订单</h5>
                    <div class="ibox-tools">
                    </div>
                </div>
                <div class="ibox-content">
                    <form action="/order/getOrderAll.html" method="post">
                        <input type="hidden" name="pageIndex" value="1" id="pageIndex"/>
                <#include "orderList.ftl">
                        <script src="/static/js/showOrderDetail.js" type="text/javascript"></script>