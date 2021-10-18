package at.kaindorf.webintro;

import at.kaindorf.webintro.beans.GuestbookEntry;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private List<GuestbookEntry> entries = new ArrayList<>();

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");


        // Hello
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("index.jsp").include(request, response);
        for (GuestbookEntry listEntry: entries) {
            out.println(listEntry.toHtmlString());
        }
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
        String[] selectedSeason = req.getParameterValues("season");

        GuestbookEntry g = new GuestbookEntry(nickname, email, comment);
        entries.add(g);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        req.getRequestDispatcher("index.jsp").include(req,resp);
        for (GuestbookEntry listentry: entries) {
            out.println(listentry.toHtmlString());
        }



    }

    public void destroy() {
    }
}