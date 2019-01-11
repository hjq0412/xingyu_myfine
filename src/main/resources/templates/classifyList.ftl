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
    <div class="wrapper wrapper-content">
        <div class="row animated fadeInRight">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>分类</h5>
                    <div class="ibox-tools">
                        <a href="#" data-toggle="modal" data-target="#addModal">
                            <i class="fa fa-plus"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
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
                        <#if pageInfo.list?exists>
                            <#list pageInfo.list as list >
                                <tbody>
                                <tr>
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
                                            <#list pageInfo.list as list2>
                                                <#if list.parentId==list2.id >
                                                    ${list2.name}
                                                </#if>
                                            </#list>
                                        </#if>
                                    </td>
                                    <td class="text-center"><a data-toggle="modal" data-target="#updateModal">修改</a>|<a>删除</a>
                                    </td>
                                </tr>
                                </tbody>
                            </#list>
                        </#if>
                    </table>
                </div>
            </div>
        </div>
    </div>


   <#-- <!--新增分类的模态框&ndash;&gt;
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
                    <div class="form-group">
                        <label>分类等级：</label><!--如果选择一级分类就隐藏掉父级分类&ndash;&gt;
                        <div>
                            <select class="form-control m-b" name="type">
                                 <#list classifyList as list>
                                    <#if list.typeId==1>
                                        <option value="${list.id}">一级分类</option>
                                    <#else >
                                        <option value="${list.id}">二级分类</option>
                                    </#if>
                                 </#list>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>父级分类：</label><!--如果选择一级分类就隐藏掉二级分类&ndash;&gt;
                        <div>
                            <select class="form-control m-b" name="parentId">
                                <#list classifyList as list>
                                    <#if list.typeId==1>
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
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary">保存</button>
                </div>
            </div>
        </div>
    </div>-->
    <!--修改分类的模态框-->
    <div class="modal inmodal" id="updateModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content animated flipInY">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span
                            class="sr-only">关闭</span>
                    </button>
                    <h4 class="modal-title">修改分类</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>分类等级：</label><!--如果选择一级分类就隐藏掉二级分类名称-->
                        <div>
                            <select class="form-control m-b" name="account">
                                <option>一级分类</option>
                                <option>二级分类</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>一级分类名称：</label>

                        <div>
                            <input id="updateName" class="form-control" name="price" required="" aria-required="true">
                        </div>
                    </div>
                    <div class="form-group">
                        <label>二级分类名称：</label>

                        <div>
                            <input id="leve2" class="form-control" name="price" required="" aria-required="true">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary">保存</button>
                </div>
            </div>
        </div>
    </div>
<#--引入尾部导入-->
<#include "common/tail.ftl">