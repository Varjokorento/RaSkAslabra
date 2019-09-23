# Viikkopalautus 3

### Mitä olen tehnyt?

Olen taas lukenut lisää RSA-algoritmista ja siitä, miten se toimii. Olen korvannut avainten generoinnin omilla implementaatioilla, jotka
generiovat suuria alkulukuja ja laskevat niiden perusteella julkisen sekä yksityisen avaimen. Tämä vei huomattavasti aikaa minulta tällä viikolla.

Tämän lisäksi olen kirjoittanut dokumentaatioon selityksen siitä, miten ohjelma generoi julkisen ja yksityisen avaimen. 

### Miten ohjelma on edistynyt?

Olen toteuttanut avainten generoimisen omien implementaatioiden kanssa. Tähän mennessä olen implementoinut potenssit ja alkulukujen generoimisen. Ohjelma on ottanut tietyssä mielessä takapakkia viime viikkoisesta, sillä nyt tekstiä ei pysty vielä kryptaamaan. Tämä ei ole kuitenkaan todellista takapakkia, sillä edellisen viikon implementaatiossa käytettiin valmiita krypto- ja securitykirjastoja, joilla tämä RSA-algoritmi oli triviaali toteuttaa. 

Ohjelma nyt mielestäni oikeaoppisesti generoi avaimet. Tällä hetkellä avaimien kokoon ei voi vaikuttaa, mutta tämän toteutan myöhemmillä viikoilla. 

### Mitä opin tällä viikolla?

Opin huomattavasti RSA-algoritmin matemaattisesta taustasta sekä siitä, miten avainten generointi toteutetaan suhteellisen tehokkaasti Javalla. 

### Mitä jäi epäselväksi?

Minulle jäi muutama asia epäselväksi. 1. Mitä kirjastoja saa käyttää? Esimerkiksi voiko Javan Randomia käyttää vai tulisiko se itse implementoida ja 2. Voinko hieman muuttaa projektini scopea siten, että toteutan sekä RSA:n omilla kirjastoilla ja sitten vertaan sitä Javan valmiilla kirjastoilla toteutettuun? Näkisin tämän mielekkääksi. 

### Mitä teen seuraavaksi?

Seuraavaksi aion tehdä itse kryptauksen ja dekryptauksen. Tämä vaihe myös validoi sen, että toimivatko avaimeni todella. Sen jälkeen, kun tämä on tehty, aion implementoida omat tietorakenteeni (linkkilista ja tavallinen lista), jonka jälkeen hioa ja kaunistella koodiani. 

Käytetty aika: 8 tuntia. 
