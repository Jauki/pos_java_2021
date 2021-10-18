package at.kaindorf.webintro;

import at.kaindorf.webintro.beans.GuestbookEntry;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private List<GuestbookEntry> entries = new ArrayList<>();

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> GET-Request to our HelloServler</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nickname = req.getParameter("nickname");
        if(nickname == null || nickname.trim().equals("")){
            nickname = "unknown";
        }
        String email = req.getParameter("email");
        if(email == null || email.trim().equals("")){
            email = "unknown";
        }
        String comment = req.getParameter("comment");
        if(comment == null || comment.trim().equals("")){
            comment = "unknown";
        }

        GuestbookEntry g = new GuestbookEntry(nickname, email, comment);
        entries.add(g);
    }

    public void destroy() {
    }
}