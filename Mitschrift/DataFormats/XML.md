
# XML
Extensible Markup Language
## Dependencies:
uses the [[#JAXB]] library:

```xml
 <dependency>  
 	<groupId>javax.xml.bind</groupId>  
 	<artifactId>jaxb-api</artifactId>  
 	<version>2.2.5</version>  
</dependency>  
<dependency>  
 	<groupId>com.sun.xml.bind</groupId>  
 	<artifactId>jaxb-impl</artifactId>  
 	<version>2.2.5</version>  
</dependency>  
<dependency>  
 	<groupId>com.sun.xml.bind</groupId>  
 	<artifactId>jaxb-xjc</artifactId>  
 	<version>2.2.5</version>  
</dependency>  
<dependency>  
 	<groupId>com.sun.activation</groupId>  
 	<artifactId>javax.activation</artifactId>  
 	<version>1.2.0</version>  
</dependency>
```

## Basics
The syntax is similar to **HTML** (Hyper text MarkUp Language), but in XML the tags are used to declare a **Variable**. Between the Tag `<foo></foo>` is the value of the variable in our example it would look like this: 

`<foo> 69 </foo>`

From this declaration you see that *foo* is the **variable** name and `69` is the **value** of it

The **value** of the variable is not important you can use a **String** or **Date**...

### Relations:
>from @heinz 
+ **Root**:  ^71b53e
	+ Wurzelelement Das einzige, oberste Element im XML-Dokument. 
+ **Parent**:
	+  Elternelement Ein Element das ein oder mehrere weitere Elemente enthält. 
+ **Child**:  ^1a7336
	+ Kindelement Ein Element das innerhalb eines anderen Elements definiert wurde. 
+ **Sibling**: 
	+ Geschwisterelement Ein Element das in derselben Ebene wie ein weiteres Element steht.

### Attributes
They are basically Variables inside the the tag like `<foo name="bar"></foo>`. Usage for attributes are normally *UID[^UID] / ID* or somthing like this


#### XML Header
The **header** just says what XML version the document is running and what encoding it uses. Sometimes if the document is more compilcated, **variables** from other documents will be defined here. *(rss:foo)* Example:

```xml
<buch xmlns="http://www.oreilly.com/javaxml2"
 xmlns:ora="http://www.oreilly.com">
</buch>
```

## JAXB
*Data-binding* library for JAVA-SE -> Java Objects are being **converted** / **parsed** to a XML Document. The same thing goes**reversed!**
+ #Marshalling: Java Objects -> XML Document **(parses)**
+ #Unmarshalling: XML Document -> Java Object **(resolves)**

To declare the [[XML#^71b53e|Rootelement]] in java you have to set a **Annotation**: `@XmlRootElement`

**Example:**
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<student>
	<dateOfBirth>2004-10-23</dateOfBirth>
	<name>David</name>
</student>
```
 
 Here you can see the Student is the [[XML#^71b53e|Rootelement]] and `<name/>` is the [[xml#^1a7336|Child]] To get the Schema in Java define a Class with the same varibale names and put the **annotation** before the Class:
 
 ```java
@XmlRootElement
public class Student { 
	private String name; 
	private Date dateOfBirth;
}
```


[^UID]: Unique Identification 