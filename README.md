# Instructions de l'exercice

Vous devez compléter les méthodes dans le **contrôleur**, le **service** et le **repository**.

Les méthodes sont fournies soit vides, soit avec un `return null`, par exemple : 
```java

    @GetMapping("/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable Long id) {
        return null;
    }
```
L'objectif de l'exercice est de manipuler les `ResponseEntity` et de retourner les bons statuts HTTP :

- **`200 OK`** : pour une requête réussie
- **`201 Created`** : pour une création de ressource
- **`204 NO_CONTENT`** : pour une suppression réussie (`DELETE`)



## Structure du projet

Le projet est organisé comme suit :

```
interview-java/
│-- src/
│   │-- main/
│   │   ├── java/com/invivoo/hackerrank
│   │   ├    ├── controller
│   │   ├    ├── repository
│   │   ├    ├── service
│   │-- test/
│       ├── java/com/tests/      # Tests unitaires à completer
│-- README.md
│-- pom.xml (si Maven) / build.gradle (si Gradle)
```

### Ce projet contient la solution avec les classes implémentées.