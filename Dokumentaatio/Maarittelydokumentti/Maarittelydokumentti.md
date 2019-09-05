# Määrittelydokumentti

## Mitä algoritmeja ja tietorakenteita toteutan työssäni

Toteutan RSA(Rivest-Shamir-Adleman)-algoritmin työssäni. 

## Mitä ongelmaa ratkaiset ja miksi valitsit kyseiset algoritmit/tietorakenteet

Ongelma, joka ratkaistaan, on, miten saa salattua tietoa, niin, että sen lukeminen on mahdollista. Valitsin kyseisen algoritmin sen vuoksi, että minua henkilökohtaisesti on aina kiinnostanut kryptografia. 

Ohjelma tekee kaksi asiaa:
  1. Generoi julkisen ja yksityisen avaimen
  2. Salaa annetun syötteen syötetyllä julkisella avaimella.
  3. Purkaa salauksen, kun ohjelmalle syötetään yksityinen avain.

## Mitä syötteitä ohjelma saa ja miten näitä käytetään

Käyttäjä syöttää syötteen, joka on plain text -tekstiä. Ohjelma generoi ensin julkisen avaimen, jonka jälkeen se generoi yksityisen avaimen. Käyttäjä näkee molemmat avaimet sekä salatun tekstin.

Tämän jälkeen käyttäjä voi syöttää salatun tekstin sekä yksityisen avaimen, jolloin ohjelma purkaa salauksen. 

## Tavoitteena olevat aika- ja tilavaativuudet

RSA-algoritmin aikavaativuus perustee sen eri osien aikavaativuuteen. RSA-algoritmin aikavaativuus on hieman lähteistä [riippuen](https://crypto.stackexchange.com/questions/6164/how-do-i-derive-the-time-complexity-of-encryption-and-decryption-based-on-modula) yleisesti O(log(N^3)), kun yksityinen avain generoidaan ja salaus puretaan ja O(log(N^2)), kun julkinen avain generoidaan ja teksti salataan. Näitä aikavaativuuksia itse tavoittelen. 

RSA-algoritmin tilavaativuus on O(1), sillä lisätty syöte ei vaikuta siihen, montako muuttujaa täytyy varata. 

## Lähteet

- Paloja, J. "RSA-salausalgoritmi ja alkuluvut", https://trepo.tuni.fi/handle/10024/78940
- Rivest, Shamir, Adleman, "Cryptographic communications system and method" https://patents.google.com/patent/US4405829
- Ireland D, "RSA Algorithm", https://www.di-mgt.com.au/rsa_alg.html
