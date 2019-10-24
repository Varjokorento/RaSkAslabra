# Toteutusdokumentti

Aikavaativuudet ovat itse laskettuja ellei lähdettä ole mainittu. 

## RSA-tool -luokan toteutus

### 1. Julkisen ja yksityisen avaimen generointi

Ohjelma toteuttaa avainten generoinnin seuraavasti:

1. Ohjelman PrimeNumberGenerator-luokka generoi kaksi alkulukua p ja q, joilla on bittipituus n. Alkuluvut generoidaan käyttäen suurta satunnaista lukua, jonka alkulukuluonne testataan Miller-Rabin testillä. 

#### Aikavaativuus
    Tämän aikavaativuus on  O(k log 3n) (ks. Wikipedia-artikkeli aiheesta). 

2. Ohjelman KeyPairGeneratorImpl-luokka tekee tämän jälkeen seuraavat laskutoimitukset.
    i. Etsii n laskemalla p*q. (Tämä on avainten jakojäännös). 
    ii. Laskee Eulerin  φ-funktiolla λ(n)
        a. Usein vaiheessa tässä käytetään Carmichaelin φ-funktiota. Alkuperäisessä patentissa käytetään kuitenkin Euleria. 
    iii. Laskee e:n niin, että 1 < e < λ(n)  ja e:n ja λ(n) suurin yhteinen nimittäjä on yksi, eli luvut ovat keskenään jaottomia.
    iv. Laskee d niin, että d ≡ e−1 (mod λ(n))
        b. Tämä lasketaan Euclideanin algoritmin laajennetulla versiolla (Extended Euclidean Algorithm).

##### Aikavaativuudet:
    i. O(n)
    ii. O(n)
    iii. O(c * log(n)) (gcd:n aikavaativuus log(n) * kuinka monta kertaa täytyy yrittää.)
    iv. En oikein osaa sanoa. Funktio on otettu https://fi.wikipedia.org/wiki/Modulaariaritmetiikan_k%C3%A4%C3%A4nteisluku -linkistä ja aikavaativuudesta keskustellaan muun muassa täällä : https://en.wikipedia.org/wiki/Euclidean_algorithm#Algorithmic_efficiency


Laskun tuloksena saadaan julkinen avain, joka on jakojäännös n ja exponentti e. Yksityinen avain on exponentti d.

### 2. Tekstin salaaminen 

1. Käyttäjä syöttää merkkijonon. 
2. RSATool-luokka purkaa merkkijonot puretaan sen merkkien ASCII-arvoon, josta tehdään OwnBigInteger-array. Esimerkiksi abc = {97, 98, 99}
3. Tämän jälkeen Encrypter-luokka kryptaa OwnBigInteger-arrayn niin, että jokainen numero nostetaan a^e mod n. e ja n ovat julkisen avaimen osia. Lopputuloksena saadaan kryptattu versio BigInteger-arraystä.

#### Aikavaativuus:
    O(n * a log a), jossa n on syötteen pituus kirjaimina ja a on avainten numeroiden koko. 

### 3. Salauksen purkaminen
1. Kryptattu OwnBigInteger-array annetaan Decrypter-luokalle, joka saa syötteenään myös julkisen avaimen ja yksityisen avaimen. 
2. Jokaiselle alkiolle tehdään seuraava operaatio: a^d mod n. Tässä d on yksityinen avain ja n saadaan julkisesta avaimesta. 

#### Aikavaativuus:
    O(n * a log a), jossa n on syötteen pituus kirjaimina ja a on avainten numeroiden koko. 
    
## OwnBigInteger-luokka

Tämä luokka implementoi Javan BigInteger-luokan. Luokka säilöö suuria lukua Array-listoissa yksi numero kerrallaan. Luokan toiminnallisuus perustuu allekkain laskemiseen.

1. Lisäys

Jokainen lukuun lisätään allekkain toisen luvun vastaava. Jos mennään yli kymmenen, niin lisätään muistiin luku. 

    Aikavaativuus on O(n), jossa n on suuremman numeron pituus. 

2. Vähennys

Jokainen lukuun lisätään allekkain toisen luvun vastaava. Jos mennään yli kymmenen, niin lisätään muistiin luku. Aikavaativuus on O(n), jossa n on suuremman numeron pituus. Vähennyksessä ei voi vähentää numeroiltaan lyhyempää numeroa toisella. Tämä ei tuota ongelmia, sillä algoritmissa ei ole tuollaisia tilanteita vaan kaikista luvuista vähennetään aina pienempi numero. 

    Jakolaskun aikavaativuus on O(n), jossa n on jaettavan numeron pituus. 

3. Jakolasku

Jakolasku tehdään jakokulmalla.

    Kertolaskun aikavaativuus on O(n), jossa n ja m ovat jaettavat luvut. 

4. Kertolasku

Kertolasku tehdään niin, että otetaan pienemmästä numerosta viimeinen luku ja kerrotaan sillä kokonaan suurempi luku. Tämän jälkeen tämä luku lisätään tuloslistaan. Käydään näin läpi koko luku ja aina välitulokset lisätään allekkain toisiinsa niin, että välitulokset saavat aina matalamman indeksin kuin edellinen (eli saadaan '0' luvun perään). 

    Kertolaskun aikavaativuus on O(n^(n-1)), jossa n on on jaettavan numeron koko. 

5. Modulo ja potenssi.

Modulo ja potenssi tehdään modulaari exponentaatiolla (ks. lähde Wikipediasta). 

    Modulaariexponentaatio artikkelin pseudokoodin implementaatio, jonka aikavaativuus on lähteiden mukana O(n log n).  

6. Modulo

Pelkkä modulo tehdään operaatiolla, jossa numero jaetaan ja jaettu kokonaisluku kerrotaan jakajalla ja miinustetaan itse luvusta. 

    Tämän aikavaativuus on O(n^(n-1)).

### Lähteet

- https://en.wikipedia.org/wiki/Miller%E2%80%93Rabin_primality_test#Complexity
- Paloja, J. "RSA-salausalgoritmi ja alkuluvut", https://trepo.tuni.fi/handle/10024/78940
- Rivest, Shamir, Adleman, "Cryptographic communications system and method" https://patents.google.com/patent/US4405829
- Ireland D, "RSA Algorithm", https://www.di-mgt.com.au/rsa_alg.html
- https://www.geeksforgeeks.org/primality-test-set-3-miller-rabin/
- https://en.wikipedia.org/wiki/RSA_(cryptosystem)
- https://rosettacode.org/wiki/Long_multiplication
- https://en.wikipedia.org/wiki/Long_division
- https://fi.wikipedia.org/wiki/Modulaariaritmetiikan_k%C3%A4%C3%A4nteisluku
- https://en.wikipedia.org/wiki/Modular_exponentiation
- https://cp-algorithms.com/algebra/binary-exp.html

