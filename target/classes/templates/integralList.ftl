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
                    <a href="/index.html">主页</a>
                </li>
                <li>
                    <strong>查阅用户积分</strong>
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
                    <h5>用户积分</h5>
                </div>
                <div class="ibox-content">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th class="text-center">用户编号</th>
                            <th class="text-center">用户昵称</th>
                            <th class="text-center">用户积分</th>
                        </tr>
                        </thead>
                        <#if totalIntegralList?exists >
                        <#list totalIntegralList as item >
                        <tbody>
                        <tr>
                            <td class="text-center">${item.id}</td>
                            <td class="text-center">${item.userNickName}</td>
                            <td class="text-center">${item.totalIntegral}</td>
                        </tr>
                        </tbody>
                        </#list>
                        </#if>
                    </table>
                </div>
            </div>
        </div>
    </div>

 <#--引入尾部导入-->
<#include "common/tail.ftl">