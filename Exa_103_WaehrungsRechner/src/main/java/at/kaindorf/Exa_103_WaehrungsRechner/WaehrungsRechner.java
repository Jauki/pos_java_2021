package at.kaindorf.Exa_103_WaehrungsRechner;

import java.io.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "waehrungsRechner", value = "/waehrungs-rechner")
public class WaehrungsRechner extends HttpServlet {

    Map<String, Float> currency = new HashMap<String, Float>();
    //float exchangerate = 1;

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        float value = parseValue(req.getParameter("betrag"));
        String base = checkInput(req.getParameter("basis")) ? req.getParameter("basis") : "unknown";
        String toCurrency = checkInput(req.getParameter("ziel")) ? req.getParameter("ziel") : "unknown";

        String baseShort = checkInput(req.getParameter("basisShort")) ? req.getParameter("basisShort") : "unknown";
        String curShort = checkInput(req.getParameter("zielShort")) ? req.getParameter("zielShort") : "unknown";

        // Eth = base
        // Dollar Euro
        //     2     5

        currency.put("us_dollar", (float) 1.17);
        currency.put("etherum", (float) 2666.20);
        currency.put("doge", (float) 0.1892);
        currency.put("rand", (float) 17.20);

        float result = 0;
        if(base.equals("euro")){
            result = value;
        }else {
            result = value / currency.get(base);
        }

        if(!toCurrency.equals("euro")) {
            result *= currency.get(toCurrency);
        }

        out.println(toHTML(formatter(baseShort), formatter(curShort), value, result));
        req.getRequestDispatcher("index.jsp").include(req,res);
    }

    public float parseValue (String input) {
        float out = 0;
        log(input);
        if(!input.contains(",") && !input.matches("^[a-zA-Z]*$") && checkInput(input)) {
            out = Float.parseFloat(input);
        } else {
           out = 0;
        }
        return out;
    }

    public String formatter(String str) {
        switch(str) {
            case "us_dollar": return "$";
            case "euro": return "€";
            case "etherum": return "Ξ";
            case "doge": return "Ð";
            case "rand": return "R";
            default: return "";
        }
    }

    public String toHTML(String baseShort, String curShort, float value, float result) {
        String divStyle = "<div class='container card card-body'>";
        return String.format("%s<h1 class='card-title'>Ihr Ergebnis:</h1><br><h2 class='card-text'> %.02f %s = %.02f %s</h2>%s",divStyle, value,baseShort,result,curShort, "</div>");
    }

    public boolean checkInput (String input) {
        if(input == null || input.trim().equals("")){
            return false;
        }
        else {
            return true;
        }
    }

    public void destroy() {
    }
}