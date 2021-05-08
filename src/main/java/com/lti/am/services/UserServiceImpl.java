package com.lti.am.services;

import java.text.ParseException;
import java.util.List;

import org.aspectj.internal.lang.annotation.ajcPrivileged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.am.entity.UserMessageEntity;
import com.lti.am.entity.UserTimeSheetEntity;
import com.lti.am.entity.WorkTypeEntity;
import com.lti.am.mapper.MasterMapper;
import com.lti.am.mapper.UserMapper;
import com.lti.am.model.UserMessageModel;
import com.lti.am.model.UserTimeSheetModel;
import com.lti.am.repository.UserMessageRepository;
import com.lti.am.repository.UserTimeSheetRepository;
import com.lti.am.requestresponse.UserMessageRequest;
import com.lti.am.requestresponse.UserTimeSheetRequest;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMessageRepository userMessageRepository;
	@Autowired
	private UserTimeSheetRepository userTimeSheetRepository;

	@Override
	public Boolean saveUserTimeSheet(UserTimeSheetRequest request) {
		UserTimeSheetEntity entity;
		UserTimeSheetEntity returnEntity;
		try {
			entity = UserMapper.UserTimeSheetSaveRequestToEntity(request);
			returnEntity = userTimeSheetRepository.save(entity);
			if (returnEntity != null) {
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 
		return false;
	}

	@Override
	public List<UserTimeSheetModel> getUserTimeSheetList(UserTimeSheetRequest request) {
		List<UserTimeSheetEntity> list = userTimeSheetRepository.getUserTimeSheetList(request.getUserId());
		return UserMapper.UserTimeSheetListEntityToModelList(list);
	}

	@Override
	public Boolean saveUserMessage(UserMessageRequest request) {
		UserMessageEntity entity;
		UserMessageEntity returnEntity ;
		try {
			entity = UserMapper.UserMessageSaveRequestToEntity(request);
			returnEntity = userMessageRepository.save(entity);
			if (returnEntity != null) {
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<UserMessageModel> getUserMessageList(UserMessageRequest request) {
		List<UserMessageEntity> list = userMessageRepository.getUserMessageList(request.getToUserID());
		return UserMapper.UserMessageListEntityToModelList(list);
	}

}
