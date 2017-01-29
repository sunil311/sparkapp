package scalaspring

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.stereotype.Component

object ScalaSpringExample {
  @Autowired()
  var kul:Kuldeep=null
  def main(args: Array[String]) {

    var context = new AnnotationConfigApplicationContext("scalaspring")
    context.getBeanDefinitionNames.foreach { x => println(x) }
    var k : Kuldeep = context.getBean(classOf[Kuldeep]);
    k.abc
    //kul.abc
  }
}