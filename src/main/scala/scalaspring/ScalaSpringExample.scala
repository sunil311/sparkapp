package scalaspring

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.stereotype.Component

object ScalaSpringExample {
  @Autowired()
  var kul: TestService = null
  def main(args: Array[String]) {

    var context = new AnnotationConfigApplicationContext("scalaspring")
    context.getBeanDefinitionNames.foreach { x => println(x) }
    var k: TestService = context.getBean(classOf[TestService]);
    k.abc
  }
}