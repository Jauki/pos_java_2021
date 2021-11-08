# Test Stuff for 9 Nov 2021
> Summarized the stuff from:
[[JSON]], [[XML]],[[Java Streams]]

## XML 
Tags are Case Sensitive!

`@XmlAccessorType(XmlAccessType.FIELD)` -> on Class which reads the Object
`@XmlRootElement` -> on the Root element
`@XmlElement(name = "")` -> other name for element in the Object
`@XmlAttribute` -> for attribute in Xml to be parsed to the Object
`@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)` -> Date Adapter

```java
public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {  
    private final static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("E, dd MM yyyy hh:mm:ss z");  
    @Override  
 public LocalDateTime unmarshal(String s) throws Exception {  
        return LocalDateTime.parse(s,DTF);  
    }  
  
    @Override  
 public String marshal(LocalDateTime localDateTime) throws Exception {  
        return localDateTime.format(DTF);  
    }  
}
```

**XML** -> Java
+ Unmarshal
+ returns List

## JSON

`@JsonSerialize(using = LocalDateSerializer.class)` -> for converting to Date in java

`ObjectMapper mapper = new ObjectMapper();` -> maps any Object to JSON
`jsonStr = mapper.writeValueAsString(filteredList);` -> send the String back (`out.println(jsonstr)`) 

```java
public class LocalDateSerializer extends StdSerializer<LocalDate> {  
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);  
  
    protected LocalDateSerializer() {  
        super(LocalDate.class);  
    }  
  
    @Override  
 public void serialize(LocalDate localDate, JsonGenerator jsonGenerator,  
                          SerializerProvider serializerProvider) throws IOException {  
        jsonGenerator.writeString(localDate.format(DTF).toString());  
    }  
}
```


## Load Data

```java 
Path path = Paths.get(this.getServletContext().getRealPath(Paths.get("WEB-INF", "classes", "students_2021.csv").toString()));  
String[] lines = Files.lines(path).skip(1).toArray(String[]::new);  
studentList = Arrays.stream(lines).map(Student::new).collect(Collectors.toList());
```