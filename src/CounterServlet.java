import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/text")
public class CounterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text =request.getParameter("txt");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        writer.println(text);

        writer.println("<html>");
            writer.println("<h1>");
                writer.println("Ilosc slow: " + nrOfWords(text));
                writer.println("<div>");
                writer.println("Ilosc znakow: " + text.length());
                writer.println("</div>");
                writer.println("Ilosc znakow bez spacji: " + countWordWoSpace(text));
                writer.println("<div>");
                writer.println("Palindrom: " + isPalindrome(text));
                writer.println("</div>");
            writer.println("</h1>");
        writer.println("</html>");
    }

    public int countWordWoSpace(String txt){
        String txtNew = txt.replace(" ", "");

        return txtNew.length();
    }

    public static int nrOfWords(String txt) {
        String[] parts = txt.split(" ");
        return parts.length;
    }
    public static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
