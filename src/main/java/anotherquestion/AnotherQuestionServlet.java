package anotherquestion;

import org.json.JSONObject;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by icondor on 04/02/17.
 */

@WebServlet("/aq")
public class AnotherQuestionServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) {

        String action = request.getParameter("action");
        if(action!=null && action.equals("list"))
        {
            System.out.println("voi afisa lista ");

            //fac jsonul - iau din baza de date si pun in json si pe urma returnez json pe response cu returnJsonResponse
            JSONObject json = new JSONObject();
            json.put("questions",SingleList.getInstance().getIntrebari());
            String result=json.toString();
            System.out.println("result:"+result);
            returnJsonResponse(response, result);


            /*

        {"tasks":[{"name":"prima intrebare"},{"name":"a doua intrebare"}]}

             */

        }

        else {

            System.out.println("voi adauga in lista");
            String intrebarea = request.getParameter("value");


            SingleList.getInstance().addIntrebare(intrebarea);


            SingleList.getInstance().afiseza();
            System.out.println("------------");
        }


    }


    private void returnJsonResponse(HttpServletResponse response, String jsonResponse) {
        response.setContentType("application/json");
        PrintWriter pr = null;
        try {
            pr = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert pr != null;
        pr.write(jsonResponse);
        pr.close();
    }
}
