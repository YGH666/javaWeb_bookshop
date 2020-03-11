<%--
  Created by IntelliJ IDEA.
  User: Mr.Yang
  Date: 2020/3/6
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <C:if test="${requestScope.page.pageNo > 1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
    </C:if>
    <C:choose>
        <C:when test="${requestScope.page.pageTotal <= 5}">
            <C:set var="begin" value="1"></C:set>
            <C:set var="end" value="${requestScope.page.pageTotal}"></C:set>
        </C:when>
        <C:when test="${requestScope.page.pageTotal > 5}">
            <C:choose>
                <C:when test="${requestScope.page.pageNo <= 3}">
                    <C:set var="begin" value="1"></C:set>
                    <C:set var="end" value="5"></C:set>
                </C:when>
                <C:when test="${requestScope.page.pageNo > requestScope.page.pageTotal-3}">
                    <C:set var="begin" value="${requestScope.page.pageTotal-4}"></C:set>
                    <C:set var="end" value="${requestScope.page.pageTotal}"></C:set>
                </C:when>
                <C:otherwise>
                    <C:set var="begin" value="${requestScope.page.pageNo-2}"></C:set>
                    <C:set var="end" value="${requestScope.page.pageNo+2}"></C:set>
                </C:otherwise>
            </C:choose>
        </C:when>
    </C:choose>

    <C:forEach begin="${begin}" end="${end}" var="i">
        <C:if test="${i == requestScope.page.pageNo}">
            <a  style="color: red" href="${requestScope.page.url}&pageNo=${i}">[${i}]</a>
        </C:if>
        <C:if test="${i != requestScope.page.pageNo}">
            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
        </C:if>
    </C:forEach>

    <C:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </C:if>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录，到第<input id="pg_input"  style="margin: 0;border: 1px solid gray;width: 30px;text-align: center" type="text" name="title" class="layui-input-block" value="${requestScope.page.pageNo}"> 页
    <input id="searchBtn" type="button" value="确定" class="layui-btn">
</div>
