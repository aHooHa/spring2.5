package com.sunyahui.service;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

public interface PersonService {
	public Set<String> getSet() ;
	public void save();
	public Properties getProperties();
	public Map<String, String> getMaps();
}