<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/adminpage.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Admin Page</title>
</head>

<body>
    <section id="admin">
        <div class="heading">
            
            <h3><i class="fa fa-user-circle-o"></i> Admin Portal</h3> 
        </div>
    </section>
  
    <section>
        <div class="hamburger-menu">
            <input type="checkbox" id="menu-toggle">
            <label for="menu-toggle" class="menu-icon">&#9776;</label>
            <nav class="sidebar">
                <label for="menu-toggle" class="close-icon">&times;</label>
                <ul>
                    <li><a href="home.html">Dashboard</a></li>
                    <li>
                        <a href="logout" class="new-user-link" id="logout">
                            <i class="fa fa-sign-out"></i> Logout
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </section>

    <section id="division">
        <div id="box1" class="box">Doctor Section</div>
        <div id="box2" class="box">Admin Section</div>
        <div id="box3" class="box">Pateint Section</div>
        <div id="box4" class="box">Appointment Section</div>
        
        </section>
        <script>
            document.getElementById("box1").onclick = function () {
                window.location.href = "doctorInfo.html";
            };
            document.getElementById("box2").onclick = function () {
                window.location.href = "adminInfo.jsp";
            };
            document.getElementById("box3").onclick = function () {
                window.location.href = "listPatients";
            };
        </script>
   
</body>

</html>
