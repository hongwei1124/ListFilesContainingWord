import org.scalatest._

class ListerTester extends FlatSpec with Matchers {

  "A Lister.listOfFilesContainWord" should "list all files under a directory which contain the word" in {
    val lister = new Lister("../ListFilesContainingWord/resource","Scala")
    
    lister.listOfFilesContainWord().toList.size should be (2)
  }
  
  "A Lister.listOfContentOfFilesContainWord" should "list all files content under a directory which contain the ward" in {
    val lister = new Lister("../ListFilesContainingWord/resource","Scala")
    
    lister.listOfContentOfFilesContainWord().map(e=> e should be ("Scala1Scala2"))
  }

  
}