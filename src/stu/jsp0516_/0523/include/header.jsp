<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-idth, initial-scale=1">


    <title>Welcome to MyWorld</title>

    <!-- Bootstrap Core CSS -->
    <link href="/MyWeb/css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/MyWeb/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script&display=swap" 
      rel="stylesheet" type="text/css">
   
      

    <!-- jQuery -->
    <script src="/MyWeb/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/MyWeb/js/bootstrap.min.js"></script>





</head>
<body>
 <!-- header -->
    <div class="brand">
       <a href="/MyWeb">My Web</a>
    </div>
    <div class="address-bar">Welcome to MyWorld</div>


    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

                <a class="navbar-brand" href="/Test">My First Web</a>
            </div>


            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">

                    <li>
                        <a href="/MyWeb">HOME</a>
                    </li>
                    <li>
                        <a href="">Member</a>
                    </li>
                    <li>
                        <a href="/MyWeb/list.board">BOARD</a>
                    </li>
            				
            				<%--  22 05 17 ~ --%>
            				<%if(session.getAttribute("user")==null){ %>
            				
            			  <li>
            					<%-- header, footer 는 어디에서든 접근가능해야 되서 절대경로로 적는다(인클루드 되는 파일의 위치가
            					다르기 때문에 ) --%>
                              <a href="/MyWeb/user/5_user_login_0516.jsp">LOGIN</a>
                          </li>
                          <li>
                              <a href="/MyWeb/joinPage.user" style="color:red">JOIN</a>
                          </li>
                          <%}else { %>
         
                           <li>
                              <a href="/MyWeb/user/8_user_logout_0517.jsp">LOGOUT</a>
                          </li>
                          <li>
                              <a href="/MyWeb/user/7_user_mypage_0516.jsp" style="color:red">MYPAGE</a>
                          </li>
   						<%} %>
  
                </ul>
            </div>


            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    <!-- end header -->
</body>
</html>
