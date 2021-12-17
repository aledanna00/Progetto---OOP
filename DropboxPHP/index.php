<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title>Home Page DropboxStatistics</title>

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
                font-family: Arial, Helvetica, sans-serif;
            }
            .p2 {
                font-family: Arial, Helvetica, sans-serif;
            }
            .droplogo{
                
                height: 100px;
                width: 150px;
            }
        </style>
    </head>
    <body>
        <div align="center">
            <br>
            <br>
            <table>
                <tr><td> <img src="logo.png" class="droplogo"> </td> <td><h1 class="p2">  Welcome to the Home Page </h1> </td> <td> <img src="logo.png" class="droplogo"></td></tr>
            </table>
            <h3 class="p2"> In questa pagina puoi visualizzare le Statistiche e i Filtri disponibili per il Dropbox</h3>
            <br>
            <br>
        </div>
        <br>
        <br>
        <br>
        <table style="border-color: black; align-content: center; width: 70%; background-color: white " align='center'>
            <tr style="background-color: white; border-bottom-color: white" align='center'>

                <td> <form method="" action="Statistics.php" align="center"> <button class="button"> Statistiche </button> </form></td>

                <td> <form method="" action="Filters.php" align="center"> <button class="button"> Filtri </button></form> </td>

            </tr>

        </table>

    </body>
</html>
