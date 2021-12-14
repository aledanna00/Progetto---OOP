<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title>Ciaooo</title>
    </head>
    <body>
        <form method="post" action="">
            Inserisci<br>
            <input type="text" name="parametro"><br>
            <input type="submit" value="Invia Modulo">
        </form>

        <?php
        $param = $_POST['parametro'];
        echo "<a href='http://localhost:8080/stats/minimo?Estensione=$param'>Click here</a>";
        ?>


    </body>
</html>
