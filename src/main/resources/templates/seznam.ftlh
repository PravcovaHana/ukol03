[#ftl]
<!DOCTYPE html>
<html lang="cs">
<head>
    [#include "_common/head.ftlh"]
</head>
<body>
<div class="seznam">
    [#list vizitky as vizitka]
    <a href="/detail/${vizitka.id}">
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
    </a>
    [/#list]

    <a href="/nova">
        <div class="vizitka vizitka--nova">
            <svg width="100" height="100">
                <rect width="20" height="100" x="40" y="0" fill="white"/>
                <rect width="100" height="20" x="0" y="40" fill="white"/>
            </svg>
        </div>
    </a>
</div>
</body>
</html>
