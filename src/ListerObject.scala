object ListerObject {
  
  import scala.io.Source;
  import java.io.File;
  
  //list all file names under a directory which contains the word
  def listOfFilesContainWord(aDir:String,aWord:String):List[String]={
    val allFiles : List[String] = List[String]()
    getListOfFiles(aDir,allFiles).filter(e=>containWord(e,aWord))
  }
  
  //list file contents as one string under a directory if the file contains the word
  def listOfContentOfFilesContainWord(aDir:String,aWord:String):List[String]={
    val allFiles : List[String] = List[String]()
    getListOfFiles(aDir,allFiles).filter(e=>containWord(e,aWord)).map(e=>Source.fromFile(e).getLines.mkString)
  }
  
  //list all file names under a directory recursively
  private def getListOfFiles(dir:String,allFiles:List[String]):List[String] = {
  val d = new File(dir)
  if (d.isDirectory) {
      d.listFiles.toList.flatMap(e=>getListOfFiles(e.getCanonicalPath,allFiles))
    } else {
      d.getCanonicalPath::allFiles
    }
  }
  
  //check if a file contains the word. non text file will return false
  private def containWord(aFile:String,word:String):Boolean = {
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

}