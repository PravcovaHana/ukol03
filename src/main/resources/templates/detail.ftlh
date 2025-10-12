[#ftl]
<!DOCTYPE html>
<html lang="cs">
<head>
    <meta charset="UTF-8">
    <title>Vizitkovník</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="icon" type="image/png" href="/images/favicon.png">
</head>
<body>
<div class="detail">
    <div class="vizitka">
        <div class="jmeno">${(vizitka.jmeno)!""} ${(vizitka.prijmeni)!""}</div>
        <div class="firma">${(vizitka.firma)!"neuvedeno"}</div>
        <div class="udaje">
            <div class="adresa">
                <div>${(vizitka.ulice)!""}</div>
                <div><span>${(vizitka.psc)!""}</span> ${(vizitka.obec)!""}</div>
            </div>
            <div class="kontakty">
                <div><i class="las la-at"></i> <span>${(vizitka.email)!"neuvedeno"}</span></div>
                <div><i class="las la-phone-alt"></i> <span>${(vizitka.telefon)!"neuvedeno"}</span></div>
                <div><i class="las la-globe"></i> <span>${(vizitka.web)!"neuvedeno"}</span></div>
            </div>
        </div>
    </div>

    [#if vizitka.celaAdresa??]
    <div class="mapa">
        <iframe style="border:none" src="https://frame.mapy.cz/?q=${vizitka.celaAdresa?url("UTF-8")}" width="100%" height="100%" frameborder="0"></iframe>
    </div>
    [/#if]
</div>
</body>
</html>
