# Viikkopalautus 4

### Mitä olen tehnyt?

Tällä viikolla olen tehnyt loppuun oman toteutukseni RSA-algoritmista. Nyt se generoi avaimet ja niiden avulla voi salata viestejä. Tämän lisäksi olen tehnyt
RSA-algoritmin Javan omilla kirjastoilla. Nyt näitä kahta voi verrata keskenään. Olen myös kirjoittanut testejä sekä dokumentaatiota. Sinänsä suhteellisen tehokas viikko.

### Miten ohjelma on edistynyt?

Olen toteuttanut RSA-algoritmin viestin salaamisen avaimilla. Olen toteuttanut kirjastoversion tekemisen. 

### Mitä opin tällä viikolla?

Opin, että ohjelmani generoi aivan liian lyhyitä avaimia. Tämä on tämänhetkisen ohjelman ongelmallisin kohta. Minun täytyy jotenkin viilata
alkulukujen generointi -toiminnallisuutta. Oikeassa RSA-algoritmissa avaimet ovat ainakin 1024 bittisiä, eli 300 merkkisiä. Nyt minun avaimeni ovat 
hädin tuskin 30 bittisiä. Tästä syystä minun algoritmi on hyvin nopea verrattuna kirjastoalgoritmiin. Omissa performanssitesteissäni ero on jo niin huomattava, että minun on pakko lähteä selvittämään, että mikä kirjastoversiolla kestää niin pitkään. Taustalla on varmasti se, että kirjastoalgoritmi tekee asiat huomattavasti tietoturvallisemmin. 

### Mitä jäi epäselväksi?

Tällä viikolla ei jäänyt epäselväksi asioita.

### Mitä teen seuraavaksi?

Aion viilata omaa algoritmiani niin, että saan generoitua isompia avaimia. Aion myös toteuttaa Javan BigInteger ja linkedList tietorakenteen, jota käytetään algoritmissa. Aion jatkaa dokumentaation kirjoittamista sekä testaamista.


Käytetty aika: 10 tuntia. 
