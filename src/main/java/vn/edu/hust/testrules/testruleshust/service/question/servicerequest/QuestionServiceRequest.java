package vn.edu.hust.testrules.testruleshust.service.question.servicerequest;

import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Builder
public class QuestionServiceRequest {

  private String question;
  private List<String> answer;
  private List<Integer> key;
  private MultipartFile image;
}
