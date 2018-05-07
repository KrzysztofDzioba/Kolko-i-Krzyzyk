### How to run:
1. Download project
2. mvn clean install
3. java -jar target/xogame-1.1.jar
4. Enjoy!

## Estymaty dostarczonych funkcjonalności

|Data  |Pesymistyczna|Realistyczna|Optymistyczna|
:-------------------:|:-------------------:|:-------------------|-------------------:
|25.04| 1 - 3 | 1 - 4 | 1-5 
|26.04| 4 - 7 | 5 - 8 | 6 - 9
|27.04| 8 - 11 | 9 - 14 | 10 - 16
|30.04| 12 - 16 | 15 - 19 | 17 - 21
|01.05| 17 - 20 | 19 - 21 | X
|02.05| 21 | X | X

#### Lista funkcjonalności:
1. Nadanie graczom imion na początku gry
2. Graczowi przydzine są jego symbole (X lub O) w trakcie ich tworzenia
3. Program pyta, który gracz ma zacząć
4. Gracz potrafi ustalić szerokość planszy na początku sesji gry
5. Gracz wprowadza ile znaków musi być z rzędu, aby nastąpiła wygrana
6. Program sprawdza, czy przy podanych wymiarach możliwe jest uzyskanie określonej ilości znaków pod rząd. Jeśli nie – prosi o ilość znaków do wygranej raz jeszcze
7. Przed ruchem wyświetlany jest komunikat, czyj jest ruch
8. Program potrafi parsować dane wejściowe gracza na odpowiednie koordynaty
9. Gracz potrafi wstawić w planszę swój znak
10. Wygrana następuje gdy ustalona ilosc znakow jest pod rzad na planszy
11. Następuje remis I przydzielenie punktów, gdy brak już wolnych miejsc na planszy I nikt nie wygrał
12. Po zakończeniu gry wyświetlany jest napis, kto wygrał
13. Po wygranej grze przez gracza, przydzielam mu 3 punkty
14. Po zremisowaniu gry, gracze dostają po 1 punkcie
15. Gracz potrafi się poddać w trakcie swojego ruchu
16. Pytanie o to kto zaczyna, jest tylko raz. Potem kolejność jest na przemian
17. Gdy gracz wygrał 2x z rzędu, nastęþuje koniec sesji
18. Rozgrywka kończy się po 3 rundach
19. Po zakończeniu sesji, wyświetlany jest napis kto wygrał lub że jest remis
20. Wiadomośći są pokazywane w odpowiednim języku
21. Drukowanie odpowiedniego widoku planszy

