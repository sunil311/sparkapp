package ggsi.traits

trait Logger {

  protected def print(message: String)

  // override this to be notified before the application
  // quits due to an error
  protected def cleanup() {}

  def info(message: String) {
    print(s"[info] $message")
  }

  def warning(message: String) {
    print(s"[warning] $message")
  }

  def error(message: String) = {
    print(s"[error] $message")
    cleanup()
    sys.exit(1)
  }

}

class ConsoleLogger extends Logger {
  protected def print(message: String) {
    println(message)
  }
}

object TraitMain extends App {
  val logger = new ConsoleLogger()

  logger.info("Starting up...")

  try {
    // Code
  } catch {
    case npe: NullPointerException =>
      logger.warning("You should have used Option!")
    case e: Exception =>
      logger.error(e.getMessage)
  }

  logger.info("Completed Successfully")
}

