package com.dealight.service;

import java.util.List;

import com.dealight.domain.HotDealDetailVO;
import com.dealight.domain.HotDealResultVO;
import com.dealight.domain.HotDealVO;

public interface HotDealService {
	
	// �ֵ� Ȯ��
	// htdl mapper read
	// select
	HotDealVO read(long htdlId);
	
	// �ֵ� �� Ȯ��
	// htdlDtls mapper read
	// select
	HotDealDetailVO readDtls(long htdlId);
	
	// �ֵ� ��� Ȯ��
	// htdlRslt mapper read
	// select
	HotDealResultVO readRslt(long htdlId);
	
	// �ֵ� ���� �ð� ī��Ʈ �ٿ�
	// �ֵ� ���� �ð� - ����ð�
	int calHtdlEndTm(HotDealVO htdl);
	
	// mapper method �ʿ�
	// ���� '�� ����'�� ��ϵ� '�ֵ�' ����Ʈ '����' ����
	List<HotDealVO> readAllStoreHtdlList(long storeId);
	
	// mapper method �ʿ�
	// ���� '�� ����'�� ��ϵ� '�ֵ�' �� 'Ȱ��ȭ'������ ����Ʈ ����
	// htdl_stus_cd = 'A'
	List<HotDealVO> readActStoreHtdlList(long storeId);

}
