# Sort
<<<<<<< HEAD
**[[Java Streams]] <- to get back**
=======
**[[Streams]] <- to get back**
>>>>>>> f9544fd698bb8673f8b634300caebfc0f3e9692f
Sort within a stream, bascially there are 3 ways to do it:
1. with `sorted()` can only compare **One Condition**, needs `.collect(Collectors.toList())`
2. with `sort().thenComparing` can have infinity Comparators**(man kann immer `.thenComparing machen`!)**, 
3. with `Comparator.naturalOrder()`, you have to implement an Comparator interface, **needs implementation**


### Implementation:
1. Example
```java
entryList.stream()
	.sorted((e1, e2) -> e1.getNickname().compareTo(e2.getNickname()))
	.collect(Collectors.toList());

```
1. Example #2
```java
LIST.stream()
	.sorted((VARIABLENAME1, VARIABLENAME2) -> VARIABLENAME1.getSOMETHING().compareTo(VARIABLENAME2.getSOMETHING()))
	.collect(Collectors.toList());


```

2. Example
```java
entryList.sort(Comparator.comparing(GuestbookEntry::getNickname)
	.thenComparing(GuestbookEntry::getEmail);
 ```
 2. Example #2
```java
LIST.sort(Comparator.comparing(OBJECT::getSOMETHING)
	.thenComparing(OBJECT::getSOMETHING);

```

3. Example
```java
	entryList.sort(Comparator.naturalOrder());
```
3. Example #2
```java
	LIST.sort(Comparator.naturalOrder());
```