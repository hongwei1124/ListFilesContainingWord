import scala.io.Source;
import java.io.File;

class Lister(aDir:String,aWord:String){
  
  private val allFiles : List[String] = List[String]()
  private val filesContainWord: List[String] = getListOfFiles(aDir).filter(e=>containWord(e,aWord))

  
  //list all file names under a directory recursively
  def getListOfFiles(dir:String):List[String] = {
  val d = new File(dir)
  if (d.isDirectory) {
      d.listFiles.toList.flatMap(e=>getListOfFiles(e.getCanonicalPath))
    } else {
      d.getCanonicalPath::allFiles
    }
  }
  
  //check if a file contains the word. non text file will return false
  def containWord(aFile:String,word:String):Boolean = {
      var doesContain = false;
      try{
        for (line <- Source.fromFile(aFile).getLines) {
          if(line.contains(word)) {
            doesContain = true
            return doesContain
          }
        }
      }catch{
        case e: Exception=> 
      }
      
      doesContain
          
  }
  
  
  //list all file names under a directory which contains the word
  def listOfFilesContainWord():List[String]={
    filesContainWord
  }
  
  //list file contents as one string under a directory if the file contains the word
  def listOfContentOfFilesContainWord():List[String]={
    filesContainWord.map(e=>Source.fromFile(e).getLines.mkString)
  }
  
  //list all files
  def listOfFiles():List[String]={
     allFiles
  }
  

}