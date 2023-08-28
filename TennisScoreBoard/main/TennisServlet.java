package com.learning.hello.tennis;

import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/tennis")

public class TennisServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public Game game ;
	private JakartaServletWebApplication application;
	private TemplateEngine templateEngine;
	
	@Override
	  public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	    game = new Game();
	    application = JakartaServletWebApplication.buildApplication(getServletContext());
	    final WebApplicationTemplateResolver templateResolver = 
	        new WebApplicationTemplateResolver(application);
	    templateResolver.setTemplateMode(TemplateMode.HTML);
	    templateResolver.setPrefix("/WEB-INF/templates/");
	    templateResolver.setSuffix(".html");
	    templateEngine = new TemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver);
	  }
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		var out = resp.getWriter();
		final IWebExchange webExchange = this.application.buildExchange(req, resp);
		    final WebContext ctx = new WebContext(webExchange);
		    if(req.getParameter("player1")!=null) {
		    	game.updateScore1();
		    	game.getGame();
		    	ctx.setVariable("player1score",game.getPlayer1Score());
		    	System.out.println(game.getPlayer1Score());
				ctx.setVariable("player2score",game.getPlayer2Score());
				ctx.setVariable("player1match",game.getPlayer1Match());
				ctx.setVariable("player2match",game.getPlayer2Match());
				ctx.setVariable("player1set",game.getPlayer1Set());
				ctx.setVariable("player2set",game.getPlayer2set());
				
			}
		    if(req.getParameter("player2")!=null){
		    	game.updateScore2();
		    	game.getGame();
				ctx.setVariable("player1score",game.getPlayer1Score());
				ctx.setVariable("player2score",game.getPlayer2Score());
				ctx.setVariable("player1match",game.getPlayer1Match());
				ctx.setVariable("player2match",game.getPlayer2Match());
				ctx.setVariable("player1set",game.getPlayer1Set());
				ctx.setVariable("player2set",game.getPlayer2set());
		    }
		    if(req.getParameter("reset")!=null) {
		    	game.reset();
		    	ctx.setVariable("player1score",game.getPlayer1Score());
				ctx.setVariable("player2score",game.getPlayer2Score());
				ctx.setVariable("player1match",game.getPlayer1Match());
				ctx.setVariable("player2match",game.getPlayer2Match());
				ctx.setVariable("player1set",game.getPlayer1Set());
				ctx.setVariable("player2set",game.getPlayer2set());
		    }

		    templateEngine.process("tennis", ctx, out);
		    resp.sendRedirect(req.getServletPath());
	}
	
	@Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    final IWebExchange webExchange = this.application.buildExchange(req, resp);
	    final WebContext ctx = new WebContext(webExchange);
	    templateEngine.process("tennis", ctx, resp.getWriter());
	    ctx.setVariable("player1score",game.getPlayer1Score());
		ctx.setVariable("player2score",game.getPlayer2Score());
		ctx.setVariable("player1match",game.getPlayer1Match());
		ctx.setVariable("player2match",game.getPlayer2Match());
		ctx.setVariable("player1set",game.getPlayer1Set());
		ctx.setVariable("player2set",game.getPlayer2set());
	    //doPost(req,resp);
	  }
}
	