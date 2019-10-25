# RaSkaslabra

## Projektin kuvaus

Tämä sovelluksen tarkoitus on implementoida RSA-salaus algoritmi Java-ohjelmointikielellä. 

[Release 1.0](https://github.com/Varjokorento/RaSkAslabra/releases/tag/1.0)

## Projektin tavoite:

Tavoitteena on saada aikaan ohjelma, joka tekee seuraavat asiat: 

    1. Saatuaan tekstisyötteen se salaa sen RSA-salauksella
    2. Tekstisyötteen voi purkaa yksityisellä avaimella.
    
## Käyttöohje


### Ohjelman ajo

Ohjelman voi ladata Release-linkistä. Ohjelma on suoritettava jar-tiedosto. Ohjelmaa on testattu OSX- sekä Windows-ympäristöissä.

[Release 1.0](https://github.com/Varjokorento/RaSkAslabra/releases/tag/1.0)


```
java -jar *jartiedoston_nimi*.jar
```

### Ohjelman käyttö

Ohjelmaan voi syöttää lyhyitä, maksimissaan 40 merkkiä pitkiä, tekstipätkiä, jotka ohjelma sitten salaa numeroiksi. Syöttämällä "exit" ohjelma lopettaa suorituksen.

### Tunnetut bugit

Ohjelma ei tue ääkkösiä.

Ohjelmassa on olemassa bugi, joka aiheuttaa sen jäätymisen. Uskoisin sen johtuvan alkukugeneroinnista, jossa ohjelma jää ikuiseen looppiin. Tätä bugia en kuitenkaan ole onnistunut toistamaan luotettavasti enkä myöskään sen juurisyitä ole löytänyt. Tämän tapahtuessa ainoa tapa ratkaista se on lopettaa ohjelman suorittaminen ja yrittää uudelleen.  

Mvn test -komento on joskus jäätynyt. Uskoisin tämän johtuvan alkulukugeneroinnista. 

Ohjelma on myös melko raskas, joten hitaammilla koneilla ohjelma on jäätynyt suurilla syötteillä.  
    

### Testaus

Testit suoritetaan komennolla. Varoitus: Testit vievät jonkin aikaa. 

```
mvn test
```
Jacoco generoidaan seuraavalla komennolla (Sijaitsee target/site-kansiossa)
```
mvn jacoco:report
```

### Checkstyle

Checkstyle-raportti luodaan komennolla

```
mvn jxr:jxr checkstyle:checkstyle
```
Ohjelman BigInteger-luokan checkstyle-virheet on jätetty koodiin. Tämä sen vuoksi, että refaktoroituna nuo allekkain laskettavat metodit olivat hyvin vaikeita luettavia. 

 ## Dokumentaatio
 
 [Määritysdokumentti](https://github.com/Varjokorento/RaSkAslabra/blob/master/docs/Maarittelydokumentti/Maarittelydokumentti.md)       
 [Toteutusdokumentti](https://github.com/Varjokorento/RaSkAslabra/blob/master/docs/Toteutusdokumentti/toteutusdokumentti.md)    
[Testausdokumentti](https://github.com/Varjokorento/RaSkAslabra/blob/master/docs/Testausdokumentti/testausdokumentti.md)

[Javadoc](https://varjokorento.github.io/RaSkAslabra/javadocs/)
    
## Viikkopalautukset

 [Viikkopalautus1](https://github.com/Varjokorento/RaSkAslabra/blob/master/Dokumentaatio/Viikkopalautukset/Viikkopalautus1.md)
 
 [Viikkopalautus2](https://github.com/Varjokorento/RaSkAslabra/blob/master/Dokumentaatio/Viikkopalautukset/Viikkopalautus2.md)
 
 [Viikkopalautus3](https://github.com/Varjokorento/RaSkAslabra/blob/master/Dokumentaatio/Viikkopalautukset/Viikkopalautus3.md)
 
 [Viikkopalautus4](https://github.com/Varjokorento/RaSkAslabra/blob/master/Dokumentaatio/Viikkopalautukset/Viikkopalautus4.md)
 
 [Viikkopalautus5](https://github.com/Varjokorento/RaSkAslabra/blob/master/Dokumentaatio/Viikkopalautukset/Viikkopalautus5.md)
 
 [Viikkopalautus6](https://github.com/Varjokorento/RaSkAslabra/blob/master/Dokumentaatio/Viikkopalautukset/Viikkopalautus6.md)
 
 


