def dodaj_linie(nazwa_pliku, linia):
    with open(nazwa_pliku, 'a') as plik:
        plik.write(linia + '\n')

