package com.eomcs.lms.web.json;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

// @RestController
// => request handler의 리턴 값이 응답 데이터임을 선언한다.
// => 리턴 값은 내부에 설정된 HttpMessageConverter에 의해 JSON 문자열로 변환하여 보낸다.
// 
@RestController("json.MemberController")
@RequestMapping("/json/member")
public class MemberController {

  @Resource
  private MemberService memberService;

  @RequestMapping("form")
  public void form() {
  }

  @RequestMapping("add")
  public JsonResult add(Member member) 
      throws Exception {
    try {
      memberService.insert(member);
      return new JsonResult().setState(JsonResult.SUCCESS);
      
    } catch (Exception e) {
      return new JsonResult()
          .setState(JsonResult.FAILURE)
          .setMessage(e.getMessage());
    }

  }

  @RequestMapping("delete")
  public JsonResult delete(int no) 
      throws Exception {
    try {
      memberService.delete(no);
      return new JsonResult().setState(JsonResult.SUCCESS);

    } catch (Exception e) {
      return new JsonResult()
          .setState(JsonResult.FAILURE)
          .setMessage(e.getMessage());
    }
  }

  @RequestMapping("detail")
  public JsonResult detail(int no) 
      throws Exception {

    try {
      Member member = memberService.get(no);
      return new JsonResult()
          .setState(JsonResult.SUCCESS)
          .setResult(member);

    } catch (Exception e) {
      return new JsonResult()
          .setState(JsonResult.FAILURE)
          .setResult(e.getMessage());
    }

  }

  @RequestMapping("list")
  public JsonResult list(Model model) 
      throws Exception {
    try {
      List<Member> members = memberService.list();
      return new JsonResult()
          .setState(JsonResult.SUCCESS)
          .setResult(members);
      
    } catch (Exception e) {
      return new JsonResult()
          .setState(JsonResult.FAILURE)
          .setMessage(e.getMessage());
    }
  }

  @RequestMapping("update")
  public JsonResult update(Member member) 
      throws Exception {
    try {
      memberService.update(member);
      return new JsonResult().setState(JsonResult.SUCCESS);
      
    } catch (Exception e) {
      return new JsonResult()
          .setState(JsonResult.FAILURE)
          .setMessage(e.getMessage());
    }
  }
}