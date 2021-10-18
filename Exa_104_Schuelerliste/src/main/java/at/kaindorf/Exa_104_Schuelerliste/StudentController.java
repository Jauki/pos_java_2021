package at.kaindorf.Exa_104_Schuelerliste;

import at.kaindorf.Exa_104_Schuelerliste.beans.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet(name = "StudentController", value = "/StudentController")
public class StudentController extends HttpServlet {
    private List<Student> studentList = new ArrayList<>();


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            loadData();
        } catch(IOException e) {
            System.out.println(e);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/json");
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(studentList);
        out.println(jsonStr);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/json");
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = "";

        if(request.getParameter("filter")!= null){
            String filter = request.getParameter("filter").toLowerCase();
            List<Student> filteredList = studentList.stream()
                    .filter(student -> student.getName().toLowerCase().contains(filter)||student.getSuname().toLowerCase().contains(filter))
                    .collect(Collectors.toList());
            jsonStr = mapper.writeValueAsString(filteredList);
        }else{
            // man könnte die Suche mit einer, beim einlesen vergebenen UID verschnellern ??
            // Für jeden Schüler eine UID -> schnellers finden durch index übergeben wird auch der index
            String name = request.getParameter("name");
            //Student student = studentList.stream().filter(s -> name.equals(s.getFullName())).findAny().orElse(null);

            Student x = null;
            for (Student s: studentList
                 ) {
                if((s.getName()+ " " +s.getSuname()).equals(name)){
                    x = s;
                }
            }
            jsonStr = mapper.writeValueAsString(x);
        }



        mapper.writerWithDefaultPrettyPrinter().writeValue(System.out, jsonStr);
        out.println(jsonStr);
    }

    public void loadData() throws IOException {
        Path path = Paths.get(this.getServletContext().getRealPath(Paths.get("WEB-INF", "classes", "students_2021.csv").toString()));
        String[] lines = Files.lines(path).skip(1).toArray(String[]::new);
        studentList = Arrays.stream(lines).map(Student::new).collect(Collectors.toList());
        studentList.sort(Comparator.comparing(Student::getClassName).thenComparing(Student::getSuname));
        String strClass = studentList.get(0).getClassName();
        int i = 0;
        for (Student e : studentList) {
            if(strClass.equals(e.getClassName())){
                i++;
                e.setCatNo(i);
            } else{
                i = 1;
                e.setCatNo(i);
                strClass = e.getClassName();
            }
        }
    }
}
