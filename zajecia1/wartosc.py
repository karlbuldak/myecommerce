def oblicz_wartosc_netto(wartosc_brutto, stawka_podatku):
    wartosc_netto = wartosc_brutto+wartosc_brutto*stawka_podatku/100
    return(wartosc_netto)