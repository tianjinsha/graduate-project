package com.chengshi.qixingshe.core.validate.code.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.chengshi.qixingshe.core.properties.MineProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import com.chengshi.qixingshe.core.properties.security.SecurityProperties;
import com.chengshi.qixingshe.core.validate.code.ValidateCode;
import com.chengshi.qixingshe.core.validate.code.ValidateCodeGenerator;

import lombok.Data;

/**
 * 图片验证码生成器
 * @author tian
 * @date 2018年11月26日
 */
@Data
public class ImageCodeGenerator implements ValidateCodeGenerator {

	/**
	 * 系统配置
	 */
	@Autowired
	private MineProperties mineProperties;
	
	@Override
	public ValidateCode generate(ServletWebRequest request) {
		int width = ServletRequestUtils.getIntParameter(request.getRequest(), "width", mineProperties.getSecurity().getCode().getImage().getWidth());
		int height = ServletRequestUtils.getIntParameter(request.getRequest(), "height", mineProperties.getSecurity().getCode().getImage().getHeight());
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		Random random = new Random();
		g.setColor(getColor(200, 250));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("TImes new Roman", Font.ITALIC, 20));
		g.setColor(getColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int x1 = random.nextInt(12);
			int y1 = random.nextInt(12);
			g.drawLine(x, y, x + x1, y + y1);
		}

		String sRand = "";
		for (int i = 0; i < mineProperties.getSecurity().getCode().getImage().getLength(); i++) {
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(rand, 13 * i + 6, 16);
		}
		g.dispose();
		return new ImageCode(image, sRand, mineProperties.getSecurity().getCode().getImage().getExpireIn());
	}
	
	/**
	 * 生成随机背景条纹
	 * @param fc
	 * @param bc
	 * @return
	 */
	private Color getColor(int fc ,int bc) {
		Random random=new Random();
		if(fc>255) {
			fc=255;
		}
		if(bc>255) {
			bc=255;
		}
		int r=fc+random.nextInt(bc-fc);
		int g=fc+random.nextInt(bc-fc);
		int b=fc+random.nextInt(bc-fc);
		return new Color(r, g, b);
	}

}
