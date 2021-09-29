<!DOCTYPE HTML>

<html lang="hu">
    <head>
        <title>Feldolgozó php</title>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    </head>

    <body>
        <h2>HTML5 ürlap</h2>

        <?php

        echo("<strong>Név:</strong> " . $_POST['nev'] . "<br><br>");
        echo("<strong>PIN kód:</strong> " . $_POST['kod'] . "<br><br>");
        echo("<strong>Gyümölcs:</strong> " . $_POST['gyumolcs'] . "<br><br>");
        echo("<strong>Életkor:</strong> " . $_POST['eletkor'] . "<br><br>");
        echo("<strong>Lábméret:</strong> " . $_POST['labmeret'] . "<br><br>");
        echo("<strong>Önbizalom:</strong> " . $_POST['onbizalom'] . "<br><br>")
        ?>

        <a href="urlap.html">vissza az ürlapra...</a>
    </body>
</html>