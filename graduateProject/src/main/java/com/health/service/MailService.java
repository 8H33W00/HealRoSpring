package com.health.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.entity.CardioResult;
import com.health.entity.CoronaryResult;
import com.health.entity.DiabetesResult;
import com.health.entity.User;
import com.health.repository.CardioResultRepository;
import com.health.repository.CoronaryResultRepository;
import com.health.repository.DiabetesResultRepository;

@Service
public class MailService {
	
	@Autowired
	CoronaryResultRepository corepo;
	@Autowired
	DiabetesResultRepository diarepo;
	@Autowired
	CardioResultRepository carepo;
	
	
	
	
	public String coronaryContent(User user)
	{
		CoronaryResult core = corepo.findByUserName(user.getUserName()); 
		if(core.getRecentResult() != null)
		{
			String message = "����� ���󵿸� ��ȯ �ߺ� Ȯ���� " + core.getRecentResult() +"% �Դϴ�.\n" ;
			message += "\n �н�ƮǪ�� ���븦 ���̰� �������� ��� �����ϼ���.";
			message += "\n ���ڴ� �ߺ����� �ݿ��ں��� 2.2�� ���ٴ� ��������� ������ �ݿ��� �����մϴ�.";
			message += "\n";
			return message;
		}
		return "���󵿸� ��ȯ ������ �ǽ��ϼ���\n";
	}
	
	public String diabeteContent(User user)
	{
		DiabetesResult diare = diarepo.findByUserName(user.getUserName());
		if(diare.getRecentResult() != null)
		{
			String message = "����� �索�� ��ȯ �ߺ� Ȯ���� " + diare.getRecentResult() +"% �Դϴ�.\n" ;
			message += "\n ��Ģ���� ��̳� ��üȰ���� �ø�����. ��� �ּ� 2�Ͽ� �ѹ�, ���Ͽ� 3�� �̻� �����ϴ� ���� �����ϴ�.";
			message += "\n ź��ȭ���� ������ �� ������ ���� ���� (�����, ��, ����, ä��, ����ǰ ��)�� ���� ���� �ϼ���.";
			message += "\n";
			return message;
		}
		return "�索�� ��ȯ ������ �ǽ��ϼ���\n";
	}
	
	public String cadioContent(User user)
	{
		
		CardioResult care = carepo.findByUserName(user.getUserName());
		if(care.getRecentResult() != null)
		{
			String message = "����� ������ ��ȯ �ߺ� Ȯ���� " + care.getRecentResult() +"% �Դϴ�.\n" ;
			message += "\n ���� ������ �����ϸ鼭 ���� ��ȯ�� �� �� �ǰ� ����(�Ƕ�)�� ���� �� ������ �ݿ��� �����մϴ�.";
			message += "\n ������ �ܹ���, ����, Ʈ���� ����, ���� ��� ������, ������ ź��ȭ��, ���� ���� ���� ���븦 �ּ�ȭ�ϱ� �ٶ��ϴ�.";
			message += "\n";
			return message;
		}
		return "������ ��ȯ ������ �ǽ��ϼ���\n";
	}

}
