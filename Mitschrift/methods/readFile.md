# ReadFile
<<<<<<< HEAD
**[[Java Streams]] <- to get back**
=======
**[[Streams]] <- to get back**
>>>>>>> f9544fd698bb8673f8b634300caebfc0f3e9692f
How to read a file -> basically there are 2 ways
1. `System.getProperty` takes the path in the **not** compiled version of the Project
2. `getServletContext()` takes the file of the compilied version which is in  `/target/APP-NAME-SNAPSHOT` 


### Implementation:
1. Example
```java
File jsonFile = Paths.get(System.getProperty("user.dir"),  
        "src", "main", "resources", "person.json").toFile();
```

1. Example #2
```java
File FILENAME = Paths.get(System.getProperty("user.dir"),  
        "/PATH").toFile();
```

2. Example
```java
Path path = Paths.get(this.getServletContext().getRealPath(Paths.get("WEB-INF", "classes", "schuelerdaten.csv").toString()));
```

2. Example #2
```java
Path PATH = Paths.get(this.getServletContext().getRealPath(Paths.get("/PATH").toString()));
```

----

# Map the Input File
via **InputStreams**!

```java
String[] lines = Files.lines(path).skip(1).toArray(String[]::new);  
studentList = Arrays.stream(lines).map(Student::new).collect(Collectors.toList());

```