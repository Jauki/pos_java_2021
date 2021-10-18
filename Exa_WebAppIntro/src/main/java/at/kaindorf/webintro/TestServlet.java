package at.kaindorf.webintro;

import at.kaindorf.webintro.beans.GuestbookEntry;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "TestServlet", value = "/TestServlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter writer = response.getWriter();

        GuestbookEntry entry = new GuestbookEntry("james", "bond@mi6.uk", "Martini");
        GuestbookEntry entry2 = new GuestbookEntry("james", "bond@mi6.uk", "Martini");
        GuestbookEntry[] entries = {entry, entry2};

        List<GuestbookEntry> entryList = Arrays.stream(entries).collect(Collectors.toList());
        //String[] strArr = entryList.stream().map(e -> entry.getNickname()).tos

        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(entry);
        System.out.println(str);
        writer.println(str);
        writer.flush();
        writer.close();
    }
}
