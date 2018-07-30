package com.example.sleep;

@java.lang.SuppressWarnings("serial")
@javax.servlet.annotation.WebServlet(urlPatterns = { "/*" })
public class EchoServlet extends javax.servlet.http.HttpServlet {
	@Override
	protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		StringBuilder builder = new StringBuilder();
		builder.append("## Header ----------------------------------------------").append("\r\n");
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String name = headerNames.nextElement();
			String value = request.getHeader(name);
			builder.append(name).append(": ").append(value).append("\r\n");
		}
		builder.append("\r\n");
		builder.append("## Content ---------------------------------------------").append("\r\n");
		try (java.io.BufferedReader reader = new java.io.BufferedReader(
				new java.io.InputStreamReader(request.getInputStream()))) {
			String line = null;
			while (null != (line = reader.readLine())) {
				builder.append(line).append("\r\n");
			}
		}
		response.getWriter().println(builder.toString());
	}
}
