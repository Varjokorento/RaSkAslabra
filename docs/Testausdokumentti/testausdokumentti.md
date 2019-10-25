# Testaus

## Yksikkötestaus
 
Ohjelmassa on kattava yksikkötestaus, jonka rivikohtainen kattavuus on 72 prosenttia ja haarakohtainen 77 prosenttia.

[Jacoco-raportti](https://varjokorento.github.io/RaSkAslabra/jacoco/)

## Integraatiotestaus

Tällä hetkellä integraatiotestausta on tehty käsin kokeilemalla eri syötteitä ja katsomalla toimivatko ne oikein halutulla tavalla. 

Tämän lisäksi on RSAToolTest.java luokka, joka tekee End-to-End-testausta: Se generoiduilla avaimilla kryptaa ja dekryptaa syötteen oikein. 

## Suorituskykytestaus

### Koko algoritmin suorituskyky

Suorituskykytestausta on tehty koneellisesti. Testauksessa kryptattiin viesti 'message'. Testeissä otettiin pois kaikki testattavissa metodeissa tehdyt tulostukset. 

Koko algoritmia on testattu käyttäen eri pituisia avaimia. Yli 200 bitin avaimia on yritetty, mutta näiden suoritus ei päättynyt järkevän ajan sisällä. 

#### Testi käyttäen new BigInteger(int bitlength, Random random)

Testeissä on käytetty apuna satunnaislukujen generointiin BigInteger-luokkaa ja sen konstruktoria new BigInteger(int bitlength, Random random). Lopullinen versio generoi satunnaisluvut käyttäen omaa metodia, mutta tämä ei kyennyt generoimaan tarpeeksi suuria lukuja järkevissä ajoissa. 

Alla suorituskyky käyttäen 10, 100 ja 200 bitin avaimia. Jokainen testi ajettiin 100 kertaa ja otettiin keskiarvo.

##### Keygeneration

![alt text](https://raw.githubusercontent.com/Varjokorento/RaSkAslabra/master/docs/Testausdokumentti/keygen.png)

##### Encryption


![alt text](https://raw.githubusercontent.com/Varjokorento/RaSkAslabra/master/docs/Testausdokumentti/Encryption.png)

##### End-To-End

![alt text](https://raw.githubusercontent.com/Varjokorento/RaSkAslabra/master/docs/Testausdokumentti/EndtoEnd.png)


#### Testi käyttäen omaa satunnaislukugeneraattoria

Alla suorituskyky käyttäen OwnBigInteger-luokan getLargeNumber -metodia, joka generoi 40 bittisiä avaimia.

Jokainen testi ajettiin sata kertaa ja otettiin keskiarvo.

|Toiminto | Kesto (ms) |
|---------|-----------|
| Key-Generation | 1171 ms |
| Encryption     | 33 ms |  
| End-to-End     | 1430 ms |  

![alt text](https://raw.githubusercontent.com/Varjokorento/RaSkAslabra/master/docs/Testausdokumentti/42bit.png)

Testeissä huomasin, että avainten generoinnissa on huomattavaa varianssia ajallisessa kestossa. Koska avainten generointi on selkeästi aikaavievin vaihe, johtaa tämä myös ohjelman suorituskyvyn huomattavaan vaihteluun. Uskoisin, että vaihtelu johtuu alkuluvun generoimiseen liittyvästä sattumatekijästä. 

![alt text](https://raw.githubusercontent.com/Varjokorento/RaSkAslabra/master/docs/Testausdokumentti/Varianssi.png)

### BigInteger-luokan suorituskyky:

Koko algoritmin lisäksi on myös testattu BigIntegerin implementaatiota. Huomioitavaa on, ettei lopullisessa versiossa käytetä pow-metodia lainkaan vaan se on korvattu modulaarisella eksponentaatiolla (ks määrittelydokumentin lähteet), joka on merkittävästi nopeampi


##### Lisäys

Lisäystestissä liästtiin numeroon 20000000000000000000 tuhat kertaa numero 20000000000000000000.  

| Toiminto   | OwnBigInteger | BigInteger | BigIntegerin verrannollinen nopeus |
|------------|---------------|------------|------------------------------------                                            
| Lisäys     | 349973ns      | 226442ns   | 1.5x                               |


![alt text](https://raw.githubusercontent.com/Varjokorento/RaSkAslabra/master/docs/Testausdokumentti/Lisäys.png)

#### Vähennys

Vähennystestissä vähennettiin numerosta 20000000000000000000 tuhat kertaa numero 10.

| Toiminto   | OwnBigInteger | BigInteger | BigIntegerin verrannollinen nopeus |
|------------|---------------|------------|------------------------------------|
| Vähennys   | 4665ns        | 1160ns     | 4.0x                               |


![alt text](https://raw.githubusercontent.com/Varjokorento/RaSkAslabra/master/docs/Testausdokumentti/vähennys.png)

#### Kertolasku

Kertolaskutestissä kerrottiin numero 200000000000000000 tuhat kertaa numerolla 1000000.

| Toiminto   | OwnBigInteger | BigInteger | BigIntegerin verrannollinen nopeus |
|------------|---------------|------------|------------------------------------|
| Kertolasku | 116971ns      | 955ns      | 122x                               |


![alt text](https://raw.githubusercontent.com/Varjokorento/RaSkAslabra/master/docs/Testausdokumentti/kertolasku.png)

#### Jakolasku

Jakolaskutestissä jaettiin numeroa 20000000000 tuhat kertaa numerolla 10 tuhat kertaa.

| Toiminto   | OwnBigInteger | BigInteger | BigIntegerin verrannollinen nopeus |
|------------|---------------|------------|------------------------------------|
| Jakolasku  | 5892ns        | 1135ns     | 5.19x                              |


![alt text](https://raw.githubusercontent.com/Varjokorento/RaSkAslabra/master/docs/Testausdokumentti/Jakolasku.png)

#### Jakojäännös

Jakojäännöstestissa otettiin numerosta 2000000000 jakojäännös luvulla 100 tuhat kertaa.

| Toiminto   | OwnBigInteger | BigInteger | BigIntegerin verrannollinen nopeus |
|------------|---------------|------------|------------------------------------|
| mod        | 10005ns       | 1457ns     | 6.86x                              |


![alt text](https://raw.githubusercontent.com/Varjokorento/RaSkAslabra/master/docs/Testausdokumentti/Jakojäännös.png)

#### Potenssi

Potenssitestissä numero 200 nostettiin potenssiin 3397 kymmenen kertaa. 

| Toiminto   | OwnBigInteger | BigInteger | BigIntegerin verrannollinen nopeus |
|------------|---------------|------------|------------------------------------|
| pow        | 1571463ns     | 55ns       | 28572x                             |


![alt text](https://raw.githubusercontent.com/Varjokorento/RaSkAslabra/master/docs/Testausdokumentti/potenssi.png)

#### ModPow

ModPow-testissä numero 200 nostettiin potenssiin 3397 jonka jälkeen otettiin jakojäännös luvulla 23323 tuhat kertaa.
   
| Toiminto   | OwnBigInteger | BigInteger | BigIntegerin verrannollinen nopeus |
|------------|---------------|------------|------------------------------------|
| modPow     | 10434ns       | 1843ns     | 5.66x                              |


![alt text](https://raw.githubusercontent.com/Varjokorento/RaSkAslabra/master/docs/Testausdokumentti/ModPow.png)

