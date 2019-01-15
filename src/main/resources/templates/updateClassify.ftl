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
    <div class="row wrapper border-bottom white-bg page-heading">
        <div class="ibox-content profile-content ">
            <form id="frmClassifyUpdate">
                <input type="hidden" id="updateId" value="" name="id">
                <div class="form-group">
                    <label>分类等级：</label>
                    <div>
                        <select class="form-control m-b" name="type" id="updateType">
                            <option value="0">请选择</option>
                            <option value="1" <#if classify.type ==1>selected="selected"</#if>>一级分类</option>
                            <option value="2" <#if classify.type ==2>selected="selected"</#if>>二级分类</option>
                        </select>
                    </div>
                </div>
<#if classify.type==2>
            <div class="form-group" id="updateParentIdDiv">
                <label>所属一级分类：</label>
                <div>
                    <select class="form-control m-b" name="parentId" id="updateParentId">
                                <#list classifyList as list>
                                    <#if list.type==1>
                                        <option value="${list.id}">${list.name}</option>
                                    </#if>
                                </#list>
                    </select>
                </div>
            </div>
</#if>
<#if classify.type==1>
            <div class="form-group" id="updateLevel1Div">
                <label>一级分类名称：</label>
                <div>
                    <input id="updateLevel1" name="name" class="form-control" required=""
                           aria-required="true"
                           placeholder="一级分类名称" value="<#if classify.type==1>
                                ${classify.name}
                                 </#if>">
                </div>
            </div>
</#if>
<#if classify.type==2>
            <div class="form-group" id="updateLevel2Div">
                <label>二级分类名称：</label>
                <div>
                    <input id="updateLevel2" class="form-control" name="${classify.name}" required=""
                           aria-required="true" placeholder="二级分类名称">
                </div>
            </div>
</#if>
                <div class="modal-footer">
                    <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                    <button type="button" id="btnClassifySave" class="btn btn-primary">保存</button>
                </div>
            </form>
        </div>
    </div>
<#--引入尾部导入-->
<#include "common/tail.ftl">