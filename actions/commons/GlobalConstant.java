package commons;

import java.io.File;

public class GlobalConstant {
	public static final String PROJECT_DIR = System.getProperty("user.dir");
	public static final String UPLOAD_DIR = PROJECT_DIR + File.separator + "uploadFiles";
	public static final int LONG_TIMEOUT = 30;
	public static final int SHORT_TIMEOUT = 5;
	
}
