# Filter
**[[Java Streams]] <- to get back**
Filter within a stream, bascially there are 2 ways to do it:
1. with `filter()` to get a **copy** of the **origin** List, needs `.collect(Collectors.toList())`
2. with `removeIf()` returns the **origin List** and **deletes** the Objects if the Condition is **true**


### Implementation:
1. Example
```java
entryList = entryList.stream()
	.filter(guestbookEntry -> guestbookEntry.getEmail().contains("bond"))
	.collect(Collectors.toList());

```
1. Example #2
```java
LIST = LIST.stream()
	.filter(VARIABLENAME -> 
VARIABLENAME.getSOMETHING().contains(SOMETHING))
	.collect(Collectors.toList());

```

2. Example
```java
entryList.removeIf(
	guestbookEntry -> guestbookEntry.getEmail().contains("bond")
);
 ```
 2. Example #2
```java
LIST.removeIf(
	VARIABLENAME -> VARIABLENAME.getSOMETHING.contains(SOMETHING)
);

```