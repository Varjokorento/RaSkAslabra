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
2. RSATool-luokka purkaa merkkijonot puretaan sen merkkien ASCII-arvoon, josta tehdään OwnBigInteger-array. Esimerkiksi abc = {97, 98, 99}
3. Tämän jälkeen Encrypter-luokka kryptaa OwnBigInteger-arrayn niin, että jokainen numero nostetaan a^e mod n. e ja n ovat julkisen avaimen osia. Lopputuloksena saadaan kryptattu versio BigInteger-arraystä.

## 3. Salauksen purkaminen
1. Kryptattu OwnBigInteger-array annetaan Decrypter-luokalle, joka saa syötteenään myös julkisen avaimen ja yksityisen avaimen. 
2. Jokaiselle alkiolle tehdään seuraava operaatio: a^d mod n. Tässä d on yksityinen avain ja n saadaan julkisesta avaimesta. 


## OwnBigInteger-luokka

Tämä luokka implementoi Javan BigInteger-luokan. Luokka säilöö suuria lukua Array-listoissa yksi numero kerrallaan. Luokan toiminnallisuus perustuu allekkain laskemiseen.

1. Lisäys

Jokainen lukuun lisätään allekkain toisen luvun vastaava. Jos mennään yli kymmenen, niin lisätään muistiin luku. 

2. Vähennys

Jokainen lukuun lisätään allekkain toisen luvun vastaava. Jos mennään yli kymmenen, niin lisätään muistiin luku. 

3. Jakolasku

Jakolasku tehdään jakokulmalla.

4. Kertolasku

Kertolasku tehdään niin, että otetaan pienemmästä numerosta viimeinen luku ja kerrotaan sillä kokonaan suurempi luku. Tämän jälkeen tämä luku lisätään tuloslistaan. Käydään näin läpi koko luku ja aina välitulokset lisätään allekkain toisiinsa niin, että välitulokset saavat aina matalamman indeksin kuin edellinen (eli saadaan '0' luvun perään).

5. Modulo ja potenssi.

Nämä ovat edellämainittujen operaatioiden kombinaatioita. Tämän vuoksi ne eivät ole erityisen tehokkaita.

Lähteet:
https://www.geeksforgeeks.org/primality-test-set-3-miller-rabin/
https://en.wikipedia.org/wiki/RSA_(cryptosystem)
https://rosettacode.org/wiki/Long_multiplication
https://en.wikipedia.org/wiki/Long_division

