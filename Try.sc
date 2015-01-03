object Try {
import scala.io.Source;
import java.io.File;

	val allFiles : List[String] = List[String]()
                                                  //> allFiles  : List[String] = List()
  def getListOfFiles(dir: String):List[String] = {
	val d = new File(dir)
	if (d.isDirectory) {
			//d.listFiles.filter { e => e.isFile() }.map { e => e.getAbsolutePath }.toList ++ allFiles
			//d.listFiles.filter { e => e.isDirectory() }.toList.flatMap(e=>getListOfFiles(e.getAbsolutePath))
			d.listFiles.toList.flatMap(e=>getListOfFiles(e.getAbsolutePath))
		} else {
			d.getAbsolutePath::allFiles
		}
	}                                         //> getListOfFiles: (dir: String)List[String]
	
	def containWord(aFile:String, word:String):Boolean = {
			val doesnotContain = false;
			val doesContain = true;
			try{
				for (line <- Source.fromFile(aFile).getLines) {
					if(line.contains(word)) {
						return doesContain
					}
				}
			}catch{
				case e: Exception=> //println(s"Can't read file $aFile")
			}
			
			doesnotContain
					
	}                                         //> containWord: (aFile: String, word: String)Boolean
	
	def printAFile(aFile:String) = {
		println(Source.fromFile(aFile).getLines.mkString)
	}                                         //> printAFile: (aFile: String)Unit
	
	getListOfFiles("/home/hongwei/workspace/ListFilesContainingWord").filter(e=>containWord(e,"Scala")).map(e=>println(e))
                                                  //> /home/hongwei/workspace/ListFilesContainingWord/Try.sc
                                                  //| /home/hongwei/workspace/ListFilesContainingWord/.worksheet/src/Try.scala
                                                  //| res0: List[Unit] = List((), ())
	
	getListOfFiles("/home/hongwei/workspace/ListFilesContainingWord").filter(e=>containWord(e,"Scala")).map(e=>printAFile(e))
                                                  //> object Try {import scala.io.Source;import java.io.File;	val allFiles : L
                                                  //| ist[String] = List[String]()                                               
                                                  //|    //> allFiles  : List[String] = List()  def getListOfFiles(dir: String):L
                                                  //| ist[String] = {	val d = new File(dir)	if (d.isDirectory) {		
                                                  //| 	//d.listFiles.filter { e => e.isFile() }.map { e => e.getAbsolutePath }.
                                                  //| toList ++ allFiles			//d.listFiles.filter { e => e.isDirector
                                                  //| y() }.toList.flatMap(e=>getListOfFiles(e.getAbsolutePath))			
                                                  //| d.listFiles.toList.flatMap(e=>getListOfFiles(e.getAbsolutePath))		
                                                  //| } else {			d.getAbsolutePath::allFiles		}	
                                                  //| }                                         //> getListOfFiles: (dir: String)
                                                  //| List[String]		def containWord(aFile:String, word:String):Boole
                                                  //| an = {			val doesnotContain = false;			
                                                  //| val doesContain = true;			try{				
                                                  //| for (line <- Source.fromFile(aFile).getLines) {				
                                                  //| 	if(line.contains(word)) {						
                                                  //| return doesContain					}			
                                                  //| Output exceeds cutoff limit.
  
	
	
                                                  
	
	
}