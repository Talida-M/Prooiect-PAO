# Proiect-PAO
Galerie de Arta 

Proiectul are ca scop  administrarea unei galerii de arta online.

```
Actiuni / Interogari:
Avem ca roluri: Admin/Vizitator/Artist

#Administratorul are urmatoarele actiuni:

-Poate adauga o viitoare expozitie 

-Poare realiza cereri primite din partea vizitatorului(printr-un fisier csv cereri). 

Astfel, in functie de ceea ce doreste un client (sa i se stearga contul, sa ii fie schimbata parola, sa isi schimbe numarul de telefon) 

administratorul va realiza task-ul.

-Poate vizualiza conturile si expozitiile

#Clientul are urmatoarele permisiuni:
-Register

- Login

- Vizualizare  Opere unde:

 ->Vezi toate operele
 
 -> Vezi opere filtrate dupa stil
 
 -> Apreciere opere (se va pune intr-un fisier csv numele operei, emailul si data la care a fost facuta)
 
 -> Vizualizare numar aprecieri(se vor numara aprecierile din fisierul listaActiuni)

-Vizualizeaza detalii despre viitoarele expozitii

-Creare Cereri pentru Admin

#Artistul poate folosi programul astfel:

-Register

-Login

-Adauga Opere 

-Poate sa elimine din galerie o opera

-Poate sa modifice pretul unei opere

```

```
Obiecte:
 1. Administrator
 2. Vizitator
 3. Opera de arta
 4. Expozitie
 5. Galerie
 6. Artist
 7. Cont
 8. ArtistOpera (este o clasa care reprezinta tabelul asociativ intre artist si opere <mai multi artisti au mai multe opere expuse>)
```
