package com.qa.connecting.utils;

import com.qa.connecting.dao.RemoteDatabaseConnection;

public class Factory {
	Factory factory = null;
	RemoteDatabaseConnection db = null;


public Factory getInstance() {
	
if (factory!=null) {
	return factory;
}
else {
	Factory factory =new Factory();
	return factory;
}
	
}

}	


