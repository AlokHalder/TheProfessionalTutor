<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insert page="/Layout.jsp" flush="true">

<tiles:put name="title" value="Tiles Example" />
   <tiles:put name="header" value="/header.jsp" />
    <tiles:put name="menu" value="/menu.jsp" />
    <tiles:put name="body" value="/body.jsp" />
    <tiles:put name="footer" value="/footer.jsp" />
    <tiles:put name="teaser" value="/teaser.jsp" />
</tiles:insert>