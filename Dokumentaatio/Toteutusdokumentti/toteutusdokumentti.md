# Toteutusdokumentti

## 1. Julkisen ja yksityisen avaimen generointi

Ohjelma toteuttaa avainten generoinnin seuraavasti:

1. Ohjelman PrimeNumberGenerator-luokka generoi kaksi alkulukua p ja q, joilla on bittipituus n. Alkuluvut generoidaan käyttäen suurta satunnaista lukua, jonka alkulukuluonne testataan Miller-Rabin testillä. 

2. Ohjelman KeyPairGeneratorImpl-luokka tekee tämän jälkeen seuraavat laskutoimitukset.
    1. Etsii n laskemalla p*q. (Tämä on avainten jakojäännös).
    2. Laskee Eulerin  φ-funktiolla λ(n)
        1. Usein vaiheessa tässä käytetään Carmichaelin φ-funktiota. Alkuperäisessä patentissa käytetään kuitenkin Euleria. 
    3. Laskee e:n niin, että 1 < e < λ(n)  ja e:n ja λ(n) suurin yhteinen nimittäjä on yksi, eli luvut ovat keskenään jaottomia.
    4. Laskee d niin, että d ≡ e−1 (mod λ(n))
        1. Tämä lasketaan Euclideanin algoritmin laajennetulla versiolla (Extended Euclidean Algorithm).

Laskun tuloksena saadaan julkinen avain, joka on jakojäännös n ja exponentti e. Yksityinen avain on exponentti d.

## 2. Tekstin salaaminen 

1. Käyttäjä syöttää merkkijonon. 
2. RSATool-luokka purkaa merkkijonot puretaan sen merkkien ASCII-arvoon, josta tehdään BigInteger-array. Esimerkiksi abc = {97, 98, 99}
3. Tämän jälkeen Encrypter-luokka kryptaa BigInteger-arrayn niin, että jokainen numero nostetaan a^e mod n. e ja n ovat julkisen avaimen osia. Lopputuloksena saadaan kryptattu versio BigInteger-arraystä.

## 3. Salauksen purkaminen
1. Kryptattu BigInteger-array annetaan Decrypter-luokalle, joka saa syötteenään myös julkisen avaimen ja yksityisen avaimen. 
2. Jokaiselle alkiolle tehdään seuraava operaatio: a^d mod n. Tässä d on yksityinen avain ja n saadaan julkisesta avaimesta. 

Lähteet:
https://www.geeksforgeeks.org/primality-test-set-3-miller-rabin/
https://en.wikipedia.org/wiki/RSA_(cryptosystem)
