package com.lti.am.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.am.entity.UserWorkItemEntity;
import com.lti.am.entity.WorkItemEntity;
import com.lti.am.entity.WorkTypeEntity;
import com.lti.am.mapper.MasterMapper;
import com.lti.am.model.UserWorkItemModel;
import com.lti.am.model.WorkItemModel;
import com.lti.am.model.WorkTypeModel;
import com.lti.am.repository.UserWorkItemRepository;
import com.lti.am.repository.WorkItemRepository;
import com.lti.am.repository.WorkTypeRepository;
import com.lti.am.requestresponse.UserWorkItemRequest;
import com.lti.am.requestresponse.WorkItemRequest;
import com.lti.am.requestresponse.WorkTypeRequest;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private WorkTypeRepository workTypeRepository;
	
	@Autowired
	private WorkItemRepository workItemRepository;
	
	@Autowired
	private UserWorkItemRepository userWorkItemRepository;
	
	@Override
	public Boolean saveWorkTypeData(WorkTypeRequest request) {
		WorkTypeEntity entity = MasterMapper.SaveWorkTypeRequestToEntity(request);
		WorkTypeEntity returnEntity = workTypeRepository.save(entity);
		if (returnEntity != null) {
			return true;
		}
		return false;
	}

	@Override
	public WorkTypeModel getWorkTypeDetail(WorkTypeRequest request) {
		WorkTypeEntity entity = workTypeRepository.getOne(request.getWorkTypeCode());
		return MasterMapper.WorkTypeEntityToModel(entity);
	}

	@Override
	public List<WorkTypeModel> getActiveWorkTypeList() {
		List<WorkTypeEntity> list = workTypeRepository.getWorkTypeActiveList();
		return MasterMapper.WorkTypeListEntityToModelList(list);
	}

	@Override
	public Boolean saveWorkItemData(WorkItemRequest request) {
		WorkItemEntity entity = MasterMapper.SaveWorkItemRequestToEntity(request);
		WorkItemEntity returnEntity = workItemRepository.save(entity);
		if (returnEntity != null) {
			return true;
		}
		return false;
	}

	@Override
	public WorkItemModel getWorkItemDetail(WorkItemRequest request) {
		WorkItemEntity entity = workItemRepository.getOne(request.getWorkItemCode());
		return MasterMapper.WorkItemEntityToModel(entity);
	}

	@Override
	public List<WorkItemModel> getActiveWorkItemList() {
		List<WorkItemEntity> list = workItemRepository.getWorkItemActiveList();
		return MasterMapper.WorkItemListEntityToModelList(list);
	}

	@Override
	public Boolean userWorkItemDataSave(UserWorkItemRequest request) {
		UserWorkItemEntity entity = MasterMapper.SaveAssignWorkItemToUserRequestToEntity(request);
		UserWorkItemEntity returnEntity = userWorkItemRepository.save(entity);
		if (returnEntity != null) {
			return true;
		}
		return false;
	}

	@Override
	public UserWorkItemModel userWorkItemDetail(UserWorkItemRequest request) {
		UserWorkItemEntity entity = userWorkItemRepository.getUserWorkItemDetail(request.getUserId());
		return MasterMapper.GetAssignWorkItemToUserEntityToModel(entity);
	}

	@Override
	public List<UserWorkItemModel> userWorkItemModelList(UserWorkItemRequest request) {
		List<UserWorkItemEntity> list = userWorkItemRepository.getAssignUserWorkItemList(request.getUserId());
		return MasterMapper.ListAssignWorkItemToUserEntityToModelList(list);
	}

}
