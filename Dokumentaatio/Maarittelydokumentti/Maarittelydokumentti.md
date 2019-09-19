# Määrittelydokumentti

## Mitä algoritmeja ja tietorakenteita toteutan työssäni

Toteutan RSA(Rivest-Shamir-Adleman)-algoritmin työssäni. 

## Mitä ongelmaa ratkaiset ja miksi valitsit kyseiset algoritmit/tietorakenteet

Ongelma, joka ratkaistaan, on, miten saa salattua tietoa, niin, että sen lukeminen on mahdollista. Valitsin kyseisen algoritmin sen vuoksi, että minua henkilökohtaisesti on aina kiinnostanut kryptografia. 

Ohjelma tekee kolme RSA-salauksen osiota.

  1. Generoi julkisen ja yksityisen avaimen
  2. Salaa annetun syötteen syötetyllä julkisella avaimella.
  3. Purkaa salauksen, kun ohjelmalle syötetään yksityinen avain.
  
### 1. Julkisen ja yksityisen avaimen generointi

Ohjelma toteuttaa avainten generoinnin seuraavasti:

1. Ohjelman PrimeNumberGenerator-luokka generoi kaksi alkulukua p ja q. Alkuluvut generoidaan käyttäen satunnaista lukua, josta generoidaan Eratostheneen seula -algoritmilla kaksi erillistä alkulukua. 

2. Ohjelman KeyPairGeneratorImpl-luokka tekee tämän jälkeen seuraavat laskutoimitukset.
    1. Etsii n laskemalla p*q. (Tämä on avainten modulo).
    2. Laskee Eulerin  φ-funktiolla λ(n).*
    3. Laskee e:n niin, että 1 < e < λ(n)  ja suurin yhteinen nimittäjä e, λ(n) on yksi, eli luvut ovat keskenään jaottomia.
    4. Laskee d niin, että d ≡ e−1 
    
* Usein tässä käytetään myös Carmichaelin φ-funktiota. Alkuperäisessä patentissa käytetään kuitenkin Euleria. 

Laskun tuloksena saadaan julkinen avain, joka on modulus n ja exponentti e. Yksityinen avain on exponentti d. 

## Mitä syötteitä ohjelma saa ja miten näitä käytetään

Käyttäjä syöttää syötteen, joka on plain text -tekstiä. Ohjelma generoi ensin julkisen avaimen, jonka jälkeen se generoi yksityisen avaimen. Käyttäjä näkee molemmat avaimet sekä salatun tekstin.

Tämän jälkeen käyttäjä voi syöttää salatun tekstin sekä yksityisen avaimen, jolloin ohjelma purkaa salauksen. 

## Tavoitteena olevat aika- ja tilavaativuudet

RSA-algoritmi etenee osissa. Näin ollen RSA-algoritmin aikavaativuus perustee sen eri osien aikavaativuuteen. Osat ovat matemaattisia operaatioita, jotka voi toteuttaa eri tavoilla. RSA-algoritmin aikavaativuus on hieman lähteistä [riippuen](https://crypto.stackexchange.com/questions/6164/how-do-i-derive-the-time-complexity-of-encryption-and-decryption-based-on-modula) yleisesti O(log(N^3)), kun yksityinen avain generoidaan ja salaus puretaan ja O(log(N^2)), kun julkinen avain generoidaan ja teksti salataan. Näitä aikavaativuuksia itse tavoittelen. 

RSA-algoritmin tilavaativuus on O(1), sillä lisätty syöte ei vaikuta siihen, montako muuttujaa täytyy varata. 

## Lähteet

- Paloja, J. "RSA-salausalgoritmi ja alkuluvut", https://trepo.tuni.fi/handle/10024/78940
- Rivest, Shamir, Adleman, "Cryptographic communications system and method" https://patents.google.com/patent/US4405829
- Ireland D, "RSA Algorithm", https://www.di-mgt.com.au/rsa_alg.html
