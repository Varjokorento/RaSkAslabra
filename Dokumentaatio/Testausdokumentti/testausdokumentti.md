# Testaus

## Yksikkötestaus
 
Tällä hetkellä ohjelman testaus on toteutettu enimmäkseen yksikkötesteillä. Yksikkötestit testaavat ohjelman eri ominaisuuksia. Testaus
on kattava ja rivikohtainen kattavuus on 72 prosenttia ja haarakohtainen 77 prosenttia.

![alt text](https://github.com/Varjokorento/RaSkAslabra/blob/master/Dokumentaatio/Testausdokumentti/testaus2.PNG "Raportti")

## Integraatiotestaus

Tällä hetkellä integraatiotestausta on tehty käsin kokeilemalla eri syötteitä ja katsomalla toimivatko ne oikein halutulla tavalla. Tämän lisäksi
on RSAToolTest.java luokka, joka generoiduilla avaimilla kryptaa ja dekryptaa syötteen oikein. Tämä on oikeastaan samalla end-to-end-testausta. 

## Suorituskykytestaus

Suorituskykytestaus on aloitettu. Suorituskykytestausta tehdään PerformanceTest-luokalla joka ottaa aikaa metodien suorituksista. Metodit ajetaan 10 kertaa
ja sen perusteella vertaillaan suorituskykyä. Tällä hetkellä performanssitestit testaavat koko toiminnallisuuden tehokkuutta, kryptaamisen tehokkuutta ja avainten generoinnin tehokkuutta.
