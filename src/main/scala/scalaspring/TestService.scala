package scalaspring

import org.springframework.stereotype.Service
import org.springframework.context.annotation.Bean

@Service
class TestService {
  def abc : Unit = {
    println("Sunil")
  }
}