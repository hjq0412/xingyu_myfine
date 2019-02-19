<#--导入头部引入文件-->
<#include "common/head.ftl">
<#--导入左侧导航栏-->
<#include "common/left.ftl">
<div id="page-wrapper" class="gray-bg dashbard-1">
<#--引入上方 -->
<#include "common/top.ftl">
    <div class="row wrapper border-bottom white-bg page-heading">
        <div class="col-lg-10">
            <h2>查阅用户积分</h2>
            <ol class="breadcrumb">
                <li>
                    <a href="index.html">主页</a>
                </li>
                <li>
                    <a>查阅用户积分</a>
                </li>
                <li>
                    <strong>变动详情</strong>
                </li>
            </ol>
        </div>
        <div class="col-lg-2">
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="wrapper wrapper-content">
                    <div class="row animated fadeInRight">
                        <div class="col-lg-12">
                            <div class="ibox float-e-margins">
                                <div class="" id="ibox-content">
                                    <h2>${userNickName}</h2>
                                    <#list list as li >
                                        <div id="vertical-timeline" class="vertical-timeline light-timeline">
                                            <div class="vertical-timeline-block">
                                                <div class="vertical-timeline-icon yellow-bg">
                                                    <i class="fa fa-briefcase"></i>
                                                </div>
                                                <div class="vertical-timeline-content">
                                                    <h4><#if li.type==1 >
                                                        购买
                                                    <#else >
                                                        兑换
                                                    </#if></h4>
                                                    <p>${li.remark}</p>
                                                </div>
                                            </div>
                                        </div>
                                    </#list>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 text-center">
                     <button class="btn btn-xl btn-primary" id="btnBack" >返回</button>
                </div>
            </div>
        <#--引入尾部导入-->
<#include "common/tail.ftl">
            <script>
                $(function () {
                    $('#leftVersion').click(function (event) {
                        event.preventDefault();
                        $('#vertical-timeline').toggleClass('center-orientation');
                    });

                    $("#btnBack").click(function () {
                        location.href="/user/getTotalIntegral.html";
                    });
                });
            </script>