package com.ph34757.sof3011.utils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;

public interface ServletUtils<Entity> {
          void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

          void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException;

          void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

          void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

          void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException;

          void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException;

          void filter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

          Entity getEntityAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException;

          Entity getEntityUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException;

          boolean validate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException;
}
