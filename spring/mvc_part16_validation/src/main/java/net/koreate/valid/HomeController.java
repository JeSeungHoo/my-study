package net.koreate.valid;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.koreate.valid.vo.ValidationMemberVO;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;

@Controller
public class HomeController {
	
	@Autowired
	JavaMailSender mailSender;
	

    private DefaultMessageService messageService;

    @PostConstruct
    public void init(){
        this.messageService = NurigoApp.INSTANCE.initialize("NCSOSUQP7ILDDKLL", "0NWRX81AS1CFX7DQNKH3RWVOKIKJXLJU", "https://api.coolsms.co.kr");
    }

	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@GetMapping("regex")
	public void regex() {}
	
	@GetMapping("/user/join")
	public String join() {
		return "user/join";
	}
	
	@GetMapping("/user/joinVal")
	public void joinVal() {}
	
	@GetMapping("/user/login")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("/user/uidCheck")
	@ResponseBody
	public boolean isCheck(String u_id) {
		boolean isCheck = false;
		System.out.println("u_id : " + u_id);
		if(u_id != null && !u_id.equals("chlrlrms@gmail.com")) {
			// ???????????? ?????? ????????? ?????????
			isCheck = true;
		}
		// ????????? ????????? ????????? 
		return isCheck;
	}
	
	@GetMapping("/checkEmail")
	@ResponseBody
	public String sendMail(
			@RequestParam("u_id") String email
			)throws Exception{
		System.out.println(email);
		String code = "";
		for(int i=0; i<5; i++) {
			code += (int)(Math.random()*10);
		}
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper
			= new MimeMessageHelper(message,"UTF-8");
		helper.setFrom("chlrlrms1@gmail.com");
		helper.setTo(email);
		helper.setSubject("????????? ?????? ?????? ??????");
		helper.setText("?????? ?????? ????????? ??????????????????.<h3>["+code+"]</h3>",true);
		mailSender.send(message);
		System.out.println("?????? ??????");		
		return code;
	}
	
	// ???????????? ?????? ?????? ????????? ??????
	@PostMapping("/sendSMS")
	@ResponseBody
	public Map<String,String> sendSMS(
			String userPhoneNumber
			) throws Exception{
		// code ??????
		String code = "";
		for(int i=0; i<5; i++) {
			code += (int)(Math.random()*10);
		}
		
		Message message = new Message();
        // ???????????? ??? ??????????????? ????????? 01012345678 ????????? ??????????????? ?????????.
        message.setFrom("01094867166");
        // ????????? ?????? - ?????? ?????? ??????
        // message.setTo("01000000000");
        message.setTo(userPhoneNumber);
        message.setText("???????????? ????????? ?????????["+code+"]????????? ????????? ??????!");

        SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
        System.out.println(response);
	
        Map<String,String> map = new HashMap<>();
        map.put("code", code);
        map.put("result", response.getStatusCode());
        return map;
	}
	
	@Autowired
	ServletContext context;
	
	// ?????? ?????? ??????
	@PostMapping("/user/joinPost")
	public String joinPost(
				ValidationMemberVO vo,
				MultipartFile profileImage
			)throws Exception{
		System.out.println(vo);
		// ????????? ?????? ????????? ???????????? ????????? true
		System.out.println(profileImage.isEmpty());
		System.out.println(profileImage.getOriginalFilename());
		System.out.println(profileImage.getContentType());
		// ?????? ?????? ???????????? ??????
		System.out.println(profileImage.getName());
		if(!profileImage.isEmpty()) {
			// src/main/webapp/upload/profile/u_id/image
			String path = "upload"+File.separator 
						  +"profile"+File.separator
						  +vo.getU_id();
			String realPath = context.getRealPath(path);
			File file = new File(realPath);
			if(!file.exists()) {
				file.mkdirs();
			}
			file = new File(
					realPath, 
					profileImage.getOriginalFilename()
			);
			profileImage.transferTo(file);
			String u_profile
			= path+File.separator+profileImage.getOriginalFilename();
			vo.setU_profile(u_profile);
		}
		System.out.println(vo);
		return "home";
	}
	
}













