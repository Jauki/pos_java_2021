# JSON
**[[Streams]] <- to get back**
First you need to get the JSON file by [[readFile]]
To read a JSON **obj** -> you have to make #ObjectMapper  `ObjectMapper mapper = new ObjectMapper();`

## Anything to JSON
It completley dosent matter if the thing u want to convert/parse is a List/Array/Object. U just need a #ObjectMapper, 
### Implementation

```java
String jsonStr = "";
jsonStr = mapper.writeValueAsString(OBJECT)
```
to Send it back as a respond you just need to put the String in the out.println [[Java Servlet#Println]]!

----
## Map to Array
How an the JSON data to an Array of any Class

### Implementation
```java
OBJECT[] OBJECTSARRAY = mapper.readValue(FILE, OBJECT[].class);
```

## Map to List
If you would like to map the JSON Data to a List you need to **create** an **TypeReference** with no code in the function and no Parameters.

### Implementation
```java
List<OBJECT> OBJECTSLIST = mapper.readValue(FILE, new TypeReference<List<OBJECT>>(){});
```

----
## To Pretty Print (System.Out.Println)

### Implementation
Default console: **System.out**
```java
mapper.writerWithDefaultPrettyPrinter().writeValue(OUTPUTSTREAM, OBJECTSLIST);
```