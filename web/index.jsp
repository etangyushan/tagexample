<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@ taglib uri="demotag" prefix="demo" %>
<html>
<body>
<br>
<demo:loop counts="5"> ����ʱ���ǣ�<%=new java.util.Date().toString()%>
  <br>
</demo:loop>
<br>
</body>
</html>