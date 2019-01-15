<#-- 取得 应用的绝对根路径 -->
<#assign basePath=springMacroRequestContext.contextPath>

<ul class="pager">
    <li><a href="javascript:page_nav(document.forms[0],1);">首页</a></li>
    <#if page.hasPreviousPage>
        <li class=""><a href="javascript:page_nav(document.forms[0],${page.pageNum - 1});">上一页</a></li>
    <#else >
         <li class="disabled"><a href="javascript:;">上一页</a></li>
    </#if>
     <#if page.hasNextPage>
            <li><a href="javascript:page_nav(document.forms[0],${page.pageNum + 1});">下一页</a></li>
     <#else>
            <li class="disabled"><a href="javascript:;">下一页</a></li>
     </#if>
    <li><a href="javascript:page_nav(document.forms[0],${page.pages});">尾页</a></li>
</ul>