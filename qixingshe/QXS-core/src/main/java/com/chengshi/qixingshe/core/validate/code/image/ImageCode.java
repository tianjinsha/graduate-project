package com.chengshi.qixingshe.core.validate.code.image;

import com.chengshi.qixingshe.core.validate.code.ValidateCode;

import java.awt.image.BufferedImage;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.time.LocalDateTime;

/**
 * 图片验证码
 * @author tian
 * @date 2018年11月26日
 */
public class ImageCode extends ValidateCode  implements Externalizable {
	private BufferedImage bufferedImage;

	public  ImageCode(){}

	/**
	 * 图片验证构造
	 * @param bufferedImage
	 * @param code
	 * @param expireTime 过期具体时间
	 */
	public ImageCode(BufferedImage bufferedImage, String code, LocalDateTime expireTime) {
		super(code, expireTime);

		this.bufferedImage = bufferedImage;
	}

	/**
	 * 图片验证构造
	 * @param bufferedImage
	 * @param code
	 * @param expireSec 过期的秒数
	 */
	public ImageCode(BufferedImage bufferedImage, String code, int expireSec) {
		super(code, expireSec);
		this.bufferedImage = bufferedImage;
	}

	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	public void setBufferedImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}

	@Override
	public void writeExternal(ObjectOutput out) {
        try{

        }catch (Exception e){
            System.out.println("error");
        }
	}

	@Override
	public void readExternal(ObjectInput in) {
	    try{

        }catch (Exception e){
	        System.out.println("error");
        }
	}
}
