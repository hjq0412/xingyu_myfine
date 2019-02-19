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
            <input type="hidden" id="classifyName" value="${classify.name}" name="name">
            <input type="hidden" id="classifyParentId" value="${classify.parentId}" name="parentId">
            <input type="hidden" id="classifyType" value="${classify.type}" name="type">
            <form id="frmClassifyUpdate">
                <input type="hidden" id="classifyId" value="${classify.id}" name="id">
                <div class="form-group">
                    <label>分类等级：</label>
                    <div>
                        <select class="form-control m-b" name="type" id="updateType">
                            <option value="1" <#if classify.type ==1>selected="selected"</#if>>一级分类</option>
                            <option value="2" <#if classify.type ==2>selected="selected"</#if>>二级分类</option>
                        </select>
                    </div>
                </div>
                <div class="form-group" id="updateParentIdDiv">
                    <label>所属一级分类：</label>
                    <div>
                        <select class="form-control m-b" name="parentId" id="updateParentId">
                            <option value="0">请选择</option>
                                <#list classifyList as list>
                                    <#if list.type==1>
                                        <option value="${list.id}">${list.name}</option>
                                    </#if>
                                </#list>
                        </select>
                    </div>
                </div>

                <div class="form-group" id="updateLevelDiv">
                    <label>分类名称：</label>
                    <div>
                        <input id="updateLevel" class="form-control" name="name" value="${classify.name}" required=""
                               aria-required="true" placeholder="二级分类名称">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-white" data-dismiss="modal">返回</button>
                    <button type="button" id="btnClassifySave" class="btn btn-primary">保存</button>
                </div>
            </form>
        </div>
    </div>
<#--引入尾部导入-->

<#include "common/tail.ftl">
    <script>
        $(function () {
            $("#updateLevelDiv").show();
            var id = $("#classifyId").val();
            var name = $("#classifyName").val();
            var parentId = $("#classifyParentId").val();
            var type = $("#classifyType").val();
            var updateParentIdDiv = $("#updateParentIdDiv");//所属一级分类
            if (type == 1) {
                //隐藏所属一级分类
                updateParentIdDiv.hide();
                //隐藏分类名称
                $("#updateLevelDiv").show();
                //将一级分类赋值
                $("#updateLevel").val(name);
            } else if (type == 2) {
                updateParentIdDiv.show();//显示所属一级分类
                $("#updateLevel1Div").hide();//隐藏一级分类名称
                $("#updateParentId option[value='" + parentId + "']").attr("selected", "selected");//所属一级分类下拉框选中
                $("#updateLevel2").val(name);//二级分类名称
            }

            //所属分类修改时  下拉框修改
            $("#updateType").change(function () {
                if ($(this).val() != 1) {
                    //显示分类名称
                    $("#updateLevelDiv").show();
                    //显示所属一级分类
                    $("#updateParentIdDiv").show();
                } else {
                    //显示分类名称
                    $("#updateLevelDiv").show();
                    //隐藏所属一级分类
                    $("#updateParentId option[value='" + id + "']").attr("selected", "selected");
                    $("#updateParentIdDiv").hide();

                }
            });

            //修改
            $("#btnClassifySave").click(function () {
                //将表单转化为json对象
                var formJson = $("#frmClassifyUpdate").getFormJSON();
                var formUpdateClassify = JSON.stringify(formJson);
                $.ajax({
                    type:"POST",
                    url:"/classify/updateClassify.html",
                    data:{"formUpdate":formUpdateClassify},
                    success:function (data) {
                        //成功
                        if (data.result=="success") {
                            alert(data.message);
                        }else {
                            alert(data.message);
                        }
                        //跳转至分类列表
                        location.href="/classify/classifyList.html";
                    },
                    dataType:"json"
                });
            });
        });
    </script>