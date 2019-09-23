# Toteutusdokumentti

## 1. Julkisen ja yksityisen avaimen generointi

Ohjelma toteuttaa avainten generoinnin seuraavasti:

1. Ohjelman PrimeNumberGenerator-luokka generoi kaksi alkulukua p ja q. Alkuluvut generoidaan käyttäen satunnaista lukua, josta generoidaan Eratostheneen seula -algoritmilla kaksi erillistä alkulukua. 

2. Ohjelman KeyPairGeneratorImpl-luokka tekee tämän jälkeen seuraavat laskutoimitukset.
    1. Etsii n laskemalla p*q. (Tämä on avainten jakojäännös).
    2. Laskee Eulerin  φ-funktiolla λ(n)
        1. Usein vaiheessa tässä käytetään Carmichaelin φ-funktiota. Alkuperäisessä patentissa käytetään kuitenkin Euleria. 
    3. Laskee e:n niin, että 1 < e < λ(n)  ja e:n ja λ(n) suurin yhteinen nimittäjä on yksi, eli luvut ovat keskenään jaottomia.
    4. Laskee d niin, että d ≡ e−1 (mod λ(n))
        1. Tämä lasketaan Euclideanin algoritmin laajennetulla versiolla (Extended Euclidean Algorithm).

Laskun tuloksena saadaan julkinen avain, joka on jakojäännös n ja exponentti e. Yksityinen avain on exponentti d.
