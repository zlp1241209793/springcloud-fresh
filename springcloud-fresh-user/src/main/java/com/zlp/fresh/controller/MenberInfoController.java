package com.zlp.fresh.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zlp.fresh.entity.MenberInfo;
import com.zlp.fresh.service.IMenberInfoService;
import com.zlp.fresh.util.ResponseUtil;
import com.zlp.fresh.util.SendMailUtil;
import com.zlp.fresh.util.VerifyCode;

@Controller
@RequestMapping("/member")
public class MenberInfoController {
	@Autowired
	private SendMailUtil sendMailUtil; // 邮件发送的工具类
	
	@Autowired
	private IMenberInfoService menberInfoService;
	
	/**
	 * 邮箱发送验证码
	 * @param receive
	 * @param name
	 * @param session
	 * @return
	 */
	@RequestMapping("/code")
	@ResponseBody
	public Map<String, Object> sendCode(String receive, String name, HttpSession session) {
		String code = "";
		Random rd = new Random();
		while (code.length() < 6) {
			code += rd.nextInt(10);
		}
		
		if (sendMailUtil.sendHtmlMail(receive, name, code)) {
			session.setAttribute("sendCode", code);
			
			TimerTask task = new TimerTask() {
				
				@Override
				public void run() {
					session.removeAttribute("sendCode");
				}
			};
			
			Timer timer = new Timer();
			timer.schedule(task, 180000); // 3分钟后执行任务一次
			
			return ResponseUtil.responseMap(200, null, null);
		}
		return ResponseUtil.responseMap(500, null, null);
	}
	
	/**
	 * 生成图片验证码
	 * @param response
	 * @param request
	 */
	@RequestMapping("/getCode")
	public void getCode(HttpServletResponse response, HttpServletRequest request) {

		/* 获取验证码图片*/
		try {

			int width=200;

			int height=100;

			BufferedImage verifyImg=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

			//生成对应宽高的初始图片

			String randomText = VerifyCode.drawRandomText(width,height,verifyImg);

			//单独的一个类方法，出于代码复用考虑，进行了封装。

			//功能是生成验证码字符并加上噪点，干扰线，返回值为验证码字符                   

			request.getSession().setAttribute("validateCode", randomText);
			System.out.println(randomText);

			response.setContentType("image/png");//必须设置响应内容类型为图片，否则前台不识别

			OutputStream os = response.getOutputStream(); //获取文件输出流    

			ImageIO.write(verifyImg,"png",os);//输出图片流

			os.flush();

			os.close();//关闭流

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 会员注册
	 * @param session
	 * @param mf
	 * @return
	 */
	@RequestMapping("/reg")
	@ResponseBody
	public Map<String, Object> reg(HttpSession session, MenberInfo mf) {
		Object object = session.getAttribute("sendCode");
		if (object == null) { // 说明验证码过期了
			return ResponseUtil.responseMap(501, null, null);
		}
		
		String code = (String) object;
		if (!code.equals(mf.getRealName())) { // 验证码错误
			return ResponseUtil.responseMap(502, null, null);
		}
		
		int result = menberInfoService.reg(mf);
		if (result > 0) {
			return ResponseUtil.responseMap(200, null, null);
		}
		return ResponseUtil.responseMap(503, null, null);
	}
	
	/**
	 * 会员登录
	 * @param session
	 * @param mf
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Map<String, Object> login(HttpSession session, MenberInfo mf) {
		String code = mf.getRealName();
		String vcode = (String) session.getAttribute("validateCode");
		System.out.println(vcode);
		if (!code.equalsIgnoreCase(vcode)) { 
			return ResponseUtil.responseMap(501, null, null);
		}
		
		MenberInfo menberInfo = menberInfoService.login(mf);
		
		if (menberInfo == null) {
			return ResponseUtil.responseMap(500, null, null);
		}
		
		session.setAttribute("loginMember", menberInfo);
		return ResponseUtil.responseMap(200, null, null);
	}
	
	/**
	 * 检验用户有没有登录
	 * @param session
	 * @return
	 */
	@RequestMapping("/check")
	@ResponseBody
	public Map<String, Object> checkLogin(HttpSession session) {
		Object object = session.getAttribute("loginMember");
		if (object == null) {
			return ResponseUtil.responseMap(500, null, null);
		}
		
		return ResponseUtil.responseMap(200, null, object);
	}
}
