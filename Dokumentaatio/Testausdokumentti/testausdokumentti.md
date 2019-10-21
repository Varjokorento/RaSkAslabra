# Testaus

## Yksikkötestaus
 
Ohjelmassa on kattava yksikkötestaus, jonka rivikohtainen kattavuus on 72 prosenttia ja haarakohtainen 77 prosenttia.

![alt text](https://github.com/Varjokorento/RaSkAslabra/blob/master/Dokumentaatio/Testausdokumentti/testaus2.PNG "Raportti")

## Integraatiotestaus

Tällä hetkellä integraatiotestausta on tehty käsin kokeilemalla eri syötteitä ja katsomalla toimivatko ne oikein halutulla tavalla. Tämän lisäksion RSAToolTest.java luokka, joka tekee End-to-End-testausta: Se generoiduilla avaimilla kryptaa ja dekryptaa syötteen oikein. 

## Suorituskykytestaus

### Koko algoritmin suorituskyky

Suorituskykytestausta on tehty koneellisesti. Koko algoritmia on testattu käyttäen eri pituisia avaimia. Yli 200 bitin avaimia on yritetty, mutta näiden suoritusaika on niin pitkä, ettei sen testaaminen ollut mielekästä.  

HUOM: Testeissä on käytetty apuna satunnaislukujen generointiin BigInteger-luokkaa ja sen konstruktoria new BigInteger(int bitlength, Random random). Lopullinen versio generoi satunnaisluvut käyttäen omaa metodia, mutta tämä ei kyennyt generoimaan tarpeeksi suuria lukuja järkevissä ajoissa. 

Alla suorituskyky käyttäen 10, 100 ja 200 bitin avaimia. 

| Toiminto       | 10 | 100  | 200    |   |
|----------------|----|------|--------|---|
| Key-Generation | 58 ms | 8788 ms | 78423 ms  |   |
| Encryption     | 8 ms | 60 ms  | 216  ms  |   |
| End-to-End     | 75 ms | 6564 ms| 100940 ms |   |

### BigInteger-luokan suorituskyky:

Koko algoritmin lisäksi on myös testattu BigIntegerin implementaatiota. Huomioitavaa on, ettei lopullisessa versiossa käytetä pow-metodia lainkaan vaan se on korvattu modulaarisella eksponentaatiolla (ks määrittelydokumentin lähteet), joka on merkittävästi nopeampi. 

| Toiminto   | OwnBigInteger | BigInteger | BigIntegerin verrannollinen nopeus |
|------------|---------------|------------|------------------------------------|
|            |               |            |                                    |
| Lisäys     | 349973ns      | 226442ns   | 1.5x                               |
| Vähennys   | 4665ns        | 1160ns     | 4.0x                               |
| Kertolasku | 116971ns      | 955ns      | 122x                               |
| Jakolasku  | 5892ns        | 1135ns     | 5.19x                              |
| mod        | 10005ns       | 1457ns     | 6.86x                              |
| pow        | 1571463ns     | 55ns       | 28572x                             |
| mulPow     | 10434ns       | 1843ns     | 5.66x                              |
