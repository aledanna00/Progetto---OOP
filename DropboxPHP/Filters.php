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
                width: 300px;
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
                <tr><td> <img src="logo.png" class="droplogo"> </td> <td><h1 class="p2">  Welcome to the Filters Page </h1> </td> <td> <img src="logo.png" class="droplogo"></td></tr>
            </table>
            <h3 class="p2"> In questa pagina puoi visualizzare le Statistiche nel Dropbox</h3>
            <br>
            <br>
        </div>

        <table style="border-color: black; align-content: center; width: 70%; background-color: white " align='center'>
            <tr style="background-color: white; border-bottom-color: white" align='center'>

                <td> <button class="button" onclick="document.getElementById('FilterExt').style.display = 'block'"> Filtra per Estensione </button> </form></td>

                <td> <button class="button" onclick="document.getElementById('FilterDate').style.display = 'block'"> Filtra per Data </button></form>

                <td> <button class="button" onclick="document.getElementById('FilterExtAndDate').style.display = 'block'"> Filtra per Data ed Estensione</button> </form></td>
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





        <div id="FilterExt" class="modal">

            <form class="modal-content animate" action="" method="post" name="FilterExt">
                <div class="imgcontainer">
                    <span onclick="document.getElementById('FilterExt').style.display = 'none'" class="close" title="Close Modal">&times;</span>

                </div>
                <h2 style="color: black" align='center'>  </h2>
                <br>
                <br>
                <div class="FrameStatsCreation" align="center">

                    <h2> Filtra i File nel Dropbox in base alla loro Estensione </h2>
                    <h3> Qui sotto sono riportati i file che corrispondono all'estensione selezionata</h3>
                    <br>
                    <br>
                    <h3>Inserire qui l'estensione (es .txt) </h3><br>
                    <input type="text" name="estensione"><br>
                    <button class="button" type="submit""> Cerca </button>
                </div>
                <?php
                    $param1 = $_POST['estensione'];

                    if (isset($_POST['estensione'])) {
                        //echo 'Il valore Massimo è:';
                        //echo "<iframe src='http://localhost:8080/stats/massimo?Estensione=$param1' width='100%' height='100' style='border:none;' align='center'></iframe>";
                        $url = "http://localhost:8080/filter/extention?Estensione=$param1";
                        $get = file_get_contents($url);
                        $prima = '{ "lista": ';
                        $dopo = '}';
                        $getnuovo = $prima . $get . $dopo;
                        $json_decodato = json_decode($getnuovo);
                        //var_dump($json_decodato, true);
                        //echo $json_decodato;
                        //echo sizeof($json_decodato->lista);
                        echo '<table class="tabella" align="center">';
                        echo '<tr class="tabella"> <td class="tabella"> Tag </td><td class="tabella"> Name </td>  <td class="tabella">Estensione</td> <td class="tabella"> Id </td> <td class="tabella"> Ultima modifica</td> <td class="tabella"> Data Creazione </td> <td class="tabella"> Size </td>   </tr>';
                        
                        for ($i = 0; $i < sizeof($json_decodato->lista); $i++) {

                            $tag = $json_decodato->lista[$i]->tag;
                            $name = $json_decodato->lista[$i]->name;
                            $estensione = $json_decodato->lista[$i]->estensione;
                            $id = $json_decodato->lista[$i]->id;
                            $client_modified = $json_decodato->lista[$i]->client_modified;
                            $server_modified = $json_decodato->lista[$i]->server_modified;
                            $size = $json_decodato->lista[$i]->size;

                            echo "<tr class='tabella'><td> $tag </td><td> $name </td>  <td>$estensione</td> <td> $id </td> <td> $client_modified</td> <td> $server_modified </td> <td> $size </td>   </tr>";
                        }
                    }
                    ?>
                </table>
            </form>
        </div>



        <div id="FilterDate" class="modal">

            <form class="modal-content animate" action="" method="post" name="FilterDate">
                <div class="imgcontainer">
                    <span onclick="document.getElementById('FilterDate').style.display = 'none'" class="close" title="Close Modal">&times;</span>

                </div>
                <h2 style="color: black" align='center'>  </h2>
                <br>
                <br>
                <div class="FrameStatsCreation" align="center">

                    <h2> Filtra i File nel Dropbox in base alla loro Data di Creazione </h2>
                    <h3> Qui sotto sono riportati i file che corrispondono alla data selezionata</h3>
                    <br>
                    <br>
                    <h3>Inserire qui la data (es 2021-12-08) </h3><br>
                    <input type="text" name="estensione"><br>
                    <button class="button" type="submit""> Cerca </button>
                </div>
               <?php
                    $param1 = $_POST['estensione'];

                    if (isset($_POST['estensione'])) {
                        //echo 'Il valore Massimo è:';
                        //echo "<iframe src='http://localhost:8080/stats/massimo?Estensione=$param1' width='100%' height='100' style='border:none;' align='center'></iframe>";
                        $url = "http://localhost:8080/filter/date?Data=$param1";
                        $get = file_get_contents($url);
                        $prima = '{ "lista": ';
                        $dopo = '}';
                        $getnuovo = $prima . $get . $dopo;
                        $json_decodato = json_decode($getnuovo);
                        //var_dump($json_decodato, true);
                        //echo $json_decodato;
                        //echo sizeof($json_decodato->lista);
                        echo '<table class="tabella" align="center">';
                        echo '<tr class="tabella"> <td class="tabella"> Tag </td><td class="tabella"> Name </td>  <td class="tabella">Estensione</td> <td class="tabella"> Id </td> <td class="tabella"> Ultima modifica</td> <td class="tabella"> Data Creazione </td> <td class="tabella"> Size </td>   </tr>';
                        
                        for ($i = 0; $i < sizeof($json_decodato->lista); $i++) {

                            $tag = $json_decodato->lista[$i]->tag;
                            $name = $json_decodato->lista[$i]->name;
                            $estensione = $json_decodato->lista[$i]->estensione;
                            $id = $json_decodato->lista[$i]->id;
                            $client_modified = $json_decodato->lista[$i]->client_modified;
                            $server_modified = $json_decodato->lista[$i]->server_modified;
                            $size = $json_decodato->lista[$i]->size;

                            echo "<tr><td> $tag </td><td> $name </td>  <td>$estensione</td> <td> $id </td> <td> $client_modified</td> <td> $server_modified </td> <td> $size </td>   </tr>";
                        }
                    }
                    ?>
                </table>
            </form>
        </div>

        <div id="FilterExtAndDate" class="modal">

            <form class="modal-content animate" action="" method="post" name="FilterExtAndDate">
                <div class="imgcontainer">
                    <span onclick="document.getElementById('FilterExtAndDate').style.display = 'none'" class="close" title="Close Modal">&times;</span>

                </div>
                <h2 style="color: black" align='center'>  </h2>
                <br>
                <br>
                <div class="FrameStatsCreation" align="center">

                    <h2> Filtra i File nel Dropbox in base alla loro Data di Creazione e alla loro Estensione</h2>
                    <h3> Qui sotto sono riportati i file che corrispondono alla Data e all'Estensione selezionate</h3>
                    <br>
                    <br>
                    <h3>Inserire qui l'Estensione (es .txt) </h3><br>
                    <input type="text" name="estensione"><br>
                    <h3>Inserire qui la data (es 2021-12-08) </h3><br>
                    <input type="text" name="data"><br>
                    <button class="button" type="submit""> Cerca </button>
                </div>


               <?php
                    $paramEst = $_POST['estensione'];
                    $paramData = $_POST['data'];
                    if (isset($_POST['estensione'])) {
                        //echo 'Il valore Massimo è:';
                        //echo "<iframe src='http://localhost:8080/stats/massimo?Estensione=$param1' width='100%' height='100' style='border:none;' align='center'></iframe>";
                        $url = "http://localhost:8080/filter/ext_and_date?Estensione=$paramEst&Data=$paramData";
                        $get = file_get_contents($url);
                        $prima = '{ "lista": ';
                        $dopo = '}';
                        $getnuovo = $prima . $get . $dopo;
                        $json_decodato = json_decode($getnuovo);
                        //var_dump($json_decodato, true);
                        //echo $json_decodato;
                        //echo sizeof($json_decodato->lista);
                        echo '<table class="tabella" align="center">';
                        echo '<tr class="tabella"> <td class="tabella"> Tag </td><td class="tabella"> Name </td>  <td class="tabella">Estensione</td> <td class="tabella"> Id </td> <td class="tabella"> Ultima modifica</td> <td class="tabella"> Data Creazione </td> <td class="tabella"> Size </td>   </tr>';
                        for ($i = 0; $i < sizeof($json_decodato->lista); $i++) {

                            $tag = $json_decodato->lista[$i]->tag;
                            $name = $json_decodato->lista[$i]->name;
                            $estensione = $json_decodato->lista[$i]->estensione;
                            $id = $json_decodato->lista[$i]->id;
                            $client_modified = $json_decodato->lista[$i]->client_modified;
                            $server_modified = $json_decodato->lista[$i]->server_modified;
                            $size = $json_decodato->lista[$i]->size;

                            echo "<tr><td> $tag </td><td> $name </td>  <td>$estensione</td> <td> $id </td> <td> $client_modified</td> <td> $server_modified </td> <td> $size </td>   </tr>";
                        }
                    }
                    ?>
                </table>
            </form>
        </div>

    </body>
</html>
