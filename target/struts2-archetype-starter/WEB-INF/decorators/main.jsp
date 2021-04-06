<!DOCTYPE html PUBLIC
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title><decorator:title default="Struts Starter"/></title>
    <link href="<s:url value='/styles/main.css'/>" rel="stylesheet" type="text/css" media="all"/>
    <decorator:head/>
</head>
<body id="page-home">
    <div id="page">
        <div id="header" class="clearfix">
        	Login application
            <hr />
        </div>
        
        <div id="content" class="clearfix">
            <div id="main">
            	<h3>Main Content</h3>
                <s:form action="loginActivity">
                    <s:textfield label="Username" name="username" />
                    <s:textfield label="Password " name="password" />
                    <s:submit />
                </s:form>
                <hr />
            </div>
            
            <div id="sub">
            	<h3>Sub Content</h3>
            </div>
        </div>

</body>
</html>
