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
			String message = "당신의 관상동맥 질환 발병 확률은 " + core.getRecentResult() +"% 입니다.\n" ;
			message += "\n 패스트푸드 섭취를 줄이고 지속적인 운동을 수행하세요.";
			message += "\n 흡연자는 발병률이 금연자보다 2.2배 높다는 연구결과가 있으니 금연을 권장합니다.";
			message += "\n";
			return message;
		}
		return "관상동맥 질환 진단을 실시하세요\n";
	}
	
	public String diabeteContent(User user)
	{
		DiabetesResult diare = diarepo.findByUserName(user.getUserName());
		if(diare.getRecentResult() != null)
		{
			String message = "당신의 당뇨병 질환 발병 확률은 " + diare.getRecentResult() +"% 입니다.\n" ;
			message += "\n 규칙적인 운동이나 신체활동을 늘리세요. 운동은 최소 2일에 한번, 주일에 3일 이상 시행하는 것이 좋습니다.";
			message += "\n 탄수화물은 가능한 당 지수가 낮은 음식 (전곡류, 콩, 과일, 채소, 유제품 등)을 통해 섭취 하세요.";
			message += "\n";
			return message;
		}
		return "당뇨병 질환 진단을 실시하세요\n";
	}
	
	public String cadioContent(User user)
	{
		
		CardioResult care = carepo.findByUserName(user.getUserName());
		if(care.getRecentResult() != null)
		{
			String message = "당신의 심혈관 질환 발병 확률은 " + care.getRecentResult() +"% 입니다.\n" ;
			message += "\n 흡연시 혈관이 수축하면서 혈액 순환이 잘 안 되고 혈전(피떡)이 생길 수 있으니 금연을 권장합니다.";
			message += "\n 동물성 단백질, 생선, 트랜스 지방, 붉은 고기 가공육, 정제된 탄수화물, 설탕 함유 음료 섭취를 최소화하길 바랍니다.";
			message += "\n";
			return message;
		}
		return "심혈관 질환 진단을 실시하세요\n";
	}

}
