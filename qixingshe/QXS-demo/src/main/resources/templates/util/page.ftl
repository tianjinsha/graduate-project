<#-- 参数说明：current当前的页码，totalPage总页数， showPages显示的页码个数，callFunName回调方法名（需在js中自己定义）-->
<#macro page current total pages showPages url>

	<div class="page">
        <#if total &gt;0>
            <#if current lte 1>
                <a href="#" class="disabled prev">&lt;&lt;</a>
            <#else>
                <a href="${url}page=${current-1}" class="prev">&lt;&lt;</a>
            </#if>

            <#if (pages > 0)>
                <#if current == 1>
                <span class="current">1</span>
                <#else >
                 <a href="${url}page=1">1</a>
                </#if>
            </#if>

            <#if (pages > 1)>

            <#--如果当前页往前查3页不是第2页-->
                <#if ((current - showPages) > 2)>
                        <span class="num">…</span>
                </#if>

            <#--当前页的前3页和后3页-->
                <#list (current - showPages)..(current + showPages) as index>
                <#--如果位于第一页和最后一页之间-->
                    <#if (index > 1) && (index < pages)>
                        <#if current == index>
                            <span class="current">${index}</span>
                        <#else >
                        <a href="${url}page=${index}">${index}</a>
                        </#if>
                    </#if>
                </#list>

            <#--如果当前页往后查3页不是倒数第2页-->
                <#if (current + 3) < (pages - 1)>
                    <span class="num">…</span>
                </#if>
            <#--最后页-->
            <#--<#if current == pages>class="disabled"</#if>-->
                <#if current == pages>
                <span class="current">${pages}</span>
                <#else >
                 <a href="${url}page=${pages}">${pages}</a>
                </#if>

            </#if>

            <#if current gte pages>
                <a href="#" class="next disabled">&gt;&gt;</a>
            <#else>
                <a href="${url}page=${current+1}" class="next">&gt;&gt;</a>
            </#if>
            <#else >没有查询到数据！
        </#if>
    </div>


</#macro>
