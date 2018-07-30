package com.example.sleep;

@javax.servlet.annotation.WebFilter("*")
public class SleepFilter implements javax.servlet.Filter {
	public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {}
	public void destroy() {}
	public void doFilter(javax.servlet.ServletRequest servletRequest, javax.servlet.ServletResponse servletResponse,
			javax.servlet.FilterChain chain) throws java.io.IOException, javax.servlet.ServletException {
		if (servletRequest instanceof javax.servlet.http.HttpServletRequest) {
			String sleepHeader = ((javax.servlet.http.HttpServletRequest) servletRequest).getHeader("XX-SLEEP");
			if (sleepHeader != null && !sleepHeader.isEmpty() && sleepHeader.matches("[0-9]+")) {
				long sleep = Long.parseLong(sleepHeader);
				long start = System.currentTimeMillis();
				System.out.println("### begin :: sleep ");
				try {
					Thread.sleep(sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.printf("### done  :: sleep (%d)\n", System.currentTimeMillis() - start);
			}
		}
		chain.doFilter(servletRequest, servletResponse);
	}
}
