<%-- 
    Document   : about
    Created on : 07-Apr-2023, 9:52:15 pm
    Author     : Radhika Swaminathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About</title>
    <style>
        body{
            position:relative;
        }
        #myVideo {
  position: fixed;
  right: 0;
  bottom: 0;
  min-width: 100%;
  min-height: 100%;
 
}
        .mission{
            background-color: burlywood;
            text-align: center;
            color:white;
            position:absolute;
            font-size: 30px;
             background:transparent;
             font-family: cursive;
        }
        .mission h{
             font-size:50px;
             color:crimson;
             
        }
        .members{
            background:transparent;
            color:turquoise;
            font-size:30px;
            position:absolute;
            top:300px;
            left:600px;
            font-family: cursive;
        }
       .members h{
        color:crimson;
        font-size: 50px;

       }
      
    </style>
</head>
<body>
    <video autoplay muted loop id="myVideo">
        <source src="backv.mp4" type="video/mp4">
      </video>
    <div class="mission">
        <h>OUR MISSION</h>
        <p> Technology that propels productivity is always at the forefront
            Our mission is to help you to achieve greater levels of speed,
            responsiveness, and productivity by bringing service and asset 
            management together in one platform with AI-driven knowledge intelligence.</p>
       </div>
       <div class="members">
        <h>MEMBERS</h>
        <p>1.Pooja B</p>
        <p>2.Poojaa G</p>
        <p>3.Praiseline J</p>
        <p>4.Radhika Swaminathan</p>
        <p>5.PVS Deepti</p>
       </div>
        

   
</body>
</html>
