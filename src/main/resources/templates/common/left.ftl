<div id="wrapper">
    <#if Session["manager"]?exists>
    <!--左侧导航栏-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                                <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold text-center">欢迎，${Session.manager.managerCode}</strong>
                             </span> <span class="text-muted text-xs block">${Session.manager.managerName} <b class="caret"></b></span> </span>
                        </a>
                    </div>
                    <div class="logo-element">
                        我有我优
                    </div>

                </li>
                <li>
                    <a href="/index.html"><i class="fa fa-th-large"></i> <span class="nav-label">个人资料</span> </span></a>
                </li>
                <li>
                    <a href="index.html#"><i class="fa fa fa-globe"></i> <span class="nav-label">商品管理</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a href="/product/getProductAll.html">商品信息</a></li>
                        <li><a href="productAdd.html">录入商品</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="index.html#"><i class="fa fa-bar-chart-o"></i> <span class="nav-label">商品分类</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a href="/classify/classifyList.html">分类管理</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="mailbox.html"><i class="fa fa-envelope"></i> <span class="nav-label">本店活动</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a href="mailbox.html">优惠商品</a>
                        </li>
                        <li><a href="exchange.html">积分兑换</a>
                        </li>
                    </ul>
                </li>

                <li>
                    <a href="index.html#"><i class="fa fa-edit"></i> <span class="nav-label">订单管理</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a href="/order/getOrderAll.html">全部订单</a>
                        </li>
                        <li><a href="/order/getOrderNoPay.html">待付款订单</a>
                        </li>
                        <li><a href="/order/getOrderDelivery.html?isDelivery=1">已发货订单</a>
                        </li>
                        <li><a href="/order/getOrderDelivery.html?isDelivery=2">待发货订单</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="/user/getTotalIntegral.html"><i class="fa fa-flask"></i> <span class="nav-label">查阅用户积分</span></a>
                </li>
            </ul>
        </div>
    </nav>
    </#if>