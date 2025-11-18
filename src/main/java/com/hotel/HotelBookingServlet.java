package com.hotel;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HotelBookingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String room = request.getParameter("room");
        String date = request.getParameter("date");

        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.setAttribute("room", room);
        request.setAttribute("date", date);

        RequestDispatcher rd = request.getRequestDispatcher("success.html");
        rd.forward(request, response);
    }
}
