<%-- 
    Document   : signup_
    Created on : 08-Apr-2023, 12:04:06 pm
    Author     : Radhika Swaminathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styling.css">
   
	<title>PAYROLL</title>
</head>
<body>
    <form method="get" action="InsertDataServlet" target='_blank'>
    <div id="container" >
        <div id="left" class="side">
            <h3 id="head1">EMPLOYEE DETAILS:</h3>
            <label>EMPLOYEE CODE: <input type="text" id="code" size="25px" name='code'></label>
            <label>DESIGNATION: <input type="text" id="des" size="25px" name='des'></label>
            <label>EMPLOYEE D.O.B: <input type="date" id="dob" size="25px" name='dob'></label>
            <label>EMPLOYEE NAME: <input type="text" id="name" size="25px" name='name'></label>
            <label>EMPLOYEE D.O.J: <input type="date" id="doj" size="25px" name='doj'></label>
            <label>EMPLOYEE AGE: <input type="number" id="age" size="25px" name='age'></label>
            <label>EXPERIENCE: <input type="number" id="exp" size="25px" name='exp'></label>
            <label>GENDER: <input type="text" id="gen" size="25px" name='gen'></label>
            <label>PROOF ID: <input type="text" id="id1" size="25px" name='id'></label>
            <label>EMPLOYEE EMAIL: <input type="email" id="email" size="25px" name='email'></label>
            <label>CONTACT: <input type="text" id="num" size="25px" name='num'></label>
            <label>HIRED LOCATION: <input type="text" id="loc" size="25px" name='loc'></label>
            <label>EMPLOYEE STATUS: <input type="text" id="stat" size="25px" name='stat'></label>
            <label>ADDRESS: <textarea rows="5" cols="40" id="add" name='add'></textarea></label>
        </div>
        <div id="right" class="side">
            <div id="righttop">
                <h3 id="head2">EMPLOYEE SALARY DETAILS:</h3>
                <label>Month and Year: <input type="month" id="mon" size="10px" name='mon'></label>
                <label>Date: <input type="number" id="dat" size="10px" name='dat'></label>
                <label>Total Days: <input type="number" id="day" size="10px" name='day'></label>
                <label>Absence: <input type="number" id="abs" size="10px" name='abs'></label>
                <label>Medical: <input type="number" id="med" size="10px" name='med'></label>
                <label>PF: <input type="text" id="pf" size="10px" name='pf'></label>
                <label>Conveyance: <input type="text" id="con" size="10px" name='con'></label>
                <!--
                <button type='submit' id="sav" name="action" value="Save">Save</button>
                <button type='reset' id="clr" name="action" value="Clear">Clear</button>
                <button type='submit' id="up" name="action" value="Update">Update</button>
                <button type='submit' id="del" name="action" value="Delete">Delete</button>
                <button type='submit' id="dis" name="action" value="Display">Display</button>
                -->
            </div>
            <div id="rightbottom">
                <button type='submit' class="but" id="sav" name="action" value="Save">Save</button>
                <button type='reset' class="but" id="clr" name="action" value="Clear">Clear</button>
                <button type='submit' class="but" id="up" name="action" value="Update">Update</button>
                <button type='submit' class="but" id="del" name="action" value="Delete">Delete</button>
                <button type='submit' class="but" id="dis" name="action" value="Display">Display</button>
            </div>
        </div>
    </div>
    </form>
</body>
</html>