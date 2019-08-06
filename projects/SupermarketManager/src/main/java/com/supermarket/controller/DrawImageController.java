package com.supermarket.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * ��֤��������
 * @author 13713
 *
 */
@Controller
public class DrawImageController {

	public static final int WIDTH = 120;
	public static final int HEIGHT = 30;
	
	 /**
     * ����ͼƬ
     * @param request
     * @param response
     */
    @RequestMapping("/drawImage")
    public void drawImage(HttpServletRequest request, HttpServletResponse response)throws Exception{
    	request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// ��������
		BufferedImage bi = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		// ��û���
		Graphics g = bi.getGraphics();

		// ���ñ�Ӱɫ
		setBackGround(g);
		// ���ñ߿�
		setBorder(g);
		// ��������
		drawRandomLine(g);
		// д�����
		String random = drawRandomNum((Graphics2D) g);
		// ��������ִ���session��
		request.getSession().setAttribute("checkcode", random);
		// ��ͼ��д�������
		response.setContentType("image/jpeg");
		// ��ͷ�����������Ҫ����
		response.setDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		// ��ͼƬд�������
		ImageIO.write(bi, "jpg", response.getOutputStream());
    }
    
    /**
	 * ���ñ���ɫ
	 * 
	 * @param g
	 */
	private void setBackGround(Graphics g) {
		// ������ɫ
		g.setColor(new Color(22, 160, 133));
		// �������
		g.fillRect(0, 0, WIDTH, HEIGHT);

	}

	/**
	 * ���ñ߿�
	 * 
	 * @param g
	 */
	private void setBorder(Graphics g) {
		// ���ñ߿���ɫ
		g.setColor(new Color(22, 160, 133));
		// �߿�����
		g.drawRect(1, 1, WIDTH - 2, HEIGHT - 2);
	}

	/**
	 * ���������
	 * 
	 * @param g
	 */
	private void drawRandomLine(Graphics g) {
		// ������ɫ
		g.setColor(Color.WHITE);
		// ������������������
		for (int i = 0; i < 5; i++) {
			int x1 = new Random().nextInt(WIDTH);
			int y1 = new Random().nextInt(HEIGHT);
			int x2 = new Random().nextInt(WIDTH);
			int y2 = new Random().nextInt(HEIGHT);
			g.drawLine(x1, y1, x2, y2);
		}

	}

	/**
	 * ���������
	 * 
	 * @param g
	 * @return
	 */
	private String drawRandomNum(Graphics2D g) {
		StringBuffer sb = new StringBuffer();
		// ������ɫ
		g.setColor(Color.WHITE);
		// ��������
		g.setFont(new Font("�����ź�", Font.BOLD, 20));
		// ׼����������
		String base = "0123456789";
		int x = 5;
		// ��������
		for (int i = 0; i < 4; i++) {
			// ����������ת�Ƕ�
			int degree = new Random().nextInt() % 30;
			// ��ȡ����
			String ch = base.charAt(new Random().nextInt(base.length())) + "";
			sb.append(ch);
			// ����Ƕ�
			g.rotate(degree * Math.PI / 180, x, 20);
			g.drawString(ch, x, 20);
			// ����Ƕ�
			g.rotate(-degree * Math.PI / 180, x, 20);
			x += 30;
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
    
}