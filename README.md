# RaSkaslabra

## Projektin kuvaus

Tämä sovelluksen tarkoitus on implementoida RSA-salaus algoritmi Java-ohjelmointikielellä. 

## Omat toteutukset v Kirjasto-toteutukset

Projektissa implementoidaan RSA-salaus Javan valmiilla kirjastoilla sekä omilla implementaatioilla. Tämä tehdään sen vuoksi, että voidaan vertailla näiden kahden toteututuksen eroja. RSA-algoritmi on hyvin vanha algoritmi ja sen "klassinen" toteutus eroaa mahdollisesti sen nykyisestä kirjastototeutuksesta. 

Koodin lukemiseen on kaksi nyrkkisääntöä:
1. Jos metodin kommentissa lukee OWN IMPLEMENTATION, on kyse omasta implementaatiosta. Jos siinä lukee LIBRARY IMPLEMENTATION niin kyse on kirjastojen käyttämisestä.
2. Jokainen luokka, jonka perässä on sana "Impl" on oma toteutus kyseisestä luokasta. Esimerkiksi LinkedListImpl on toteutus LinkedList-luokasta. Impl-luokat eivät välttämättä toteuta kaikkia mahdollisia metodeja, vaan ainoastaan ne, joita käytetään projektissa.

## Projektin tavoite:

Tavoitteena on saada aikaan ohjelma, joka tekee seuraavat asiat: 

    1. Saatuaan tekstisyötteen se salaa sen RSA-salauksella
    2. Tekstisyötteen voi purkaa yksityisellä avaimella.
    
## Käyttöohje

### Testaus

Testit suoritetaan komennolla

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

### Ohjelman ajo

src-kansiossa: 

```
1. javac Main.class 2. java Main
```
    
 ## Dokumentaatio
 
 [Määritysdokumentti](https://github.com/Varjokorento/RaSkAslabra/blob/master/Dokumentaatio/Maarittelydokumentti/Maarittelydokumentti.md)       
 
 
 [Toteutusdokumentti](https://github.com/Varjokorento/RaSkAslabra/blob/master/Dokumentaatio/Toteutusdokumentti/toteutusdokumentti.md)    
[Testausdokumentti](https://github.com/Varjokorento/RaSkAslabra/blob/master/Dokumentaatio/Testausdokumentti/testausdokumentti.md)
 
 
    
    
## Viikkopalautukset

 [Viikkopalautus1](https://github.com/Varjokorento/RaSkAslabra/blob/master/Dokumentaatio/Viikkopalautukset/Viikkopalautus1.md)
 
 [Viikkopalautus2](https://github.com/Varjokorento/RaSkAslabra/blob/master/Dokumentaatio/Viikkopalautukset/Viikkopalautus2.md)
 
 [Viikkopalautus3](https://github.com/Varjokorento/RaSkAslabra/blob/master/Dokumentaatio/Viikkopalautukset/Viikkopalautus3.md)
 
 [Viikkopalautus4](https://github.com/Varjokorento/RaSkAslabra/blob/master/Dokumentaatio/Viikkopalautukset/Viikkopalautus4.md)
 
 


