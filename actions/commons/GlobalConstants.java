package commons;

import java.io.File;

public class GlobalConstants {
	public static final String DEV_URL_STRING = "";
	public static final String STAG_URL_STRING = "";
	public static final String PRODUCTION_URL_STRING = "";

	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;

	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE_PATH = PROJECT_PATH + File.separator + "downloadFiles";

	public static final String DEV_DB_URL = "";

}
