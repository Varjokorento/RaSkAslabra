# RaSkaslabra

## Projektin kuvaus

Tämä sovelluksen tarkoitus on implementoida RSA-salaus algoritmi Java-ohjelmointikielellä. 

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

```
java -jar *jartiedoston_nimi*.jar
```

### Ohjelman käyttö

Ohjelmaan voi syöttää lyhyitä tekstipätkiä, jotka ohjelma sitten salaa numeroiksi. Syöttämällä "exit" ohjelma lopettaa suorituksen.
    
 ## Dokumentaatio
 
 [Määritysdokumentti](https://github.com/Varjokorento/RaSkAslabra/blob/master/Dokumentaatio/Maarittelydokumentti/Maarittelydokumentti.md)       
 [Toteutusdokumentti](https://github.com/Varjokorento/RaSkAslabra/blob/master/Dokumentaatio/Toteutusdokumentti/toteutusdokumentti.md)    
[Testausdokumentti](https://github.com/Varjokorento/RaSkAslabra/blob/master/Dokumentaatio/Testausdokumentti/testausdokumentti.md)

## Huomio tarkastajalle:

Viikkopalautuksissa olen suunnitellut, että tekisin vertailuja Javan RSA-algoritmin kirjastototeutukselle. Tätä ei ollut alkuperäisessä määrittelyssäni ja tämä idea tavallaan tuli kesken kurssin. Tekemäni lopputulos on kuitenkin sen verran tehoton, etteivät vertailut olisi olleet erityisen mielekkäitä. Näin ollen poistin kirjastototeutuksen kokonaan ohjelmasta. Mielestäni ei ollut järkeä vertailla ohjelmaa, joka pystyy luomaan vain maksimissaan 100-bittisen avaimen ohjelmaan, joka voi luoda 1024-bittisen, koska vertailut eivät oikeastaan kerro mitään muuta, kuin että Javan versio on huomattavasti parempi. 

Tämän sijaan BigInteger-luokan ja OwnBigInteger-luokan performansseja vertaillaan. 
    
    
## Viikkopalautukset

 [Viikkopalautus1](https://github.com/Varjokorento/RaSkAslabra/blob/master/Dokumentaatio/Viikkopalautukset/Viikkopalautus1.md)
 
 [Viikkopalautus2](https://github.com/Varjokorento/RaSkAslabra/blob/master/Dokumentaatio/Viikkopalautukset/Viikkopalautus2.md)
 
 [Viikkopalautus3](https://github.com/Varjokorento/RaSkAslabra/blob/master/Dokumentaatio/Viikkopalautukset/Viikkopalautus3.md)
 
 [Viikkopalautus4](https://github.com/Varjokorento/RaSkAslabra/blob/master/Dokumentaatio/Viikkopalautukset/Viikkopalautus4.md)
 
 [Viikkopalautus5](https://github.com/Varjokorento/RaSkAslabra/blob/master/Dokumentaatio/Viikkopalautukset/Viikkopalautus5.md)
 
 [Viikkopalautus6](https://github.com/Varjokorento/RaSkAslabra/blob/master/Dokumentaatio/Viikkopalautukset/Viikkopalautus6.md)
 
 


