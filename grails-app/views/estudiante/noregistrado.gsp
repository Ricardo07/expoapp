<%--
  Created by IntelliJ IDEA.
  User: ricardo
  Date: 2/4/14
  Time: 10:45 PM
--%>

<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Slick &amp; clean CSS3 Forms Pack</title>
    <meta name="description" content="Slick &amp; clean CSS3 Forms Pack" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Forms stylesheet -->
    <link rel="stylesheet" type="text/css"   href="${resource(dir: 'css', file: 'slick_lf.css')}" media="screen" />
    <!-- / Forms stylesheet -->
    <link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'demo.css')}" media="screen" />
    %{--<!--[if IE 9]>--}%
    %{--<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>--}%
    %{--<script type="text/javascript" src="js/placeholder.js"></script>--}%
    %{--<![endif]-->--}%
    <script type="text/javascript">''</script>
</head>
<body>
<div id="page-2">

    <div class="demo">
        EXPO PUCMM 2014
        <h1>&#x25C2; IMAGINA A DONDE PUEDES LLEGAR! &#x25B8;</h1>
    </div>

    <section id="slick">
        <!-- Login form -->
        <div class="login-form">
            <!-- Title -->
            <div class="title">ERROR al llenar el formulario, inténtelo de nuevo ingresando los datos correctamente.</div>
            <!-- Intro text -->
            %{--<p class="intro"><b>Hi there.</b> Login with your favorite social network or registration account to access our user area and great community!</p>--}%
            <form action="formulario.gsp" name="login" id="login" method="post">
                <!-- Send button -->
                <div class="clrfx mt-20"></div>
                <input type="submit" value="Aceptar" class="send" form="login" name="boton_aceptar" />
                %{--<g:link class="send" action="formulario">hey</g:link>--}%
            </form>
        </div>
    </section>
</div>
</body>
</html>