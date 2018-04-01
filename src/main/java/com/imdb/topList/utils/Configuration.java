package com.imdb.topList.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	private final static Properties prop = new Properties();
	static {
		try {
			prop.load(new FileInputStream("config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
	}

	private final static String url = getProperties("url");
	private final static int implicit = Integer.parseInt(getProperties("implicit"));
	private final static int pageLoad = Integer.parseInt(getProperties("pageLoad"));
	private final static int explicit = Integer.parseInt(getProperties("explicit"));
	private final static int script = Integer.parseInt(getProperties("script"));

	public static int getScript() {
		return script;
	}

	private final static String getProperties(String akey) {
		return prop.getProperty(akey);
	}

	public static String getUrl() {
		return url;
	}

	public static int getImplicit() {
		return implicit;
	}

	public static int getPageload() {
		return pageLoad;
	}

	public static int getExplicit() {
		return explicit;
	}

}
