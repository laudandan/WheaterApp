# Wheather Application

Aceasta este o implementare a unei aplicatiei web ce afiseaza cateva caracteristici despre vreme in functie de orasul selectat.

##How To Use

Se configureaza un fisier cu formatul:

ID   |   nm  | countryCode
819827 | Razvilka | RU
524901 | Moscow | RU
2973393 | Tarascon | FR
2986678 | Ploufragan | FR

si denumirea orase.txt.

##Descripton

Aplicatia foloseste un API de la OpenWeatherMap in care face o cerere http cu id-ul orasului pentru a obtine un buffer de tip json cu datele despre vreme.
De acolo sunt preluate datele si afisate intr-un TextBox. Orasele de unde se poate face selectia trebuie sa fie configurate intr-un fisier de intrare cu id-ul unic
al orasului.
Aplicatia ruleaza cu interfata grafica folosind javafx si fxml.

## Link of API OpenWeatherMap
[OpenWeatherMap](https://openweathermap.org/current)