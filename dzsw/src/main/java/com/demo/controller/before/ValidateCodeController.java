package com.demo.controller.before;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValidateCodeController {
	private char code[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
			'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', '0' };
	private static final int WIDTH=50;
	private static final int HEIGHT=20;
	private static final int LENGTH=4;
	@RequestMapping("/validateCode")
	public void validateCode(HttpServletRequest request,HttpServletResponse response) {
		//设置相应报头
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		//设置相应的MIME类型
		response.setContentType("image/jpeg");
		BufferedImage image=new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		Font mFont=new Font("Arial",Font.TRUETYPE_FONT,18);
		Graphics g=image.getGraphics();
		Random rd=new Random();
		//背景颜色
		g.setColor(new Color(rd.nextInt(55)+200,rd.nextInt(55)+200,rd.nextInt(55)+200));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		/* 字体 */
		g.setFont(mFont);
		/* 画边框 */
		g.setColor(Color.black);
		g.drawRect(0, 0, WIDTH-1, HEIGHT-1);
		
		/* 随机产生的验证码 */
		String  result="";
		for(int i=0;i<LENGTH;i++) {
			result+=code[rd.nextInt(code.length)];
		}
		HttpSession session=request.getSession();
		session.setAttribute("code", result);
		//化验证码
		for(int i=0;i<result.length();i++) {
			g.setColor(new Color(rd.nextInt(200),rd.nextInt(200),rd.nextInt(200)));
			g.drawString(result.charAt(i)+"", 12*i+1, 16);
		}
		/* 随机产生干扰线 */
		for(int i=0;i<2;i++) {
			g.setColor(new Color(rd.nextInt(200),rd.nextInt(200),rd.nextInt(200)));
			int x1=rd.nextInt(WIDTH);
			int x2=rd.nextInt(WIDTH);
			int y1=rd.nextInt(HEIGHT);
			int y2=rd.nextInt(HEIGHT);
			g.drawLine(x1, y1, x2, y2);
		}
		/* 释放图形资源 */
		g.dispose();
		try {
			OutputStream os = response.getOutputStream();
			ImageIO.write(image, "JPEG", os);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
