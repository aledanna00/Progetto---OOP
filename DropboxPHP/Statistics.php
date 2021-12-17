<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title> Statistiche Dropbox</title>

        <style>
            .button {
                background-color: #6797cf; /* Green */
                border: 2px solid black;
                color: black;
                padding: 20px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 18px;
                margin: 4px 2px;
                cursor: pointer;
                border-radius: 12px;
                width: 200px;
            }
            .imgcontainer {
                text-align: center;
                margin: 24px 0 12px 0;
                position: relative;

            }

            img.avatar {
                width: 40%;
                border-radius: 50%;
            }

            .container {
                padding: 16px;
            }

            span.psw {
                float: right;
                padding-top: 16px;
            }

            /* The Modal (background) */
            .modal {
                display: none; /* Hidden by default */
                position: fixed; /* Stay in place */
                z-index: 1; /* Sit on top */
                left: 0;
                top: 0;
                width: 100%; /* Full width */
                height: 100%; /* Full height */
                overflow: auto; /* Enable scroll if needed */
                background-color: rgb(0,0,0); /* Fallback color */
                background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
                padding-top: 60px;
                padding-left: 30px;
                padding-right: 30px;
            }

            /* Modal Content/Box */
            .modal-content {
                background-color: white;
                margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
                border: 3px solid black;
                border-color: black;
                width: 80%; /* Could be more or less, depending on screen size */
                border-radius: 15px;
                padding-bottom: 60px;
                padding-left: 30px;
                padding-right: 30px;
            }

            /* The Close Button (x) */
            .close {
                position: absolute;
                right: 25px;
                top: 0;
                color: red;
                font-size: 35px;
                font-weight: bold;
            }

            .close:hover,
            .close:focus {
                color: red;
                cursor: pointer;
            }

            /* Add Zoom Animation */
            .animate {
                -webkit-animation: animatezoom 0.6s;
                animation: animatezoom 0.6s
            }

            @-webkit-keyframes animatezoom {
                from {-webkit-transform: scale(0)} 
                to {-webkit-transform: scale(1)}
            }

            @keyframes animatezoom {
                from {transform: scale(0)} 
                to {transform: scale(1)}
            }

            /* Change styles for span and cancel button on extra small screens */
            @media screen and (max-width: 300px) {
                span.psw {
                    display: block;
                    float: none;
                }
                .cancelbtn {
                    width: 100%;
                }
            }
            .FrameStatsCreation {
                align-items: center;
                align-content: center;
                width: auto;
            }
            .tabella2{
                padding: 10px;
            }

            .tabella{
                padding-left: 15px;
                padding-right: 15px;
                border: 2px solid black;
                align-content: center;
                width: auto;
            }
            .p2{
                font-family: Arial, Helvetica, sans-serif;
            }
            .droplogo{
                height: 100px;
                width: 150px;
            }
            input[type=text], input[type=password] {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }
        </style>
    </head>
    <body>


        <div align="center">
            <table>
                <tr><td> <img src="logo.png" class="droplogo"> </td> <td><h1 class="p2">  Welcome to the Statistics Page </h1> </td> <td> <img src="logo.png" class="droplogo"></td></tr>
            </table>
            <h3 class="p2"> In questa pagina puoi visualizzare le Statistiche nel Dropbox</h3>
            <br>
            <br>
        </div>

        <table style="border-color: black; align-content: center; width: 70%; background-color: white " align='center'>
            <tr style="background-color: white; border-bottom-color: white" align='center'>

                <td> <button class="button" onclick="document.getElementById('StatsMin').style.display = 'block'"> Stats Dimensione Minima File</button> </form></td>

                <td> <button class="button" onclick="document.getElementById('StatsMax').style.display = 'block'"> Stats Dimensione Massima File </button></form>

                <td> <button class="button" onclick="document.getElementById('StatsAvg').style.display = 'block'"> Stats Dimensione Media File</button> </form></td>

                <td> <button class="button" onclick="document.getElementById('StatsCreation').style.display = 'block'"> Stats Data di Creazione dei File </button> </td>
            </tr>
        </table>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <table style="border-color: black; align-content: center; width: 70%; background-color: white " align='center'>
            <tr style="background-color: white; border-bottom-color: white" align='center'>

                <td> <form method="" action="index.php" align="center"> <button class="button"> Torna alla Home </button></form> </td>

            </tr>   
        </table>







        <div id="StatsMin" class="modal">

            <form class="modal-content animate" action="" method="post" name="StatsMin">
                <div class="imgcontainer">
                    <span onclick="document.getElementById('StatsMin').style.display = 'none'" class="close" title="Close Modal">&times;</span>

                </div>
                <h2 style="color: black" align='center'>  </h2>
                <br>
                <br>
                <div class="FrameStatsCreation" align="center">

                    <h2> Statistiche sulla Dimensione Minima dei File </h2>
                    <h3> Qui sotto è riportata la dimensione minima dei file, cercati per tipo di file </h3>
                    <br>
                    <br>
                    <h3>Inserire qui l'estensione (es .txt) dei file di cui si vuole conoscere la dimensione minima</h3><br>
                    <input type="text" name="estensione"><br>
                    <button class="button" type="submit""> Cerca </button>
                </div>
                <?php
                $param = $_POST['estensione'];

                if (isset($_POST['estensione'])) {
                    echo 'Il valore Minimo è:';
                    //echo "<iframe src='http://localhost:8080/stats/massimo?Estensione=$param1' width='100%' height='100' style='border:none;' align='center'></iframe>";
                    $url = "http://localhost:8080/stats/minimo?Estensione=$param";
                    $get = file_get_contents($url);
                    echo $get;
                }
                ?>
            </form>
        </div>



        <div id="StatsMax" class="modal">

            <form class="modal-content animate" action="" method="post" name="StatsMax">
                <div class="imgcontainer">
                    <span onclick="document.getElementById('StatsMax').style.display = 'none'" class="close" title="Close Modal">&times;</span>

                </div>
                <h2 style="color: black" align='center'>  </h2>
                <br>
                <br>
                <div class="FrameStatsCreation" align="center">

                    <h2> Statistiche sulla Dimensione Massima dei File </h2>
                    <h3> Qui sotto è riportata la dimensione massima dei file, cercati per tipo di file </h3>
                    <br>
                    <br>
                    <h3>Inserire qui l'estensione (es .txt) dei file di cui si vuole conoscere la dimensione massima</h3><br>
                    <input type="text" name="estensione"><br>
                    <button class="button" type="submit""> Cerca </button>
                </div>


                <?php
                $param1 = $_POST['estensione'];

                if (isset($_POST['estensione'])) {
                    echo 'Il valore Massimo è:';
                    //echo "<iframe src='http://localhost:8080/stats/massimo?Estensione=$param1' width='100%' height='100' style='border:none;' align='center'></iframe>";
                    $url = "http://localhost:8080/stats/massimo?Estensione=$param1";
                    $get = file_get_contents($url);
                    echo $get;
                }
                ?>

            </form>
        </div>

        <div id="StatsAvg" class="modal">

            <form class="modal-content animate" action="" method="post" name="StatsAvg">
                <div class="imgcontainer">
                    <span onclick="document.getElementById('StatsAvg').style.display = 'none'" class="close" title="Close Modal">&times;</span>

                </div>
                <h2 style="color: black" align='center'>  </h2>
                <br>
                <br>
                <div class="FrameStatsCreation" align="center">

                    <h2> Statistiche sulla Dimensione Massima dei File </h2>
                    <h3> Qui sotto è riportata la dimensione media dei file, cercati per tipo di file </h3>
                    <br>
                    <br>
                    <h3>Inserire qui l'estensione (es .txt) dei file di cui si vuole conoscere la dimensione media</h3><br>
                    <input type="text" name="estensione"><br>
                    <button class="button" type="submit""> Cerca </button>
                </div>
                <?php
                $param2 = $_POST['estensione'];

                if (isset($_POST['estensione'])) {
                    echo 'Il valore Medio è:';
                    //echo "<iframe src='http://localhost:8080/stats/massimo?Estensione=$param1' width='100%' height='100' style='border:none;' align='center'></iframe>";
                    $url = "http://localhost:8080/stats/media?Estensione=$param2";
                    $get = file_get_contents($url);
                    echo $get;
                }
                ?>
            </form>
        </div>

        <div id="StatsCreation" class="modal">

            <form class="modal-content animate" action="" method="post" name="StatsCreation">
                <div class="imgcontainer">
                    <span onclick="document.getElementById('StatsCreation').style.display = 'none'" class="close" title="Close Modal">&times;</span>

                </div>
                <h2 style="color: black" align='center'>  </h2>
                <br>
                <br>
                <div class="FrameStatsCreation" align="center">

                    <h2> Statistiche sulla Creazione dei File </h2>
                    <h3> Qui sotto è riportato il mese nel quale sono stati creati il maggior numero di file </h3>
                    <br>
                    <br>
                    <br>

                    <?php
                    //echo "<iframe src='http://localhost:8080/stats/massimo?Estensione=$param1' width='100%' height='100' style='border:none;' align='center'></iframe>";
                    $url = "http://localhost:8080/stats/creation";
                    $get = file_get_contents($url);
                    echo $get;
                    ?> 
                </div>
            </form>
        </div>

    </body>
</html>
