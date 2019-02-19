
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th class="text-center">订单编号</th>
                        <th class="text-center">用户昵称</th>
                        <th class="text-center">收货地址</th>
                        <th class="text-center">订单创建时间</th>
                        <th class="text-center">订单类型</th>
                        <th class="text-center">操作</th>
                    </tr>
                    </thead>
<#if page?exists>
    <#list page.list as list>
                        <tbody>
                        <tr>
                            <td class="text-center">${list.orderNo}</td>
                            <td class="text-center"><span class="line">${list.userNickName}</span></td>
                            <td class="text-center">${list.address}</td>
                            <td class="text-center">${list.createtime}</td>
                            <td class="text-center">
                                <#if list.orderType ==2 >
                                    自购
                                <#else >
                                    兑换
                                </#if>
                            </td>
                            <td class="text-center"><a class="lookDetail" orderId="${list.id}" data-toggle="modal" data-target="#showDetail">查看详细</a></td>
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
    <!--显示订单详细的模态框-->
    <div class="modal inmodal" id="showDetail" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content animated bounceInRight">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span
                            class="sr-only">关闭</span>
                    </button>
                    <h4 class="modal-title">订单详细</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group" id="classifyType">
                        <label >订单编号：<span id="orderNo"></span></label>
                    </div>
                    <div class="form-group" id="parentClassifyDiv">
                        <label >用户昵称：<span id="userNickName"></span></label>
                    </div>
                    <div class="form-group">
                        <label >收货地址：<span id="address"></span></label>
                    </div>
                    <div class="form-group">
                        <label >收货人：<span id="consignee"></span></label>
                    </div>
                    <div class="form-group">
                        <label >收货电话：<span id="phone"></span></label>
                    </div>
                    <div class="form-group">
                        <label >商品名：<span id="productName"></span></label>
                    </div>
                    <div class="form-group">
                        <label >购买数量：<span id="productNum"></span></label>
                    </div>
                    <div class="form-group">
                        <label >总消费：<span id="total"></span></label>
                    </div>
                    <div class="form-group">
                        <label >积分变动：<span id="integralVariation"></span></label>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-white btn-primary" data-dismiss="modal" id="btnClose">关闭</button>
                </div>
            </div>
        </div>
    </div>

<#--引入尾部导入-->
<#include "common/tail.ftl">