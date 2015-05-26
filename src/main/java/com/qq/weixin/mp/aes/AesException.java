package com.qq.weixin.mp.aes;

@SuppressWarnings("serial")
public class AesException extends Exception {

	public final static int OK = 0;
	public final static int ValidateSignatureError = -40001;
	public final static int ParseXmlError = -40002;
	public final static int ComputeSignatureError = -40003;
	public final static int IllegalAesKey = -40004;
	public final static int ValidateCorpidError = -40005;
	public final static int EncryptAESError = -40006;
	public final static int DecryptAESError = -40007;
	public final static int IllegalBuffer = -40008;
	//public final static int EncodeBase64Error = -40009;
	//public final static int DecodeBase64Error = -40010;
	//public final static int GenReturnXmlError = -40011;

	private int code;

	private static String getMessage(int code) {
		switch (code) {
		case ValidateSignatureError:
			return "\u7B7E\u540D\u9A8C\u8BC1\u9519\u8BEF";
		case ParseXmlError:
			return "xml\u89E3\u6790\u5931\u8D25";
		case ComputeSignatureError:
			return "sha\u52A0\u5BC6\u751F\u6210\u7B7E\u540D\u5931\u8D25";
		case IllegalAesKey:
			return "SymmetricKey\u975E\u6CD5";
		case ValidateCorpidError:
			return "corpid\u6821\u9A8C\u5931\u8D25";
		case EncryptAESError:
			return "aes\u52A0\u5BC6\u5931\u8D25";
		case DecryptAESError:
			return "aes\u89E3\u5BC6\u5931\u8D25";
		case IllegalBuffer:
			return "\u89E3\u5BC6\u540E\u5F97\u5230\u7684buffer\u975E\u6CD5";
//		case EncodeBase64Error:
//			return "base64\u52A0\u5BC6\u9519\u8BEF";
//		case DecodeBase64Error:
//			return "base64\u89E3\u5BC6\u9519\u8BEF";
//		case GenReturnXmlError:
//			return "xml\u751F\u6210\u5931\u8D25";
		default:
			return null; // cannot be
		}
	}

	public int getCode() {
		return code;
	}

	AesException(int code) {
		super(getMessage(code));
		this.code = code;
	}

}
