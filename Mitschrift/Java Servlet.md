# Java Servlet
[^html]: Only in String like: "\<h1>\</h1>" 

## Response
If you want to send something back u need the #response Parameter

### PrintWriter
The PrintWriter is for returning somthing, u can return anything you want String, HTML[^html] To create a PrintWriter you have to get it from the #response: 
`PrintWriter writer = response.getWriter()`

#### Println
It prints the parameter to the response you can choose a type with `response.setContentType("text/json");`, u have to replace the json with plain or any Text Format you want:
`writer.println(parameter)`

## Request
If you want to read something you need the #request

### Get Data from the Frontend
If you want to get data from the frontend u firstly need to make a [[GET]]/[[POST]] Request via **\<form>** or via the `fetch(url)` [[Fetch]], in both cases u have to set a destinct parameter in the form u just have to have a input with a **name** prop. For Example: 

\<input name="inputField" value="test123"/>

In the fetch url to get parameters you have to set a body in the [[POST]] request