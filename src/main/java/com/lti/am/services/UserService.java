package com.lti.am.services;

import java.util.List;

import com.lti.am.model.UserMessageModel;
import com.lti.am.model.UserTimeSheetModel;
import com.lti.am.requestresponse.UserMessageRequest;
import com.lti.am.requestresponse.UserTimeSheetRequest;

public interface UserService {
	Boolean saveUserTimeSheet(UserTimeSheetRequest request);
	List<UserTimeSheetModel> getUserTimeSheetList(UserTimeSheetRequest request);
	
	Boolean saveUserMessage(UserMessageRequest request);
	List<UserMessageModel> getUserMessageList(UserMessageRequest request);
	
	
}
