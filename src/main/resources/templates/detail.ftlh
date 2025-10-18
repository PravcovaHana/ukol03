[#ftl]
<!DOCTYPE html>
<html lang="cs">
<head>
    [#include "_common/head.ftlh"]
</head>
<body>
<div class="detail">
    <form action="[#if idVizitka??]/${idVizitka}[#else]/novaUlozit[/#if]" method="post" class="vizitka">
        <div class="jmeno">
            <input name="jmeno" type="text" value="${(vizitka.jmeno)!""}" placeholder="jmeno" required />
             
            <input name="prijmeni" type="text" value="${(vizitka.prijmeni)!""}" placeholder="prijmeni" required />
        </div>
        <div class="firma">
            <input name="firma" type="text" value="${(vizitka.firma)!""}" placeholder="firma" />
        </div>
        <div class="udaje">
            <div class="adresa">
                <div>
                    <input name="ulice" type="text" value="${(vizitka.ulice)!""}" placeholder="ulice cislo" />
                </div>
                <div><span>
                        <input name="psc" type="text" value="${(vizitka.psc)!""}" placeholder="psc" />
                    </span>
                     
                    <input name="obec" type="text" value="${(vizitka.obec)!""}" placeholder="obec" />
                </div>
            </div>
            <div class="kontakty">
                <div><i class="las la-at"></i> <span><input name="email" type="text" value="${(vizitka.email)!""}" placeholder="email" /></span></div>
                <div><i class="las la-phone-alt"></i> <span><input name="telefon" type="text" value="${(vizitka.telefon)!""}" placeholder="telefon" /></span></div>
                <div><i class="las la-globe"></i> <span><input name="web" type="text" value="${(vizitka.web)!""}" placeholder="web" /></span></div>
            </div>
        </div>
        <div class="tlacitko">
            <button type="submit" class="btn btn-primary">Uložit</button>
        </div>
    </form>

    [#if idVizitka??]
        <div style="display: inline-block; margin-top: 5px;">
            <form action="/delete" method="post" class="d-inline">
                <input type="hidden" name="id" value="${idVizitka}"/>
                <button type="submit" class="btn btn-primary">Smazat</button>
            </form>
        </div>
    [/#if]

    [#if vizitka.celaAdresa??]
        <div class="mapa">
            <iframe style="border:none" src="https://frame.mapy.cz/?q=${vizitka.celaAdresa?url("UTF-8")}" width="100%" height="100%" frameborder="0"></iframe>
        </div>
    [/#if]

    <nav>
        <a href="/">◂ zpět na seznam</a>
    </nav>
</div>
</body>
</html>
