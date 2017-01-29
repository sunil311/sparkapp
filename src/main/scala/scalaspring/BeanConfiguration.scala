package scalaspring

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.context.annotation.Profile

@Configuration
@ComponentScan(basePackages = Array("scalaspring"))
class BeanConfiguration {
  
}