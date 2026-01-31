package com.poly.servlet;

import com.poly.dao.VideoDAO;
import com.poly.dao.VideoDAOImpl;
import com.poly.entity.Video;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/search-video")
public class SearchVideoServlet extends HttpServlet {

    private VideoDAO videoDAO = new VideoDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String keyword = req.getParameter("keyword");

        if (keyword != null && !keyword.isEmpty()) {
            List<Video> videos = videoDAO.findByKeyword(keyword);
            req.setAttribute("videos", videos);
        }

        req.getRequestDispatcher("/search.jsp").forward(req, resp);
    }
}
