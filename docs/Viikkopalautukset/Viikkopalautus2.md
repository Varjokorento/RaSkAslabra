# Viikkopalautus 2

### Mitä olen tehnyt?

Olen lukenut lisää RSA-algoritmista ja siitä, miten se toimii. Olen toteuttanut avainten generoimisen sekä encryptaamisen sekä dekryptaamisen käyttämällä javan valmiita kirjastoja ja työkaluja. Tällä hetkellä ohjelma pystyy salaamaan lyhyen tekstin, jonka käyttäjä syöttää. Törmäsin siihen ongelmaan, että suurten tekstien salaaminen tällä perus RSA-salauksella ei välttämättä onnistu. Selvitin, että AES-salauksen ja RSA-salauksia yhdistelemällä tämä taas onnistuu. Näin ollen ajattelin, että teen sen seuraavaksi ja säilytän ohjelmassani molemmat vaihtoehdot. 

### Miten ohjelma on edistynyt?

Olen toteuttanut avainten generoimisen sekä encryptaamisen sekä dekryptaamisen käyttämällä javan
valmiita kirjastoja ja työkaluja. Tällä hetkellä ohjelma pystyy salaamaan lyhyen tekstin, jonka käyttäjä syöttää. Tämä kaikki käyttää valmiita kirjastoja.

Lisäksi olen aloittanut yksikkötestaamisen. Yksikkötestaamisessa on tullut vastaan joitain ongelmia, joista suurin osa liittyy ohjelman erilaisten muuttujien käyttämiseen. Esimerkiksi tällä hetkellä kryptatun bittikoodin tallentaminen ja uudelleen lukeminen tiedostosta ei onnistu. Näin ollen decryptTest joutuu ensin encryptaamaan tekstin byteArrayksi. Osa testeistä on siis kriittisen riippuvaisia toisistaan. Tämä menee vastoin yksikkötestaamisen ajatusta, joten se täytyy korjata. En vielä ole hirveästi sitä miettinyt, sillä ajattelin testien muuttuvat hieman, kun implementoin oman version valmiista luokista. 

Ohjelmaan on lisätty myös checkstyle-määrittely. 

### Mitä opin tällä viikolla?

Opin lisää RSA-algoritmista. Opin sen rajoitteet. Opin paljon Javan kirjastoista, kuten java.security ja java.crypto. 

### Mitä jäi epäselväksi?

Tällä viikolla ei juurikaan jäänyt mitään kysyttävää. Tämän viikon työ oli enimmäkseen valmiiden kirjastojen hyödyntämistä sekä ohjelman rungon rakentamista. Lisäksi yksikkötestit veivät aikaa. 

### Mitä teen seuraavaksi?

Ajattelin alkaa implementoimaan omaa versiota RSA-salauksesta. Jos tämä sujuu rivakasti, harkitsen AES-salauksen yhdistelemistä. Jos taas huomaan, että kohtaan merkittäviä ongelmia, saatan tämän hylätä. 

Käytetty aika: 8 tuntia. 
