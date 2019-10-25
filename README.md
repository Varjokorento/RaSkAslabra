# RaSkaslabra

## Projektin kuvaus

Tämä sovelluksen tarkoitus on implementoida RSA-salaus algoritmi Java-ohjelmointikielellä. 

[Release 1.0](https://github.com/Varjokorento/RaSkAslabra/releases/tag/1.0)

## Projektin tavoite:

Tavoitteena on saada aikaan ohjelma, joka tekee seuraavat asiat: 

    1. Saatuaan tekstisyötteen se salaa sen RSA-salauksella
    2. Tekstisyötteen voi purkaa yksityisellä avaimella.
    
## Käyttöohje

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

### Ohjelman ajo

Ohjelman voi ladata Release-linkistä. Ohjelma on suoritettava jar-tiedosto. 

[Release 1.0](https://github.com/Varjokorento/RaSkAslabra/releases/tag/1.0)


```
java -jar *jartiedoston_nimi*.jar
```

### Ohjelman käyttö

Ohjelmaan voi syöttää lyhyitä, maksimissaan 40 merkkiä pitkiä, tekstipätkiä, jotka ohjelma sitten salaa numeroiksi. Syöttämällä "exit" ohjelma lopettaa suorituksen.
    
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
 
 


