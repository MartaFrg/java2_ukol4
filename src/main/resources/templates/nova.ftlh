[#ftl]
[#import "/spring.ftl" as spring]
<!DOCTYPE html>
<html lang="cs">
<head>
    <meta charset="UTF-8">
    <title>Nová vizitka</title>
    <link rel="stylesheet" href="/style.css"/>
</head>
<body>
<div class="container">
    <form class="vizitka--nova" action="/" method="post">
        <h1>Přidání vizitky</h1>

        <label for="jmeno" class="radek">Jméno a příjmení:</label>
        [@spring.formInput path="vizitka.jmeno" /]
        <div class="error">[@spring.showErrors "<br>"/]</div>

        <label for="firma" class="radek">Firma:</label>
        [@spring.formInput path="vizitka.firma"/]
        <div class="error">[@spring.showErrors "<br>"/]</div>

        <label for="ulice" class="radek">Ulice:</label>
        [@spring.formInput path="vizitka.ulice" /]
        <div class="error">[@spring.showErrors "<br>"/]</div>

        <label for="obecPsc" class="radek">Firma:</label>
        [@spring.formInput path="vizitka.obecPsc"/]
        <div class="error">[@spring.showErrors "<br>"/]</div>

        <label for="email" class="radek">E-mail:</label>
        [@spring.formInput path="vizitka.email" fieldType="email" /]
        <div class="error">[@spring.showErrors "<br>"/]</div>

        <div class="radek controls">
            <button type="submit">Přidat</button>
        </div>
    </form>
</div>
</body>
</html>