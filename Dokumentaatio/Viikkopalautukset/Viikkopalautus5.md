# Viikkopalautus 5

### Mitä olen tehnyt?

Tällä viikolla olen implementoinut LinkedList-tietorakenteen sekä muutaman muun Javan valmiin luokan. Tämän lisäksi olen siistinyt ja järkevöittänyt
koodiani. Lisäksi olen tehnyt vertaisarviointia. 

Kävi kuitenkin niin, että johtuen edellisen viikon kriittisestä ongelmasta -- eli generoitujen alkulukujen aivan liian pienestä koosta -- muutin ohjelmani alkulukugeneroimista. Sen sijaan, että ohjelma käyttää Eratostheneen seulaa, se generoi vain suuren BigIntegerin, jota se sitten testaa Miller-Rabin alkulukutestillä. Tämä ratkaisu mahdollistaa sen, että pystyn nyt generoimaan huomattavasti suurempia alkulukuja. Tosin nyt LinkedList-implementointini on täysin turha. Jätin sen kuitenkin ohjelmakoodiin siltä varalta, että sitä joskus tarvitsen vielä tässä projektissa. Poistan sen lopullisesta versiosta, jos tälle ei olekaan tarvetta.

### Miten ohjelma on edistynyt

Ohjelma ei ole näkyvästi edistynyt tällä viikolla. Koska ohjelman runko on valmis ja algoritmi toimii, keskityn nyt sen parantamiseen ja omiin implementointeihin.

Miller-Rabin -alkulukugenerointi toimii nyt jotenkuten. Tosin nyt ohjelman performanssi kärsii merkittävästi. Nyt kirjastoversio generoi avaimet keskimäärin 34 ms kun taas minun implementaationi kestää 209 millisekuntia. Toisaalta tämä oli odotettavissa. 
 
### Mitä opin tällä viikolla?

Tällä viikolla olen miettinyt, että miten voisin generoida tarpeeksi suuria alkulukuja. Tutustuin moneen eri tapaan generoida alkulukuja. 

### Mitä jäi epäselväksi?

Tällä viikolla ei jäänyt epäselväksi asioita.

### Mitä teen seuraavaksi?

Seuraavaksi aion alkaa toteuttamaan BigInteger-luokkaa. Uskoisin tämän olevan melkoisen hankala vaihe työtä.

Käytetty aika: 9 tuntia. 
