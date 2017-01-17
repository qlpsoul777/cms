package com.qlp.cms.filter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class CaptchaFilter extends OncePerRequestFilter {
	
	private final static int HEIGHT = 40;
	private final static int WIDTH = 80;
	private final static char MAPTABLE[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','p','q',
			'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z','1','2','3','4','5','6','7','8','9'};

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		response.setDateHeader("Expires", 0L);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
		BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		// 获取图片上下文
		Graphics g = image.getGraphics();
	    // 设定背景色       
	    g.setColor(getRandColor(200,250));       
	    g.fillRect(0, 0, WIDTH, HEIGHT);
	    String strEnsure = "";
		// 4代表4为验证码，如果要产生更多位的验证码，则加大数值
		for (int i = 0; i < 4; i++) {
			strEnsure += MAPTABLE[(int) (MAPTABLE.length * Math.random())];
		}
		// 设定字体       
		g.setFont(new Font("Times New Roman",Font.PLAIN,24)); 
		// 将认证码显示到图像中，如果要生成更多位的验证码，增加drawString语句
		g.setColor(Color.black);
		String str = strEnsure.substring(0, 1);
		g.drawString(str, 8, 24);
		str = strEnsure.substring(1, 2);
		g.drawString(str, 23, 24);
		str = strEnsure.substring(2, 3);
		g.drawString(str, 38, 24);
		str = strEnsure.substring(3, 4);
		g.drawString(str, 53, 24);
		// 生成随机类       
		Random random = new Random(); 
	    // 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到       
	    g.setColor(getRandColor(160,200));
	    for (int i=0;i<155;i++){       
		    int x = random.nextInt(WIDTH);       
		    int y = random.nextInt(HEIGHT);       
		    int xl = random.nextInt(12);       
		    int yl = random.nextInt(12);       
		    g.drawLine(x,y,x+xl,y+yl);       
	    } 
		// 释放图形上下文
		g.dispose();
		ServletOutputStream out = response.getOutputStream();
		request.getSession().setAttribute("captchaCode", strEnsure);
		ImageIO.write(image, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
	}
	
	private Color getRandColor(int fc, int bc) {
		Random random = new Random();       
	    if(fc>255) fc=255;       
	    if(bc>255) bc=255;       
	    int r=fc+random.nextInt(bc-fc);       
	    int g=fc+random.nextInt(bc-fc);       
	    int b=fc+random.nextInt(bc-fc);       
	    return new Color(r,g,b); 
	}

}
