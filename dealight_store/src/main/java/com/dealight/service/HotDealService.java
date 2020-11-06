package com.dealight.service;

import java.util.List;

import com.dealight.domain.HotDealDetailVO;
import com.dealight.domain.HotDealResultVO;
import com.dealight.domain.HotDealVO;

public interface HotDealService {
	
	// �ֵ� Ȯ��
	// htdl mapper read
	HotDealVO read(long htdlId);
	
	// �ֵ� �� Ȯ��
	// htdlDtls mapper read
	HotDealDetailVO readDtls(long htdlId);
	
	// �ֵ� ��� Ȯ��
	// htdlRslt mapper read
	HotDealResultVO readRslt(long htdlId);
	
	// �ֵ� ���� �ð�
	int calHtdlEndTm(HotDealVO htdl);
	
	// ���� '�� ����'�� ��ϵ� '�ֵ�' ����Ʈ ���� ����
	List<HotDealVO> readAllStoreHtdlList(long storeId);
	
	// ���� '�� ����'�� ��ϵ� '�ֵ�' �� 'Ȱ��ȭ'������ ����Ʈ ����
	List<HotDealVO> readActStoreHtdlList(long storeId);

}
